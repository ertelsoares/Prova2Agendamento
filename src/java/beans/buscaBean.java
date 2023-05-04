package beans;

import dao.EquipeDao;
import java.io.Serializable;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import model.Equipe;
import model.TipoDeServico;

@Named(value = "buscaBean")
@SessionScoped
public class BuscaBean implements Serializable {
    private TipoDeServico tipodeservicoselecionado;
    private Equipe equipeSelecionada;
    private  String responsavel;
    private Double valorservico;
    private Double totalServico;
    private String periodo;
    private LinkedList<SelectItem> selectEquipes;
    
    @Inject
    EquipeDao equipeDao;
    
     @PostConstruct
    public void iniciar() {
        selectEquipes = new LinkedList<SelectItem>();
        selectEquipes.add(new SelectItem(null,"Selecione o tipo de serviço primeiro"));
        responsavel = "selecione uma equipe";
        valorservico = 0.0;
        totalServico = 0.0;
        periodo = "";
    }
     
    public TipoDeServico getTipodeservicoselecionado() {
        return tipodeservicoselecionado;
    }

    public void setTipodeservicoselecionado(TipoDeServico tipodeservicoselecionado) {
        this.tipodeservicoselecionado = tipodeservicoselecionado;
        selectEquipes.clear();
        responsavel = "selecione uma equipe";
        valorservico = 0.0;
        totalServico = 0.0;
        periodo = "";
        if(tipodeservicoselecionado == null){
             selectEquipes.add(new SelectItem(null,"Selecione o tipo de serviço primeiro"));
        }else{
            selectEquipes.add(new SelectItem(null,"Equipe..."));
            for (Equipe eq : equipeDao.filtarPorTipoDeServico(tipodeservicoselecionado) ) {
                selectEquipes.add( new SelectItem(eq, eq.getNomedaequipe()));
            }
        }
    }

    public LinkedList<SelectItem> getSelectEquipes() {
        return selectEquipes;
    }

    
    
    
    
    public Equipe getEquipeSelecionada() {
        return equipeSelecionada;
    }
   
    public void setEquipeSelecionada(Equipe equipeSelecionada) {
        this.equipeSelecionada = equipeSelecionada;
        responsavel = "";
        if (equipeSelecionada == null) {
            responsavel = "selecione uma equipe para listar responsavel";
            valorservico = 0.0;
        } else {
            responsavel = equipeSelecionada.getResponsavel();
            valorservico = equipeSelecionada.getValorservicoperiodo();
            if(periodo.equals("")){
            totalServico = 0.0;
            }else{
            validaperido(periodo);

            }
        }
        
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Double getValorservico() {
        return valorservico;
    }

    public void setValorservico(Double valorservico) {
        this.valorservico = valorservico;
    }

    public Double getTotalServico() {
        return totalServico;
    }

    public void setTotalServico(Double totalServico) {
        this.totalServico = totalServico;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
        if(periodo.equals("")){
            totalServico = 0.0;
            
        }else{
            validaperido(periodo);

        }
    } 
    
    
    public void validaperido(String periodo){
        switch(periodo) {
            case "manha":
              totalServico = valorservico;
              break;
            case "tarde":
             totalServico = valorservico;
             break;
             case "diainterio":
             totalServico = (valorservico * 2);
             break;
         }
    }
}
