<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<style>
.main-nav__items li{
   list-style-type: none;
   display: inline;
   padding-right: 5px;
}
</style>
<body>
	<button type="button">
		<sec:authorize access="hasAuthority('Especialista')">Fisioterapeuta: </sec:authorize>
		<sec:authorize access="hasAuthority('Administrador')">Administrador: </sec:authorize>
		<sec:authorize access="hasAuthority('Cliente')">Cliente: </sec:authorize>
		<sec:authentication property="name"/>
	</button>
	<sec:csrfInput />
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
						<li class="main-nav__item"><a href="/" class="btn-link">Inicio</a></li>				
					<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">
						<li class="main-nav__item"><a class="btn-link" href="/rol/todos">Roles</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/usuario/todos">Lista de usuarios</a></li>						
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li class="main-nav__item"><a class="btn-link" href="/cita/todas">Citas</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/familia/todas">Familias</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/producto/todos">Lista de productos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/usuario/misDatos">Mis Datos</a></li>		
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
		<footer>
				<p class="mensaje-exito" style="color:green;">${ mensajeExito }</p>
				<p class="mensaje-error" style="color:red;">${ mensajeError }</p>
		</footer>
</body>
</html>