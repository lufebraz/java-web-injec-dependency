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
	  <h3>Listagem de Televisores:</h3>
	  <h4><a href="/televisao/cadastro">cadastrar nova televisao</a></h4>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Nome</th>
	        <th>Valor</th>
	        <th>C�digo</th>
	        <th>Polegadas</th>
	        <th>SmartTv</th>
	        <th>Marca</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	   	    
	      <c:forEach var="notebook" items="${tvList}">
		      <tr>
		        <td>${notebook.id}</td>
		        <td>${notebook.nome}</td>
		        <td>${notebook.valor}</td>
		        <td>${notebook.codigo}</td>
		        <td>${notebook.polegadas}</td>
		        <td>${notebook.smartTv ? "sim": "n�o"}</td>
		        <td>${notebook.marca}</td>
		        <td><a href="/televisao/${notebook.id}/excluir">excluir</a> </td>
		      </tr>
	      </c:forEach>
	    </tbody>
	  </table>
	  
	</div>
</body>
</html>