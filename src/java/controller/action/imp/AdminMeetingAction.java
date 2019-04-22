/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.imp;

import Dao.imp.FuncionarioDAO;
import controller.action.ICommandAction;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;

/**
 *
 * @author aluno
 */
public class AdminMeetingAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
          
        Funcionario user = new FuncionarioDAO().login(request.getParameter("login"), request.getParameter("password"));
        
        if (user == null){
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?page=login");
            request.setAttribute("msg", "Usuário ou senha incorreta!!!");
            rd.forward(request, response);
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp?page=home");
            request.getSession().setAttribute("user", user);
            rd.forward(request, response);            
        }
        
    }
    
}
