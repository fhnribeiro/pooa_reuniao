/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.action.ICommandAction;
import controller.action.imp.HomeAction;
import controller.action.imp.LoginAction;
import controller.action.imp.SaveMeetingAction;
import controller.action.imp.ShowLoginAction;
import controller.action.imp.ShowMeetingAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fhnri
 */
@WebServlet(name = "ControllerCentral", urlPatterns = {"/control"})
public class ControllerCentral extends HttpServlet {
    
    static final Map<String, ICommandAction> comandos = new HashMap<>();
    
    static{
        comandos.put(null, new HomeAction());
        comandos.put("", new HomeAction());
        comandos.put("home", new HomeAction());
        comandos.put("ShowLogin", new ShowLoginAction());
        comandos.put("login", new LoginAction());
        comandos.put("ShowMeeting", new ShowMeetingAction());
        comandos.put("SaveMeeting", new SaveMeetingAction());
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("ac");
        
        if(request.getSession().getAttribute("user")==null && !acao.equals("login")){
            acao="ShowLogin";
        }
        
        
        try {            
            comandos.get(acao).execute(request, response);            
        } catch (Exception ex) {
            Logger.getLogger(ControllerCentral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
