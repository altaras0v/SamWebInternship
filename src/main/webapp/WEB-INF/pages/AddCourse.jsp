<%@ taglib prefix="textarea" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body><form:form id="updateForm" modelAttribute="course" action="../AddCourse" method="post">
    <table>

        <tr>
            <td>
                <form:label path="name">name</form:label>
            </td>
            <td>
                <form:input path="name" name="name" id="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">desc</form:label>
            </td>
            <td>
                <form:input path="description" name="description" id="description" />
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <form:button id="sibmit" name="submit">Submit</form:button>
            </td>
        </tr>
        <tr>
            <td><a href="<c:url value='..' />">Return to start page</a>
            </td>
        </tr>

    </table>
</form:form></body>
</html>