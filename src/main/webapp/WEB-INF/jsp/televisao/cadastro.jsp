<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>AppPedido</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-3">
	  <h2>Cadastramento de Televisao</h2>
	  
	  <form action="/televisao/incluir" method="post">
	  
<%--		<c:import url="/WEB-INF/jsp/produto/cadastro.jsp"/>--%>
		
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" name="doce" value="true" checked>
		  <label class="form-check-label">Doce</label>
		</div>		

	    <div class="mb-3 mt-3">
	      <label>Quantidade:</label>
	      <input type="text" class="form-control" value="99" placeholder="Entre com a sua quantidade" name="quantidade">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Informação:</label>
	      <input type="text" class="form-control" value="Doce docinho" placeholder="Entre com as suas informações" name="informacoes">
	    </div>

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>
</body>
</html>