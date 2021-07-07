<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire | Agence</title>
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
	        <c:if test="${agence != null}">
	        	<form action="update" method="post">
	        </c:if>
	         <c:if test="${agence == null}">
	        	<form action="insert" method="post">
	        </c:if>
            
                <fieldset>
                    <c:if test="${agence != null }">
                    <legend>Modification Agence</legend>
                    </c:if>
                    
                    <c:if test="${agence == null }">
                    <legend>Nouvelle Agence</legend>
                    </c:if>
                    
                    <c:if test="${agence != null }">
                    <input type="hidden" name="id" value="<c:out value='${agence.idAgence}'/>">
                    </c:if>
                    
                    <div class="form-group">
                        <label for="nom" class="form-label mt-4">Nom Agence</label>
                        <input value="<c:out value='${agence.nom}'/>" required name="nom" type="text" class="form-control" id="nom"
                            placeholder="Entrez le nom de votre agence">
                    </div>
                    <div class="form-group">
                        <label for="adresse" class="form-label mt-4">Adresse</label>
                        <input value="<c:out value='${agence.adresse}'/>" required name="adresse" type="text" class="form-control" id="adresse"
                            placeholder="Entrez l'adresse de votre agence">
                    </div>

                    <div class="form-group">
                        <label for="email" class="form-label mt-4">Email</label>
                        <input value="<c:out value='${agence.email}'/>" required name="email" type="email" class="form-control" id="email"
                            placeholder="Entrez l'email de votre agence">
                    </div>

                    <div class="form-group">
                        <label for="telephone" class="form-label mt-4">Téléhpone</label>
                        <input value="<c:out value='${agence.telephone}'/>" required name="telephone" type="tel" class="form-control" id="tel"
                            placeholder="Numero telephone de votre agence">
                    </div>

                    <div class="d-grid">
                    	<c:if test="${agent == null }">
                        	<button type="submit" class="mt-4 mb-4 btn btn-primary btn-lg">Créer</button>
                        </c:if>
                    	<c:if test="${agent != null }">
                        	<button type="submit" class="mt-4 mb-4 btn btn-primary btn-lg">Enregistrer</button>
                        </c:if>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

</body>
</html>