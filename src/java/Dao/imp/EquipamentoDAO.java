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
import model.Equipamento;

/**
 *
 * @author fhnri
 */
public class EquipamentoDAO extends DaoGenerics<Equipamento, Integer>{

    @Override
    public List findAll() {
         
        Query q = em.createNamedQuery("Equipamento.findAll");

        return q.getResultList();
    }

    @Override
    public Equipamento findById(Integer id) {
        
        Query q = em.createNamedQuery("Equipamento.findByIdEquipamento");

        q.setParameter("idEquipamento", id);
        try {
            return (Equipamento) q.getSingleResult();
        } catch (NoResultException e) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, e);
            return null;
            // } catch (NonUniqueResultException e) {
            //     return null;
        }
    }

    @Override
    public Equipamento inserir(Equipamento f) {
        
        try {
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
            return f;
        } catch (Exception e) {
            Logger.getLogger(Equipamento.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback();
            return null;
        }
    }
    
}
