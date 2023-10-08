<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <h3>Pedidos: ${pedidoList.size()}</h3>

    <h4><a href="/pedido">Novo pedido</a></h4>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Descrição</th>
            <th>Data</th>
            <th>Web</th>
            <th>Requerente</th>
            <th>Produtos</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="pedido" items="${pedidoList}">
            <tr>
                <td>${pedido.id}</td>
                <td>${pedido.descricao}</td>
                <td>${pedido.data}</td>
                <td>${pedido.web ? "sim" : "não"}</td>
                <td>${pedido.requerente.nome}</td>
                <td>${pedido.produtoList.size()}</td>
                <td><a href="/pedido/${pedido.id}/excluir">excluir</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>