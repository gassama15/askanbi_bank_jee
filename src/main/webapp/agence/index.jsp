<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste | Agence</title>
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
					<th scope="col">Nom Agence</th>
					<th scope="col">Adresse</th>
					<th scope="col">Email</th>
					<th scope="col">Telephone</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="agence" items="${agences}">
					<tr class="table-active">
						<td><c:out value="${agence.idAgence}" /></td>
						<td><c:out value="${agence.nom}" /></td>
						<td><c:out value="${agence.adresse}" /></td>
						<td><c:out value="${agence.email}" /></td>
						<td><c:out value="${agence.telephone}" /></td>
						<td><span><a
								href="edit?id=<c:out value='${agence.idAgence}'/>"><i
									class="fas fa-edit text-warning"></i></a></span> - <span><a
								onclick="return confirm('Êtes-vous sûr(e) de vouloir supprimer?')"
								href="delete?id=<c:out value='${agence.idAgence}'/>"><i
									class="fas fa-trash text-danger"></i></a></span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>