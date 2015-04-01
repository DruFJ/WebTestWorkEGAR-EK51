<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>Билеты онлайн - Главная</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet">
    
  </head>
  <body>
    <!--Шапка-->
    <c:import url="http://localhost:8080/dateandtimeaction/Header.jsp"></c:import>
    
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">               		
	        <h3>Внимание, этот сайт не производит реальной покупки билетов. Это тестовое задание.</h3>
          	</div>
            
            <div class="col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1"></div>
		</div>
    </div>  
    
    <!--Подвал-->
    <c:import url="http://localhost:8080/dateandtimeaction/Footer.jsp"></c:import>   
</body>
</html>