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

    <title>Lesson</title>

    <style>
        <%@include file="/WEB-INF/css/speclesson.css"%>
        <%@include file="/WEB-INF/css/lesson.css"%>

    </style>
</head>
<script>
    <%@include file="/WEB-INF/js/deleteFile.js" %>
</script>
<script>
    <%@include file="/WEB-INF/js/deleteQuestion.js" %>
</script>
<body>

<section class="row-section">

    <div class="container">
        <br>
        <div class="navbar-translate">
            <a style="margin: auto auto auto -100px; color: #FF8C00; font-size: 30px; font-weight: 500"
               href="<c:url value = "/"/>"
               class="navbar-brand">
                <h3><em><p>E-Learning System</p></em></h3>
            </a>

        </div>

    </div>

    <br><br>
    <div class="main main-raised" style="background: #d1e7e5;margin: 0 90px 0 90px">
        <a href="<c:url value='/' />"><img style="margin: 0 0 -25% 84%" height="300" width="225" src=<c:url
                value='/img/logo.png'/>></a>
        <a href="<c:url value='/' />"><img style="margin: 0 0 -20% 0%" height="300" width="225" src=<c:url
                value='/img/logo.png'/>></a>
        <div class="container">
            <div class="section text-center">
                <div class="row">
                    <div class="col-md-10 ml-auto mr-auto">
                        <h2>${lessonDTO.name}</h2>
                        <br>
                        <h5 class="description" style="color:#696969;">${lessonDTO.description}</h5>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="container">

            <h3 class="text-center">
                <center><spring:message
                        code="lesson.materials"/></center>
            </h3>
            <br>
            <c:if test="${auth.authorities!='[ROLE_USER]'}">
                <td><form:form name="id" action="${pageContext.request.contextPath}/uploadRedirect" method="post">

                    <div class="coursename">
                        <button style="margin: 0 0 0 10%;
                        font-size:16px;background-color:#3C4858;color: #FF8C00;height:
                        50px"
                                type="submit"
                                name="id" value="${lessonDTO.id}" class="btn btn-link border-pretty">
                            <spring:message
                                    code="lesson.addFile"/>
                        </button>
                    </div>

                </form:form></td>
            </c:if>
            <c:forEach items="${listFiles}" var="files" varStatus="counter">


                <div id="${files.id}" class="col-md-10 offset-md-1 row-block">
                    <ul id="sortable">
                        <li>
                            <div class="media">

                                <div class="media-body">
                                    <form:form name="first" action="${pageContext.request.contextPath}/download"
                                               method="get">
                                        <button type="submit" name="id" value="${files.id}"
                                                style="text-transform: capitalize;font-size: 18px" class="btn btn-link">
                                            <p
                                                    style="text-transform: capitalize"> ${files.name}</p></button>
                                    </form:form>
                                    <p style="font-size: 16px">${files.description}</p>
                                        <%-- <input type="hidden" --%>
                                </div>
                                <c:if test="${auth.authorities!='[ROLE_USER]'}">
                                    <div class="media-right align-self-center">

                                        <button style="color: #4BA89C" onclick="deleteFile(${files.id})" type="button"
                                                name="fileId" class="btn btn-link"><spring:message
                                                code="lesson.deleteFile"/>
                                        </button>


                                    </div>
                                </c:if>
                            </div>
                        </li>
                    </ul>
                </div>
            </c:forEach>
        </div>
        <br>
    </div>
    <div class="container">

        <div class="section text-center">
            <div class="row">
                <c:if test="${auth.authorities!='[ROLE_USER]'}">
                    <td><form:form name="lessonId" action="${pageContext.request.contextPath}/addTest" method="get">

                        <c:if test="${testDTO.id==0}">

                            <button class="btn btn-link border-pretty" type="submit" name="lessonId"
                                    value="${lessonDTO.id}"
                                    style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                                    code="lesson.addTest"/>
                            </button>


                        </c:if>

                    </form:form></td>
                </c:if>
            </div>
        </div>
    </div>
    <c:if test="${testDTO.id!=0}">
        <div class="main main-raised" style="background: #d1e7e5;margin: 60px 90px 0 90px">
            <a href="<c:url value='/' />"><img style="margin: 0 0 -25% 84%" height="300" width="225" src=<c:url
                    value='/img/logo.png'/>></a>
            <a href="<c:url value='/' />"><img style="margin: 0 0 -20% 0%" height="300" width="225" src=<c:url
                    value='/img/logo.png'/>></a>
            <div class="container">
                <div class="section text-center">
                    <div class="row">
                        <div class="col-md-10 ml-auto mr-auto">
                            <h2><spring:message
                                    code="lesson.test"/></h2>
                            <br>
                            <h5 class="description" style="color:#696969;">${testDTO.description}</h5>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <div class="container">

                <h3 class="text-center">
                    <center> ${testDTO.name}</center>
                </h3>
                <br>
                <c:if test="${auth.authorities!='[ROLE_USER]'}">
                    <td><form:form name="quest" action="${pageContext.request.contextPath}/addQuestion" method="get">
                        <c:if test="${listQuestion.size()==0||listQuestion.size()==10}">
                            <button class="btn btn-link border-pretty" type="submit" name="testId"
                                    value="${testDTO.id}"
                                    style="font-size:16px;background-color:#3C4858;color: #FF8C00;
                                    margin: 0 0 0 10%"><spring:message
                                    code="lesson.addQw"/>
                            </button>
                        </c:if>
                    </form:form></td>
                </c:if>
                <c:if test="${listQuestion.size()!=0}">
                    <form:form name="result" modelAttribute="answer"
                               action="${pageContext.request.contextPath}/addAnswer"
                               method="post">

                    <c:forEach items="${listQuestion}" var="question" varStatus="count">
                        <div class="col-md-10 offset-md-1 row-block" style="margin: 0px 180px 0 80px" id=${question.id}>
                            <ul id="newsortable">
                                <li>
                                    <div class="media">

                                        <div class="form-group">
                                            <label style="color: #00008B" for="Textarea"><p>${question.question}</p></label>
                                            <textarea name="answer${count.count}" maxlength="1000" class="form-control"
                                                      id="Textarea"
                                                      cols="100"
                                                      rows="3"></textarea>
                                        </div>

                                    </div>

                                </li>

                            </ul>

                            <c:if test="${auth.authorities!='[ROLE_USER]'}">
                                <button onclick="deleteQuestion(${question.id},${listQuestion.size()})" type="button"
                                        name="questionId"
                                        style="text-transform: capitalize" class="btn btn-link"><p
                                        style="text-transform: capitalize;margin: 0 100px 0 110px"><h6>
                                    <spring:message
                                            code="lesson.deleteQw"/>
                                </h6></p>
                                </button>
                            </c:if>
                        </div>
                    </c:forEach>

                    <br><c:if test="${contactCheck==true}">
                    <c:if test="${auth.authorities=='[ROLE_USER]'}">
                        <center>
                            <button id="0012" type="submit" name="testId" value="${testDTO.id}" class="btn
                            btn-primary"><spring:message
                                    code="lesson.send"/></button>
                        </center>
                    </c:if>
                    </c:if>
                    </form:form>
                </c:if>

            </div>

                <c:if test="${listQuestion.size()!=0}">

                    <br>
                    <c:if test="${auth.authorities!='[ROLE_USER]'}">
                        <td><form:form name="quest" action="${pageContext.request.contextPath}/addQuestion"
                                       method="get">
                            <c:if test="${listQuestion.size()<5}">
                                <button class="btn btn-link border-pretty" type="submit" name="testId"
                                        value="${testDTO.id}"
                                        style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                                        code="lesson.addQw"/>
                                </button>
                            </c:if>
                        </form:form></td>
                    </c:if>
                </c:if>
            </div>

            <br>

        </div>
    </c:if>
    <footer style="margin: 7% auto 0 auto;color: black" class="footer text-center ">
        <p> Copyright &copy; localhost:8080&#128518;,2019. All rights reserved.</p>
        <p>Contact: altaras0b@gmail.com</p>
    </footer>
    <br><br>


</section>


</body>
</html>