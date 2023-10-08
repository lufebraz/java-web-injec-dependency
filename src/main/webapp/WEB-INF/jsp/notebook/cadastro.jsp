<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>AppPedido</title>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<style>
		/* Estilo geral para o elemento <select class="custom-select" > */
		.custom-select {
			font-family: Arial, sans-serif;
			font-size: 16px;
			padding: 10px 15px;
			margin: 5px 0;
			border: 1px solid #ccc;
			border-radius: 5px;
			background-color: #f8f8f8;
			transition: background-color 0.3s;
		}

		/* Estilo para o foco */
		.custom-select:focus {
			outline: none;
			border-color: #6699cc;
			box-shadow: 0 0 5px rgba(102, 153, 204, 0.5);
			background-color: #e5e5e5;
		}

		/* Estilo para as opções do <select class="custom-select" > */
		.custom-select option {
			padding: 10px;
			background-color: #f8f8f8;
			border-bottom: 1px solid #ddd;
		}

		.custom-select option:last-child {
			border-bottom: none;
		}

		/* Estilo para uma opção quando o mouse está sobre ela */
		.custom-select option:hover {
			background-color: #e5e5e5;
		}

		/* Estilo para uma opção selecionada */
		.custom-select option:checked,
		.custom-select option:active {
			background-color: #6699cc;
			color: white;
		}

	</style>
</head>
<body>
	<div class="container mt-3">
	  <h2>Cadastramento de Televisao</h2>

	  <form action="/televisao/incluir" method="post">

		<div class="form-check">
			<select class="custom-select">
				<option value="infinity">infinity</option>
				<option value="thinkpad">thinkpad</option>
				<option value="mac">mac</option>
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