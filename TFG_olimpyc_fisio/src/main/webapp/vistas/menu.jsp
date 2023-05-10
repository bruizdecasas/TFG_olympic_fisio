<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" 
data-integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" data-crossorigin="anonymous">
</head>
<style>
.main-nav__items li{
   list-style-type: none;
   display: inline;
   padding-right: 5px;
}
</style>
<body>
	<!--<button type="button">
		<sec:authorize access="hasAuthority('Especialista')">Fisioterapeuta: </sec:authorize>
		<sec:authorize access="hasAuthority('Administrador')">Administrador: </sec:authorize>
		<sec:authorize access="hasAuthority('Cliente')">Cliente: </sec:authorize>
		<sec:authentication property="name"/>
	</button>-->
	<p>Bienvenido <sec:authentication property="name"/></p>
	<sec:csrfInput />
		<header>
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<ul class="container-fluid">
				<a class="navbar-brand" href="../resources/img/logo.png">OlympicFisio</a>
    			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      				<span class="navbar-toggler-icon"></span>
    			</button>
    			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    				<div class="navbar-nav">
					  <ul class="navbar-nav flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link" aria-current="page" href="/">Inicio</a></li> 	
						<li class="nav-item dropdown">
                    		<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       			Tratamientos y Servicios
                    		</a>
                      		<ul class="dropdown-menu">
                         		<li><a class="dropdown-item" href="/producto/productosFamilia/1">Fisioterapia</a></li>
                         		<li> <hr class="dropdown-divider"> </li>
                         		<li><a class="dropdown-item" href="/producto/productosFamilia/2">Acupuntura</a></li>
                         		<li><hr class="dropdown-divider"></li>
                         		<li><a class="dropdown-item" href="/producto/productosFamilia/3">Técnicas especiales</a></li>
                       		</ul>
                       	 </li>					
        				 <li class="nav-item">  <a class="nav-link" href="#">Contacto</a>
        				 <sec:authorize access="!isAuthenticated()">
						  <li class="main-nav__item"><a href="/entrar" class="nav-link">Entrar</a></li>	
						  <li class="main-nav__item"><a href="/altausuario" class="nav-link">Registro</a></li>		
					     </sec:authorize>
						<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">
							<li class="main-nav__item"><a class="nav-link" href="/rol/todos">Roles</a></li>
							<li class="main-nav__item"><a class="nav-link" href="/usuario/todos">Lista de usuarios</a></li>						
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
							<li class="main-nav__item"><a class="nav-link" href="/cita/todas">Citas</a></li>
							<li class="main-nav__item"><a class="nav-link" href="/familia/todas">Familias</a></li>
							<li class="main-nav__item"><a class="nav-link" href="/producto/todos">Lista de productos</a></li>
							<li class="main-nav__item"><a class="nav-link" href="/usuario/misDatos">Mis Datos</a></li>		
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">	
							<li class="main-nav__item"><a class="nav-link" href="/logout">Salir</a></li> 
						</sec:authorize>
					</ul>	
				</div>
			</div>
			</ul>
		</nav>
		</header>		
		<footer>
				<p class="mensaje-exito" style="color:green;">${ mensajeExito }</p>
				<p class="mensaje-error" style="color:red;">${ mensajeError }</p>
		</footer>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" 
		data-integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" data-crossorigin="anonymous"></script>
</body>
</html>