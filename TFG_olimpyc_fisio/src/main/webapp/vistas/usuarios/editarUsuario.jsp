<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de productos</title>
	<title>OlympicFisio</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
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
	
	<link rel="stylesheet" type="text/css" href="../css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" type="text/css" href="../css/icomoon.css">
	<!-- Simple Line Icons -->
	<link rel="stylesheet" type="text/css" href="../css/simple-line-icons.css">
	<!-- Magnific Popup -->
	<link rel="stylesheet" type="text/css" href="../css/magnific-popup.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css">

	
	<link rel="stylesheet" type="text/css" href="../css/style3.css">
	
	<link rel="stylesheet" type="text/css" href="../css/_precios.css">

	<!-- Modernizr JS -->
	<script src="../js/modernizr-2.6.2.min.js"></script>
<style>

    .contenedor {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100%;
    }

    .form {
      max-width: 30%;
    }

    .campos {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
	
	.botones{
	margin-top: 5%;
	display:flex;
	justify-content: space-between;
	}

</style>
</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<section id="fh5co-home" data-section="home" style="background-image: url(../images/Portada.jpg);" data-stellar-background-ratio="0.5">
		<div class="gradient"></div>
		<p>Bienvenido <sec:authentication property="name"/></p>
		<div class="container">
			<div class="text-wrap">
				<div class="text-inner">
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<h1 class="to-animate">Gestion de usuarios</h1>
							<h2 class="to-animate">Editar los datos de los usuarios </h2>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="slant"></div>
	</section>
		<sec:csrfInput />

	<div class="contenedor">
		<form class="form" action="/usuario/editar" method="post">
			<fieldset class="full-form">
				<legend>Introduce los nuevos datos ${usuario.nombreUsuario } ${usuario.apellidosUsuario }</legend>
			<fieldset class="default">
			<input type="hidden" name="idUsuario" id="idUsuario" required value="${ usuario.idUsuario }"/>	
				<fieldset class="default">
					<label for="emailUsuario">Email</label>
					<input type="text" name="emailUsuario" id="emailUsuario" required placeholder="${usuario.emailUsuario }" class="campos"/>	
				</fieldset>		
				<fieldset class="default">
					<label for="nombre_usuario">Nombre</label>
					<input type="text" name="nombreUsuario" id="nombreUsuario" required value="${usuario.nombreUsuario }" class="campos"/>
					<label for="apellido_usuario">Apellido</label>
					<input type="text" name="apellidosUsuario" id="apellidosUsuario" required value="${usuario.apellidosUsuario }" class="campos"/>
					<label for="fecha_nacimiento">Fecha Nacimiento</label>
					<input type="date" name="fechaNacimiento" id="fechaNacimiento" required value="${usuario.fechaNacimiento }" class="campos"/>
				</fieldset>	
				<fieldset>
					<label for="telefono">Teléfono</label>
					<input type="text" name="telefono" id="telefono" required value="${usuario.telefono }" class="campos"/>
					<label for="sociedadMedica">Sociedad Médica </label> (opcional)
					<input type="text" name="sociedadMedica" id="sociedadMedica" value="${usuario.sociedadMedica }" class="campos" />
				</fieldset>
				<fieldset>
					<sec:authorize access="hasAuthority('Administrador')">
						<label for="enabled">Activo/inactivo</label>
						<select name="enabled" id="enabled" required class="campos">
							<option value="1" selected>Activo</option>
							<option value="0">Inactivo</option>
						</select>
						<label for ="rol">Rol</label>
						<select name="idRol" id="idRol" required class="campos">
						<option value="3" selected class="campos">Seleccionar rol</option>
						<c:forEach var="ele" items="${ listaRol }">
							<option value="${ ele.idRol }">${ ele.nombreRol }</option>
						</c:forEach>
					</select>	
					</sec:authorize>
				</fieldset>
				<div class="botones">
				<button type="submit" class="btn btn-primary">Editar usuario</button>
				<a class="btn btn-primary" href="/">Volver</a>
				</div>
			</fieldset>
		</fieldset>
		</form>
	</div>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
		<jsp:include page="../footer.jsp"></jsp:include>
			
	<!-- jQuery -->
	<script src="../js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="../js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="../js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="../js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="../js/jquery.stellar.min.js"></script>
	<!-- Counter -->
	<script src="../js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="../js/jquery.magnific-popup.min.js"></script>
	<script src="../js/magnific-popup-options.js"></script>
	<!-- Google Map -->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
	<script src="../js/google_map.js"></script>

	<!-- Main JS (Do not remove) -->
	<script src="../js/main.js"></script>
	</body>
</html>
