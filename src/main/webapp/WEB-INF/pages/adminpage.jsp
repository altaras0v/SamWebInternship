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

    <title>Admin</title>

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

        <strong><span></span> Admin Page</strong>
        <hr>
    </div>

    <div class="form-group pull-right">
        <input type="text" class="search form-control" placeholder="What you looking for?">
    </div>
    <div class="counter pull-right"></div>
    <table class="table table-hover table-bordered results">
        <thead>
        <tr>
            <th>#</th>
            <th class="col-md-3 col-xs-3">Login</th>
            <th class="col-md-3 col-xs-3">First Name</th>
            <th class="col-md-3 col-xs-3">Last Name</th>
            <th class="col-md-2 col-xs-2">Status</th>
            <th class="col-md-2 col-xs-2">Make a role</th>
        </tr>
        <tr class="warning no-result">
            <td colspan="4"><i class="fa fa-warning"></i> No result</td>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="person" items="${users}" varStatus="iter">
        <tr>
            <th scope="row">${iter.count}</th>
            <td>${person.name}</td>
            <td>${person.FName}</td>
            <td>${person.LName}</td>
            <td>${person.role}</td>
            <td>
                <c:choose>
                    <c:when test="${person.role=='ROLE_USER'}">
                        <form:form  action="${pageContext.request.contextPath}/makeMentor"
                                   method="get">
                            <button type="submit" name="id" value="${person.id}"
                                    style="text-transform: capitalize;font-size: 18px" class="btn btn-link">
                                <p
                                        style="text-transform: capitalize"> Make Mentor</p></button>
                        </form:form>
                    </c:when>
                    <c:when test="${person.role=='ROLE_MENTOR'}">
                        <form:form  action="${pageContext.request.contextPath}/makeUser"
                                   method="get">
                            <button type="submit" name="id" value="${person.id}"
                                    style="text-transform: capitalize;font-size: 18px" class="btn btn-link">
                                <p
                                        style="text-transform: capitalize"> Make User</p></button>
                        </form:form>
                    </c:when>

                </c:choose>
            </td>
        </tr>
        </c:forEach>

        </tbody>
    </table>
    <br><br>
    <table class="table table-hover table-bordered results">
    <thead>
    <tr>
        <th>#</th>
        <th class="col-md-4 col-xs-4">Login</th>
        <th class="col-md-1 col-xs-2">WITH</th>
        <th class="col-md-4 col-xs-4">Login</th>
        <th class="col-md-4 col-xs-4">Delete</th>

    </tr>

    </thead>
    <tbody>

    <c:forEach var="contact" items="${contacts}" varStatus="iter">
        <tr>
            <th scope="row">${iter.count}</th>
            <td>${contact.user.name}</td>
            <td></td>
            <td>${contact.mentor.name}</td>
            <td> <form:form  action="${pageContext.request.contextPath}/deleteContact"
                             method="post">
                <button type="submit" name="contactId" value="${contact.id}"
                        style="text-transform: capitalize;font-size: 18px" class="btn btn-link">
                    <p
                            style="text-transform: capitalize">Delete Contact</p></button>
            </form:form></td>

        </tr>
    </c:forEach>

    </tbody>
    </table>
    <center> <h2 style="color: steelblue">Make contact Mentor-User</h2></center>

    <form:form  action="${pageContext.request.contextPath}/makeContact" method="post">
    <div class="form-group">
        <label style="color:steelblue" for="ControlSelect">Choose mentor</label>
        <select name="mentorId" class="form-control" id="ControlSelect">
            <c:forEach items="${mentors}"  var="mentor">
                <option value=${mentor.id}>${mentor.name}</option>
            </c:forEach>
        </select>
    </div>
        <br>
    <div class="form-group">
        <label style="color:steelblue" for="ControlSelect">Choose user</label>
        <select name="userId" class="form-control" id="ControlSelct">
            <c:forEach items="${freeUsers}"  var="user">
                <option value=${user.id}>${user.name}</option>
            </c:forEach>
        </select>
    </div>
        <p><center><input class="btn btn-primary" type="submit" value="Submit"></center></p>
    </form:form>

    <br><br>

    <script id="rendered-js">
        <%@include file="/WEB-INF/js/admin.js"%>
    </script>
</section>

</body>
</html>