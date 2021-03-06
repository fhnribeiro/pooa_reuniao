/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.imp;

import Dao.imp.FuncionarioDAO;
import Dao.imp.ReservaDAO;
import controller.action.ICommandAction;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import model.Reserva;

/**
 *
 * @author aluno
 */
public class AdminMeetingAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp?page=adminReuniao");
        
        Reserva r = new ReservaDAO().findById(Integer.parseInt(request.getParameter("id")));
        
        request.setAttribute("reserva", r);
        
        rd.forward(request, response);
        
        
    }
    
}
