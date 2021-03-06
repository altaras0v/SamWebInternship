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

    <title>Courses</title>

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

    <div style="margin: 0 0 0 10% " >
        <a style=  "margin: auto auto auto -100px; color: #FF8C00; font-size: 30px; font-weight: 500"
           href="<c:url value = "/"/>"  class="navbar-brand" > <h3><em><span>E-Learning System </span></em></h3>
        </a>

    </div>
<nav class="navbar navbar-color-on-scroll navbar-transparent    fixed-top  navbar-expand-lg "  color-on-scroll="100"  id="sectionsNav">
    <a href="<c:url value='/' />"><img style="margin: 20% 0 0 20%" height="225" width="175" src=<c:url
            value='/img/logo.png' />></a>
    <a href="<c:url value='/' />"><img style="margin: 0 0 0 665%" height="225" width="175" src=<c:url
        value='/img/logo.png' />></a>
    <div class="container">

        <div class="navbar-translate" >



        </div>


    </div>
</nav>
<br>
    <div class="container">

        <div class="row">
        <br><br><br>

            <div class="row">
            <h2 class="text"><span
                    style="color:whitesmoke;margin: 5% auto 0 18%;"><spring:message code="coursepage.title"/></span>
            </h2>

            <div class="col-md-8 offset-md-2">
                <div class="bd-example" data-example-id="">

                        <c:forEach items="${listsCourses}" var="course">
                        <td><form:form name="first" action="${pageContext.request.contextPath}/redirect/courseRedirect" method="get">
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

            <c:if test="${auth.authorities!='[ROLE_USER]'}">
            <form:form name="courseId" action="${pageContext.request.contextPath}/addCourse" method="get">
                <button style="font-size:16px;width: 142px;background-color:#3C4858;color: #FF8C00;height: 50px" type="submit"

                        class="btn btn-link border-pretty"><p
                        style="text-transform:capitalize"><spring:message code="coursepage.add"/></p></button>
            </form:form>
            <form:form name="courseId" action="${pageContext.request.contextPath}/deleteCourse" method="get">
                <button style="font-size:16px;background-color:#3C4858;color: #FF8C00;height: 50px" type="submit"
                        class="btn btn-link border-pretty"><p
                        style="text-transform:capitalize"><spring:message code="coursepage.delete"/></p></button>
            </form:form>
            </c:if>
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