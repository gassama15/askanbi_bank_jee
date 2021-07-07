<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DÉtails | Client | Compte</title>
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
    <div class="row">
        <div class="col-md-6">
            <div class="card border-primary mb-3">
                <div class="card-header">
                    <h3 class="text-center">Client</h3>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-6 h5">#ID</div>
                        <div class="col-md-6 h5"><c:out value="${client.idClient}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 h5">Nom</div>
                        <div class="col-md-6 h5"><c:out value="${client.nom}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 h5">Prénom</div>
                        <div class="col-md-6 h5"><c:out value="${client.prenom}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 h5">Adrese</div>
                        <div class="col-md-6 h5"><c:out value="${client.adresse}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 h5">Telephone</div>
                        <div class="col-md-6 h5"><c:out value="${client.tel}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 h5">CNI</div>
                        <div class="col-md-6 h5"><c:out value="${client.cni}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 h5">email</div>
                        <div class="col-md-6 h5"><c:out value="${client.email}" /></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 h5">Type Client</div>
                        <div class="col-md-6 h5"><c:out value="${client.typeClient}" /></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card border-primary mb-3">
                <div class="card-header">
                    <h3 class="text-center">Compte</h3>
                </div>
                <div class="card-body">
                    <!-- <div class="row">
                        <div class="col-md-6 h5">#numéro compte</div>
                        <div class="col-md-6 h5"><?= $client->num_compte ?></div>
                    </div> -->
                    <!-- <div class="row">
                        <div class="col-md-6 h5">Date ouverture</div>
                        <div class="col-md-6 h5"><?= $client->date_ouverture ?></div>
                    </div>-->
                    <!-- <div class="row">
                        <div class="col-md-6 h5">Solde</div>
                        <div class="col-md-6 h5"><?= $client->solde ?> F CFA</div>
                    </div> -->
                    <div class="row">
                        <div class="col-md-6 h5">Statut</div>
                        <div class="col-md-6 h5">${compte.statut == true
                            ? 'Actif'
                            : 'Inactif'}</div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 h5">Type de compte</div>
                        <div class="col-md-6 h5">
                        	<c:forEach var="typeCpt" items="${typeComptes}">
                        		<c:if test="${typeCpt.idtypeCompte eq compte.idtypeCompte}">
                        			<c:out value="${typeCpt.libelleType }"/>
                        		</c:if>
                        	</c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>