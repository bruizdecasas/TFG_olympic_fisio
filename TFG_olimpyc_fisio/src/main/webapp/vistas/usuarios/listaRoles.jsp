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
				<tr>
				<th>Id Rol</th>
				<th>Nombre Rol</th>
				<th colspan="10">Opciones</th>				
				</tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listaRoles }">
					<tr>						
						<td>${ ele.idRol }</td>
						<td>${ ele.nombreRol }</td>
						<sec:authorize access="hasAuthority('Administrador')">
							<td><a href="/rol/editar/${ ele.idRol }">Editar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('Administrador')">
							<td><a href="/rol/eliminar/${ ele.idRol }">Eliminar</a></td>
						</sec:authorize>						
					</tr>
				</c:forEach>					
			</tbody>
		</table>
					<table class="default">
					<sec:authorize access="hasAuthority('Administrador')">
						<a class="btn-link" href="/rol/alta">Crear Rol</a>
					</sec:authorize>
			</table>
		
	</body>
</html>