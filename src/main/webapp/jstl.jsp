<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("lactoseIntolerant", false);

    List<String> dairyProducts = new ArrayList<>();
    dairyProducts.add("milk");
    dairyProducts.add("cheese");
    dairyProducts.add("yogurt");
    dairyProducts.add("ice cream");
    dairyProducts.add("cottage cheese");
    dairyProducts.add("butter");

//    jsp to value of instance of dairyProducts arraylist
    request.setAttribute("dairyProducts", dairyProducts);

    boolean textIsBlue = true;
    request.setAttribute("blue", textIsBlue);
%>


<html>
<head>
    <title>JSPs: JSTL
    </title>
</head>
<body>
<h1>Hello!</h1>

<%--what kind of functionality we are going to be using.--%>
<c:choose>
<%--    when this is true, output whats within the tags.--%>
    <c:when test="${lactoseIntolerant}">
        <h1>You are lactose intolerant. Please do not buy dairy products.</h1>
    </c:when>
<%--    otherwise acts as our else--%>
    <c:otherwise>
        <h3>Dairy Products List</h3>
<%--        foreach loop with jstl--%>
        <c:forEach items="${dairyProducts}" var="diaryProduct">
            <div>
                <p>${diaryProduct}</p>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>

<%--if only want to test if true, can use if statement. There is no <c:else> tag. Use when/otherwise--%>
<c:if test="${blue}">
    <p style="color: blue">Blue text</p>
</c:if>



</body>
</html>