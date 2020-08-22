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
    <title>Resultados Candidatos</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
          <h1 class="display-4">Resultados Candidatos</h1>
          <div>
            <p class="lead">                
              <a class="btn btn-primary btn-lg" href="index" role="button">Regresar</a>
            </p>
          </div>
          
        </div>
    </div>
    <div class="container">
        <div class="container">
            <div class="alert alert-warning" role="alert">
                ${message}
              </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Distrito</th>
                <th scope="col">Candidato</th>
                <th scope="col">Candidato</th>
                <th scope="col">Candidato</th>
                <th scope="col">Candidato</th>
            </tr>
            </thead>
            <tbody>
                    <tr>
                        <td></td>
                        <c:forEach var="subheader" items="${subheaders}">
                            <td>${subheader.nombre}</td>
                        </c:forEach>
                    </tr>
                    <c:forEach var="ds" items="${ds}">
                        <tr>
                            <td>${ds.distrito}</td>
                            <c:forEach var="candidato" items="${ds.candidatos}">
                                <td>${candidato.total}</td>
                            </c:forEach>
                        </tr>    
                    </c:forEach>
            </tbody>
        </table>
    </div> 
    <hr class="my-4">
    <br/>
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Candidato</th>
                <th scope="col">Total</th>
                <th scope="col">Porcentaje</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="totales" items="${ctotal}">
                    <tr>
                        <td>${totales.candidato}</td>
                        <td>${totales.total}</td>
                        <td><fmt:formatNumber type = "number" maxFractionDigits = "1" value = "${totales.pct}"/><span>&#37;</span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>  
</body>
</html>