
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Rol</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Editar el rol: ${ rol.nombreRol } </h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/rol/alta" method="post">
			
			<fieldset class="full-form">
				<legend>Introduce los datos para el nuevo Rol</legend>
			<fieldset class="default">							
					<input type="hidden" name="idRol" id="idRol" required value="${ rol.idRol }"/>		
				</fieldset>
				<fieldset class="default">
					<label for="nombreRol">Nombre Rol</label>
					<input type="text" name="nombreRol" id="nombreRol" required />		
				</fieldset>		
				<button type="submit" class="btn-link">Editar el Rol</button>
			</fieldset>
	</body>
</html>
