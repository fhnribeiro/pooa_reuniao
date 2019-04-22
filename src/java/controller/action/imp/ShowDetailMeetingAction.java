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
public class ShowDetailMeetingAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        
        Reserva r = new ReservaDAO().findById(Integer.parseInt(request.getParameter("id")));
        
        Funcionario logado = (Funcionario) request.getSession().getAttribute("user");
        
        Participante p =new ParticipanteDAO().recuperaParticipante(logado, r);
        
        if(r!=null && p!=null){
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?page=detalheReuniao");
        
            request.setAttribute("reserva", r);
            request.setAttribute("agreed", p.getAceitouAta());

            rd.forward(request, response);
            
        }else{
            
            response.sendRedirect("control?ac=ShowMeetings");
            
        }
        
        
    }
    
}
