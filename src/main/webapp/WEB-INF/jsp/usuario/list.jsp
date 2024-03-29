<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<title>Usuarios</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
<c:import url="/WEB-INF/jsp/main.jsp"/>
<c:if test="${not empty selected}">
<c:if test="${selected.nome == 'Admin'}">
	<table class="table">
  <thead>
    <tr>
      <th>Nome</th>
      <th>Email</th>
      <th></th>
    </tr>
  </thead>
  
  <c:forEach items="${users}" var="users">
  <tbody>
    <tr>
      <td><c:out value="${users.nome}"></c:out></td>
      <td><c:out value="${users.email}"></c:out></td>
      <td><a class="btn btn-outline-danger" href="/user/delete/${users.id}">Remover Usuario</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

		
	</c:if>  
<c:if test="${selected.nome != 'Admin'}">	
<table class="table">
  <thead>
    <tr>
      <th>Nome</th>
      <th>Email</th>
    </tr>
  </thead>
  
  <c:forEach items="${users}" var="users">
  <tbody>
    <tr>
      <td><c:out value="${users.nome}"></c:out></td>
      <td><c:out value="${users.email}"></c:out></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</c:if>
</c:if>
</body>
</html>