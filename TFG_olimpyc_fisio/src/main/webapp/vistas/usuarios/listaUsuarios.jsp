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
				<tr><th>Nombre</th><th>Apellidos</th><th>Email</th><th>fecha de nacimiento</th>
				<th>Teléfono</th><th>Sociedad Médica</th>
				<th class="nav-item dropdown">
    				<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Rol</a>
    					<ul class="dropdown-menu">
    						<li><a class="dropdown-item" href="/usuario/todos/">Todos los roles</a></li>
        					<li><hr class="dropdown-divider"></li>
        					<li><a class="dropdown-item" href="/usuario/rol/1">Administrador</a></li>
        					<li><hr class="dropdown-divider"></li>
        					<li><a class="dropdown-item" href="/usuario/rol/2">Especialistas</a></li>
        					<li><hr class="dropdown-divider"></li>
        					<li><a class="dropdown-item" href="/usuario/rol/3">Clientes</a></li>
    					</ul>
				</th>
				<th class="buffer-cell"></th>
				<th colspan="10">Opciones</th></tr>				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listaUsuarios }">
					<tr>
						
						<td>${ ele.nombreUsuario }</td>
						<td>${ ele.apellidosUsuario }</td>
						<td>${ ele.emailUsuario }</td>
						<td>${ ele.fechaNacimiento }</td>
						<td>${ ele.telefono }</td>
						<td>${ ele.sociedadMedica }</td>
						<td>${ ele.rol.nombreRol }</td>
						
												
						<td class="buffer-cell"></td>
						<sec:authorize access="hasAnyAuthority ('Administrador', 'Especialista')">
							<td><a href="/usuario/detalle/${ ele.idUsuario }">Detalle</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('Administrador')">
							<td><a href="/usuario/editar/${ ele.idUsuario }">Editar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('Administrador')">
							<td><a href="/usuario/eliminar/${ ele.idUsuario }">Eliminar</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="default">
					<sec:authorize access="hasAuthority('Administrador')">
						<a class="btn-link" href="/usuario/alta">Crear Usuario</a>
					</sec:authorize>
			</table>
	</body>
</html>
