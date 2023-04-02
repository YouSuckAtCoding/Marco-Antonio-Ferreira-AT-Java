<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Compras</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<c:import url="/WEB-INF/jsp/main.jsp"/>
<c:if test="${empty compras}">
		<div class="container text-center">
			<h1>Não existem compras cadastradas</h1>
			<li><a class="me-4 btn btn-outline-primary" href="/inserirCompra">Cadastrar Compra</a></li>
		</div>
	</c:if>
<c:if test="${not empty compras}">
<table class="table">
  <thead>
    <tr>
      <th>Reponsavel</th>
      <th>Total Preço</th>
      <th>Total de Produtos</th>
      <th></th>
    </tr>
  </thead>
  <c:forEach items="${compras}" var="compras">
  <tbody>
    <tr>
      <td><c:out value="${compras.responsavel.nome}"></c:out></td>
      <td><c:out value="${compras.total}"></c:out></td>
      <td><c:out value="${compras.produtos.size()}"></c:out></td>
      <td><a class="btn btn-outline-danger" href="/compra/delete/${compras.id}">Remover Compra</a></td>
    </tr>
   </c:forEach>
  </tbody>
</table>
</c:if>
</body>
</html>