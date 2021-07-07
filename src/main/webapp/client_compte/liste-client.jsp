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
	
	<div class="container mt-4">
	<%
        	if(session.getAttribute("user") == null){
        		response.sendRedirect("login");
        	}
        %>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#ID</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">adresse</th>
					<th scope="col">Tel</th>
					<th scope="col">CNI</th>
					<th scope="col">Email</th>
					<th scope="col">Type Client</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				
				<tbody>
				<c:forEach var="client" items="${clients}">
					<tr class="table-active">
						<td><c:out value="${client.idClient}" /></td>
						<td><c:out value="${client.nom}" /></td>
						<td><c:out value="${client.prenom}" /></td>
						<td><c:out value="${client.adresse}" /></td>
						<td><c:out value="${client.tel}" /></td>
						<td><c:out value="${client.cni}" /></td>
						<td><c:out value="${client.email}" /></td>
						<td><c:out value="${client.typeClient}" /></td>
						<!-- <td>
						<c:forEach var="agence" items="${agences}">
							<c:if test="${agence.idAgence == agent.idAgence }">
								<c:out value="${agence.nom}" />
							</c:if>
						</c:forEach>
						</td>-->
						<td><span><a
								href="client_show?id=<c:out value='${client.idClient}'/>"><i
									class="fas fa-eye text-info"></i></a></span></td>
					</tr>
				</c:forEach>
			</tbody>
				
			</tbody>
		</table>
	</div>
</body>
</html>