<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire | Connexion</title>
<%@include file="../layouts/cdnlinks.jsp" %>
</head>
<body>
<%@include file="../layouts/header.jsp" %>
	<%
        	if(session.getAttribute("user") != null){
        		response.sendRedirect("home");
        	}
        %>
	<div class="container">
    <div class="row">
        <div class="col-md-6 mx-auto">
            <form action="signin" method="POST">
                <fieldset>
                    <legend>Authentification</legend>
                    <div class="form-group">
                        <label for="login" class="form-label mt-4">Login</label>
                        <input required name="login" type="text" class="form-control" id="login"
                            aria-describedby="emailHelp" placeholder="Entrez votre login">
                        <small id="emailHelp" class="form-text text-muted">Nous ne partagerons jamais votre login avec
                            qui
                            que ce soit.</small>
                    </div>
                    <div class="form-group">
                        <label for="password" class="form-label mt-4">Mot de passe</label>
                        <input required name="password" type="password" class="form-control" id="password"
                            placeholder="Entrez votre mot de passe">
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="mt-4 mb-4 btn btn-primary btn-lg">Connexion</button>
                    </div>
                </fieldset>
            </form>
        </div>
        </div>
        </div>
	
	
</body>
</html>