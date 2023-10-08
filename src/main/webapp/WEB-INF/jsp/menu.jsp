<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Luiz's App</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="/">Home</a></li>
				<li class="nav-item">
					<a class="nav-link" href="/usuario/lista">Usuários</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/pedido/lista">Pedidos</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/requerente/lista">Requerentes</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/produto/lista">Produtos</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/celular/lista">Celulares</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/nootebook/lista">Notebooks</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/televisao/lista">Televisoes</a>
				</li>
		</ul>
<%--		<ul class="nav navbar-nav navbar-right">--%>
<%--			<c:if test="${empty user}">--%>
<%--				<li><a href="/usuario/cadastro"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>--%>
<%--				<li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>--%>
<%--			</c:if>--%>

<%--			<c:if test="${not empty user}">--%>
<%--				<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout ${user.nome}</a></li>--%>
<%--			</c:if>--%>
<%--		</ul>--%>
	</div>
</nav>