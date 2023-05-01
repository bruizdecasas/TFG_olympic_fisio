<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<sec:authorize access="hasAuthority('ROLE_USUARIO')">Eres un CLIENTE</sec:authorize>
	<sec:authorize access="hasAuthority('ROLE_ADMIN')">Eres un ADMINISTRADOR</sec:authorize>
	<sec:csrfInput />
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<sec:authorize access="!isAuthenticated()">
						<li class="main-nav__item"><a href="/" class="btn-link">Inicio</a></li>				
					</sec:authorize>
					<sec:authorize access="hasAuthority('ROLE_ADMIN')">
						<li class="main-nav__item"><a class="btn-link" href="/admin/roles">Roles</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/admin/usuarios">Clientes</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/admin/pedidos">Pedidos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/user/familias">Familias</a></li>
					</sec:authorize>	
					<sec:authorize access="hasAnyAuthority('ROLE_ADMIN','ROLE_USUARIO')">						
						<li class="main-nav__item"><a class="btn-link" href="/user/productos">Lista de productos</a></li>
					</sec:authorize>
					<sec:authorize access="hasAuthority('ROLE_USUARIO')">
						<li class="main-nav__item"><a class="btn-link" href="/user/misDatos">Mis Datos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/carrito/miCarrito">Carrito</a></li>		
					</sec:authorize>	
					<sec:authorize access="!isAuthenticated()">
						<li class="main-nav__item"><a href="/entrar" class="btn-link">Entrar</a></li>	
						<li class="main-nav__item"><a href="/altausuario" class="btn-link">Registro</a></li>		
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">	
						<li class="main-nav__item"><a class="btn-link danger" href="/logout">Salir</a></li> 
					</sec:authorize>
				</ul>
			</nav>
		</header>
</body>
</html>