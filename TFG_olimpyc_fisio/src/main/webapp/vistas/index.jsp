<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
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
<script src="/js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
<style>
.item1 {
	grid-area: item1;
}

.item2 {
	grid-area: item2;
}

.info {
	display: grid;
	grid-template-areas: 'item1' 'item2';
	justify-content: center;
}
</style>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>

	<section id="fh5co-home" data-section="home"
		style="background-image: url(images/Portada.jpg);"
		data-stellar-background-ratio="0.5">
		<div class="gradient"></div>

		<div class="container">
			<div class="text-wrap">
				<div class="text-inner">
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<h1 class="to-animate">Olympic Fisio</h1>
							<h2 class="to-animate">Clínica especializada en fisioterapia
								deportiva, tenemos la convicción de que las necesidades de
								nuestros clientes son lo más importante.</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="slant"></div>
	</section>

	<section id="fh5co-intro" data-section="Tratamientos">
		<div class="container">
			<div class="row row-bottom-padded-lg">
				<div class="fh5co-block to-animate"
					style="background-image: url(images/Portada.jpg);">
					<div class="overlay-darker"></div>
					<div class="overlay"></div>
					<div class="fh5co-text">
						<h2>Fisioterapia</h2>
						<p>Tenemos una gran variedad de tratamientos para poder
							adaptarnos tanto a los presupuestos como a las preferencias
							personales. Consúltanos sin compromiso</p>

					</div>
				</div>
				<div class="fh5co-block to-animate"
					style="background-image: url(images/diatermia.jpg);">
					<div class="overlay-darker"></div>
					<div class="overlay"></div>
					<div class="fh5co-text">
						<h2>Técnicas Especiales</h2>
						<p>En OlympicFisio la formación continuada es la clave para la
							mejora de las dolencias de nuestros pacientes con la tecnología y
							metodología más novedosa.</p>

					</div>
				</div>
				<div class="fh5co-block to-animate"
					style="background-image: url(images/puncion-seca.jpg);">
					<div class="overlay-darker"></div>
					<div class="overlay"></div>
					<div class="fh5co-text">
						<h2>Tecnicas Invasivas</h2>
						<p>La Punción Seca es una técnica semi-invasiva que utiliza la
							punción con agujas de acupuntura para el tratamiento de la
							afección músculo-esquelética conocida como Punto Gatillo.</p>

					</div>
				</div>
			</div>
			<!--<div class="row watch-video text-center to-animate">
				<span>Watch the video</span>

				<a href="https://vimeo.com/channels/staffpicks/93951774" class="popup-vimeo btn-video"><i class="icon-play2"></i></a>
			</div>-->
		</div>
	</section>

	<section id="fh5co-work" data-section="equipo">
		<div class="container">
			<div class="row">
				<div class="col-md-12 section-heading text-center">
					<h2 class="to-animate">Nuestros especialistas</h2>
					<div class="row">
						<div class="col-md-8 col-md-offset-2 subtext to-animate">
							<h3>OlympicFisio está especializada en rehabilitación de
								lesiones deportivas, contando en su equipo con profesionales de
								amplia trayectoria que aportan a su experiencia profesional sus
								conocimientos adquiridos a lo largo de su propia carrera
								deportiva.</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="row row-bottom-padded-sm">
				<div class="col-md-4 col-sm-6 col-xxs-12">
					<a href="images/fisio1.jpg"
						class="fh5co-project-item image-popup to-animate"> <img
						src="images/fisio1.jpg" alt="Image" class="img-responsive">
						<div class="fh5co-text">
							<h2>Jesús Martinez</h2>
							<span>Fisioterapeuta y director del centro</span>
						</div>
					</a>
				</div>
				<div class="col-md-4 col-sm-6 col-xxs-12">
					<a href="images/fisio2.jpg"
						class="fh5co-project-item image-popup to-animate"> <img
						src="images/fisio2.jpg" alt="Image" class="img-responsive">
						<div class="fh5co-text">
							<h2>Pablo Gutierrez</h2>
							<span>Fisioterapeuta</span>
						</div>
					</a>
				</div>

				<div class="clearfix visible-sm-block"></div>

				<div class="col-md-4 col-sm-6 col-xxs-12">
					<a href="images/fisio3.jpg"
						class="fh5co-project-item image-popup to-animate"> <img
						src="images/fisio3.jpg" alt="Image" class="img-responsive">
						<div class="fh5co-text">
							<h2>Susana Fernández</h2>
							<span>Fisioterapeuta</span>
						</div>
					</a>
				</div>


			</div>
			<div class="row"></div>
		</div>
	</section>

	<section id="fh5co-testimonials" data-section="opiniones">
		<div class="container">
			<div class="row">
				<div class="col-md-12 section-heading text-center">
					<h2 class="to-animate">Opiniones de nuestros clientes</h2>
					<div class="row">
						<div class="col-md-8 col-md-offset-2 subtext to-animate">
							<h3>Muchos pacientes quieren compartir sus experiencias y
								hacer sus recomendaciones sobre los especialistas que visitan.
								Las opiniones ayudan cada día a miles de pacientes a elegir y
								confiar en un profesional de la salud.</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="box-testimony">
						<blockquote class="to-animate-2">
							<p>&ldquo;Ha sido mi primera visita al centro y he quedado
								encantada con la completísima atención médica del Dr Jesús
								Martinez. 48 horas después del tratamiento tengo mucho menos
								dolor cervical.&rdquo;</p>
						</blockquote>
						<div class="author to-animate">
							<p>Alicia. 14 de mayo de 2023</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="box-testimony">
						<blockquote class="to-animate-2">
							<p>&ldquo; El trato recibido por el doctor ha sido
								extraordinario. El cuidado mostrado en todo momento ha
								conseguido que me pudiera relajar y calmar mis inquietudes. Las
								instalaciones son relajantes lo cual ayuda a mantener siempre la
								serenidad. Muy agradecida por todo lo que estoy recibiendo y
								mejorando de manera impresionante!.&rdquo;</p>
						</blockquote>
						<div class="author to-animate">
							<p>Blanca. 25 de abril de 2023</p>
						</div>
					</div>
				</div>

				<div class="col-md-4">
					<div class="box-testimony">
						<blockquote class="to-animate-2">
							<p>&ldquo; Excelente trato, profesionalidad, dedicación y
								explicación detallada de los tratamientos. &rdquo;</p>
						</blockquote>
						<div class="author to-animate">
							<p>Carlos. 13 de abril de 2023</p>
						</div>
					</div>
				</div>


			</div>
		</div>
	</section>


	<section id="fh5co-services" data-section="services">
		<div class="container">
			<div class="row">
				<div class="col-md-12 section-heading text-center">
					<h2 class="to-animate">Contáctanos</h2>
					<div class="row">
						<div class="col-md-8 col-md-offset-2 subtext to-animate">
							<h3>Ponte en contacto con nosotros y responderemos tus dudas
								o comentarios a la brevedad.</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="info" id="fh5co-contact">
			<h3 class="item1">Información de contacto</h3>
			<ul class="item2">
				<li class="fh5co-contact-address "><i class="fas fa-home"></i>
					Calle Mayor 8, Madrid</li>
				<li><i class="fas fa-phone"></i> 916354598</li>
				<li><i class="fas fa-envelope"></i> info@olympicfisio.com</li>

			</ul>
		</div>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>


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
