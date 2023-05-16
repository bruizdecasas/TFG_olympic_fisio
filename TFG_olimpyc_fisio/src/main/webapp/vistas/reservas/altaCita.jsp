<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Cita</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Dar de alta una nueva Cita</h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/cita/alta" method="post">
			
			<fieldset class="full-form">
				<legend>Introduce los datos de la cita</legend>
			<fieldset class="default">
				<fieldset class="default">
					<label for="fechaCita">Fecha</label>
					<input type="date" name="fechaCita" id="fechaCita" required />
					<label for="horaCita">Hora</label>
					<select name="horaCita" id="horaCita" required>
						<option value="">Selecciona una hora</option>
						<option value="09.00">09.00</option>
						<option value="10.00">10.00</option>
						<option value="11.00">11.00</option>
						<option value="12.00">12.00</option>
						<option value="13.00">13.00</option>
						<option value="14.00">14.00</option>
						<option value="15.00">15.00</option>
						<option value="16.00">16.00</option>
						<option value="17.00">17.00</option>
						<option value="18.00">18.00</option>
						<option value="19.00">19.00</option>
						<option value="20.00">20.00</option>											
					</select>		
				</fieldset>		
				<fieldset class="default">
					<label for="observaciones">Observaciones</label>
					<input type="text" name="observaciones" id="observaciones"/>
				</fieldset>	
				<button type="submit" class="btn-link">Alta Cita</button>
			</fieldset>
		</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>
