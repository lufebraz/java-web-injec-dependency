<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<title>e-commerce</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
	  <h3>Listagem de Celulares:</h3>
	  <h4><a href="/celular/cadastro">cadastrar novo celular</a></h4>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Nome</th>
	        <th>Valor</th>
	        <th>Código</th>
	        <th>Armazenamento</th>
	        <th>Qnt. Cameras</th>
	        <th>Sistema Operacional</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	   	    
	      <c:forEach var="notebook" items="${celList}">
		      <tr>
		        <td>${notebook.id}</td>
		        <td>${notebook.nome}</td>
		        <td>${notebook.valor}</td>
		        <td>${notebook.codigo}</td>
		        <td>${notebook.armazenamento}</td>
		        <td>${notebook.quantidadeCameras}</td>
		        <td>${notebook.sistemaOperacional}</td>
		        <td><a href="/celular/${notebook.id}/excluir">excluir</a> </td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	</div>
</body>
</html>