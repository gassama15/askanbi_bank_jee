<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire | Type Compte</title>
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