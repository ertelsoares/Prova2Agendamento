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
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
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

    List<Agendamento> agendamentos = new LinkedList<>();

    @PostConstruct
    public void iniciar() {
        agendamentos = agendamentoDao.listar();
    }

    public AgendamentoBean() {
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public String confirmarAgendamento() {
        agendamento.setTipodeservico(buscabean.getTipodeservicoselecionado());
        agendamento.setEquipe(buscabean.getEquipeSelecionada());
        agendamento.setData(buscabean.getData());
        agendamento.setPeriodo(buscabean.getPeriodo());
        agendamento.setContratante(buscabean.getContratante());
        agendamento.setTelefonecontato(buscabean.getTelefonecontato());
        agendamento.setEmail(buscabean.getEmail());
        agendamento.setEnderecodoservico(buscabean.getEnderecodoservico());
        agendamento.setTotalservico(buscabean.getTotalServico());
        Agendamento agen = agendamentoDao.findByExample(agendamento);
        if (agen != null) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Equipe não Disponivel",
                            "Esta equipe não está disponível nesse período e data pois já tem serviço"));

        } else {
            if ("diainteiro".equals(buscabean.getPeriodo())) {
                Agendamento agendamentoManha = new Agendamento(agendamento); // cria um novo objeto de agendamento com os mesmos valores do original
                agendamentoManha.setPeriodo("manha"); // define o período para manhã
                agendamentoDao.inserir(agendamentoManha); // salva o agendamento da manhã

                Agendamento agendamentoTarde = new Agendamento(agendamento); // cria outro objeto de agendamento com os mesmos valores do original
                agendamentoTarde.setPeriodo("tarde"); // define o período para tarde
                agendamentoDao.inserir(agendamentoTarde); // salva o agendamento da tarde

                agendamento = new Agendamento(); // cria um novo objeto de agendamento para ser usado na próxima inserção
                agendamentos = agendamentoDao.listarAgendamentos(); // atualiza a lista de agendamentos
                return null;
            } else {
                agendamentoDao.inserir(agendamento);
                agendamento = new Agendamento();
                agendamentos = agendamentoDao.listarAgendamentos();
                return null;
            }

        }
        return null;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

}
