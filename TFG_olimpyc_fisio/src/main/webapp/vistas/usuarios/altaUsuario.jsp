<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta de nuevo usuario</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Alta de nuevo usuario</h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/usuario/alta" method="post">
			
			<fieldset class="full-form">
				<legend>Introduzca sus datos</legend>
			<fieldset class="default">
				<fieldset class="default">
					<label for="emailUsuario">Email</label>
					<input type="text" name="emailUsuario" id="emailUsuario" required />
					<label for="password">Contraseña</label>
					<input type="text" name="password" id="password" required />		
				</fieldset>		
				<fieldset class="default">
					<label for="nombre_usuario">Nombre</label>
					<input type="text" name="nombreUsuario" id="nombreUsuario" required />
					<label for="apellido_usuario">Apellido</label>
					<input type="text" name="apellidosUsuario" id="apellidosUsuario" required />
					<label for="fecha_nacimiento">Fecha Nacimiento</label>
					<input type="date" name="fechaNacimiento" id="fechaNacimiento" required/>
				</fieldset>	
				<fieldset>
					<label for="telefono">Teléfono</label>
					<input type="text" name="telefono" id="telefono" required />
					<label for="sociedadMedica">Sociedad Médica</label>
					<input type="text" name="sociedadMedica" id="sociedadMedica" />
				</fieldset>
				<fieldset>
					<sec:authorize access="hasAuthority('Administrador')">
						<label for ="rol">Rol</label>
						<select name="idRol" id="idRol" required>
						<option value="3">Seleccionar rol</option>
						<c:forEach var="ele" items="${ listaRol }">
							<option value="${ ele.idRol }">${ ele.nombreRol }</option>
						</c:forEach>
					</select>	
					</sec:authorize>
				</fieldset>
				<button type="submit" class="btn-link">Alta de usuario</button>
			</fieldset>
		</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>