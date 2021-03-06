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
public class DeleteMeetingAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Reserva reserva = new ReservaDAO().findById(Integer.parseInt(request.getParameter("id")));
        
        if(reserva != null){
            
            Funcionario f = (Funcionario) request.getSession().getAttribute("user");
            
            if(f.getIdFuncionario().equals(reserva.getFuncionario().getIdFuncionario())){
                
                new ReservaDAO().deleta(reserva);
                response.sendRedirect("control?ac=ShowMeetings");
                
            }else{
                
                RequestDispatcher rd = request.getRequestDispatcher("control?ac=ShowMeetings");
                request.setAttribute("msgError", "Você não pode remover essa reunião");
                rd.forward(request, response);            
                
            }
            
        }else{
            
            RequestDispatcher rd = request.getRequestDispatcher("control?ac=ShowMeetings");
            request.setAttribute("msgError", "Você não pode remover essa reunião");
            rd.forward(request, response);            
            
        }
        
    }
    
}
