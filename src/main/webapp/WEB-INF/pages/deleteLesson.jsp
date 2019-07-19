<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>


<meta charset="utf-8">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>This is a Bootstrap example</title>


    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/base.css">

    <%--  <link href="../assets/css/bootstrap.css" rel="stylesheet">--%>

    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>
<br><br><br><br><br>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 well">
            <h3 class="text-center">Delete courses</h3>

            <form:form  action="../deleteLesson" method="post">
                <div class="form-group">
                    <label style="color:steelblue" for="ControlSelect">Choose lesson</label>
                    <select name="lessonId" class="form-control" id="ControlSelect">
                        <c:forEach items="${lessonDTOList}"  var="lesson">
                            <option value=${lesson.id}>${lesson.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <p><center><input class="btn btn-primary" type="submit" value="Submit"></center></p>
                <a href="<c:url value='..' />">Return to start page</a>
            </form:form>
        </div>
    </div>

</div>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

<style>

    body{
        background-color: lightblue; /* Цвет фона веб-страницы */
    }
    .form .form-group[class*="col-"] input[type=text],
    .form .form-group[class*="col-"] input[type=email],
    .form .form-group[class*="col-"] input[type=password] {
        display: inline-block;
        width: 100%;
        min-width: 0;
        max-width: 100%;
    }

    input[type=text],
    input[type=email],
    input[type=password] {
        -webkit-transition: color 0.2s ease, background 0.3s ease;
        -moz-transition: color 0.2s ease, background 0.3s ease;
        -o-transition: color 0.2s ease, background 0.3s ease;
        transition: color 0.2s ease, background 0.3s ease;
        -webkit-border-radius: 0;
        -webkit-background-clip: padding-box;
        -moz-border-radius: 0;
        -moz-background-clip: padding;
        border-radius: 0;
        background-clip: padding-box;
        -webkit-box-shadow: none;
        -moz-box-shadow: none;
        box-shadow: none;
        margin: 0;
        vertical-align: top;
        display: inline-block;
        width: 100%;
        font-size: 17px;
        color: #8d8d8d;
        border-style: solid;
        border-width: 1px 1px 1px 3px;
        border-top-color: #d7d7d7;
        border-right-color: #d7d7d7;
        border-bottom-color: #d7d7d7;
        outline: none;
    }


    input[type=text]:focus,
    input[type=email]:focus,
    input[type=password]:focus {
        outline: none;
        border-left-color: steelblue;
    }

    .well h3 {
        text-shadow: -1px -1px #FFF, -2px -2px #FFF, -1px 1px #FFF, -2px 2px #FFF, 1px 1px #FFF, 2px 2px #FFF, 1px -1px #FFF, 2px -2px #FFF, -3px -3px 2px #BBB, -3px 3px 2px #BBB, 3px 3px 2px #BBB, 3px -3px 2px #BBB;
        color: steelblue;
        transition: all 1s;
    }
</style>




<script src="../assets/js/jquery.js"></script>
<script src="../assets/js/bootstrap-transition.js"></script>
<script src="../assets/js/bootstrap-alert.js"></script>
<script src="../assets/js/bootstrap-modal.js"></script>
<script src="../assets/js/bootstrap-dropdown.js"></script>
<script src="../assets/js/bootstrap-scrollspy.js"></script>
<script src="../assets/js/bootstrap-tab.js"></script>
<script src="../assets/js/bootstrap-tooltip.js"></script>
<script src="../assets/js/bootstrap-popover.js"></script>
<script src="../assets/js/bootstrap-button.js"></script>
<script src="../assets/js/bootstrap-collapse.js"></script>
<script src="../assets/js/bootstrap-carousel.js"></script>
<script src="../assets/js/bootstrap-typeahead.js"></script>
</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/bootstrap-select.min.js"></script>

<!-- (Optional) Latest compiled and minified JavaScript translation files -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.9/dist/js/i18n/defaults-*.min.js"></script>
</body>
</html>
