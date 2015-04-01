<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
   
    <title>Билеты онлайн</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="css/style.css" rel="stylesheet">
    
  </head>
<body>
	<script>
    	function sendFormAction(id){
    		document.ViewFilmsFormAction.id.value = id;
    		document.ViewFilmsFormAction.submit();
    	}
    </script>
    <form name="ViewFilmsFormAction" action="Controller" method="get">
    	<input type="hidden" name="id" value="">
    	<input type="hidden" name="type" value="${type}">
    	<input type="hidden" name="command" value="viewObject">
    </form>
	<!--Шапка + карусель-->
    <c:import url="http://localhost:8080/dateandtimeaction/Header.jsp"></c:import>

	<div class="container">
        <div class="row">
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">         
        		<div class="row">
	        		<c:forEach var="film" items="${films}">
	        			<div class="col-sm-5 col-md-3">
	           				<div class="thumbnail scope">
	               				<img src="images/${film.imagePath}.jpg" alt="...">
	               				<h5>${film.name }</h5>
	               				<p><a href="JavaScript:sendFormAction(${film.id});" class="btn btn-primary">Заказать</a> </p>
	           				</div>
	       				</div>
	        		</c:forEach>
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