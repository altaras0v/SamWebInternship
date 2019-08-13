<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src ="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.js"></script>
<!------ Include the above in your HEAD tag ---------->

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

    <title>Registration</title>

    <style>

        <%@include file="/WEB-INF/css/registrate.css"%>
        <%@include file="/WEB-INF/css/lesson.css"%>

    </style>
</head>
<script> <%@include file="/WEB-INF/js/registrate.js"%></script>
<script> <%@include file="/WEB-INF/js/avatarInput.js"%></script>
<script> <%@include file="/WEB-INF/js/passwordConfirm.js"%></script>
<body>
<section>
    <nav class="navbar navbar-color-on-scroll navbar-transparent    fixed-top  navbar-expand-lg " color-on-scroll="100"
         id="sectionsNav">
        <div class="container">
            <div style="margin: 0 0 0 0% " >
                <a style=  "margin: auto auto auto -100px; color: #FF8C00; font-size: 30px; font-weight: 500"
                   href="<c:url value = "/"/>"  class="navbar-brand" > <h3><em><span>E-Learning System </span></em></h3>
                </a>

            </div>

        </div>
    </nav>
    <br><br>
    <div class="main main-raised" style="background: #d1e7e5;margin:5% 90px 0 90px">
        <div class="container">
            <div id="kv-avatar-errors-2" class="center-block" style="width:800px;display:none"></div>
            <form id="registrationForm" class="form form-vertical"  action="${pageContext.request.contextPath}/addUser" method="post"
                  enctype="multipart/form-data">
                <br>
                <a><span style="margin: 0 0 0 42%; color:#FF8C00 "> <spring:message
                        code="regpage.reg"/></span></a>
                <div class="row">



                    <div class="col-sm-8" style="margin: 30px 20px 50px 160px">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center><label for="email"><spring:message
                                            code="regpage.login"/><span class="kv-reqd">*</span></label></center>
                                    <input value="${user.name}"  id="email" type="text"
                                           class="form-control"
                                                 name="name" required/>
                                    <span style="color: red"> <form:errors path="user.name"/></span>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center><label for="password"><spring:message
                                            code="regpage.password"/><span class="kv-reqd">*</span></label></center>
                                    <input value="${user.password}" id="password"  type="password"
                                           class="form-control"
                                                name="password" required/>
                                  <span style="color: red"> <form:errors path="user.password"/> </span>
                                </div>
                                  <%--  <form:errors path="user.password"/>--%>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center>
                                        <label for="fname"><spring:message
                                                code="regpage.fname"/><span class="kv-reqd">*</span></label></center>
                                    <input id="fname" value="${user.FName}" type="text" class="form-control" name="fName"
                                           required>

                                </div>

                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center><label for="confirm_password"><spring:message
                                            code="regpage.conf"/><span class="kv-reqd">*</span></label></center>
                                    <input id="confirm_password" type="password" class="form-control"
                                           name="confirm_password">
                                </div>
                            </div>
                        </div>

                        <div class="row">

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center> <label for="lname"><spring:message
                                            code="regpage.lname"/><span class="kv-reqd">*</span></label></center>
                                    <input value="${user.LName}" id="lname" type="text" class="form-control"
                                           name="lName"
                                           required>
                                </div>
                                <%--<span style="color: red">
                                    <form:errors path="user.lname"/></span>--%>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="text-right">
                                <center>
                                    <button name="sub" id="sub" type="submit" class="btn
                                    btn-primary"><spring:message
                                            code="regpage.submit"/></button>
                                </center>
                            </div>
                        </div>


                    </div>

                </div>
            </form>

        </div>


    </div>
    <footer style="margin: 3% 0 0 0" class="footer text-center ">
    <p> Copyright &copy; localhost:8080&#128518;,2019. All rights reserved.</p>
    <p>Contact: altaras0b@gmail.com</p>
</footer> <br><br><br><br>
</section>

<!-- the fileinput plugin initialization -->


</body>
</html>