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
	
	<div class="container mt-4">
	<%
        	if(session.getAttribute("user") == null){
        		response.sendRedirect("login");
        	}
        %>
        <c:if test="${solde != null }">
        	<div class="alert alert-success">
        		Votre solde est de <c:out value="${solde }"/> F CFA
        	</div>
        </c:if>
        <c:if test="${sessionScope['user'].role != 'client'}">
		    <div class="row">
		        <div class="col-md-6 mx-auto">
		            <form action="display_amount" method="POST">
		           
		                <div class="form-group">
		                    <label for="num_compte" class="form-label mt-4">Numéro de compte</label>
		                    <input required id="num_compte" name="num_compte" type="text" class="form-control">
		                </div>
		              
		                   
		                <div class="d-grid">
		                    <button type="submit" class="mt-4 mb-4 btn btn-primary btn-lg">Valider</button>
		                </div>
		            </form>
		        </div>
		    </div>
        </c:if>
    </div>

</body>
</html>