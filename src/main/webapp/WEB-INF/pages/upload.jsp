<%--
&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: Dell
  Date: 19.06.2019
  Time: 13:47
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload File Request Page</title>
</head>
<body>
<form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>
--%>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 19.06.2019
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload File Request Page</title>
</head>
<body>

<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadedFile" action="uploadFile">
    <table>
        <tr>
            <td>Upload file:</td>
            <td><input type="file" name="file"></td>
            <td style="color: red; font-style: italic";><form:errors path="file" /></td>
        </tr>

        <tr>
            <td></td>
            <td><input type="submit" value="Upload"></td>
            <td></td>
        </tr>
    </table>

</form:form>

<%--<form method="POST" action="uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file"><br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>--%>
</body>
</html>
