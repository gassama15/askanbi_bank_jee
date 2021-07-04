<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DÉtails | Client | Compte</title>
<link rel="stylesheet" href="https://bootswatch.com/5/flatly/bootstrap.min.css">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Askan Bi Bank</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarColor01"
					aria-controls="navbarColor01" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link active" href="<%request.getContextPath();%>/list">Liste Agences</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Features</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">Pricing</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="#">About</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	
	<div class="container mt-4">
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