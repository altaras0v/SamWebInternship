<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java"  pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<br><br><br><br><br>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 well">
            <h3 class="text-center">Add courses</h3>
            <form:form id="updateForm" modelAttribute="course" action="../addCourse" method="post">
                <%--<table>--%>
                <div class="col-xs-12">
                    <div class="form-group">

                            <%-- <form:label path="name">name</form:label>--%>
                        <form:input maxlength="30" path="name" placeholder="Name" name="name" id="name"/>

                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="form-group">
                        <form:input maxlength="254" path="description" placeholder="Description" name="description"
                                    id="description"/>
                    </div>
                </div>
                <div class="col-xs-12">
                    <div class="form-group">
                        <form:input maxlength="3000" path="fullDescription" placeholder="Full Description"
                                    name="fullDescription"
                                    id="fullDescription"/>
                    </div>
                </div>
                <%--     </td>
                 </tr>
                 <tr>
                     <td></td>--%>
                <div class="text-center col-xs-12">
                    <button class="btn btn-primary" id="sibmit" name="submit">Submit</button>
                </div>

                <%--<form:button id="sibmit" name="submit">Submit</form:button>--%>


                <br>
                <a href="<c:url value='/courses' />">Return to course page</a>


                <%--  </table>--%>
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

    input[type=text]:hover,
    input[type=email]:hover,
    input[type=password]:hover {
        color: #000000;
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
</body>
</html>