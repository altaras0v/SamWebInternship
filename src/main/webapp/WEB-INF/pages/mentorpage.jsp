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
            <th>Test Name</th>
            <th class="col-md-2 col-xs-2">Answer 1</th>
            <th class="col-md-2 col-xs-2">Answer 2</th>
            <th class="col-md-2 col-xs-2">Answer 3</th>
            <th class="col-md-2 col-xs-2">Answer 4</th>
            <th class="col-md-2 col-xs-2">Answer 5</th>
            <th class="col-md-1 col-xs-1">Grade</th>
            <th class="col-md-1 col-xs-1">Submit</th>

        </tr>
        <tr class="warning no-result">
            <td colspan="4"><i class="fa fa-warning"></i> No result</td>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="answer" items="${answers}" varStatus="iter">
            <tr>
                <th scope="row">${answer.result.test.name}</th>
                <td>${answer.answer_1}</td>
                <td>${answer.answer_3}</td>
                <td>${answer.answer_4}</td>
                <td>${answer.answer_5}</td>
                <td>${answer.answer_5}</td>


                <td>
                    <form:form action="${pageContext.request.contextPath}/grade"
                               method="post">
                    <select name="grade" class="form-control col-2">

                    <option value= 1/${answer.result.id} >1</option>
                    <option value= 2/${answer.result.id} >2</option>
                    <option value= 3/${answer.result.id} >3</option>
                    <option value= 4/${answer.result.id} >4</option>
                    <option value= 5/${answer.result.id} >5</option>
                    <option value= 6/${answer.result.id} >6</option>
                    <option value= 7/${answer.result.id} >7</option>
                    <option value= 8/${answer.result.id} >8</option>
                    <option value= 9/${answer.result.id} >9</option>
                    <option value= 10/${answer.result.id} >10</option>



                </select></td>
                 <td>
                     <input class="btn btn-primary" type="submit" value="Submit">
                 </td>
                </form:form>
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