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

    <title>This is a Bootstrap example</title>

    <style>

        <%@include file="/WEB-INF/css/registrate.css"%>

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
            <div class="navbar-translate">
                <a style="margin: auto auto auto -100px; color: #FF8C00; font-size: 30px; font-weight: 500"
                   href="<c:url value = "/"/>"
                   class="navbar-brand"> <em>E-Learning System</em>
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
    <br><br>
    <div class="main main-raised" style="background: #d1e7e5;margin:0px 90px 0 90px">
        <div class="container">
            <div id="kv-avatar-errors-2" class="center-block" style="width:800px;display:none"></div>
            <form id="registrationForm" class="form form-vertical"  action="/addUser" method="post"
                  enctype="multipart/form-data">
                <div class="row">
                    <br>
                    <div class="col-sm-4 text-center" >
                        <div class="kv-avatar" >
                            <div class="avatar-wrapper" style="margin: 40px auto 0 450px">

                                <img class="profile-pic" src=""/>
                                <div class="upload-button">
                                    <i class="fa fa-arrow-circle-up" aria-hidden="true"></i>
                                </div>
                                <input name="photo" value="${user.photo}" class="file-upload" type="file"
                                       accept="image/*"
                                required/>
                                <form:errors path="user.photo"/>
                            </div>



                        </div>
                        <div class="col-sm-8" style="margin: 0px 0px 0px 435px">
                            <span>Choose avatar<span class="kv-reqd">*</span></span>
                        </div>
                    </div>

                    <div class="col-sm-8" style="margin: 30px 20px 20px 160px">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center><label for="email">Login<span class="kv-reqd">*</span></label></center>
                                    <input value="${user.name}"  id="email" type="text"
                                           class="form-control"
                                                 name="name" required/>
                                    <form:errors path="user.name"/>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center><label for="password">Password<span class="kv-reqd">*</span></label></center>
                                    <input value="${user.password}" id="password"  type="password"
                                           class="form-control"
                                                name="password" required/>
                                    <form:errors path="user.password"/>
                                </div>
                                  <%--  <form:errors path="user.password"/>--%>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center>
                                        <label for="fname">First Name<span class="kv-reqd">*</span></label></center>
                                    <input id="fname" value="${user.FName}" type="text" class="form-control" name="fName"
                                           required>

                                </div>

                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center><label for="confirm_password">Confirm Password<span class="kv-reqd">*</span></label></center>
                                    <input id="confirm_password" type="password" class="form-control"
                                           name="confirm_password">
                                </div>
                            </div>
                        </div>

                        <div class="row">

                            <div class="col-sm-6">
                                <div class="form-group">
                                    <center> <label for="lname">Last Name<span class="kv-reqd">*</span></label></center>
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
                                    <button type="submit" onclick="validatePassword()" class="btn btn-primary">Submit</button>
                                </center>
                            </div>
                        </div>


                    </div>

                </div>
            </form>

        </div>


    </div>
    <br>
</section>

<!-- the fileinput plugin initialization -->


</body>
</html>