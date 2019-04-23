<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row justify-content-center">
    <div class="col-xl-5 col-lg-7">
        <div class="card shadow">
            <div class="card-header py-3">
                Reunião
            </div>
            <div class="card-body">
                
                <c:if test="${requestScope.msgError!=null}">
                    <div class="card bg-danger text-white mb-3">
                        <div class="card-body">
                            ${requestScope.msgError}
                        </div>
                    </div>
                </c:if>
                <form>
                    <div class="form-group">
                        <input type="date" required class="form-control form-control-user" id="dateMeeting" name="date" placeholder="Data da reunião"/>
                    </div>
                    <div class="form-group">
                        <label>Hora da reunião</label>
                        <input type="text" required class="form-control form-control-user time" id="timeMeeting" name="time"/>
                    </div>
                    <div class="form-group">
                        <label>Duração (min)</label>
                        <input type="number" required class="form-control form-control-user time" id="durationMeeting" name="duration"/>
                    </div>                    
                    <div class="form-group">
                        <label>Pauta</label>
                        <textarea class="form-control form-control-user" id="durationMeeting" name="agenda"></textarea>
                    </div>
                    <select name="room">
                        <c:forEach items="${requestScope.listRooms}" var="room">
                            <option value="${room.getIdSala()}" capacity="${room.getCapacidade()}">${room.getDescricao()}  (${room.getCapacidade()} pessoas)</option>
                        </c:forEach>
                    </select>
                    <div>
                        <select id="selectFuncionario">
                            <c:forEach items="${requestScope.listEmployees}" var="emp">
                                <c:if test="${sessionScope.user.getIdFuncionario()!= emp.getIdFuncionario() }">
                                    <option value="${emp.getIdFuncionario()}">${emp.getNome()}</option>
                                </c:if>
                            </c:forEach>                                    
                        </select>
                        <input type="button" id="addEmployee" value="+">
                    </div>
                    <ul id="listEmployeesSelected">
                        
                    </ul>
                    <div>
                        <select id="selectEquipamento">
                            <c:forEach items="${requestScope.listEquipments}" var="eqt">
                                <option value="${eqt.getIdEquipamento()}">${eqt.getDescricao()}</option>
                            </c:forEach>
                        </select>
                        <input type="button" id="addEquipment" value="+">
                    </div>
                    <ul id="listEquipamentSelected">
                        
                    </ul>
                    <input type="hidden" name="ac" value="SaveMeeting"/>
                    <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block">
                </form>
            </div>
        </div>
    </div>
</div>