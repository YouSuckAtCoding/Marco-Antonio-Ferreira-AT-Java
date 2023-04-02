<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Cadastrar Endereços</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<c:import url="/WEB-INF/jsp/main.jsp"/>
<body>
<div class="d-flex flex-column align-items-center" style="margin-top:10%">
<form action="/buscarcep" method="post">
	<h1>Cadastro de Endereco</h1>
	<div class="mb-3">
	  	<label for="cepInput" class="form-label">Nome</label>
	  	<input type="text" class="form-control" id="NameInput" placeholder="cep" name="cep">
	</div>
	
	<div class="mb-3 text-center">
		 <button type="submit" class="btn btn-outline-primary w-50" value="Create">Submit</button>
	</div>
</form>
<form action="/inserirEndereco" method="post">
<div class="mb-3">
	 	 <label for="CepInput" class="form-label">Cep</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="CepInput" placeholder="Cep" name="Cep"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="CepInput" placeholder="Cep" name="Cep" value="${endereco.cep}"></input>
	 	 </c:if>
	</div>
	<div class="mb-3">
	 	 <label for="LogradouroInput" class="form-label">Logradouro</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="LogradouroInput" placeholder="Logradouro" name="Logradouro"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="LogradouroInput" placeholder="Logradouro" name="Logradouro" value="${endereco.logradouro}"></input>
	 	 </c:if>
	</div>
	<div class="mb-3">
	 	 <label for="ComplementoInput" class="form-label">Complemento</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="ComplementoInput" placeholder="Complemento" name="Complemento"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="ComplementoInput" placeholder="Complemento" name="Complemento" value="${endereco.complemento}"></input>
	 	 </c:if>
	</div>
	<div class="mb-3">
	 	 <label for="BairroInput" class="form-label">Bairro</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="BairroInput" placeholder="Bairro" name="Bairro"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="BairroInput" placeholder="Bairro" name="Bairro" value="${endereco.bairro}"></input>
	 	 </c:if>
	</div>
	<div class="mb-3">
	 	 <label for="LocalidadeInput" class="form-label">Localidade</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="LocalidadeInput" placeholder="Localidade" name="Localidade"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="LocalidadeInput" placeholder="Localidade" name="Localidade" value="${endereco.localidade}"></input>
	 	 </c:if>
	</div>
	<div class="mb-3">
	 	 <label for="UfInput" class="form-label">Uf</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="UfInput" placeholder="Uf" name="Uf"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="UfInput" placeholder="Uf" name="Uf" value="${endereco.uf}"></input>
	 	 </c:if>
	</div>
	<div class="mb-3">
	 	 <label for="IbgeInput" class="form-label">Ibge</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="IbgeInput" placeholder="Ibge" name="Ibge"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="IbgeInput" placeholder="Ibge" name="Ibge" value="${endereco.ibge}"></input>
	 	 </c:if>
	</div>
	<div class="mb-3">
	 	 <label for="GiaInput" class="form-label">Gia</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="GiaInput" placeholder="Gia" name="Gia"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="GiaInput" placeholder="Gia" name="Gia" value="${endereco.gia}"></input>
	 	 </c:if>
	</div>
	<div class="mb-3">
	 	 <label for="DDDInput" class="form-label">DDD</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="DDDInput" placeholder="DDD" name="Ddd"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="DDDInput" placeholder="DDD" name="Ddd" value="${endereco.ddd}"></input>
	 	 </c:if>
	</div>
	
	<div class="mb-3">
	 	 <label for="SiafiInput" class="form-label">Siafi</label>
	 	 <c:if test="${empty endereco}">
	 	 <input type="text" class="form-control" id="SiafiInput" placeholder="Siafi" name="Siafi"></input>
	 	 </c:if>
	 	 <c:if test="${not empty endereco}">
	 	 <input type="text" class="form-control" id="SiafiInput" placeholder="Siafi" name="Siafi" value="${endereco.siafi}"></input>
	 	 </c:if>
	</div>
	


	<div class="mb-3 text-center">
		 <button type="submit" class="btn btn-outline-primary w-50" value="Create">Submit</button>
	</div>
</form>
</div>
</body>
</html>