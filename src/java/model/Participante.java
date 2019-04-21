/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fhnri
 */
@Entity
@Table(catalog = "pooa", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participante.findAll", query = "SELECT p FROM Participante p")
    , @NamedQuery(name = "Participante.findByReserva", query = "SELECT p FROM Participante p WHERE p.participantePK.reserva = :reserva")
    , @NamedQuery(name = "Participante.findByFuncionario", query = "SELECT p FROM Participante p WHERE p.participantePK.funcionario = :funcionario")
    , @NamedQuery(name = "Participante.findByAceitouAta", query = "SELECT p FROM Participante p WHERE p.aceitouAta = :aceitouAta")})
public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticipantePK participantePK;
    private Short aceitouAta;
    @JoinColumn(name = "Funcionario", referencedColumnName = "idFuncionario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario1;
    @JoinColumn(name = "Reserva", referencedColumnName = "idReserva", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reserva reserva1;

    public Participante() {
    }

    public Participante(ParticipantePK participantePK) {
        this.participantePK = participantePK;
    }

    public Participante(int reserva, int funcionario) {
        this.participantePK = new ParticipantePK(reserva, funcionario);
    }

    public ParticipantePK getParticipantePK() {
        return participantePK;
    }

    public void setParticipantePK(ParticipantePK participantePK) {
        this.participantePK = participantePK;
    }

    public Short getAceitouAta() {
        return aceitouAta;
    }

    public void setAceitouAta(Short aceitouAta) {
        this.aceitouAta = aceitouAta;
    }

    public Funcionario getFuncionario1() {
        return funcionario1;
    }

    public void setFuncionario1(Funcionario funcionario1) {
        this.funcionario1 = funcionario1;
    }

    public Reserva getReserva1() {
        return reserva1;
    }

    public void setReserva1(Reserva reserva1) {
        this.reserva1 = reserva1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participantePK != null ? participantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.participantePK == null && other.participantePK != null) || (this.participantePK != null && !this.participantePK.equals(other.participantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Participante[ participantePK=" + participantePK + " ]";
    }
    
}
