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
	</head>
	<body>
	<jsp:include page="../menu.jsp"></jsp:include>
		<h2>Citas disponibles</h2>
		<table>
			<thead>
				<tr><th>Fecha</th>
				<th>hora</th>
				<th>Especialista</th>
				<th class="buffer-cell"></th>
				<th colspan="10">Opciones</th></tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listacitas }">
					<tr>
						
						<td>${ ele.fechaCita }</td>
						<td>${ ele.horaCita }</td>
						<td>${ ele.usuario.nombreUsuario }</td>	

								
						<td class="buffer-cell"></td>		
								
						<sec:authorize access="hasAnyAuthority('Cliente', 'Administrador', 'Especialista')">
							<!-- <td><a href="/cita/reserva/${ ele.idCita }">Reservar</a></td> -->
							<td><a href="/cita/detalle/${ ele.idCita }">Detalle</a></td>
						</sec:authorize>
						<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">
							<td><a href="/cita/editar/${ ele.idCita }">Editar</a></td>
							<td><a href="/cita/eliminar/${ ele.idCita }">Eliminar</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="default">
					<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">
						<a class="btn-link" href="/cita/alta">Crear Cita</a>
					</sec:authorize>
					<sec:authorize access="hasAnyAuthority('Cliente', 'Administrador', 'Especialista')">
						<a class="btn-link" href="/cita/todas">Ver todas las citas</a>
					</sec:authorize>
			</table>
		<footer>
				<p class="mensaje-exito" style="color:green;">${ mensajeExito }</p>
				<p class="mensaje-error" style="color:red;">${ mensajeError }</p>
		</footer>
		
	</body>
</html>
