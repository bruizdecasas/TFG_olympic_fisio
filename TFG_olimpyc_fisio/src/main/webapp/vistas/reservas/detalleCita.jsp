<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
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
					<th>Fecha</th>
					<th>Hora</th>					
					<th>Especialista</th>
					<th>Observaciones del especialista</th>
					<th>Observaciones del Cliente</th>
				</tr>
			</thead>
			<tbody>
				<tr class="default">
					<td>${ reserva.cita.fechaCita }</td> 
					<td>${ reserva.cita.horaCita }</td>
					<td>${ reserva.cita.usuario.nombreUsuario }</td>
					<td>${ reserva.cita.observaciones }</td>
					<td>${ reserva.observacionesResevas }</td>

				<sec:authorize access="hasAnyAuthority('Cliente', 'Administrador', 'Especialista')">	
					<td><a class="btn-link" href="/reserva/cancelar/${ cita.idCita }">Cancelar</a></td>
				</sec:authorize>
				<h3>Si deseas modificar los datos de tu reserva, contacta con </h3>
				</tr>
			</tbody>
		</table>
		</section>
			<p class="mensaje-exito">${ mensajeExito }</p>
			<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
