/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.imp;

import Dao.DaoGenerics;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Funcionario;
import model.Participante;

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
        
        Query q = em.createQuery("Participante.findByReserva");

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
   
    
}
