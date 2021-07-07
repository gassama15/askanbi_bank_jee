<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste | Type Compte</title>
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
					<th scope="col">#CODE</th>
					<th scope="col">LIBELLE</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				
				<tbody>
				<c:forEach var="typeCompte" items="${typeComptes}">
					<tr class="table-active">
						<td><c:out value="${typeCompte.idtypeCompte}" /></td>
						<td><c:out value="${typeCompte.codeType}" /></td>
						<td><c:out value="${typeCompte.libelleType}" /></td>
						<td><span><a
								href="type_edit?id=<c:out value='${typeCompte.idtypeCompte}'/>"><i
									class="fas fa-edit text-warning"></i></a></span> - <span><a
								onclick="return confirm('Êtes-vous sûr(e) de vouloir supprimer?')"
								href="type_delete?id=<c:out value='${typeCompte.idtypeCompte}'/>"><i
									class="fas fa-trash text-danger"></i></a></span></td>
					</tr>
				</c:forEach>
			</tbody>
				
			</tbody>
		</table>
	</div>

</body>
</html>