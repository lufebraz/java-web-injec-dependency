<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>AppPedido</title>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container-fluid mt-3">
	  <h3>Listagem de Televisoes:</h3>
	  <h4><a href="/televisao/cadastro">Nova Televisao</a></h4>

	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>ID</th>
	        <th>Nome</th>
	        <th>Valor</th>
	        <th>Código</th>
	        <th>Polegadas</th>
	        <th>SmartTv</th>
	        <th>Marca</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
	   	    
<%--	      <c:forEach var="tv" items="${tvList}">--%>
<%--		      <tr>--%>
<%--		        <td>${tv.id}</td>--%>
<%--		        <td>${tv.nome}</td>--%>
<%--		        <td>${tv.valor}</td>--%>
<%--		        <td>${tv.codigo}</td>--%>
<%--		        <td>${tv.polegadas}</td>--%>
<%--		        <td>${tv.smartTv}</td>--%>
<%--		        <td>${tv.marca}</td>--%>
<%--		        <td><a href="/televisao/${tv.id}/excluir">excluir</a> </td>--%>
<%--		      </tr>--%>
<%--	      </c:forEach>--%>
	    </tbody>
	  </table>
	  
	</div>
</body>
</html>