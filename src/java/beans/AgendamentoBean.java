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
       
       agendamento.setEquipe(buscabean.getEquipeSelecionada());
 
     
       
        
      return "teste.jsf";
    }
}
