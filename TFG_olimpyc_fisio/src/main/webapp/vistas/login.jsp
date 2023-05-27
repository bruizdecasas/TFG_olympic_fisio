<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body>
<!-- Formulario -->
<div class="container-fluid" style="margin: 50px 0 20px 0">
    <div class="row">
        <div class="col-sm-4 col-md-4 col-lg-4"></div>
        <div class="col-sm-4 col-md-4 col-lg-4">
            <div class="card card-container">
                <h2 class="text-center" style="margin: 25px 0 25px 0">Iniciar Sesión</h2>
                <form method="post" action="/login">
                    <div class="mb-3" style="margin: 0 25px 0 25px">
                        <label for="username" class="form-label">Email</label>
                        <input type="email" class="form-control" id="username" name="username"
                               aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3" style="margin: 0 25px 0 25px">
                        <label for="password" class="form-label">Contraseña</label>
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-primary" style="margin: 25px 0 25px 0">
                            Iniciar Sesión
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <div class="col-sm-4 col-md-4 col-lg-4"></div>
    </div>
</div>


<!-- Registro -->
<div class="d-flex justify-content-center">
    <blockquote class="blockquote">
        <p>¿No tienes cuenta? <cite title="Source Title"><a href="/registro">create una.</a></cite></p>
    </blockquote>
</div>
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
		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCefOgb1ZWqYtj7raVSmN4PL2WkTrc-KyA&sensor=false"></script>
		<script src="/js/google_map.js"></script>
	<!-- Main JS (Do not remove) -->
		<script src="/js/main.js"></script>
</body>
</html>