/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.imp;

import Dao.DaoGenerics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Equipamento;
import model.Funcionario;
import model.Reserva;
import model.Sala;

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
    
    public Boolean salaLivre(Sala sala, Date dataInicio, Date dataFinal){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Query q = em.createQuery("SELECT r FROM Reserva r "
          + " where r.sala = :sala AND r.data>=:dataInicio AND r.data<=:dataFim");

        q.setParameter("sala", sala);
        q.setParameter("dataInicio", dataInicio);
        q.setParameter("dataFim", dataFinal);
        
        if(q.getResultList().size()>0){
            return false;
        }else{
            q = em.createQuery("SELECT r FROM Reserva r "
          + " where r.sala = :sala AND r.dataFim>=:dataInicio AND r.dataFim<=:dataFim");

            q.setParameter("sala", sala);
            q.setParameter("dataInicio", dataInicio);
            q.setParameter("dataFim", dataFinal);
            
            if(q.getResultList().size()>0){
                return false;
            }
        }
        
        return true;
    }
    
    public List<Reserva> minhasReunioes(Funcionario f){

        Query q = em.createQuery("SELECT r FROM Reserva r "
          + " where r.funcionario = :funcionario");

        q.setParameter("funcionario", f);
        
        return q.getResultList();
        
    }
    
    public List<Reserva> reunioesQueParticipo(Funcionario f){

         TypedQuery<Reserva> q = em.createQuery("SELECT r FROM Reserva r, Participante p "
                + "WHERE r=p.reserva1 AND p.funcionario1=:funcionario AND r.funcionario<>:funcionario", Reserva.class);

        q.setParameter("funcionario", f);
        
        return q.getResultList();
        
    }
    
    public List<Reserva> reunioesDemais(Funcionario f){

         TypedQuery<Reserva> q = em.createQuery("SELECT r FROM Reserva r, Participante p "
                + "WHERE r=p.reserva1 AND p.funcionario1<>:funcionario AND r.funcionario<>:funcionario", Reserva.class);

        q.setParameter("funcionario", f);
        
        return q.getResultList();
        
    }

    public void deleta(Reserva reserva) {
        
        try {
            em.getTransaction().begin();
            Reserva reserva2 = em.merge(reserva);
            em.remove(reserva2);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback();
        }
    }

    public void atualiza(Reserva reserva) {
        try {
            em.getTransaction().begin();
            em.merge(reserva);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, e);
            em.getTransaction().rollback();
        }
    }
    
}
