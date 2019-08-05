<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>

<html lang="en">
<meta charset="utf-8">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>This is a Bootstrap example</title>

    <style>
        <%@include file="/WEB-INF/css/courses.css"%>
        <%@include file="/WEB-INF/css/main.css"%>
    </style>
</head>
<body>
<section>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<nav class="navbar navbar-color-on-scroll navbar-transparent    fixed-top  navbar-expand-lg "  color-on-scroll="100"  id="sectionsNav">
    <div class="container">
        <div class="navbar-translate" >
            <a style=  "margin: auto auto auto -100px; color: #FF8C00; font-size: 30px; font-weight: 500" href="<c:url value = "/"/>"
               class="navbar-brand"  > <em><span>E-Learning System</span></em>
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
<br>
    <div class="container">
        <div class="row">
        <br><br><br>
        <div class="row">
            <h2 class="text"><span style="color:whitesmoke;margin: 5% auto 0 18%;">Our courses</span> </h2>
            <div class="col-md-8 offset-md-2">
                <div class="bd-example" data-example-id="">


                        <c:forEach items="${listsCourses}" var="course">
                        <td><form:form name="first" action="../redirect/courseRedirect" method="get">
                        <div class="card">
                            <div class="card-header" role="tab" id="headingThree">
                                <div class="mb-0">
                                    <a data-toggle="collapse" data-parent="#accordion"
                                       aria-expanded="false" aria-controls="collapseOne" class="collapsed">
                                        <i class="fa fa-file-text-o" aria-hidden="true"></i>
                                         <button style="color:#4682B4"
                                                     type="submit" name="first"
                                                     value="${course.id}"
                                                 class="btn btn-link"><h3 style="color: #4682B4">${course.name}</h3></button>
                                       <p> <h6 style="color:#003333">${course.description}</h6></p>
                                    </a>

                                </div>
                            </div>
                        </div>
                        </form:form></td>
                        </c:forEach>

                    </div>
                </div>
            </div>
        </div>
        <br><br><br>
        <footer style="margin: 0 auto 0 auto;color: black" class="footer text-center ">
            <p> Copyright &copy; localhost:8080&#128518;,2019. All rights reserved.</p>
            <p>Contact: altaras0b@gmail.com</p>
        </footer>
        </div>
    </div>
</section>
</body>
</html>