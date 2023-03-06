<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Cadastrar Sopro</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<c:import url="/WEB-INF/jsp/main.jsp"/>
<div class="d-flex flex-column align-items-center" style="margin-top:10%">
<form action="/inserirSopro" method="post">
	<h1>Cadastro de Instrumento de Sopro</h1>
	<div class="mb-3">
	  	<label for="NameInput" class="form-label">Name</label>
	  	<input type="text" class="form-control" id="NameInput" placeholder="Name" name="Nome">
	</div>
	<div class="mb-3">
	  <label for="TipoInput" class="form-label">Tipo</label>
	 		 <input type="text" class="form-control" id="TipoInput" placeholder="Tipo" name="Tipo">
	</div>
	<div class="mb-3">
	 	 <label for="MaterialInput" class="form-label">Material</label>
	 	 <input type="text" class="form-control" id="MaterialInput" name="Material"></input>
	</div>
	<div class="mb-3">
	 	 <label for="ClassificacaoInput" class="form-label">Classificação</label>
	 	 <input type="text" class="form-control" id="ClassificacaoInput" name="Classificacao"></input>
	</div>
	<div class="mb-3">
	 	 <label for="PrecoInput" class="form-label">Preço</label>
	 	 <input type="text" class="form-control" id="PrecoInput" name="Preco"></input>
	</div>
	<div class="mb-3 text-center">
		 <button type="submit" class="btn btn-outline-primary w-50" value="Create">Submit</button>
	</div>
</form>
</div>
</body>
</html>