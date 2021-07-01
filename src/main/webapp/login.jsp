<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    if(request.getMethod().equalsIgnoreCase("post")){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equalsIgnoreCase("admin") && password.equals("password")){
            response.sendRedirect("/profile.jsp");
        } else {
            response.sendRedirect("/login.jsp");
        }
    }
%>

<%--INSTRUCTOR EXAMPLE--%>
<%
if (request.getMethod().equalsIgnoreCase("post")){
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    if(username.equals("admin") && password.equals("password")){
        response.sendRedirect("/profile.jsp");
    }

}
%>





<html>
<head>
    <title>Login</title>

    <%@include file="partials/head.jsp"%>

</head>

<header>
    <%@include file="partials/navbar.jsp"%>
</header>

<body class="m-5">

<main class="mt-3">
    <h3>Please log in below.</h3>

    <form method="post" action="/login.jsp">
        <div class="row mb-3">
            <label for="username" class="col-sm-2 col-form-label">Username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username">
            </div>
        </div>
        <div class="row mb-3">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="password" name="password">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Sign in</button>
    </form>
</main>

</body>
</html>





<%--<form method="post" action="/login.jsp">--%>
<%--    <label for="username">Enter your username:</label><br>--%>
<%--    <input type="text" id="username" name="username"><br>--%>
<%--    <label for="password">Enter your password:</label><br>--%>
<%--    <input type="text" id="password" name="password">--%>
<%--    <button type="submit">Log in</button>--%>
<%--</form>--%>

<%--INSTRUCTOR EXAMPLE--%>




















