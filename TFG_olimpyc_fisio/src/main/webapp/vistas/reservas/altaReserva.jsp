<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Reservar</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Reservar</h1>
		<a class="btn-link" href="/">Volver</a>	</br>	
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
					<td>${ cita.fechaCita }</td> 
					<td>${ cita.horaCita }</td>
					<td>${ cita.usuario.nombreUsuario }</td>
					<td>${ cita.observaciones }</td>
					<td>${ observacionesResevas }</td>

				<sec:authorize access="hasAnyAuthority('Cliente', 'Administrador', 'Especialista')">	
					<td><a class="btn-link" href="/reserva/cancelar/${ cita.idCita }">Cancelar</a></td>
				</sec:authorize>
				<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">	
					<td><a class="btn-link" href="/reserva/editar/${ ele.idReserva }">Editar</a></td>
				</sec:authorize>
				</tr>
			</tbody>
		<form action="/reserva/alta" method="post">
				<fieldset class="default">
				<input type="hidden" name="idCita" value="${cita.idCita}">
					<label for="observacionesResevas">Observaciones</label>
					<input type="text" name="observacionesResevas" id="observacionesResevas"/>
				</fieldset>	
			<button type="submit" class="btn-link">Confirmar reserva</button>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>
