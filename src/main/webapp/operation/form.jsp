<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Opération</title>
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
            <form action="operation_insert" method="POST">
            <div class="form-group">
                        <label for="idAgent" class="form-label mt-4">Agent</label>
                        <select class="form-select" name="idAgent" id="idAgent">
                            <option>Sélecionner votre agent</option>
                            <c:forEach var="agent" items="${agents}">
                            <option value="<c:out value='${agent.idAgent}'/>"><c:out value="${agent.nom}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                <div class="form-group">
                    <label for="num_compte" class="form-label mt-4">Numéro de compte</label>
                    <input required id="num_compte" name="num_compte" type="text" class="form-control">
                </div>
                <div class="form-group">
                    <label for="montant" class="form-label mt-4">Montant</label>
                    <input required id="montant" name="montant" type="number" class="form-control">
                </div>
                <div class="row p-3">
                    <div class="col">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="typeOperation" id="optionsRadios3"
                                    value="depot">
                                Dépôt
                            </label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="typeOperation" id="optionsRadios3"
                                    value="retrait">
                                Retrait
                            </label>
                        </div>
                    </div>
                </div>
                <div class="d-grid">
                    <button type="submit" class="mt-4 mb-4 btn btn-primary btn-lg">Valider</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>