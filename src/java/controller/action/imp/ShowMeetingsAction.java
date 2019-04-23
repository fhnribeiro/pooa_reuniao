/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.imp;

import Dao.imp.EquipamentoDAO;
import Dao.imp.FuncionarioDAO;
import Dao.imp.ReservaDAO;
import Dao.imp.SalaDAO;
import controller.action.ICommandAction;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Equipamento;
import model.Funcionario;
import model.Reserva;
import model.Sala;

/**
 *
 * @author fhnri
 */
public class ShowMeetingsAction implements ICommandAction{
    

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Funcionario f = (Funcionario) request.getSession().getAttribute("user");
        
        List<Reserva> minhasReunioes = new ReservaDAO().minhasReunioes(f);
        
        List<Reserva> reunioesParticipo = new ReservaDAO().reunioesQueParticipo(f);
        
        List<Reserva> reunioesDemais = new ReservaDAO().reunioesDemais(f);
      
        request.setAttribute("listMyMeetings", minhasReunioes);
        request.setAttribute("listMeetingsIam", reunioesParticipo);
        request.setAttribute("listMeetings", reunioesDemais);

        RequestDispatcher rd = request.getRequestDispatcher("index.jsp?page=listaReunioes");

        rd.forward(request, response);
        
    }
    
}
