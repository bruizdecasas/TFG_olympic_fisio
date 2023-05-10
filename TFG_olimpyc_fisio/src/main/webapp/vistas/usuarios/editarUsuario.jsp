<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar usuario</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Editar al usuario ${usuario.nombreUsuario } ${usuario.apellidosUsuario }</h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/" method="post">
			<fieldset class="full-form">
				<legend>Introduzca los nuevos datos</legend>
			<fieldset class="default">
			<input type="hidden" name="idUsuario" id="idUsuario" required value="${ usuario.idUsuario }"/>	
				<fieldset class="default">
					<label for="emailUsuario">Email</label>
					<input type="text" name="emailUsuario" id="emailUsuario" required placeholder="${usuario.emailUsuario }" />
					<input type="hidden" name="password" id="password" required value="${usuario.password} }"/>		
				</fieldset>		
				<fieldset class="default">
					<label for="nombre_usuario">Nombre</label>
					<input type="text" name="nombreUsuario" id="nombreUsuario" required placeholder="${usuario.nombreUsuario }"/>
					<label for="apellido_usuario">Apellido</label>
					<input type="text" name="apellidosUsuario" id="apellidosUsuario" required placeholder="${usuario.apellidosUsuario }"/>
					<label for="fecha_nacimiento">Fecha Nacimiento</label>
					<input type="date" name="fechaNacimiento" id="fechaNacimiento" required/>
				</fieldset>	
				<fieldset>
					<label for="telefono">Teléfono</label>
					<input type="text" name="telefono" id="telefono" required placeholder="${usuario.telefono }"/>
					<label for="sociedadMedica">Sociedad Médica</label>
					<input type="text" name="sociedadMedica" id="sociedadMedica" />
				</fieldset>
				<fieldset>
					<sec:authorize access="hasAuthority('Administrador')">
						<label for="enabled">Activo/inactivo</label>
						<select name="enabled" id="enabled" required>
							<option value="1" selected>Activo</option>
							<option value="0">Inactivo</option>
						</select>
						<label for ="rol">Rol</label>
						<select name="idRol" id="idRol" required>
						<option value="3">Seleccionar rol</option>
						<c:forEach var="ele" items="${ listaRol }">
							<option value="${ ele.idRol }">${ ele.nombreRol }</option>
						</c:forEach>
					</select>	
					</sec:authorize>
				</fieldset>
				<button type="submit" class="btn-link">Editar usuario</button>
			</fieldset>
		</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>