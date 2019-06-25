<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring MVC Download File Example</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/base.css">

    <%--  <link href="../assets/css/bootstrap.css" rel="stylesheet">--%>

    <link href="../assets/css/bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>

<h1>Spring MVC Download File </h1>




   <%-- <a href="<c:url value='/download/a'/>" name="first" >Download file via servlet response.</a><br/>--%>

<form:form name="first" action="../download/a" method="get">
    <button type="submit" name="first" value="1.txt" class="btn btn-link">Button</button>
</form:form>
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