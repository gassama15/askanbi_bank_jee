<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire | Client | Compte</title>
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
	
	<div class="container">
    <form action="client_insert" method="POST">
        <div class="row">
            <div class="col-md-6">
                <fieldset class="mt-4">
                    <legend>Client</legend>
                    <div class="form-group">
                        <label for="nom" class="form-label mt-4">Nom</label>
                        <input required name="nom" type="text" class="form-control" id="nom"
                            placeholder="Entrez le nom de l'agent">
                    </div>
                    <div class="form-group">
                        <label for="prenom" class="form-label mt-4">Prénom</label>
                        <input required name="prenom" type="text" class="form-control" id="prenom"
                            placeholder="Entrez le prenom de l'agent">
                    </div>
                    <div class="form-group">
                        <label for="adresse" class="form-label mt-4">Adresse du client</label>
                        <input required name="adresse" type="text" class="form-control" id="adresse"
                            placeholder="Adresse du client">
                    </div>

                    <div class="form-group">
                        <label for="tel" class="form-label mt-4">Téléphone du client</label>
                        <input required name="tel" type="tel" class="form-control" id="tel"
                            placeholder="Téléphone du client">
                    </div>

                    <div class="form-group">
                        <label for="cni" class="form-label mt-4">CNI</label>
                        <input required name="cni" type="number" class="form-control" id="cni"
                            placeholder="CNI du client">
                    </div>

                    <div class="form-group">
                        <label for="email" class="form-label mt-4">Email du client</label>
                        <input required name="email" type="email" class="form-control" id="email"
                            placeholder="Email du client">
                    </div>
                    
                    <div class="form-group">
                        <label for="login" class="form-label mt-4">Login du client</label>
                        <input required name="login" type="text" class="form-control" id="login"
                            placeholder="Login du client">
                    </div>
                    
                    <div class="form-group">
                        <label for="password" class="form-label mt-4">Mot de passe du client</label>
                        <input required name="password" type="text" class="form-control" id="password"
                            placeholder="Mot de passe du client">
                    </div>
                    <input type="hidden" value="client" name="role" />
                    <div class="row p-3">
                        <div class="col">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="radio" class="form-check-input" name="typeClient" id="optionsRadios3"
                                        value="physique" checked>
                                    Physique
                                </label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="radio" class="form-check-input" name="typeClient" id="optionsRadios3"
                                        value="moral">
                                    Moral
                                </label>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
            <div class="col-md-6">
                <fieldset class="mt-4">
                    <legend>
                        Compte
                    </legend>
                    <div class="form-group">
                        <label for="num_compte" class="form-label mt-4">Numero de compte</label>
                        <input required name="num_compte" type="text" class="form-control" id="num_compte" placeholder="Numero de compte">
                    </div>
                    <div class="form-group">
                        <label for="solde" class="form-label mt-4">Solde</label>
                        <input required name="solde" type="number" class="form-control" id="solde" placeholder="Solde">
                    </div>
                    <div class="form-group">
                        <label for="idAgence" class="form-label mt-4">Agence</label>
                        <select class="form-select" name="idAgence" id="idAgence">
                            <option>Sélecionner votre agence</option>
                            <c:forEach var="agence" items="${agences}">
                            <option value="<c:out value='${agence.idAgence}'/>"><c:out value="${agence.nom}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="idAgent" class="form-label mt-4">Agent</label>
                        <select class="form-select" name="idAgent" id="idAgent">
                            <option>Sélecionner votre agent</option>
                            <c:forEach var="agent" items="${agents}">
                            <option value="<c:out value='${agent.idAgent}'/>"><c:out value="${agent.nom}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="row p-3">
                   		<c:forEach var="typeCompte" items="${typeComptes}">
                   			<div class="col">
                   				<div class="form-check">
                   					<div class="form-check-label">
                   						<input type="radio" class="form-check-input" name="idtypeCompte"
                                        value='<c:out value="${typeCompte.idtypeCompte }"/>' 
                                        ${typeCompte.libelleType ==
                                        'Compte Epargne'
                                            ? 'checked'
                                            : ''}>
                   						${typeCompte.libelleType == 'Compte Epargne' ? 'Compte Epargne' : 'Compte Courant' }
                   					</div>
                   				</div>
                   			</div>
                   		</c:forEach>
                    </div>

                </fieldset>
            </div>

            <div class="d-grid p-3">
                <button class="btn btn-primary btn-lg">Créer</button>
            </div>
    </form>
</div>
	
</body>
</html>