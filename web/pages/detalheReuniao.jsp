<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="row justify-content-center">
    <div class="col-xl-5 col-lg-7">
        <div class="card shadow">
            <div class="card-header py-3">
                Reunião - <fmt:formatDate type = "both" value = "${requestScope.reserva.getData()}"/>
            </div>
            <div class="card-body">
                <div>
                    <label>Início: <fmt:formatDate type = "both" value = "${requestScope.reserva.getData()}"/></label>
                </div>
                <div>
                    <label>Final: <fmt:formatDate type = "both" value = "${requestScope.reserva.getDataFim()}"/></label>
                </div>
                <div>
                    <label>Responsável: ${requestScope.reserva.getFuncionario().getNome()}</label>
                </div>
                <div>
                    <label>Lista de participantes</label>
                    <ul>
                        <c:forEach items="${requestScope.reserva.participanteList}" var="participante">
                            <li>${participante.getFuncionario1().getNome()} <c:if test="${requestScope.reserva.getStatus()==2}"> - ${participante.getAceitouAta()==1 ? "De acordo" : "Pendente"} </c:if></li>
                        </c:forEach>
                    </ul>
                </div>
                <div>
                    <label>Lista de equipamentos</label>
                    <ul>
                        <c:forEach items="${requestScope.reserva.reservaequipamentoList}" var="equipamento">
                            <li>${equipamento.getEquipamento().getDescricao()}</li>
                        </c:forEach>
                    </ul>
                </div>                
                <div>
                    <label>Pauta</label>
                    <div>${requestScope.reserva.getPauta()}</div>
                </div>
                
                <c:if test="${requestScope.reserva.getStatus()==2}">
                    <div>
                        <label>Ata</label>
                        <div>${requestScope.reserva.getAta()}</div>
                    </div>
                    <div>
                        <form id="formAgreeMinute" action="control" Method="Post">
                            <input type="checkbox" value="1" name="agreeMinute" id="agreeMinute" <c:if test="${requestScope.agreed==1}">checked</c:if>><label for="agreeMinute">Estou de acordo com a ata</label>
                            <input type="hidden" name="ac" value="AgreeMeeting"/>
                            <input type="hidden" name="id" value="${requestScope.reserva.getIdReserva()}"/>
                            <!--<input type="submit" value="Salvar" class="btn btn-primary btn-user"/>-->
                        </form>
                        
                    </div>
                </c:if>
                <a href="control?ac=ShowMeetings" class="btn btn-primary btn-user">Voltar</a>
            </div>
        </div>
    </div>
</div>
