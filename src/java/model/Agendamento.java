
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class Agendamento implements Serializable{
    private int id;
    private TipoDeServico tipodeservico;
    private Equipe equipe;
    private Date data;
    private String periodo;
    private String contratante;
    private String telefonecontato;
    private String email;
    private String enderecodoservico;
    private Double totalservico;

    public Agendamento() {
    }

    public Agendamento(int id, TipoDeServico tipodeservico, Equipe equipe, Date data, String periodo, String contratante, String telefonecontato, String email, String enderecodoservico) {
        this.id = id;
        this.tipodeservico = tipodeservico;
        this.equipe = equipe;
        this.data = data;
        this.periodo = periodo;
        this.contratante = contratante;
        this.telefonecontato = telefonecontato;
        this.email = email;
        this.enderecodoservico = enderecodoservico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoDeServico getTipodeservico() {
        return tipodeservico;
    }

    public void setTipodeservico(TipoDeServico tipodeservico) {
        this.tipodeservico = tipodeservico;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getTelefonecontato() {
        return telefonecontato;
    }

    public void setTelefonecontato(String telefonecontato) {
        this.telefonecontato = telefonecontato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecodoservico() {
        return enderecodoservico;
    }

    public void setEnderecodoservico(String enderecodoservico) {
        this.enderecodoservico = enderecodoservico;
    }

    public Double getTotalservico() {
        return totalservico;
    }

    public void setTotalservico(Double totalservico) {
        this.totalservico = totalservico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.tipodeservico);
        hash = 17 * hash + Objects.hashCode(this.equipe);
        hash = 17 * hash + Objects.hashCode(this.data);
        hash = 17 * hash + Objects.hashCode(this.periodo);
        hash = 17 * hash + Objects.hashCode(this.contratante);
        hash = 17 * hash + Objects.hashCode(this.telefonecontato);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.enderecodoservico);
        hash = 17 * hash + Objects.hashCode(this.totalservico);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.contratante, other.contratante)) {
            return false;
        }
        if (!Objects.equals(this.telefonecontato, other.telefonecontato)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.enderecodoservico, other.enderecodoservico)) {
            return false;
        }
        if (!Objects.equals(this.tipodeservico, other.tipodeservico)) {
            return false;
        }
        if (!Objects.equals(this.equipe, other.equipe)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.totalservico, other.totalservico)) {
            return false;
        }
        return true;
    }

    
}
