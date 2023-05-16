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
				<h2>Reservas</h2>
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
			<c:forEach var="ele" items="${ listareservas }">
				<tr class="default">
					<td>${ ele.cita.fechaCita }</td> 
					<td>${ ele.cita.horaCita }</td>
					<td>${ ele.cita.usuario.nombreUsuario }</td>
					<td>${ ele.cita.observaciones }</td>
					<td>${ ele.observacionesResevas }</td>

				<sec:authorize access="hasAnyAuthority('Cliente', 'Administrador', 'Especialista')">	
					<td><a class="btn-link" href="/reserva/cancelar/${ ele.idReserva }">Cancelar</a></td>
					<td><a class="btn-link" href="/reserva/detalle/${ ele.idReserva }">Detalle</a></td>
				</sec:authorize>
				<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">	
					<td><a class="btn-link" href="/reserva/editar/${ ele.idReserva }">Editar</a></td>
				</sec:authorize>
				
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</section>
			<p class="mensaje-exito">${ mensajeExito }</p>
			<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
