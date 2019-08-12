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

        <%@include file="/WEB-INF/css/main.css"%>
        <%@include file="/WEB-INF/css/admin.css"%>

    </style>



</head>
<body translate="no">
<section>

    <script>
        <%@include file="/WEB-INF/js/admin.js" %>
    </script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->

    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css" rel="stylesheet">

    <div id="top-nav" class="navbar navbar-inverse navbar-static-top">
        <div class="container-fluid">

            <div class="navbar-translate" >

                <a style=  "margin: auto auto auto 2%; color: #FF8C00; font-size: 30px; font-weight: 500"
                   href="<c:url value = "/"/>"  class="navbar-brand" > <h3><em><span>E-Learning System </span></em></h3>
                </a>

            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">

                    <form:form name="login" action="${pageContext.request.contextPath}/logout" method="get">
                        <li style="margin: 15% auto auto -40%;" class="nav-item">
                            <button class="btn btn-link border-pretty" type="submit"
                                    style="font-size:16px;background-color:#3C4858;color: #FF8C00;"><spring:message
                                    code="logout"/><i
                                    class="icon ion-android-arrow-forward">
                            </i></button>
                        </li>
                    </form:form>
                </ul>
            </div>
        </div>
        <!-- /container -->
    </div>

    <!-- /Header -->

    <!-- Main -->

    <div class="col-lg-10 col-md-10 col-sm-9 col-xs-12">
        <!-- Right -->

        <strong><span></span> <h3>${user.name}</h3></strong>
        <hr>
    </div>

    <div class="form-group pull-right">
        <input type="text" class="search form-control" placeholder="What you looking for?">
    </div>
    <div class="counter pull-right"></div>
    <table class="table table-hover table-bordered results">
        <thead>
        <tr>
            <th class="col-md-4 col-xs-4">Test Name</th>
            <th class="col-md-6 col-xs-6">Test description</th>
            <th class="col-md-2 col-xs-2">Grade</th>


        </tr>
        <tr class="warning no-result">
            <td colspan="4"><i class="fa fa-warning"></i> No result</td>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="result" items="${results}" varStatus="iter">
            <tr>
                <th scope="row">${result.test.name}</th>
                <td>${result.test.description}</td>
                <td>${result.grade}</td>




            </tr>
        </c:forEach>

        </tbody>
    </table>
    <br><br>

    <br><br>

    <script id="rendered-js">
        <%@include file="/WEB-INF/js/admin.js"%>
    </script>
</section>

</body>
</html>