<%--
  Created by IntelliJ IDEA.
  User: davidculver
  Date: 7/5/21
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guessing game</title>
</head>
<body>

<h1>Welcome to the guessing game.</h1>

<form action="/guess" method="POST">

    <label for="userguess">Guess a number between 1 and 3</label>
    <input type="text" id="userguess" name="userguess">
    <button type="submit">Submit guess</button>

</form>

</body>
</html>
