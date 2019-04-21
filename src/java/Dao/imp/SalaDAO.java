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
import model.Equipamento;
import model.Sala;

/**
 *
 * @author fhnri
 */
public class SalaDAO extends DaoGenerics<Sala, Integer>{

    @Override
    public List findAll() {
         
        Query q = em.createNamedQuery("Sala.findAll");

        return q.getResultList();
    }

    @Override
    public Sala findById(Integer id) {
        
        Query q = em.createNamedQuery("Sala.findByIdSala");

        q.setParameter("idSala", id);
        try {
            return (Sala) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
            // } catch (NonUniqueResultException e) {
            //     return null;
        }
    }

    @Override
    public Sala inserir(Sala f) {
        
        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            return f;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return null;
        }
    }
    
}
