<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire | Agence</title>
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