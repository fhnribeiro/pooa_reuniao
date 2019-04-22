/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.action.imp;

import Dao.imp.EquipamentoDAO;
import Dao.imp.EquipamentoReservaDAO;
import Dao.imp.FuncionarioDAO;
import Dao.imp.ParticipanteDAO;
import Dao.imp.ReservaDAO;
import controller.action.ICommandAction;
import static controller.action.imp.SaveMeetingAction.ONE_MINUTE_IN_MILLIS;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Equipamento;
import model.Funcionario;
import model.Participante;
import model.Reserva;

/**
 *
 * @author aluno
 */
public class CheckDeviceFreeAction implements ICommandAction{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Funcionario f = (Funcionario) request.getSession().getAttribute("user");
        
        System.out.println(Integer.parseInt(request.getParameter("id")));
        
        Equipamento e = new EquipamentoDAO().findById(Integer.parseInt(request.getParameter("id")));
        
        System.out.println(e.getDescricao());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        Date dataInicio = sdf.parse(request.getParameter("date")+" "+request.getParameter("time")+": 00");
        
        Date dataFim=new Date(dataInicio.getTime() + (Integer.parseInt(request.getParameter("duration")) * ONE_MINUTE_IN_MILLIS));
        
            
        response.setContentType("text/plain; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        if(e!=null && new EquipamentoReservaDAO().equipamentoLivre(e, dataInicio, dataFim) ){

            out.println("1");

        }else if(e!=null){

            out.println("2");

        }else{

            out.println("0");
            
        }
            
       

    }
    
}
