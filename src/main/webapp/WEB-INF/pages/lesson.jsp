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
        <%@include file="/WEB-INF/css/speclesson.css"%>
        <%@include file="/WEB-INF/css/lesson.css"%>

    </style>
</head>
<script> <%@include file="/WEB-INF/js/delete.js"%></script>
<body>
<section class="row-section">
    <nav class="navbar navbar-color-on-scroll navbar-transparent    fixed-top  navbar-expand-lg " color-on-scroll="100"
         id="sectionsNav">
        <div class="container">
            <div class="navbar-translate">
                <a style="margin: auto auto auto -100px; color: #FF8C00; font-size: 30px; font-weight: 500"
                   href="<c:url value = "/"/>"
                   class="navbar-brand"><h3> <em><p>E-Learning System</p></em></h3>
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
    <br><br><br><br><br>
    <div class="main main-raised" style="background: #d1e7e5;margin: 0 90px 0 90px">
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
                <center> Материалы для урока</center>
            </h3>
            <br>
            <td><form:form name="id"  action="../uploadRedirect" method="post">



                <div class="coursename"><button style="color: #4BA89C"  type="submit" name="id" value="${lessonDTO.id}" class="btn btn-link">Загрузить файл</button>
                </div>

            </form:form></td>
            <c:forEach items="${listFiles}" var="files" varStatus="counter">


                <div id="${files.id}" class="col-md-10 offset-md-1 row-block">
                    <ul id="sortable">
                        <li>
                            <div class="media">

                                <div class="media-body">
                                    <form:form name="first" action="../download" method="get">
                                        <button type="submit" name="id" value="${files.id}"
                                                style="text-transform: capitalize;font-size: 18px" class="btn btn-link">
                                            <p
                                                    style="text-transform: capitalize"> ${files.name}</p></button>
                                    </form:form>
                                    <p style="font-size: 16px">${files.description}</p>
                                   <%-- <input type="hidden" --%>
                                </div>
                                <div class="media-right align-self-center">
                                    <form:form name="fileId" action="../deleteFile">
                                        <button style="color: #4BA89C" onclick="deleteFile(${files.id})" type="button"
                                                name="fileId"
                                            <%-- value="${files.id}"--%>
                                          <%--onclick="Delete(${files.id})"--%>      class="btn btn-link">Удалить файл
                                        </button>

                                    </form:form>

                                </div>
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
                <td><form:form name="lessonId" action="../addTest" method="get">

                    <c:if test="${testDTO.id==0}">

                            <button class="btn btn-link border-pretty" type="submit" name="lessonId"
                                    value="${lessonDTO.id}"
                                    style="font-size:16px;background-color:#3C4858;color: #FF8C00;">Add test</button>


                    </c:if>

                </form:form></td>
            </div>
        </div>
    </div>
    <c:if test="${testDTO.id!=0}">
        <div class="main main-raised" style="background: #d1e7e5;margin: 60px 90px 0 90px">
            <div class="container">
                <div class="section text-center">
                    <div class="row">
                        <div class="col-md-10 ml-auto mr-auto">
                            <h2>Тестирование</h2>
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
        <td><form:form name="quest" action="../addQuestion" method="get">
                <c:if test="${listQuestion.size()==0||listQuestion.size()==10}">
                    <button class="btn btn-link border-pretty" type="submit" name="testId"
                            value="${testDTO.id}"
                            style="font-size:16px;background-color:#3C4858;color: #FF8C00;">Add question</button>
                </c:if>
        </form:form></td>
                <c:if test="${listQuestion.size()!=0}">
                    <c:forEach items="${listQuestion}" var="question">
                    <div class="col-md-10 offset-md-1 row-block" style="margin: 0px 180px 0 80px">
                        <ul id="newsortable">
                            <li>
                                <div class="media">


                                        <div class="form-group">
                                            <label style="color: #00008B"
                                                   for="Textarea"><p>${question.question}</p></label>
                                            <textarea maxlength="1000" class="form-control" id="Textarea" cols="100"
                                                      rows="3"></textarea>
                                        </div>
                                </div>

                            </li>

                        </ul>

                    </div>
                        <form:form name="questionId" action="../deleteQuestion"
                                   method="get">
                            <button type="submit" name="questionId" value="${question.id}"
                                    style="text-transform: capitalize" class="btn btn-link"><p
                                    style="text-transform: capitalize;margin: 0 100px 0 110px"><h6> Delete question
                            </h6></p>
                            </button>
                        </form:form>
                    </c:forEach>
                    <br>
                    <center>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </center>
                    <br>
                    <td><form:form name="quest" action="../addQuestion" method="get">
                        <c:if test="${listQuestion.size()!=10}">
                            <button class="btn btn-link border-pretty" type="submit" name="testId"
                                    value="${testDTO.id}"
                                    style="font-size:16px;background-color:#3C4858;color: #FF8C00;">Add question</button>
                        </c:if>
                    </form:form></td>
                </c:if>
            </div>

            <br>

        </div>
    </c:if>
        <footer style="margin: 0 auto 0 auto;color: black" class="footer text-center ">
            <p> Copyright &copy; localhost:8080&#128518;,2019. All rights reserved.</p>
            <p>Contact: altaras0b@gmail.com</p>
        </footer>
        <br><br>





</section>
</body>
</html>