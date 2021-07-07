<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire | Agent</title>
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
            <c:if test="${agent != null}">
	        	<form action="agent_update" method="post">
	        </c:if>
	        
	         <c:if test="${agent == null}">
	        	<form action="agent_insert" method="post">
	        </c:if>
                <fieldset class="mt-4">
                    <c:if test="${agent != null }">
                    <legend>Modification Agent</legend>
                    </c:if>
                    
                    <c:if test="${agent == null }">
                    <legend>Nouvel Agent</legend>
                    </c:if>
                    
                     <c:if test="${agent != null }">
                    <input type="hidden" name="id" value="<c:out value='${agent.idAgent}'/>">
                    </c:if>
                    
                    <c:if test="${agent == null }">
	                     <div class="form-group">
	                        <label for="login" class="form-label mt-4">Login</label>
	                        <input required name="login" type="text" class="form-control" id="login"
	                            placeholder="Login de l'agent">
	                    </div>
	                    <div class="form-group">
	                        <label for="password" class="form-label mt-4">Mot de passe</label>
	                        <input required name="password" type="text" class="form-control" id="password"
	                            placeholder="Mot de passe de l'agent">
	                    </div>
                    </c:if>
                   
                    <div class="form-group">
                        <label for="nom" class="form-label mt-4">Nom</label>
                        <input value="<c:out value='${agent.nom}'/>" required name="nom" type="text" class="form-control" id="nom"
                            placeholder="Entrez le nom de l'agent">
                    </div>
                    <div class="form-group">
                        <label for="prenom" class="form-label mt-4">Prénom</label>
                        <input value="<c:out value='${agent.prenom}'/>" required name="prenom" type="text" class="form-control" id="prenom"
                            placeholder="Entrez le prenom de l'agent">
                    </div>
                    <div class="form-group">
                        <label for="num_agent" class="form-label mt-4">Numero agent</label>
                        <input value="<c:out value='${agent.num_agent}'/>" required name="num_agent" type="number" class="form-control" id="num_agent"
                            placeholder="Numero de l'agent">
                    </div>

					<c:if test="${agent == null }">
						<div class="form-group">
                        <label for="role" class="form-label mt-4">Role</label>
                        <select class="form-select" name="role" id="role">
                            <option value="admin">Admin</option>
                            <option value="user">Agent</option>
                        </select>
                    </div>
					</c:if>
                    
                    <div class="form-group">
                        <label for="idAgence" class="form-label mt-4">Agence</label>
                        <select class="form-select" name="idAgence" id="idAgence">
                        	<c:if test="${agent == null }">
                            	<option>Sélecionner votre agence</option>
                        	</c:if>
                            <c:forEach var="agence" items="${agences}">
                            <option value="<c:out value='${agence.idAgence}'/>" ${agence.idAgence == agent.idAgence ? 'selected="selected"' : '' }><c:out value="${agence.nom}" /></option>
                            </c:forEach>
                        </select>
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