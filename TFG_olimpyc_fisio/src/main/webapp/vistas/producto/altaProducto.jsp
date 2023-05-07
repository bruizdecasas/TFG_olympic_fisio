<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Producto</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Dar de alta un nuevo producto</h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/producto/alta/" method="post">
			
			<fieldset class="full-form">
				<legend>Introduce los datos del nuevo producto</legend>
			<fieldset class="default">
				<fieldset class="default">
					<label for="nombreProducto">Nombre</label>
					<input type="text" name="nombreProducto" id="nombre_producto" required />
					<label for="descripcionProducto">Descripcion</label>
					<input type="text" name="descripcionProducto" id="descripcion_producto" required />		
				</fieldset>		
				<fieldset class="default">
					<label for="precioProducto">Precio</label>
					<input type="number" step="0.5" min="0" name="precioProducto" id="precio_producto" required />
					<select name="idFamilia" id="id_familia" required>
						<c:forEach var="ele" items="${ listaFamilia }">
							<option value="${ ele.idFamilia }">${ ele.nombreFamilia }</option>
						</c:forEach>
					</select>
				</fieldset>	
				<button type="submit" class="btn-link">Alta Producto</button>
			</fieldset>
		</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>