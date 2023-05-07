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
		<table>
			<thead>
				<tr><th>Fecha</th><th>hora</th><th>Especialista</th></th><th class="buffer-cell"></th>
				<th colspan="10">Opciones</th></tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listacitas }">
					<tr>
						
						<td>${ ele.fechaCita }</td>
						<td>${ ele.horaCita }</td>	
						<td>${ ele.especialista.getNombre }</td>					
						<td class="buffer-cell"></td>		
								
						<sec:authorize access="hasAuthority('ROLE_USUARIO', 'ROLE_ADMIN')">
							<td><a href="/cita/detalle/${ ele.idCita }">Detalle</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('ROLE_ADMIN')">
							<td><a href="/cita/editar/${ ele.idCita }">Editar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('ROLE_ADMIN')">
							<td><a href="/cita/eliminar/${ ele.idCita }">Eliminar</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="default">
					<sec:authorize access="hasAuthority('ROLE_ADMIN')">
						<a class="btn-link" href="/cita/alta">Crear Cita</a>
					</sec:authorize>
			</table>
		
		
	</body>
</html>