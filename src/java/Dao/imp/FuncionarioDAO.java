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

/**
 *
 * @author fhnri
 */
public class FuncionarioDAO extends DaoGenerics<Funcionario, Integer>{

    @Override
    public List findAll() {
         
        Query q = em.createNamedQuery("Funcionario.findAll");

        return q.getResultList();
    }

    @Override
    public Funcionario findById(Integer id) {
        
        Query q = em.createQuery("SELECT a FROM Aluno a "
                + " where a.idaluno = :id");

        q.setParameter("id", id);
        try {
            return (Funcionario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
            // } catch (NonUniqueResultException e) {
            //     return null;
        }
    }

    @Override
    public Funcionario inserir(Funcionario f) {
        
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
    
    public Funcionario login(String login,String senha) {
        
        Query q = em.createQuery("SELECT f FROM Funcionario f "
                + " where f.login= :login AND f.senha=:senha");

        q.setParameter("login", login);
        q.setParameter("senha", senha);
        
        try {
            
            return (Funcionario) q.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }
        
    }
    
}
