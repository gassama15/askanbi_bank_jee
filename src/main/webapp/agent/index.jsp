<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste | Agent</title>
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
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#ID</th>
					<th scope="col">#NUM</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">agence</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				
				<tbody>
				<c:forEach var="agent" items="${agents}">
					<tr class="table-active">
						<td><c:out value="${agent.idAgent}" /></td>
						<td><c:out value="${agent.num_agent}" /></td>
						<td><c:out value="${agent.nom}" /></td>
						<td><c:out value="${agent.prenom}" /></td>
						<td>
						<c:forEach var="agence" items="${agences}">
							<c:if test="${agence.idAgence == agent.idAgence }">
								<c:out value="${agence.nom}" />
							</c:if>
						</c:forEach>
						</td>
						<td><span><a
								href="agent_edit?id=<c:out value='${agent.idAgent}'/>"><i
									class="fas fa-edit text-warning"></i></a></span> - <span><a
								onclick="return confirm('Êtes-vous sûr(e) de vouloir supprimer?')"
								href="agent_delete?id=<c:out value='${agent.idAgent}'/>"><i
									class="fas fa-trash text-danger"></i></a></span></td>
					</tr>
				</c:forEach>
			</tbody>
				
			</tbody>
		</table>
	</div>
</body>
</html>