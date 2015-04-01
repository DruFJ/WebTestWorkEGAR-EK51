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
			<form action="Controller" method="get">
						<center>
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
			  		<div class="row">
						<input type="radio" name="answer" value="film" checked>Кино&nbsp;
				  		<input type="radio" name="answer" value="theater">Театр&nbsp;
				  		<input type="radio" name="answer" value="conzert">Концерт&nbsp;
				  		<input type="radio" name="answer" value="football">Футбол
				  		
				  		<br><br>
				  		<label>Название</label><br>
				  		<input class="input-xlarge" type="text" name="name" required><br><br>
				  		<label>Описание</label><br>
				  		<textarea name="annotation" cols=30 rows=4></textarea><br><br>
				  		<label>Адрес</label><br>
				  		<input class="input-xlarge" type="text" name="adress" required><br><br>
						<label>Название image</label><br>
				  		<input class="input-xlarge" type="text" name="image" required><br><br>
			  		</div>
		  		</div>
		  		
		  		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
			  		<div class="row">
				  		<br><br>
				  		<label>Дата</label><br>
				  		<input class="input" size="3" type="text" name="number" placeholder="Число" required>
				  		<input class="input" size="3" type="text" name="mounth" placeholder="Месяц" required>
				  		<input class="input" size="3" type="text" name="year" placeholder="Год" required>
				  		<input class="input" size="3" type="text" name="hour" placeholder="Час" required>
				  		<input class="input" size="3" type="text" name="minute" placeholder="Минута" required><br><br>
				  		
				  		<label>Количество мест</label><br>
				  		<input class="input-xlarge" type="text" name="places" required><br><br>
						<label>Стоимость билета</label><br>
				  		<input class="input-xlarge" type="text" name="cost" required><br><br>
				  		<label>Тип фильма (только для фильма)</label><br>
				  		<input type="radio" name="type" value="D2" checked>2D&nbsp;
				  		<input type="radio" name="type" value="D3">3D<br><br>
				  		<input type="hidden" name="command" value="createEvent">
				  		<input type="submit" value="Сохранить" class="btn btn-success"> 
			  		</div>
		  		</div>
		  		</center>	  		 		
			</form>			
		</div>
	</div>
	
	<!--Подвал-->
    <c:import url="http://localhost:8080/dateandtimeaction/Footer.jsp"></c:import>
	
</body>
</html>