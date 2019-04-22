/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.imp;

import Dao.DaoGenerics;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Funcionario;
import model.Participante;
import model.Reserva;

/**
 *
 * @author fhnri
 */
public class ParticipanteDAO extends DaoGenerics<Participante, Integer>{

    @Override
    public List findAll() {
         
        Query q = em.createNamedQuery("Participante.findAll");

        return q.getResultList();
    }

    @Override
    public Participante findById(Integer id) {
        
        Query q = em.createNamedQuery("Participante.findByReserva");
        
        q.setParameter("reserva", id);
        try {
            return (Participante) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
            // } catch (NonUniqueResultException e) {
            //     return null;
        }
    }

    @Override
    public Participante inserir(Participante p) {
        
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
    
    public Boolean confereParticipante(Funcionario f, Reserva r) {
        
        Query q = em.createQuery("SELECT p FROM Participante p WHERE p.funcionario1=:funcionario AND p.reserva1=:reserva ");
        q.setParameter("funcionario", f);
        q.setParameter("reserva", r);
        
        if(q.getResultList().size()>0){
            return true;
        }
        
        return false;
        
    }
    
    public Participante recuperaParticipante(Funcionario f, Reserva r) {
        
        Query q = em.createQuery("SELECT p FROM Participante p WHERE p.funcionario1=:funcionario AND p.reserva1=:reserva ");
        q.setParameter("funcionario", f);
        q.setParameter("reserva", r);
        
        try {
            return (Participante) q.getSingleResult();
        } catch (NoResultException e) {
            return null;            
        }
        
    }
    
     public void atualiza(Participante p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback();
        }
    }
   
    
}
