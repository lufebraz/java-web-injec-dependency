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
	  <h2>Cadastramento de Celular</h2>

	  <form action="/celular/incluir" method="post">

		<div class="form-check">
			<label>Celular:</label>
			<select class="custom-select">
				<option>Selecione o Celular</option>
				<option value="s20">s20</option>
				<option value="iphone">iphone</option>
				<option value="galaxy">galaxy</option>
				<option value="xioami">xioami</option>
			</select>
		</div>

		<div class="mb-3 mt-3">
		  <label>Quantidade:</label>
		  <input type="text" class="form-control" placeholder="Entre com a sua quantidade" name="quantidade">
		</div>

		<div class="mb-3 mt-3">
		  <label>Tipo de pagamento:</label>
			<select class="custom-select" >
				<option>selecione</option>
				<option value="pix">pix</option>
				<option value="cartao">cartao</option>
			</select>
		</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>
</body>
</html>