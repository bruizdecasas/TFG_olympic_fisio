<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Familia</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Editar Familia</h1>
		<a class="btn-link" href="/familia/todas">Volver</a>
		<form action="/familia/editar" method="post">	
			<fieldset class="full-form">
				<legend>Introduce los datos para editar la familia con id: ${ familia.idFamilia }</legend>
			<fieldset class="default">
				<fieldset class="default">
					<label for="id_familia">Id de la Familia</label>
					<input type="number" name="idFamilia" id="id_familia" required value="${ familia.idFamilia }"/>		
				</fieldset>
				<fieldset class="default">
						<label for="nombre_familia">Nombre de la Familia</label>
					<input type="text" name="nombreFamilia" id="nombre_familia" required placeholder="${ familia.nombreFamilia }"/>		
				</fieldset>	
					<fieldset class="default">
						<label for="descripcion_familia">Descripción de la Familia</label>
					<input type="text" name="descripcionFamilia" id="descripcion_familia" required placeholder="${ familia.descripcionFamilia }"/>		
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