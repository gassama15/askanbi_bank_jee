<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Opération</title>
<%@include file="../layouts/cdnlinks.jsp" %>
</head>
<body>

<%@include file="../layouts/header.jsp" %>
	
	<div class="container">
	<%
        	if(session.getAttribute("user") == null){
        		response.sendRedirect("login");
        	}
        %>
    <div class="row">
        <div class="col-md-6 mx-auto">
            <form action="operation_insert" method="POST">
            <div class="form-group">
                        <label for="idAgent" class="form-label mt-4">Agent</label>
                        <select class="form-select" name="idAgent" id="idAgent">
                            <option>Sélecionner votre agent</option>
                            <c:forEach var="agent" items="${agents}">
                            <option value="<c:out value='${agent.idAgent}'/>" ${sessionScope['user'].id ==
                                        agent.user_id
                                            ? 'selected'
                                            : ''}><c:out value="${agent.nom}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                <div class="form-group">
                    <label for="num_compte" class="form-label mt-4">Numéro de compte</label>
                    <input required id="num_compte" name="num_compte" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="montant" class="form-label mt-4">Montant</label>
                    <input required id="montant" name="montant" type="number" class="form-control">
                </div>
                <div class="row p-3">
                    <div class="col">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="typeOperation" id="optionsRadios3"
                                    value="depot">
                                Dépôt
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="typeOperation" id="optionsRadios3"
                                    value="retrait">
                                Retrait
                            </label>
                        </div>
                    </div>
                </div>
                <div class="d-grid">
                    <button type="submit" class="mt-4 mb-4 btn btn-primary btn-lg">Valider</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>