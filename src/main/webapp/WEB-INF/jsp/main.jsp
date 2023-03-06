<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>

<nav class="navbar navbar-expand-lg bg-body-tertiary">  
  <div class="container-fluid">
    <a class="navbar-brand" href="/">At_Java</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Loja</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="/index" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Produtos
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/listcordas">Cordas</a></li>
            <li><a class="dropdown-item" href="/listsopro">Sopro</a></li>
            <li><a class="dropdown-item" href="/listpercussao">Percussão</a></li>
          </ul>
          
        </li>
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="/index" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Cadastros 
          </a>
        <ul class="dropdown-menu">
            	<li><a class="dropdown-item" href="/inserirCordas">Cadastrar Cordas</a></li>
            	<li><a class="dropdown-item" href="/inserirSopro">Cadastrar Sopro</a></li>
            	<li><a class="dropdown-item" href="/inserirPercussao">Cadastrar Percussão</a></li>
            </ul>
       </li>
        	
         
      </ul>
      <ul class="nav navbar-nav navbar-right">
	    <c:if test="${empty selected}">
	      <li><a href="/cadastrar" class="me-4 btn btn-outline-primary">Cadastrar</a></li>
	      <li><a href="/login" class="me-4 btn btn-outline-primary">Login</a></li>
		</c:if>
		
		<c:if test="${not empty selected}">
	      <li><a class="me-4 btn btn-outline-primary" href="#">${selected.nome}</a></li>
	      <li><a href="/logout" class="me-4 btn btn-outline-primary">Logout</a></li>
	    </c:if>
      </ul>
    </div>
  </div>
 
</nav>
</html>