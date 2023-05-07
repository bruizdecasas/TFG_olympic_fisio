<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Cita</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../menu.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Editar Cita</h1>
		<h1 style="color:red;">ESTO HAY QUE REVISARLO POR EL TEMA DE LOS FORMATOS DE FECHA Y HORA</h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/cita/editar" method="post">
			
			<fieldset class="full-form">
				<legend>Introduce los datos de la cita</legend>
			<fieldset class="default">
				<fieldset class="default">
					<input type="hidden" name="idCita" id="idCita" required value="${ cita.idCita }"/>	
					<label for="fecha">Fecha</label>
					<input type="date" name="fecha" id="fechaCita" required />
					<label for="hora">Hora</label>
					<input type="number" step="0.5" min="0" name="hora" id="horaCita" required />		
				</fieldset>		
				<fieldset class="default">
					<label for="observaciones">Observaciones</label>
					<input type="text" name="observaciones" id="observaciones"/>
					<!--  <select name="idFamilia" id="id_familia" required>
						<c:forEach var="ele" items="${ listaFamilia }">
							<option value="${ ele.idFamilia }">${ ele.nombreFamilia }</option>
						</c:forEach>
					</select>-->
				</fieldset>	
				<fieldset class="default">
					<select name="Disponible" id="disponible" required>
						<option value=0>Reservada</option>
						<option value=1 selected>Libre</option>
					</select>
				</fieldset>
				<button type="submit" class="btn-link">Editar Cita</button>
			</fieldset>
		</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>