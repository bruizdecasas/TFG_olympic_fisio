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
	<h2>Todas las citas</h2>
		<table>
			<thead>
				<tr><th>Fecha</th>
				<th>hora</th>
				<th class="nav-item dropdown">
    				<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Especialista</a>
    					<ul class="dropdown-menu">
    						<li><a class="dropdown-item" href="/cita/todas/">Todos los especialistas</a></li>
        					<li><hr class="dropdown-divider"></li>
    					<c:forEach var="us" items="${listaUsuarios}">
        					<li><a class="dropdown-item" href="/cita/todas/${us.idUsuario}">${us.nombreUsuario}</a></li>
        					<li><hr class="dropdown-divider"></li>
        				</c:forEach>
    					</ul>
				</th>
				<th>Disponibilidad</th>
				<th class="buffer-cell"></th>
				<th colspan="10">Opciones</th></tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listacitas }">
					<tr>
						
						<td>${ ele.fechaCita }</td>
						<td>${ ele.horaCita }</td>
						<td>${ ele.usuario.nombreUsuario }</td>	
						<td>
      						<c:if test="${ele.disponible == 1}"> Disponible </c:if>
      						<c:if test="${ele.disponible == 0}"> Reservada </c:if>
    					</td>
								
						<td class="buffer-cell"></td>		
								
						<sec:authorize access="hasAnyAuthority('Cliente', 'Administrador', 'Especialista')">
							<c:if test="${ele.disponible == 1}">
        						<td><a href="/reserva/alta/${ ele.idCita }">Reservar</a></td>        						
      						</c:if>
      						<c:if test="${ele.disponible == 0}"><td></td></c:if>
							<td><a href="/cita/detalle/${ ele.idCita }">Detalle</a></td>
						</sec:authorize>
						<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">
							<td><a href="/cita/editar/${ ele.idCita }">Editar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAnyAuthority('Administrador', 'Especialista')">
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
						<a class="btn-link" href="/cita/disponible">Ver citas disponibles</a>
					</sec:authorize>
			</table>
		<footer>
				<p class="mensaje-exito" style="color:green;">${ mensajeExito }</p>
				<p class="mensaje-error" style="color:red;">${ mensajeError }</p>
		</footer>
		
	</body>
</html>
