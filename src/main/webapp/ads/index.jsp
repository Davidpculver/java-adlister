<%--
  Created by IntelliJ IDEA.
  User: davidculver
  Date: 7/7/21
  Time: 9:03 AM
  To change this template use File | Settings | File Templates.
--%>

<%--this page should print out all the ads --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Ads</title>
</head>
<body>
<h1>Here are all the ads:</h1>

<c:forEach var="ad" items="${ads}">
    <div class="ad">
        <h2>${ad.title}</h2>
        <p>${ad.description}</p>
    </div>
</c:forEach>

</body>
</html>
