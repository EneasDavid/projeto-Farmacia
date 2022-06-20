<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar</title>
</head>
<body>
<main>
<table>
<thead>
<tr>
<th>id</th>
<th>nome</th>
<th>cpf</th>
<th>ação</th>
</tr>
</thead>
<c:forEach var="clientes" items="${clientes}">
<tr>
<td>${clientes.id}</td>
<td>${clientes.nome}</td>
<td>${clientes.cpf}</td>
<td><a href="FarmaciaServlet?acao=editar&id=${clientes.id}">Editar</a> | <a href="FarmaciaServlet?acao=remover&id=${clientes.id}">Excluir</a></td>
</tr>
</c:forEach>
</table>
</main>
</body>
</html>