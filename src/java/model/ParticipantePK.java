/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fhnri
 */
@Embeddable
public class ParticipantePK implements Serializable {

    @Basic(optional = false)
    @Column(nullable = false)
    private int reserva;
    @Basic(optional = false)
    @Column(nullable = false)
    private int funcionario;

    public ParticipantePK() {
    }

    public ParticipantePK(int reserva, int funcionario) {
        this.reserva = reserva;
        this.funcionario = funcionario;
    }

    public int getReserva() {
        return reserva;
    }

    public void setReserva(int reserva) {
        this.reserva = reserva;
    }

    public int getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) reserva;
        hash += (int) funcionario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipantePK)) {
            return false;
        }
        ParticipantePK other = (ParticipantePK) object;
        if (this.reserva != other.reserva) {
            return false;
        }
        if (this.funcionario != other.funcionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ParticipantePK[ reserva=" + reserva + ", funcionario=" + funcionario + " ]";
    }
    
}
