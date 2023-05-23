<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="<c:url value='/css/style.css' />" rel="stylesheet">
    <link href="<c:url value='/css/table.css' />" rel="stylesheet">
    <link href="<c:url value='/css/detalle.css' />" rel="stylesheet">

    <style>
        /* Estilos para la ventana emergente */
        #modalContainer {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            display: none;
            justify-content: center;
            align-items: center;
        }

        #modalContent {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
        }

        #modalContent h3 {
            margin-top: 0;
        }

        #modalContent button {
            margin-top: 10px;
        }
    </style>

    <script src="<c:url value='/resources/bootstrap/js/jquery.min.js' />"></script>
</head>
<body>
    <jsp:include page="../menu.jsp"></jsp:include>
    <main>
        <section class="default">
        
        <table class="default">
            <thead>
                <tr class="default">
                    <th>Fecha</th>
                    <th>Hora</th>                  
                    <th>Especialista</th>
                    <th>Observaciones del especialista</th>
                    <th>Observaciones del Cliente</th>
                </tr>
            </thead>
            <tbody>
                <tr class="default">
                    <td>${ reserva.cita.fechaCita }</td> 
                    <td>${ reserva.cita.horaCita }</td>
                    <td>${ reserva.cita.usuario.nombreUsuario }</td>
                    <td>${ reserva.cita.observaciones }</td>
                    <td>${ reserva.observacionesResevas }</td>

                <sec:authorize access="hasAnyAuthority('Cliente', 'Administrador', 'Especialista')">    
                    <td><a class="btn-link" href="#" onclick="mostrarVentanaEmergente(${reserva.idReserva})">Cancelar</a></td>
                </sec:authorize>
                </tr>
                
            </tbody>
        </table>
        <h3>Si deseas modificar los datos de tu reserva, contacta con ${ reserva.cita.usuario.nombreUsuario }</h3>
        </section>
        <p class="mensaje-exito">${ mensajeExito }</p>
        <p class="mensaje-error">${ mensajeError }</p>
    </main>

    <!-- Ventana emergente -->
    <div id="modalContainer">
        <div id="modalContent">
            <h3>¿Estás seguro de que deseas cancelar esta reserva?</h3>
            <button id="confirmButton">Aceptar</button>
            <button id="cancelModalButton">Cancelar</button>
        </div>
    </div>

    <script>
        function mostrarVentanaEmergente(idReserva) {
            var modalContainer = document.getElementById("modalContainer");
            var confirmButton = document.getElementById("confirmButton");
            var cancelModalButton = document.getElementById("cancelModalButton");

            modalContainer.style.display = "flex";

            confirmButton.addEventListener("click", function() {
                // Realizar la cancelación
                window.location.href = "/reserva/cancelar/" + idReserva;
                modalContainer.style.display = "none";
            });

            cancelModalButton.addEventListener("click", function() {
                modalContainer.style.display = "none";
            });
        }
    </script>
</body>
</html>
