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
    <h3>Requerentes: ${listagem.size()}</h3>

    <h4><a href="#">Novo Requerente</a></h4>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>E-mail</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="requerente" items="${listaRequerente}">
            <tr>
                <td>${requerente.id}</td>
                <td>${requerente.nome}</td>
                <td>${requerente.cpf}</td>
                <td>${requerente.email}</td>
                <td><a href="/requerente/${requerente.id}/excluir">excluir</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>