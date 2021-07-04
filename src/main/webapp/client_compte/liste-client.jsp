<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste | Agent</title>
<link rel="stylesheet" href="https://bootswatch.com/5/flatly/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        referrerpolicy="no-referrer" />
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
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#ID</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">adresse</th>
					<th scope="col">Tel</th>
					<th scope="col">CNI</th>
					<th scope="col">Email</th>
					<th scope="col">Type Client</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>
			<tbody>
				
				<tbody>
				<c:forEach var="client" items="${clients}">
					<tr class="table-active">
						<td><c:out value="${client.idClient}" /></td>
						<td><c:out value="${client.nom}" /></td>
						<td><c:out value="${client.prenom}" /></td>
						<td><c:out value="${client.adresse}" /></td>
						<td><c:out value="${client.tel}" /></td>
						<td><c:out value="${client.cni}" /></td>
						<td><c:out value="${client.email}" /></td>
						<td><c:out value="${client.typeClient}" /></td>
						<!-- <td>
						<c:forEach var="agence" items="${agences}">
							<c:if test="${agence.idAgence == agent.idAgence }">
								<c:out value="${agence.nom}" />
							</c:if>
						</c:forEach>
						</td>-->
						<td><span><a
								href="client_show?id=<c:out value='${client.idClient}'/>"><i
									class="fas fa-eye text-info"></i></a></span></td>
					</tr>
				</c:forEach>
			</tbody>
				
			</tbody>
		</table>
	</div>
</body>
</html>