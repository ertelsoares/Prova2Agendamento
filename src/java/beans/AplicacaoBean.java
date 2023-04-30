/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import dao.AgendamentoDao;
import dao.EquipeDao;
import model.Equipe;
import dao.TipoServicoDao;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import model.TipoDeServico;


@Named("aplicacao")
@ApplicationScoped
public class AplicacaoBean {
    private EquipeDao equipeDao;
    private TipoServicoDao tiposervicoDao;
    private AgendamentoDao agendamentoDao;
    private List<SelectItem> equipes;
    private List<SelectItem> tiposdeservicos;
    
    
    
     private String arquivo = "C:/Users/ertel/Documents/dados_agendamento.dat";

    public AplicacaoBean() {
    }

    @PostConstruct
    public void iniciar() {
        try {
            FileInputStream fis = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream( fis );
            // ler na mesma ordem em que foram escritos no arquivo.
            equipeDao = (EquipeDao) ois.readObject();
            tiposervicoDao = (TipoServicoDao) ois.readObject();
            agendamentoDao = (AgendamentoDao) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception ex) { // não foi possível ler os dados, criar com os valores padrão 
            System.out.println("Erro lendo arquivos, reiniciando dados...");
            equipeDao = new EquipeDao();
            tiposervicoDao = new TipoServicoDao();
            Equipe e1 = new Equipe(1, "Equipe A1","Jackie chan",240.00);
            equipeDao.inserir(e1);
            Equipe e2 = new Equipe(2, "Equipe A2","Sylvester Stallone",250.00);
            equipeDao.inserir(e2);
            Equipe e3 = new Equipe(3, "Equipe A3","Bruce Lee",300.00);
            equipeDao.inserir(e3);
            
            TipoDeServico tps1 = new TipoDeServico(1,"Limpeza de terrenos urbanos");
            tiposervicoDao.inserir(tps1);
            TipoDeServico tps2 = new TipoDeServico(2,"Remoção de entulhos de obras");
            tiposervicoDao.inserir(tps2);
            TipoDeServico tps3 = new TipoDeServico(3,"Faxina geral (empresas ou residências)");
            tiposervicoDao.inserir(tps3);
            TipoDeServico tps4 = new TipoDeServico(4,"Jardinagem");
            tiposervicoDao.inserir(tps4);
            TipoDeServico tps5 = new TipoDeServico(5,"Limpeza de fachadas de vidro");
            tiposervicoDao.inserir(tps5);
        }
    }
    
}