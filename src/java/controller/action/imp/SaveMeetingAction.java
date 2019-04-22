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
import Dao.imp.SalaDAO;
import controller.action.ICommandAction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Equipamento;
import model.Funcionario;
import model.Participante;
import model.ParticipantePK;
import model.Reserva;
import model.Reservaequipamento;
import model.Sala;

/**
 *
 * @author aluno
 */
public class SaveMeetingAction implements ICommandAction{
    
    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        Date dataInicio = sdf.parse(request.getParameter("date")+" "+request.getParameter("time")+": 00");
        
        Date dataFim=new Date(dataInicio.getTime() + (Integer.parseInt(request.getParameter("duration")) * ONE_MINUTE_IN_MILLIS));
        
        Sala sala = new SalaDAO().findById(Integer.parseInt(request.getParameter("room")));
        
        //Equipamento e = new EquipamentoDAO().findById(4);
        
        //Boolean livre = new EquipamentoReservaDAO().equipamentoLivre(e, dataInicio, dataFim);
        
        Boolean livre = new ReservaDAO().salaLivre(sala, dataInicio, dataFim);
        
        if(livre){
        
            String[] equipamentos = request.getParameterValues("equipment");
            String[] participantes = request.getParameterValues("employee");

            List<Participante> lstParticipantes = new ArrayList<Participante>();

            Funcionario logado = (Funcionario) request.getSession().getAttribute("user");
            
            Reserva r = new Reserva(dataInicio,dataFim,logado,sala);        
            r.setPauta(request.getParameter("agenda"));
            r = new ReservaDAO().inserir(r);

            Participante p = new Participante(r.getIdReserva(),logado.getIdFuncionario());
            p.setReserva1(r);
            p.setFuncionario1(logado);

            p = new ParticipanteDAO().inserir(p);
            lstParticipantes.add(p);

            if(participantes!=null){

                for(int i=0;i<participantes.length;i++){

                    Participante p1 = new Participante(r.getIdReserva(),Integer.parseInt(participantes[i]));

                    p1 = new ParticipanteDAO().inserir(p1);

                    lstParticipantes.add(p1);

                }
            }

            r.setParticipanteList(lstParticipantes);

            List<Reservaequipamento> listReservaEquipamento = new ArrayList<Reservaequipamento>();

            if(equipamentos!=null){

                for(int i=0;i<equipamentos.length;i++){

                    Equipamento e = new EquipamentoDAO().findById(Integer.parseInt(equipamentos[i]));
                    Reservaequipamento re = new Reservaequipamento(e,r);
                    re = new EquipamentoReservaDAO().inserir(re);

                    listReservaEquipamento.add(re);

                }

            }

            r.setReservaequipamentoList(listReservaEquipamento);
            
            response.sendRedirect("control?ac=ShowMeeting");
            
        }else{
            
            RequestDispatcher rd = request.getRequestDispatcher("control?ac=ShowMeeting");
            request.setAttribute("msgError", "Este horário não está livre");
            rd.forward(request, response);            
        }

        
    }
    
}