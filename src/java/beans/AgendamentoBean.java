/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.AgendamentoDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Agendamento;

/**
 *
 * @author ertel
 */
@Named(value = "agendamentoBean")
@SessionScoped
public class AgendamentoBean implements Serializable {
   
    @Inject 
    AgendamentoDao agendamentoDao;
    
    
    @Inject 
    BuscaBean buscabean;
    
    Agendamento agendamento = new Agendamento();
    public AgendamentoBean() {
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
    
    public String confirmarAgendamento(){
       agendamento.setTipodeservico(buscabean.getTipodeservicoselecionado());
       agendamento.setEquipe(buscabean.getEquipeSelecionada());
       agendamento.setData(buscabean.getData());
       agendamento.setPeriodo(buscabean.getPeriodo());
       agendamento.setContratante(buscabean.getContratante());
       agendamento.setTelefonecontato(buscabean.getTelefonecontato());
       agendamento.setEmail(buscabean.getEmail());
       agendamento.setEnderecodoservico(buscabean.getEnderecodoservico());
       agendamento.setTotalservico(buscabean.getTotalServico());
 
       agendamentoDao.inserir(agendamento);
       
       Agendamento agen = agendamentoDao.findByExample(agendamento);
       
       if(agen != null){
          FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Perioto com essa data jaexiste",
                    "já existe data com esse periodo ")); 
           
           
       }else{
           agendamentoDao.inserir(agendamento);
           agendamento = new Agendamento();
       }
      return null;
    }
}
