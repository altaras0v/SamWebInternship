<%@ page import="myapp.service.impl.CourseServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="myapp.dto.CourseDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>

<h2>How to iterate list on JSP in Spring MVC</h2>



<p><b>Iterated List:</b></p>

<c:forEach begin="0" end="0" varStatus="loop">
    <%  %>
     ${listsCourses.get(listsCourses.size()-listsCourses.size()).name}
    ${listsCourses.get(listsCourses.size()-listsCourses.size()).description}
    ${listsCourses.get(listsCourses.size()-listsCourses.size()+1).name}
    ${listsCourses.get(listsCourses.size()-listsCourses.size()+1).description}
</c:forEach>





</body>
</html>