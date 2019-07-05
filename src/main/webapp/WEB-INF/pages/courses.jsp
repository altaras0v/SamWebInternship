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


    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/base.css">

    <%--  <link href="../assets/css/bootstrap.css" rel="stylesheet">--%>

    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>

<div class="jumbotron">
    <div class="container">
        <!-- row 1 -->
        <div class="row">
            <header class="col-md-12">
                <h2>E-Learning System</h2>
            </header>
        </div>
    </div>
</div>
<div class="container">

    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <h3>
                List of courses
            </h3>
        </div>


        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="info">
                            <h4 class="text-center w-5 p-3">Name of course</h4>
                        </th>
                        <th class="success">
                            <h4 class="text-center">Description</h4>
                        </th>

                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${listsCourses}"  var="course">
                        <tr>
                            <%--<td>${course.name}</td>--%>
                                <td><form:form name="first" action="../redirect/courseRedirect" method="get">
                                    <button type="submit" name="first" value="${course.id}" class="btn btn-link">${course.name}</button>
                                </form:form></td>
                            <td>${course.description}</td>
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>


        </div>
        <a href="<c:url value = "/AddCourse"/>">Creazione Nuovo Corso</a>
        <br>
        <a href="<c:url value = "/upload"/>">Upload files</a>

        <footer class="row jumbotron">

            <div class="col-md-3">
                <address>
                    <strong>Name, Inc.</strong><br>
                    Address line 1<br>
                    Address line 2<br>
                    <abbr title="Phone">P:</abbr> (123) 456-7890
                </address>
            </div>
        </footer>
    </div>


</div>
</div>
</div>

<style>
    :focus {outline:none !important;}
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
</body>
</html>
