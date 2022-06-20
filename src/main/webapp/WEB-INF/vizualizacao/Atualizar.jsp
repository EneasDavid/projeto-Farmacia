<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Atualizacao</title>
	<style>
		body{
		background-image: url("https://th.bing.com/th/id/R.210d3bb5e2975d4cc057721ed096df09?rik=E1yct6e5atccZw&pid=ImgRaw&r=0");
		}
		div {
		background-color: rgba(0, 0, 0, 0.9);
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		padding: 80px;
		border-radius: 15px;
		color: white;
		}
		input {
		padding: 5px;
		border: none;
		outline: none;
		font-size: 15px;
		}
		button{
			background-color: dodgerblue;
			border: none;
			padding: 15px;
			width: 100%;
			border-radius: 10px;
			color: white;
			font-size: 15px; 
		}
		button:hover{
			background-color: deepskyblue;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<div>
	<h1>Farmacia</h1>
	<form action="FarmaciaServlet" method="POST">
	  <input type="hidden" name="id" value="${clientes.id}"></input>
	  <label for="nome">Nome: </label><br><br> 
	  <input type="text" id="nome" name="nome" placeholder="nome" value="${clientes.nome}"><br><br>
	  <label for="text">CPF: </label><br><br>
	  <input type="text" id="cpf" name="cpf" placeholder="CPF" value="${clientes.cpf}"><br><br>
	  <button>enviar</button>
	</form> 
	</div>
</body>
</html>