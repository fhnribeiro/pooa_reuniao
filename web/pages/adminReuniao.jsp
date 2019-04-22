<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="row justify-content-center">
    <div class="col-xl-5 col-lg-7">
        <div class="card shadow">
            <div class="card-header py-3">
                Reunião - <fmt:formatDate type = "both" value = "${requestScope.reserva.getData()}"/>
            </div>
            <div class="card-body">
                <form method="POST" action="control">
                    <div class="form-group">
                        <h6>Ata</h6>
                        <textarea name="Minute" class="form-control form-control-user"></textarea>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="finished" id="finished" value="2"/><label for="finished" >Realizada</label>
                    </div>
                    <input type="hidden" name="id" value="${requestScope.reserva.getIdReserva()}"/>
                    <input type="hidden" name="ac" value="UpdateMeeting"/>
                    <input type="submit" value="Salvar" class="btn btn-primary btn-user btn-block"/>
                </form>
            </div>
        </div>
    </div>
</div>