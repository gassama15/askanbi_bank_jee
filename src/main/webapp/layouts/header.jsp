<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<c:if test="${sessionScope['user'] != null}">
				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav me-auto">
					<c:if test="${sessionScope['user'].role == 'admin'}">
						<li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="true" aria-expanded="false">Gestion des Agences</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/new">Créer une
                                agence</a>
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/list">Lister les
                                agences</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="true" aria-expanded="false">Gestion des Agents</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/agent_new">Créer un
                                agent</a>
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/agent_liste">Lister les
                                agents</a>
                        </div>
                    </li>
					</c:if>
					<c:if test="${sessionScope['user'].role == 'admin' || sessionScope['user'].role == 'user'}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="true" aria-expanded="false">Gestion des Clients</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/client_new">Créer un
                                compte</a>
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/client_liste">Lister les
                                clients</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="true" aria-expanded="false">Gestion des opérations</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/operation_new">Nouvelle
                                opération</a>
                            <a class="dropdown-item"
                                href="<%request.getContextPath();%>/sunubank/consult">Consultation
                                Solde</a>
                        </div>
                    </li>
					</c:if>
					<c:if test="${sessionScope['user'].role == 'client'}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="true" aria-expanded="false">Historiques</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/all_history">Toutes les historiques</a>
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/retrait_history">Historiques des retraits</a>
                            <a class="dropdown-item" href="<%request.getContextPath();%>/sunubank/depot_history">Historiques des depots</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button"
                            aria-haspopup="true" aria-expanded="false">Gestion des opérations</a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item"
                                href="<%request.getContextPath();%>/sunubank/consult_solde">Consultation
                                Solde</a>
                        </div>
                    </li>
					</c:if>
					</ul>
					</c:if>
					
					<ul class="navbar-nav ml-auto">           
                  <c:if test="${sessionScope['user'] == null}">
                    <li class="nav-item">
                        <a href="<%request.getContextPath();%>/sunubank/login" class="nav-link">Connexion</a>
                    </li>
	        	
	        </c:if>
                  <c:if test="${sessionScope['user'] != null}">
                    
                    <li class="nav-item">
                        <a href="<%request.getContextPath();%>/sunubank/logout" class="nav-link">Déconnexion</a>
                    </li>
	        	
	        </c:if>
                    
                </ul>
					
				</div>
			</div>
		</nav>
	</header>