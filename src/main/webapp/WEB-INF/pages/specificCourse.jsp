<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251"%>
<!DOCTYPE html>
<html >
<meta http-equiv="content-type" content="text/html; charset=cp1251">
<head>
    <title>Java | E-Learning</title>
    <meta charset="utf-8" />
    <meta name="description" content="Java Course">
    <meta name="viewport" content="width=device-width">
    <link href='//metanit.com/style26.css' rel='stylesheet' type='text/css'>
</head>
<body>
<h1>Java SE | E-Learning</h1>
<div id="container">

    <div id="header">
        <div id="logo">
            <a class="logoTitle" href="/" title="�� �������">E-Learning</a>
            <div class="logoDefinition">������� �������������� ��������</div>
        </div>


        <div class="menuButton" id="menuButton">

        </div>


        <div id="menu" class="menu">
            <ul class="mainmenu">

            </ul>
        </div>
    </div>


    <div id="content_right">
        <div id="content_right_inner">
            <div id="content_center">
                <div id="menC" class="menC">
                    <div class="articleText" id="articleText">
                        <h1>����������� �� ����� ���������������� ${courseDTO.name}</h1><h2>���� ����������������  ${courseDTO.name} </h2>
                        <br> <br>

                        <p> ${courseDTO.description}</p>


                    </div>

                </div>
                <div id="footer">
                    <br> <br>
                    <p>�������� ��� �����: altaras0b@gmail.com</p>
                    <p>Copyright &copy; localhost:8080&#128518;,2019. ��� ����� ��������.</p>
                </div>
            </div>
        </div>
    </div>

</div>
<script type='text/javascript' src='https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js'></script>
<script type='text/javascript' src='//metanit.com/js/jquery.treeview.min.js'></script>
<script type='text/javascript' src='//metanit.com/js/syntax7.js'></script>
<script type='text/javascript'>SyntaxHighlighter.all();</script>

</body>
</html>