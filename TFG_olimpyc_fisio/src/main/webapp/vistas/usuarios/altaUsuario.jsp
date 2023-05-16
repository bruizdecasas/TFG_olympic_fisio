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
            <label for="emailUsuario">Email</label>
            <input type="text" name="emailUsuario" id="emailUsuario" required />
            <label for="password">Contraseña</label>
            <input type="text" name="password" id="password" required />
        </fieldset>
        <fieldset class="default">
            <label for="nombreUsuario">Nombre</label>
            <input type="text" name="nombreUsuario" id="nombreUsuario" required />
            <label for="apellidosUsuario">Apellido</label>
            <input type="text" name="apellidosUsuario" id="apellidosUsuario" required />
            <label for="fechaNacimiento">Fecha Nacimiento</label>
            <input type="date" name="fechaNacimiento" id="fechaNacimiento" required />
        </fieldset>
        <fieldset>
            <label for="telefono">Teléfono</label>
            <input type="text" name="telefono" id="telefono" required />
            <label for="sociedadMedica">Sociedad Médica</label>
            <input type="text" name="sociedadMedica" id="sociedadMedica" />
        </fieldset>
        <sec:authorize access="hasAuthority('Administrador')">
            <fieldset>
                <label for="idRol">Rol</label>
                <select name="idRol" id="idRol">
                    <option value="">Seleccionar rol</option>
                    <c:forEach var="ele" items="${listaRol}">
                        <option value="${ele.idRol}">${ele.nombreRol}</option>
                    </c:forEach>
                </select>
            </fieldset>
        </sec:authorize>
        <button type="submit" class="btn-link">Alta de usuario</button>
    </fieldset>
</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>
