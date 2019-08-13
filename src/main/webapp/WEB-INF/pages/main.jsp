<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons">
    <link rel="stylesgeet" href="https://rawgit.com/creativetimofficial/material-kit/master/assets/css/material-kit.css">
    <link rel="icon" type="image/png" href="<c:url value='/img/paradrop.png'/>">
    <style>
        <%@include file="/WEB-INF/css/main.css"%>
    </style>
</head>

<body class="landing-page ">

<nav class="navbar navbar-color-on-scroll navbar-transparent    fixed-top  navbar-expand-lg "    id="sectionsNav">
    <div class="container">
        <div class="navbar-translate" >

            <a style=  "margin: auto auto auto -100px; color: #FF8C00; font-size: 30px; font-weight: 500"
               href="<c:url value = "/"/>"  class="navbar-brand" > <h3><em><span>E-Learning System </span></em></h3>
            </a>

        </div>
        <div class="navbar-translate" >
            <ul class="navbar-nav ml-auto">

                <c:choose>
                    <c:when test="${auth.authorities=='[ROLE_USER]'}">
                        <form:form name="admin" action="${pageContext.request.contextPath}/user" method="get">
                            <li style="margin: auto auto auto 100%;" class="nav-item">
                                <button   class="btn btn-link border-pretty" type="submit"
                                          style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                                        code="mainpage.touser"/><i class="icon ion-android-arrow-forward">
                                </i></button>
                            </li>
                        </form:form>
                    </c:when>
                    <c:when test="${auth.authorities=='[ROLE_ADMIN]'}">
                        <form:form name="admin" action="${pageContext.request.contextPath}/admin" method="get">
                        <li style="margin: auto auto auto 100%;" class="nav-item">
                            <button   class="btn btn-link border-pretty" type="submit"
                                      style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                                    code="mainpage.toadmin"/><i class="icon ion-android-arrow-forward">
                            </i></button>
                        </li>
                    </form:form>
                    </c:when>
                    <c:when test="${auth.authorities=='[ROLE_MENTOR]'}">
                        <form:form name="admin" action="${pageContext.request.contextPath}/mentor" method="get">
                            <li style="margin: auto auto auto 100%;" class="nav-item">
                                <button   class="btn btn-link border-pretty" type="submit"
                                          style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                                        code="mainpage.tomentor"/><i class="icon ion-android-arrow-forward">
                                </i></button>
                            </li>
                        </form:form>
                    </c:when>

                </c:choose>

            </ul>
        </div>
        <div class="navbar-translate" >
            <ul class="navbar-nav ml-auto">
                <li style="margin: auto -80px auto 0;" class="dropdown nav-item">
                    <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                        <i class="material-icons">apps</i> <spring:message
                            code="languages"/>
                    </a>
                    <div class="dropdown-menu dropdown-with-icons">
                        <a href="?mylocale=ru_RU" class="dropdown-item">
                            <i class="material-icons">layers</i> <spring:message
                                code="rus"/>
                        </a>

                        <a href="?mylocale=en_EN" class="dropdown-item">
                            <i class="material-icons">layers</i><spring:message
                                code="eng"/>
                        </a>

                    </div>
                </li>

                <form:form name="login" action="${pageContext.request.contextPath}/courses" method="get">
                <li style="margin: auto auto auto 40%;" class="nav-item">
                    <button   class="btn btn-link border-pretty" type="submit"
                             style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                            code="mainpage.tocourse"/><i class="icon ion-android-arrow-forward">
                    </i></button>
                </li>
                </form:form>
                <c:if test="${auth.authorities=='[ROLE_ANONYMOUS]'}">
                <form:form name="login" action="${pageContext.request.contextPath}/login" method="get">
                <li style="margin: auto auto auto 90%;" class="nav-item">
                    <button class="btn btn-link border-pretty" type="submit"
                             style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                            code="login"/><i
                            class="icon ion-android-arrow-forward">
                    </i></button>
                </li>
                </form:form>
                </c:if>


                <c:if test="${auth.authorities!='[ROLE_ANONYMOUS]'}">
                    <form:form name="login" action="${pageContext.request.contextPath}/logout" method="get">
                        <li style="margin: auto auto auto 90%;" class="nav-item">
                            <button class="btn btn-link border-pretty" type="submit"
                                    style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                                    code="logout"/><i
                                    class="icon ion-android-arrow-forward">
                            </i></button>
                        </li>
                    </form:form>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
<div class="page-header header-filter" data-parallax="true" style=" background-image:
        url('/img/main.png')">
    <div class="container">
        <div class="row">
            <div class="col-md-6">

                <h1 class="title"><spring:message code="mainpage.title2"/></h1>
                <h4><spring:message code="mainpage.landingText"/></h4>
                <br>
            </div>
        </div>
    </div>
</div>
<div class="main main-raised">
    <div class="container">
        <div class="section text-center">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto">
                    <h2 class="title"><spring:message code="mainpage.secondTitle"/></h2>
                    <h5 class="description"><spring:message code="mainpage.secondText"/></h5>
                </div>
            </div>

            <div class="features">

                <div class="row">
                    <div class="col-md-4">
                        <div class="info">
                            <div class="icon icon-info">
                                <i class="material-icons">chat</i>
                            </div>
                           <h4 class="info-title"><spring:message code="mainpage.nameBox1"/></h4>
                            <p> <spring:message code="mainpage.textBox1"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="info">
                            <div class="icon icon-success">
                                <i class="material-icons">verified_user</i>
                            </div>
                            <h4 class="info-title"><spring:message code="mainpage.nameBox2"/></h4>
                            <p> <spring:message code="mainpage.textBox2"/>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="info">
                            <div class="icon icon-danger">
                                <i class="material-icons">fingerprint</i>
                            </div>
                            <h4 class="info-title"><spring:message code="mainpage.nameBox3"/></h4>
                            <p> <spring:message code="mainpage.textBox3"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="section section-contacts">
            <div class="row">
                <div class="col-md-8 ml-auto mr-auto">
                    <h2 class="text-center title">Work with us</h2>
                    <h4 class="text-center description">Divide details about your product or agency work into parts. Write a few lines about each one and contact us about any further collaboration. We will responde get back to you in a couple of hours.</h4>
                    <form class="contact-form">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Your Name</label>
                                    <input type="email" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label class="bmd-label-floating">Your Email</label>
                                    <input type="email" class="form-control">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="exampleMessage" class="bmd-label-floating">Your Message</label>
                            <textarea type="email" class="form-control" rows="4" id="exampleMessage"></textarea>
                        </div>

                        <div class="row">
                            <div class="col-md-4 ml-auto mr-auto text-center">
                                <button class="btn btn-primary btn-raised">
                                    Send Message
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="footer text-center ">
    <p> Copyright &copy; localhost:8080&#128518;,2019. All rights reserved.</p>
    <p>Contact: altaras0b@gmail.com</p>
</footer>

<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>

</body>