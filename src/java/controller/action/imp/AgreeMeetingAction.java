/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.imp;

import Dao.imp.FuncionarioDAO;
import Dao.imp.ParticipanteDAO;
import Dao.imp.ReservaDAO;
import controller.action.ICommandAction;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import model.Participante;
import model.Reserva;

/**
 *
 * @author aluno
 */
public class AgreeMeetingAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Reserva reserva = new ReservaDAO().findById(Integer.parseInt(request.getParameter("id")));

        Funcionario f = (Funcionario) request.getSession().getAttribute("user");
        
        if(reserva != null && new ParticipanteDAO().confereParticipante(f,reserva)==true){
                
            Participante p =new ParticipanteDAO().recuperaParticipante(f,reserva);

            if(request.getParameter("agreeMinute")!=null && request.getParameter("agreeMinute").equals("1")){
                p.setAceitouAta(1);
            }else{
                p.setAceitouAta(0);
            }

            new ParticipanteDAO().atualiza(p);

            response.getWriter().write("OK");
            
        }
        
    }
    
}
