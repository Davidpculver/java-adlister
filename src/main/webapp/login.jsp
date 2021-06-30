<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--if (ranNum == 1) {--%>
<%--        response.sendRedirect("/hello-world");--%>
<%--    } else if (ranNum == 7) {--%>
<%--        response.sendError(500);--%>
<%--    }--%>

<%--    String textColor = (request.getParameter("color") != null) ? request.getParameter("color") : "";--%>

<%
    if(request.getMethod().equalsIgnoreCase("post")){
        if(request.getParameter("username").equalsIgnoreCase("username")){
            System.out.println("it's working");
        }
    }
%>

<html>
<head>
    <title>Login
    </title>
</head>
<body>

<h1>Hi there</h1>
<form method="post" action="/login.jsp">
    <label for="username">Enter your username:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Enter your password:</label><br>
    <input type="text" id="password" name="password">
    <input type="submit" value="Submit">
</form>
</body>
</html>

<%--post to login--%>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Implicit objects</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--&lt;%&ndash;implicit objects&ndash;%&gt;--%>
<%--<h1><%=ranNum%></h1>--%>
<%--<h3 style="color: <%=textColor%>">The color you chose is <%=textColor%>!</h3>--%>
<%--<p>Query string: <%= request.getQueryString()%></p>--%>
<%--<p>Path: <%=request.getRequestURL()%></p>--%>
<%--<p>User-Agent Header <%=request.getHeader("user-agent")%></p>--%>
<%--</body>--%>
<%--</html>--%>