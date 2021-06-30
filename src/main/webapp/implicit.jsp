<%--implicit objects can import classes or libraries--%>
<%@page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Random r = new Random();
//    to include both 1 and 7
    int ranNum = r.nextInt((7 - 1) + 1) + 1;
    if (ranNum == 1) {
        response.sendRedirect("/hello-world");
    } else if (ranNum == 7) {
        response.sendError(500);
    }
//    ternary on new String variable
    String textColor = (request.getParameter("color") != null) ? request.getParameter("color") : "";


%>

<html>
<head>
    <title>Implicit objects</title>
</head>
<body>
<%--implicit objects--%>
<h1><%=ranNum%></h1>
<h3 style="color: <%=textColor%>">The color you chose is <%=textColor%>!</h3>
<p>Query string: <%= request.getQueryString()%></p>
<p>Path: <%=request.getRequestURL()%></p>
<p>User-Agent Header <%=request.getHeader("user-agent")%></p>
</body>
</html>