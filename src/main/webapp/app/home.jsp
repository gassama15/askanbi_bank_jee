<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<%@include file="../layouts/cdnlinks.jsp" %>
</head>
<body>

<%@include file="../layouts/header.jsp" %>
	
	<div class="container mt-4">
     <div class="row">
        <div class="col-md-8 mx-auto">
        <%
        	if(session.getAttribute("user") == null){
        		response.sendRedirect("login");
        	}
        %>
            <h3>Bienvenue dans votre espace membre <c:out value="${user.login }" /></h3>
        </div>
    </div>
    
</div>

</body>
</html>