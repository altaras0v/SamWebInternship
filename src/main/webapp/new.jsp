<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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

        <%@include file="/WEB-INF/css/lesson.css"%>

    </style>
</head>
<body>
<section>
    <div class="container">
        <div class="row">
            <div class="how-it-work clearfix">
                <div class="main-how-it">
                    <h4> Follow <span class="bg-theme"> Steps</span> </h4>
                </div>
                <div class="panel panel-default col-sm-10 col-sm-offset-2">
                    <div class="panel-body">
                        <span> 1 </span> <h3 class="step-heading"> Step 1 </h3>
                        Select your category and ask any question related to it.
                    </div>
                </div>

                <div class="panel panel-default col-sm-10 col-sm-offset-2">
                    <div class="panel-body">
                        <span> 2 </span> <h3 class="step-heading"> Step 2 </h3>
                        Connect with an Expert related to your question. The licensed professionals are confirmed by a third-party verification firm.
                    </div>
                </div>

                <div class="panel panel-default col-sm-10 col-sm-offset-2">
                    <div class="panel-body">
                        <span> 3 </span> <h3 class="step-heading"> Step 3 </h3>
                        Get your answer within a min. Although, sometimes it may take a little longer to answer your question because of the solution it provides could be a little tricky or lengthy.
                    </div>
                </div>

                <div class="panel panel-default col-sm-10 col-sm-offset-2">
                    <div class="panel-body">
                        <span> 4 </span> <h3 class="step-heading"> Step 4 </h3>
                        Don’t forget to give rating to your expert. We need the ratings to keep a track of your satisfaction level and experience with us and of course to improve ourselves.
                    </div>
                </div>
                <div class="panel panel-default col-sm-10 col-sm-offset-2">
                    <div class="panel-body">
                        <span> 4 </span> <h3 class="step-heading"> Step 4 </h3>
                        Don’t forget to give rating to your expert. We need the ratings to keep a track of your satisfaction level and experience with us and of course to improve ourselves.
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>