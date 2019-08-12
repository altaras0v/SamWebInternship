<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<style>
    <%@include file="/WEB-INF/css/error.css"%>
</style>
<div id="clouds">
    <div class="cloud x1"></div>
    <div class="cloud x1_5"></div>
    <div class="cloud x2"></div>
    <div class="cloud x3"></div>
    <div class="cloud x4"></div>
    <div class="cloud x5"></div>
</div>
<div class='c'>
    <div class='_404'>404</div>
    <hr>
    <div class='_1'><spring:message
            code="error.thepage"/></div>
    <div class='_2'><spring:message
            code="error.notfound"/> </div>
    <a class='btn' href="<c:url value='/'/>"><spring:message
            code="error.return"/></a>
</div>