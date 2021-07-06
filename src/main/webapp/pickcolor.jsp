<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Color Picker</title>
</head>
<body>
<h1>Pick your color.</h1>
<form method="POST" action="/viewcolor">
    <label for="colorchoice">Enter your favorite color</label>
    <input type="text" id="colorchoice" name="colorchoice">
    <button type="submit">Click to make magic</button>
</form>

</body>
</html>