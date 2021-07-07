<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire | Type Compte</title>
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
        <c:if test="${typeCompte == null }">
            <form action="type_insert" method="POST">
        </c:if>
        
        <c:if test="${typeCompte != null }">
            <form action="type_update" method="POST">        
        </c:if>
        
                <fieldset class="mt-4">
                    <c:if test="${typeCompte != null }">
                    <legend>Modification Type de Compte</legend>
                    </c:if>
                    
                    <c:if test="${typeCompte == null }">
                    <legend>Nouveau Type de Compte</legend>
                    </c:if>
                    
                    <c:if test="${typeCompte != null }">
                    <input type="hidden" name="id" value="<c:out value='${typeCompte.idtypeCompte}'/>">
                    </c:if>
                    
                    <div class="form-group">
                        <label for="code" class="form-label mt-4">Code du type de compte</label>
                        <input name="codeType" type="text" class="form-control" id="code" placeholder="Entrez le libellé du type" value="<c:out value='${typeCompte.codeType}'/>">
                    </div>
                    <div class="form-group">
                        <label for="libelle" class="form-label mt-4">Libellé du type de compte</label>
                        <input name="libelle" type="text" class="form-control" id="libelle"
                            placeholder="Entrez le libellé du type" value="<c:out value='${typeCompte.libelleType}'/>">
                    </div>

                    <div class="d-grid">
                    	<c:if test="${typeCompte == null }">
                        	<button type="submit" class="mt-4 mb-4 btn btn-primary btn-lg">Créer</button>
                        </c:if>
                    	<c:if test="${typeCompte != null }">
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