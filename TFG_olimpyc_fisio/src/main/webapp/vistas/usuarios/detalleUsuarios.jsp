<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ usuario.nombreUsuario}</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/detalle.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<section class="default">
		
		<table class="default">
			<thead>
				<tr class="default">
					<th>Nombre</th>
					<th>Apellidos</th>
					<th>E-mail</th>
					<th>Fecha de nacimiento</th>
					<th>Teléfono</th>
					<th>Sociedad Médica</th>
				</tr>
			</thead>
			<tbody>
				<tr class="default">
					<td>${ usuario.nombreUsuario }</td>
					<td>${ usuario.apellidosUsuario }</td>
					<td>${ usuario.emailUsuario };</td>
					<td>${ usuario.fechaNacimiento }</td>
					<td>${ usuario.telefono }</td>
					<td>${ usuario.sociedadMedica }</td>
				</tr>
			</tbody>
		</table>
		</section>			
			<a class="btn-link" href="/usuario/editar/${ usuario.idUsuario }">Editar</a>
		<sec:authorize access="hasAuthority('Administrador')">
			<a class="btn-link" href="/usuario/eliminar/${ usuario.idUsuario }">Eliminar</a>
		</sec:authorize>
			<a class="btn-link" href="/usuario/password">Cambiar contraseña</a>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>