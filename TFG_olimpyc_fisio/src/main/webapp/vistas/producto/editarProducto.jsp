<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Producto</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Editar el producto: ${ producto.idProducto } - ${ producto.nombreProducto } </h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/producto/editar" method="post">
			
			<fieldset class="full-form">
				<legend>Introduce los datos del nuevo producto</legend>
			<fieldset class="default">
					<fieldset class="default">
						<input type="hidden" name="idProducto" id="id_producto" required value="${ producto.idProducto }"/>		
				</fieldset>
				<fieldset class="default">
					<label for="nombreProducto">Nombre</label>
					<input type="text" name="nombreProducto" id="nombre_producto" required placeholder="${ producto.nombreProducto}"/>
					<label for="descripcion">Descripción</label>
					<input type="text" name="descripcion" id="descripcion" required placeholder="${ producto.descripcion}"/>		
				</fieldset>		
				<fieldset class="default">
					<label for="precio">Precio</label>
					<input type="number" step="0.5" min="0" name="precio" id="precio" required placeholder="${ producto.precio}"/>
					<select name="idFamilia" id="id_familia" required>
						<c:forEach var="ele" items="${ listaFamilia }">
							<option value="${ ele.idFamilia }">${ ele.nombreFamilia }</option>
						</c:forEach>
					</select>
				</fieldset>	
				<button type="submit" class="btn-link">Editar</button>
			</fieldset>
		</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>