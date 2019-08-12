<%@ page isELIgnored="false" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">



<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="styles.css">


    <style>
        <%@include file="/WEB-INF/css/login.css"%>
    </style>

</head>
<body>

<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header" style="margin: 0 auto 0 auto;">
                <h3><spring:message
                        code="loginpage.signin"/></h3>
            </div>
            <div class="card-body">
                <form:form method="post" action="${pageContext.request.contextPath}/j_spring_security_check" >
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" id="j_username" name="j_username"
                               placeholder=<spring:message
                                code="loginpage.username"/>>

                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" class="form-control" id="j_password" name="j_password"
                               placeholder=<spring:message
                                code="loginpage.password"/>>
                    </div>
                    <br>
                    <div class="form-group">
                        <center><input type="submit"  class="btn float-md-none login_btn" value=<spring:message
                                code="loginpage.login"/>></center>
                    </div>
                    <label style="color: red">${errorMessage}</label>
                </form:form>
                <div class="d-flex justify-content-center links">
                    <spring:message
                            code="loginpage.haveaccount"/><a  href="<c:url value = "/addUser"/>"><spring:message
                        code="loginpage.signup"/></a>
                </div>
                <div class="d-flex justify-content-center">
                    <a  href="<c:url value = "/"/>"><spring:message
                            code="loginpage.return"/></a>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>