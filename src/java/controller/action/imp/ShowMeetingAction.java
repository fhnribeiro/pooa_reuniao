/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.imp;

import Dao.imp.EquipamentoDAO;
import Dao.imp.SalaDAO;
import controller.action.ICommandAction;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Equipamento;
import model.Sala;

/**
 *
 * @author aluno
 */
public class ShowMeetingAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        List<Equipamento> equipamentos = new EquipamentoDAO().findAll();
        
        request.setAttribute("listEquipments", equipamentos);
        
        List<Sala> salas = new SalaDAO().findAll();
        
        request.setAttribute("listRooms", salas);
        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp?page=reuniao");
        
        rd.forward(request, response);
    }
    
}
