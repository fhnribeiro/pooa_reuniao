<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="container-fluid">
    
    <c:if test="${requestScope.msgError!=null}">
        <div class="card bg-danger text-white mb-3">
            <div class="card-body">
                ${requestScope.msgError}
            </div>
        </div>
    </c:if>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Minhas reuniões</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table id="tableMyMeetings" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>
                                Início
                            </th>
                            <th>
                                Término
                            </th>
                            <th>
                                Sala
                            </th>
                            <th width="1%"></th>
                            <th width="1%"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.listMyMeetings}" var="met">
                            <tr>      
                                <td><fmt:formatDate type = "both" value = "${met.getData()}"/></td>
                                <td><fmt:formatDate type = "both" value = "${met.getDataFim()}"/></td>
                                <td>${met.getSala().getDescricao()}</td>
                                <td class="text-right"><a href="control?ac=AdminMeeting&id=${met.getIdReserva()}" class="btn btn-primary btn-user">Realizada</a></td>
                                <td class="text-right"><a href="control?ac=CancelMeeting&id=${met.getIdReserva()}" class="btn btn-primary btn-user">Cancelar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
    <div class="card shadow mb-4">
      <div class="card-header py-3">
          <h6 class="m-0 font-weight-bold text-primary">Reuniões que eu participo</h6>
      </div>
      <div class="card-body">
          <div class="table-responsive">
              <table id="tableMeetingsIam" class="table table-bordered">
                  <thead>
                      <tr>
                          <th>
                              Início
                          </th>
                          <th>
                              Término
                          </th>
                          <th>
                              Sala
                          </th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach items="${requestScope.listMeetingsIam}" var="met">
                          <tr>      
                              <td><fmt:formatDate type = "both" value = "${met.getData()}"/></td>
                              <td><fmt:formatDate type = "both" value = "${met.getDataFim()}"/></td>
                              <td>${met.getSala().getDescricao()}</td>
                          </tr>
                      </c:forEach>
                  </tbody>
              </table>
          </div>
      </div>
    </div>
    
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Demais reuniões</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table id="tableMeetings" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>
                                Início
                            </th>
                            <th>
                                Término
                            </th>
                            <th>
                                Sala
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.listMeetings}" var="met">
                            <tr>      
                                <td><fmt:formatDate type = "both" value = "${met.getData()}"/></td>
                                <td><fmt:formatDate type = "both" value = "${met.getDataFim()}"/></td>
                                <td>${met.getSala().getDescricao()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>