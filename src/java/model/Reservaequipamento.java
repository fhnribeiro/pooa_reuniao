/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "Reservaequipamento.findAll", query = "SELECT r FROM Reservaequipamento r")
    , @NamedQuery(name = "Reservaequipamento.findByIdReservaEquipamento", query = "SELECT r FROM Reservaequipamento r WHERE r.idReservaEquipamento = :idReservaEquipamento")})
public class Reservaequipamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idReservaEquipamento;
    @JoinColumn(name = "Equipamento", referencedColumnName = "idEquipamento", nullable = false)
    @ManyToOne(optional = false)
    private Equipamento equipamento;
    @JoinColumn(name = "Reserva", referencedColumnName = "idReserva", nullable = false)
    @ManyToOne(optional = false)
    private Reserva reserva;

    public Reservaequipamento() {
    }

    public Reservaequipamento(Integer idReservaEquipamento) {
        this.idReservaEquipamento = idReservaEquipamento;
    }

    public Reservaequipamento(Equipamento e, Reserva r) {
        this.equipamento=e;
        this.reserva=r;
    }

    public Integer getIdReservaEquipamento() {
        return idReservaEquipamento;
    }

    public void setIdReservaEquipamento(Integer idReservaEquipamento) {
        this.idReservaEquipamento = idReservaEquipamento;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservaEquipamento != null ? idReservaEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaequipamento)) {
            return false;
        }
        Reservaequipamento other = (Reservaequipamento) object;
        if ((this.idReservaEquipamento == null && other.idReservaEquipamento != null) || (this.idReservaEquipamento != null && !this.idReservaEquipamento.equals(other.idReservaEquipamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Reservaequipamento[ idReservaEquipamento=" + idReservaEquipamento + " ]";
    }
    
}
