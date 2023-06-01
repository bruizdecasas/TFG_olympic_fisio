<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
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

<link
	href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,300,600,400italic,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	data-integrity="sha512-bz/zkQ/xt3LsX+Zx1rWu/4Hh0qNrR2siZn9T2Y0CweMv2LwX5YiLw3tV5uLZdQj2NC1wx8u4Phgz+2QIn9KkDQ=="
	data-crossorigin="anonymous" data-referrerpolicy="no-referrer" />

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
<script src="../js/modernizr-2.6.2.min.js"></script>

</head>


<body>

	<sec:csrfInput />
	<header role="banner" id="fh5co-header">
		<div class="container">
			<nav class="navbar navbar-default">
				<div class="navbar-header">
					<!-- Mobile Toggle Menu Button -->
					<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar"><i></i></a> <a class="navbar-brand"
						href="/">OLYMPIC FISIO</a>
				</div>
				<div class="nav navbar-nav navbar-right" id="navbarNavAltMarkup">

					<ul class="nav navbar-nav navbar-right">
						<sec:authorize access="!isAuthenticated()">
							<li><a href="#fh5co-intro">Tratamientos</a></li>
							<li><a href="#fh5co-work">Nuestros Especialistas</a></li>
							<li><a href="#fh5co-testimonials">Opiniones</a></li>
							<li><a href="/entrar" class="nav-link">Entrar</a></li>
							<li><a href="/usuario/alta" class="nav-link">Registro</a></li>
							<li><a href="#fh5co-contact">Contacto</a>
						</sec:authorize>

						<sec:authorize
							access="hasAnyAuthority('Administrador', 'Especialista')">
							<li><a href="/usuario/todos">Gestión Usuarios</a></li>
							<li><a href="/reserva/todas"> Gestión Reservas</a></li>
						</sec:authorize>
						<sec:authorize access="hasAnyAuthority('Cliente')">
							<li><a class="nav-link" href="/reserva/misResevas">Mis
									Reservas</a></li>
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
							<li><a class="nav-link" href="/cita/todas">Gestión Citas</a></li>
							<li><a class="nav-link" href="/familia/todas">Técnicas</a></li>
							<li><a class="nav-link" href="/producto/todos">Tratamientos</a></li>
							<li><a class="nav-link" href="/usuario/misDatos">Mis
									Datos</a></li>
							<li><a class="nav-link" href="/logout">Salir</a></li>
						</sec:authorize>


					</ul>
				</div>
		</div>
		</ul>
		</nav>
	</header>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		data-integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		data-crossorigin="anonymous"></script>

	<!-- jQuery -->
	<script src="/js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="/js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="/js/jquery.stellar.min.js"></script>
	<!-- Counter -->
	<script src="/js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="/js/jquery.magnific-popup.min.js"></script>
	<script src="/js/magnific-popup-options.js"></script>
	<!-- Google Map -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
	<script src="/js/google_map.js"></script>
	<!-- Main JS (Do not remove) -->
	<script src="/js/main.js"></script>
</body>
</html>
