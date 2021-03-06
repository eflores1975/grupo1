<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Calcular temperatura en la ciudad</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="text/javascript">
        $(document).ready(function() {
            $("#calcularTemperaturaForm").validate({
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
          <h1 class="display-4">Calcular temperatura</h1>
          <div>
            <p class="lead">
              <a class="btn btn-primary btn-lg" href="temperaturas" role="button">Regresar</a>
            </p>
          </div>
        </div>
    </div>

    <div class="container">
        <form:form id="calcularTemperaturaForm" action="resultadoTemperatura" modelAttribute="temperature" method="post" class="was-validated">
            <div class="form-group">
                <form:label path="dateMeasured" pathfor="inputDate">Coloque un día de la semana</form:label>
                <form:input class="form-control" path="dateMeasured" id="dateMeasured" name="dateMeasured" placeholder="MM/dd/AAAA" type="text"/>
                <div class="invalid-feedback">
                    Por favor brinde una fecha valida en formato MM/DD/AAAAA, Intente con la primera semana del 2020: 01/01/2020
                </div>
            </div>
            <div class="form-group">
                <button class="btn btn-primary " name="submit" type="submit">Buscar</button>
            </div>
        </form:form>
      </div>
</body>
</html>