<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>Билеты онлайн - Покупка билета</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet">
    
  </head>
<body>  
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
                		<h4>Стоимость билета: ${action.cost} бел. руб.</h4>
                		<h3>В продаже доступно ${number} билетов</h3>
                		<table class="table table-condensed">
                    		<tr>
                        		<th>Занятые места</th>
                        		<th>Дата продажи</th>
                    		</tr>                    		
			        		<c:forEach var="ticket" items="${ticket}">			        		
	                    		<tr>
	                        		<td>${ticket.position}</td>
	                        		<td>${ticket.dateSold}</td>
	                    		</tr>                    		
			        		</c:forEach>
                		</table>

                		<form action="Controller" method="get">
                    		<fieldset>
                        		<h3>Введите данные</h3>
                        		<input class="input-xlarge" type="text" name="last_name" placeholder="Введите фамилию" required><br><br>
                        		<input class="input-xlarge" type="text" name="first_name" placeholder="Введите имя" required><br><br>
                        		<input class="input-xlarge" type="text" name="e-mail" placeholder="Введите e-mail" required><br><br>
                        		<input class="input-xlarge" type="text" name="place" placeholder="Введите место(места)" required><br><br>
                        		<input type="hidden" name="idAction" value="${action.id}">
                        		<input type="hidden" name="command" value="viewTicket">
                        		<input type="submit" class="btn btn-success">
                    		</fieldset>
                		</form>
                	
            		</div>
        		</div>
            </div>
            <div class="col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1"></div>
        </div>
    </div>

	<!--Подвал-->
    <c:import url="http://localhost:8080/dateandtimeaction/Footer.jsp"></c:import>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>