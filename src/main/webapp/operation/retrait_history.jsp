<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historique | Retrait</title>
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
        <h3><c:out value="${f:length(operations) }" /> opération(s)</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#ID</th>
					<th scope="col">Type Operation</th>
					<th scope="col">Montant</th>
				</tr>
			</thead>
			<tbody>
				
				<tbody>
				<c:forEach var="operation" items="${operations}">
					<tr class="table-active">
						<td><c:out value="${operation.idOperation}" /></td>
						<td><c:out value="${operation.typeOperation}" /></td>
						<td><c:out value="${operation.montant}" /></td>
						<!-- <td>
						<c:forEach var="agence" items="${agences}">
							<c:if test="${agence.idAgence == agent.idAgence }">
								<c:out value="${agence.nom}" />
							</c:if>
						</c:forEach>
						</td>-->
					</tr>
				</c:forEach>
			</tbody>
				
			</tbody>
		</table>
	</div>
</body>
</html>