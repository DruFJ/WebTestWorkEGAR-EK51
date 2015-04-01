<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>Билеты онлайн - Выбор дня</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet">
    

  </head>
<body>
	<script>
    	function sendFormDate(id){
    		document.ViewFilmsFormDate.id.value = id;
    		document.ViewFilmsFormDate.submit();
    	}
    </script>
    <form name="ViewFilmsFormDate" action="Controller" method="get">
    	<input type="hidden" name="id" value="">
    	<input type="hidden" name="type" value="${type }">
    	<input type="hidden" name="command" value="viewDateObject">
    </form>
	

	<!--Шапка + карусель-->
    <c:import url="http://localhost:8080/dateandtimeaction/Header.jsp"></c:import>

    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">        
               	<div class="row">	               	
	        		<c:set var="action" value="${action}"/>
	           		<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
	               		<div class="thumbnail">
	                   		<img src="images/${action.imagePath}.jpg" alt=""> 
	           			</div>  
	           		</div>
	           		<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
	               		<h3>${action.name}</h3>
	               		<h5><p>${action.annotation}</p></h5>
	               		<table class="table table-condensed">
	                   		<tr>
	                       		<th>Дата и время проведения</th>
	                       		<th>Место</th>
	                       		<th></th>
	                   		</tr>
	                   		
	                   		<tr>
	                       		<td>${action.date}</td>   
	                       		<td>${action.adress}</td>
	                       		<td><a href="JavaScript:sendFormDate(${action.id});" class="btn btn-primary">Закзать</a></td>
	                   		</tr>
	                  		
	               		</table>
	               		<h3>Стоимость билета: ${action.cost} бел. руб.</h3>
	           		</div>
	            </div>	
	        <div class="col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1"></div>  
        	</div>
        </div>
    </div>

	<!--Подвал-->
    <c:import url="http://localhost:8080/dateandtimeaction/Footer.jsp"></c:import>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>