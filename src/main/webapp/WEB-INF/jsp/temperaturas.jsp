<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Temperatura en la ciudad</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="text/javascript">
        $(document).ready(function() {
            $("#temperatureForm").validate({
                rules: {
                    dateMeasured: {
                        required: true,
                        date: true
                    }
                }
            })
        });
    </script>
</head>
<body>
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1 class="display-4">Ingrese la temperatura hoy</h1>
          <div>
            <p class="lead">
              <a class="btn btn-primary btn-lg" href="reporte" role="button">Ver temperaturas</a>
              <a class="btn btn-primary btn-lg" href="calcularTemperatura" role="button">Calcular temperatura</a>
            </p>
          </div>

          
        </div>
    </div>
    <div class="container">
        <form:form id="temperatureForm" action="/salvarTemperatura" method="post" modelAttribute="temperature" class="was-validated">
            <div class="form-group">
                <form:label path="dateMeasured" pathfor="inputDate">Fecha</form:label>
                <form:input class="form-control" path="dateMeasured" id="dateMeasured" name="dateMeasured" placeholder="MM/dd/AAAA" type="text"/>
                <div class="invalid-feedback">
                    Por favor brinde una fecha valida en formato MM/DD/AAAAA
                  </div>
                <form:label path="celsius" for="celsius">Temperatura de la ciudad</form:label>
                <form:input class="form-control" path="celsius" id="celsius" name="celsius" placeholder="32" type="number" required="required"/>
                <div class="invalid-feedback">
                    Utilice una temperatura valida en celsius
                  </div>
            </div>
            <div class="form-group">
                <button class="btn btn-primary " name="submit" type="submit">Guardar</button>
            </div>
        </form:form>
      </div>
</body>
</html>