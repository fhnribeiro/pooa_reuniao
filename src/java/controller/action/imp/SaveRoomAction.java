/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.imp;

import Dao.imp.ReservaDAO;
import Dao.imp.SalaDAO;
import controller.action.ICommandAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Sala;

/**
 *
 * @author aluno
 */
public class SaveRoomAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       Sala sala = new Sala();
       sala.setDescricao(request.getParameter("descricao"));
       sala.setCapacidade(Integer.parseInt(request.getParameter("capacidade")));
       
       Sala r = new SalaDAO().inserir(sala);
       
       response.sendRedirect("control?ac=home");
       
    }
    
}
