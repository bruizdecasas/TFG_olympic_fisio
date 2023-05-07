<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Zapatillas</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="menu.jsp"/>
<div class="container">	
	<div class="row">	
		<div class="col-sm-10">
			<div class="jumbotron text-center">
				  <h1>A Dar Zapatilla</h1> 
				  <p>Las zapatillas son para correr</p> 
				<table class="table table-striped table-sm" >
				<c:forEach var="ele" items="${listaProductos}" >
					<tr>
						<td>${ele.nombre }</td>
					</tr>
				</c:forEach>
				</table>
			</div>
		</div>	
		<div class="col-sm-2">
			<jsp:include page="carrito.jsp"/>
		</div>
	</div>
</div>
</body>
</html>
	