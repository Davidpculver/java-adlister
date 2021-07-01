<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello
    </title>
</head>
<body>
<%--name comes from the set attribute in the servlet--%>
<h1>Hello, ${name}!</h1>

<form action="hello" method="POST">
    <label for="name">Enter Name:</label>
    <input type="text" name="name" id="name">
    <input type="submit">
</form>


</body>
</html>