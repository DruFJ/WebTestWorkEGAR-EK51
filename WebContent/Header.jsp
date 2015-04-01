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
    <script>
    	function sendForm(type){
    		document.ViewFilmsForm.type.value = type;
    		document.ViewFilmsForm.submit();
    	}
    </script>
    <form name="ViewFilmsForm" action="Controller" method="get">
         <input type="hidden" name="type" value="">
         <input type="hidden" name="command" value="viewFilms">
    </form>
    
    <!--Шапка-->   
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
	        <div class="row col-lg-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">    
	            <div class="navbar-header"> 
		                <a class="navbar-brand" href="http://localhost:8080/dateandtimeaction/TheMain.jsp"><i class="fa fa-ticket"></i> Билеты-онлайн</a>
		                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
		                   <span class="sr-only">Открыть навигацию</span>
		                   <span class="icon-bar"></span>
		                   <span class="icon-bar"></span>
		                   <span class="icon-bar"></span>
		                </button>      
	            </div>
	            <div class="collapse navbar-collapse" id="responsive-menu">
		                <ul class="nav navbar-nav">
		                    <li><a href="JavaScript:sendForm('FILM');"><i class="fa fa-film"></i> Кино</a></li>
		                    <li><a href="JavaScript:sendForm('CONCET');"><i class="fa fa-music"></i> Музыка</a></li>
		                    <li><a href="JavaScript:sendForm('THEATER');"><i class="fa fa-university"></i> Театр</a></li>
		                    <li><a href="JavaScript:sendForm('FOOTBALL');"><i class="fa fa-futbol-o"></i> Футбол</a></li>
		                </ul>
		                <ul class="nav navbar-nav pull-right">
		                    <li><a href="http://localhost:8080/dateandtimeaction/CreateAction.jsp"><i class="fa fa-plus"></i> Создать событие</a></li>
		                </ul>
	            </div>
	        </div>
	        
	        <div class="col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
	        </div>
        </div>
    </div>   
    
    <div class="container">
        <div class="row">
            <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1">
                <div id="carousel" class="carousel slide">
                    <ol class="carousel-indicators">
                        <li class="active" data-target="#carousel" data-slide-to="0"></li>
                        <li data-target="#carousel" data-slide-to="1"></li>
                        <li data-target="#carousel" data-slide-to="2"></li>
                        <li data-target="#carousel" data-slide-to="3"></li>
                    </ol>

                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="images/films.jpg" alt="">
                            <div class="carousel-caption">
                                <h1>Фильмы</h1>
                            </div>
                        </div>
                        
                        <div class="item">
                            <img src="images/concert.jpg" alt="">
                            <div class="carousel-caption">
                                <h1>Музыка</h1>
                            </div>
                        </div>
                        
                        <div class="item">
                            <img src="images/theater.jpg" alt="">
                            <div class="carousel-caption">
                                <h1>Театр</h1>
                            </div>
                        </div>
                        <div class="item">
                            <img src="images/footbal.jpg" alt="">
                            <div class="carousel-caption">
                                <h1>Футбол</h1>
                            </div>
                        </div>
                    </div>
        
                    <a href="#carousel" class="left carousel-control" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a href="#carousel" class="right carousel-control" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div>
            <div class="col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1"></div>
        </div>       
    </div>
    <br>    
</body>
</html>