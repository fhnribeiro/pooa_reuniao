<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row justify-content-center">
    <div class="col-xl-5 col-lg-7">
        <div class="card shadow">
            <div class="card-header py-3">
                Sala
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
                        <label>Descrição</label>
                        <input type="text" required class="form-control form-control-user" id="descricao" name="descricao"/>
                    </div>                     
                    <div class="form-group">
                        <label>Capacidade</label>
                        <input type="number" required class="form-control form-control-user time" id="capacidade" name="capacidade"/>
                    </div>                            
                    <input type="hidden" name="ac" value="SaveRoom"/>
                    <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block">
                </form>
            </div>
        </div>
    </div>
</div>