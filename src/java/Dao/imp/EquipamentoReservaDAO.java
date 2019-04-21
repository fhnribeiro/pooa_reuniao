/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.imp;

import Dao.DaoGenerics;
import controller.ControllerCentral;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Equipamento;
import model.Reserva;
import model.Reservaequipamento;

/**
 *
 * @author fhnri
 */
public class EquipamentoReservaDAO extends DaoGenerics<Reservaequipamento, Integer>{

    @Override
    public List findAll() {
         
        Query q = em.createNamedQuery("Reservaequipamento.findAll");

        return q.getResultList();
    }

    @Override
    public Reservaequipamento findById(Integer id) {
        
        Query q = em.createNamedQuery("Reservaequipamento.findByIdEquipamento");

        q.setParameter("idEquipamento", id);
        try {
            return (Reservaequipamento) q.getSingleResult();
        } catch (NoResultException e) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, e);
            return null;
            // } catch (NonUniqueResultException e) {
            //     return null;
        }
    }
    
    public List<Reservaequipamento> findByReservaId(Integer id) {
        
        TypedQuery<Reservaequipamento> q = em.createQuery("SELECT re FROM Reserva r, Reservaequipamento re   WHERE re.reserva.idReserva = r.idReserva AND re.idReserva=:idReserva ", Reservaequipamento.class);
            

        q.setParameter("idReserva", id);
        return q.getResultList();
        
    }

    @Override
    public Reservaequipamento inserir(Reservaequipamento RE) {
        
        try {
            em.getTransaction().begin();
            em.persist(RE);
            em.getTransaction().commit();
            return RE;
        } catch (Exception e) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback();
            return null;
        }
    }
    
}
