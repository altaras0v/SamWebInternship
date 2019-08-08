<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html lang="en">
<meta charset="utf-8">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>This is a Bootstrap example</title>

    <style>

        <%@include file="/WEB-INF/css/lesson.css"%>
        <%@include file="/WEB-INF/css/main.css"%>

    </style>
</head>
<body>
<section>
    <nav class="navbar navbar-color-on-scroll navbar-transparent    fixed-top  navbar-expand-lg "  color-on-scroll="100"  id="sectionsNav">
        <div class="container">
            <div class="navbar-translate" >
                <a style=  "margin: auto auto auto -100px; color: #FF8C00; font-size: 30px; font-weight: 500" href="<c:url value = "/"/>"
                   class="navbar-brand"  > <em>E-Learning System</em>
                </a>

            </div>
            <div class="navbar-translate">
                <ul class="navbar-nav ml-auto">
                    <form:form name="login" action="../login" method="get">
                        <li style="margin: auto auto auto 90%;" class="nav-item">
                            <button class="btn btn-link border-pretty" type="submit"
                                    style="font-size:16px;background-color:#3C4858;color: #FF8C00;">Login<i
                                    class="icon ion-android-arrow-forward">
                            </i></button>
                        </li>
                    </form:form>
                </ul>
            </div>
        </div>
    </nav>
    <br><br><br><br><br><br><br><br>
    <div  class="main main-raised" style="background: #d1e7e5;">
        <div class="container">
            <div class="section text-center">
                <div class="row">
                    <div  class="col-md-10 ml-auto mr-auto">
                        <h2 class="title" >${courseDTO.name}</h2>
                        <h5 class="description"style="color:#696969;">${courseDTO.fullDescription}</h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
<br>
    <center><h1 class="title" style="color: black" ><span style="font-weight: bolder; color: whitesmoke">Выберите
        урок</span></h1></center>
    <br><br>
    <div class="container">
        <div class="row">
            <div class="how-it-work clearfix">
                <div style="top: 35%"  class="main-how-it">
                    <h4><b> Follow</b> <b> Steps</b> </h4>
                </div>
                <c:forEach items="${listLesson}" var="lesson" varStatus="e">
                <td><form:form name="first" action="../redirect/lessonRedirect" method="get">

                    <c:if test="${e.count %2 != 0}">
                <div class="panel panel-default col-sm-500 col-sm-offset-4" style="background-color: #2f6d9d" >
                    <div class="panel-body" >
                        <span style="color: #FF8C00"> ${e.count} </span> <h3 class="step-heading" ></h3>
                        <button style="color: #FF8C00;" type="submit"
                                name="id"
                                value="${lesson.id}"
                                class="btn btn-link"><h3>${lesson.name}</h3> </button>
                    </div>
                </div>
                    </c:if>
                    <c:if test="${e.count %2 == 0}">
                    <div class="panel panel-default col-sm-500 col-sm-offset-4" style="background-color: #369e79">
                        <div class="panel-body">
                            <span style="color: #FF8C00" > ${e.count} </span> <h3 class="step-heading"></h3>
                            <button style="color: #FF8C00;" type="submit"
                                    name="id"
                                    value="${lesson.id}"
                                    class="btn btn-link"><h3>${lesson.name}</h3> </button>
                        </div>
                    </div>
                    </c:if>
                </form:form></td>
                </c:forEach>


                <form:form name="courseId" action="../addLesson" method="get">
                    <button style="font-size:16px;width: 142px;background-color:#3C4858;color: #FF8C00;" type="submit"
                            name="courseId"
                            value="${courseDTO.id}" class="btn btn-link border-pretty"><p
                            style="text-transform:capitalize">Add lesson</p></button>
                </form:form>
                <form:form name="courseId" action="../deleteLesson" method="get">
                    <button style="font-size:16px;background-color:#3C4858;color: #FF8C00;" type="submit" name="courseId"
                            value="${courseDTO.id}" class="btn btn-link border-pretty"><p
                            style="text-transform:capitalize">Delete lesson</p></button>
                </form:form>
                <br><br><br>
                <footer style="margin: 200px 0 0 250px;color: black"  class="footer text-center ">
                    <p> Copyright &copy; localhost:8080&#128518;,2019. All rights reserved.</p>
                    <p>Contact: altaras0b@gmail.com</p>
                </footer>
            </div>
        </div>

    </div>
</section>
</body>
</html>