

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<html>
<head>
    <title>Upload File Request Page</title>

</head>
<body>

<br><br><br><br><br><br><br>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 well">
            <h3 class="text-center">Add files</h3>
            <form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="../uploadFile">
            <div class="col-xs-12">
                <div class="form-group">
                    <div class="text-center col-xs-12">
                        <div class="input-group">
                             <span class="input-group-btn">
                                <span class="btn btn-primary" onclick="$(this).parent().find('input[type=file]').click();">Browse</span>
                                    <input name="file"
                                         onchange="$(this).parent().parent().find('.form-control').html($(this).val().split(/[\\|/]/).pop());"
                                             style="display: none;" type="file">
                                </span>
                            <span class="form-control"></span>
                        </div>
                        <h3 style="color: red; font-style: italic" ;><form:errors path="file"/></h3>
                        <div class="text-center col-xs-12">
                            <input type="submit" value="Upload">
                        </div>
                    </div>
                </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

<style>

    body{
        background-color: lightblue; /* Цвет фона веб-страницы */
    }

    input[type="button"]:not(.default), input[type="submit"]:not(.default) {
        -webkit-border-radius: 3px;
        -webkit-background-clip: padding-box;
        -moz-border-radius: 3px;
        -moz-background-clip: padding;
        border-radius: 3px;
        background-clip: padding-box;
        -webkit-transition: color 0.2s ease, border 0.2s ease, background 0.2s ease, -webkit-box-shadow 0.2s ease;
        -moz-transition: color 0.2s ease, border 0.2s ease, background 0.2s ease, -moz-box-shadow 0.2s ease;
        -o-transition: color 0.2s ease, border 0.2s ease, background 0.2s ease, box-shadow 0.2s ease;
        transition: color 0.2s ease, border 0.2s ease, background 0.2s ease, box-shadow 0.2s ease;
        position: relative;
        margin: 0 7px;
        display: inline-block;
        min-width: 144px;
        max-width: 100%;
        padding: 15px 25px;
        font-family: "Arial", "Helvetica Neue", Arial, Helvetica, sans-serif;
        font-size: 14px;
        font-weight: 600;
        text-transform: uppercase;
        line-height: 1;
        border-width: 1px;
        border-style: solid;
        background-color: steelblue;
        color: #ddd;
    }
    .well h3 {
        text-shadow: -1px -1px #FFF, -2px -2px #FFF, -1px 1px #FFF, -2px 2px #FFF, 1px 1px #FFF, 2px 2px #FFF, 1px -1px #FFF, 2px -2px #FFF, -3px -3px 2px #BBB, -3px 3px 2px #BBB, 3px 3px 2px #BBB, 3px -3px 2px #BBB;
        color: steelblue;
        transition: all 1s;
    }

</style>
<%--<form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>--%>
</body>
</html>
