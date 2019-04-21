/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.imp;

import Dao.DaoGenerics;
import java.util.Iterator;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Equipamento;
import model.Reserva;

/**
 *
 * @author fhnri
 */
public class ReservaDAO extends DaoGenerics<Reserva, Integer>{

    @Override
    public List findAll() {
         
        Query q = em.createNamedQuery("Reserva.findAll");

        return q.getResultList();
    }

    @Override
    public Reserva findById(Integer id) {
        
        Query q = em.createNamedQuery("Reserva.findByIdReserva");

        q.setParameter("idReserva", id);
        try {
            return (Reserva) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
            // } catch (NonUniqueResultException e) {
            //     return null;
        }
    }

    @Override
    public Reserva inserir(Reserva r) {
        
        try {
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            
//            Iterator it = r.getEquipamentoList().iterator();
//            
//            while(it.hasNext()) {
//            
//                Equipamento e = (Equipamento) it.next();
//                Query q = em.createQuery("INSERT INTO  reservaequipamento(Equipamento,Reserva)"
//                + " values(:equipamento,:reserva)");
//
//                q.setParameter("equipamento", e.getIdEquipamento());
//                q.setParameter("reserva", r.getIdReserva());
//                
//            }
            
            return r;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
    
}
