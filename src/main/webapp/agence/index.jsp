<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste | Agence</title>
<link rel="stylesheet"
	href="https://bootswatch.com/5/flatly/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        referrerpolicy="no-referrer" />
</head>
<body>
<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="<%=request.getContextPath()%>">Askan Bi Bank</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarColor01"
					aria-controls="navbarColor01" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link active"
							href="<%=request.getContextPath()%>/list">Liste Agences</a></li>
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
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#ID</th>
					<th scope="col">Nom Agence</th>
					<th scope="col">Adresse</th>
					<th scope="col">Email</th>
					<th scope="col">Telephone</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="agence" items="${agences}">
					<tr class="table-active">
						<td><c:out value="${agence.idAgence}" /></td>
						<td><c:out value="${agence.nom}" /></td>
						<td><c:out value="${agence.adresse}" /></td>
						<td><c:out value="${agence.email}" /></td>
						<td><c:out value="${agence.telephone}" /></td>
						<td><span><a
								href="edit?id=<c:out value='${agence.idAgence}'/>"><i
									class="fas fa-edit text-warning"></i></a></span> - <span><a
								onclick="return confirm('Êtes-vous sûr(e) de vouloir supprimer?')"
								href="delete?id=<c:out value='${agence.idAgence}'/>"><i
									class="fas fa-trash text-danger"></i></a></span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>