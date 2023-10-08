<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>e-commerce</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container mt-3">
    <h3>Listagem de Produtos:</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Valor</th>
            <th>Código</th>
            <th>Pedidos</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="product" items="${listaProduto}">
            <tr>
                <td>${product.id}</td>
                <td>${product.nome}</td>
                <td>${product.valor}</td>
                <td>${product.codigo}</td>
                <td>${product.pedidos.size()}</td>
                <td><a href="/produto/${product.id}/excluir">excluir</a> </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>
</html>