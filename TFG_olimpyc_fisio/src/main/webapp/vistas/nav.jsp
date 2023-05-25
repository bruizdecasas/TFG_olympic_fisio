<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>

<title>Menú de navegacion</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>OlympicFisio</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
  	<!-- Facebook and Twitter integration -->
	
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600,400italic,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" 
	data-integrity="sha512-bz/zkQ/xt3LsX+Zx1rWu/4Hh0qNrR2siZn9T2Y0CweMv2LwX5YiLw3tV5uLZdQj2NC1wx8u4Phgz+2QIn9KkDQ==" data-crossorigin="anonymous" data-referrerpolicy="no-referrer" />
		
	<!-- Animate.css -->
	
	<link rel="stylesheet" type="text/css" href="/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" type="text/css" href="/css/icomoon.css">
	<!-- Simple Line Icons -->
	<link rel="stylesheet" type="text/css" href="/css/simple-line-icons.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" type="text/css" href="/css/magnific-popup.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/css/style3.css">

	<!-- Modernizr JS -->
	<script src="/js/modernizr-2.6.2.min.js"></script>
	
</head>

<sec:csrfInput />
		<header role="banner" id="fh5co-header">
			<div class="container">
				<!-- <div class="row"> -->
			  <nav class="navbar navbar-default">
		        <div class="navbar-header">
		        	<!-- Mobile Toggle Menu Button -->
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"><i></i></a>
		         <a class="navbar-brand" href="/">OLYMPIC FISIO</a> 
		        </div>
		        <div id="navbar" class="navbar-collapse collapse">
		         
		          <ul class="nav navbar-nav navbar-right">
		            <li class="active"><a href="/"><span>Home</span></a></li>
		               	<li><a href="/producto/todos"><span>Tratamientos</span></a></li>
		            	<li><a data-nav-section="opiniones"><span>Opiniones</span></a></li>
		            	<li><a href="#" data-nav-section="equipo"><span>Equipo</span></a></li>
		            	<li><a href="#" data-nav-section="contacto"><span>Contacto</span></a></li>
		            <sec:authorize access="!isAuthenticated()">    	
		               	<li><a href="/entrar" data-nav-section="entrar"><span>Entrar</span></a></li>
		            	<li><a href="/usuario/alta"><span>Registrarse</span></a></li>
					</sec:authorize>
					<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">
						<li><a href="/usuario/todos">Lista de usuarios</a></li>						
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a href="/cita/todas">Citas</a></li>
						<li><a href="/familia/todas">Familias</a></li>
						<li><a href="/producto/todos">Lista de productos</a></li>
						<li><a href="/usuario/misDatos">Mis Datos</a></li>		
						<li class="main-nav__item"><a class="nav-link" href="/logout">Salir</a></li> 
					</sec:authorize>
		          </ul>
		        </div>
		      </nav>
		 </div>
	</header>
<!-- jQuery -->
	<script src="../src/main/resources/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="../src/main/resources/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="../src/main/resources/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="../src/main/resources/js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="../src/main/resources/js/jquery.stellar.min.js"></script>
	<!-- Counter -->
	<script src="../src/main/resources/js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="../src/main/resources/js/jquery.magnific-popup.min.js"></script>
	<script src="../src/main/resources/js/magnific-popup-options.js"></script>
	<!-- Google Map -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
	<script src="../src/main/resources/js/google_map.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="../src/main/resources/js/main.js"></script>
	


</html>