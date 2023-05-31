<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
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
		<section id="fh5co-home" data-section="home" style="background-image: url(../images/Portada.jpg);" data-stellar-background-ratio="0.5">
		<div class="gradient"></div>
		<p>Bienvenido <sec:authentication property="name"/></p>
		<div class="container">
			<div class="text-wrap">
				<div class="text-inner">
					<div class="row">
						<div class="">
							<h1 class="to-animate">Alta Familia</h1>
							<h2 class="to-animate">Administración de las familias</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="slant"></div>
	</section>
		<sec:csrfInput />

		<div class="contenedor">		
		<form action="/familia/alta" method="post" class="form">
			
			<fieldset class="full-form">
				<legend>Introduce los datos para la nueva familia</legend>
			<fieldset class="default">
				<fieldset class="default">
						<label for="nombre_familia">Nombre de la Familia</label>
					<input type="text" name="nombreFamilia" id="nombre_familia" required class="campos"/>		
				</fieldset>	
					<fieldset class="default">
						<label for="descripcion_familia">Descripción de la Familia</label>
					<input type="text" name="descripcionFamilia" id="descripcion_familia" required class="campos"/>		
				</fieldset>	
				<div class=botones>
				<a href="/familia/todas"><button type="submit" class="btn btn-primary">Dar de alta</button></a>
				<a class="btn btn-primary" href="/familia/todas">Volver</a>
				</div>	
			</fieldset>
		</fieldset>
		</form>
		</div>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		
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