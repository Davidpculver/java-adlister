<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--jsp's let us output html--%>
<%--To begin, may need to delete the target folder, reload Maven project on the tab on right hand side, then re-run the server.--%>

<%--Directive tags use percent sign + @ symbol--%>
<%--page directive can include multiple attributes--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Include files from file structure--%>
<%--<%@include file=""%>--%>
<%----%>
<%--<%@taglib prefix=""%>--%>



<%--! lets us declare variables. ! defines instance variables. In this case, the instance count will increase, the local count will remain 2 on the page. --%>
<%! int instanceCount = 0; %>

<%-- <% to execute arbratrary java--%>
<%--    local count will will remain static, it will not change, however instanceCount will increase everytime page is refreshed.--%>
<%
    int localCount =1;
    localCount += 1;
    instanceCount +=1;
%>



<html>
<head>
    <title>JSP tags
    </title>
</head>
<body>
<%@include file="partials/navBar.jsp"%>
<%@include file="partials/head.jsp"%>
    <h1 class="bg-primary">Hello there</h1>
<%--    use <%= to use variables from above %> and print to the brower--%>
    <h2>The local count is <%= localCount %></h2>
    <h2>The instance count is <%= instanceCount %></h2>
<%@include file="partials/national-parks.jsp"%>
</body>
</html>