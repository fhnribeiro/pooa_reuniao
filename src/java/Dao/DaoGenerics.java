/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public abstract class DaoGenerics<C, K> {

    private EntityManagerFactory emf;
    protected EntityManager em;
    
    public DaoGenerics() {
        emf = Persistence.createEntityManagerFactory("ReuniaoPU");
        em = emf.createEntityManager();
    }
    
    public abstract List<C> findAll();
    public abstract C findById(K chave);
    public abstract C inserir(C objeto);
    
}
