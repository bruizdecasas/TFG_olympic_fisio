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
				<tr><th>Nombre Producto</th><th>Precio</th><th class="buffer-cell"></th>
				<th colspan="10">Opciones</th></tr>
				
			</thead>
			<tbody>
				<c:forEach var="ele" items="${ listaProductos }">
					<tr>
						
						<td>${ ele.nombreProducto }</td>
						<td>${ ele.precio }</td>						
						<td class="buffer-cell"></td>
						<sec:authorize access="hasAnyAuthority ('Cliente', 'Administrador')">
							<td><a href="/producto/detalle/${ ele.idProducto }">Detalle</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('Administrador')">
							<td><a href="/producto/editar/${ ele.idProducto }">Editar</a></td>
						</sec:authorize>
						<sec:authorize access="hasAuthority('Administrador')">
							<td><a href="/producto/eliminar/${ ele.idProducto }">Eliminar</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table class="default">
					<sec:authorize access="hasAuthority('Administrador')">
						<a class="btn-link" href="/producto/alta">Crear Producto</a>
					</sec:authorize>
			</table>
		
		
	</body>
</html>
