<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza
    </title>
    <%@include file="partials/head.jsp"%>
</head>
<body>
<h1 class="bg-primary">Order your pizza below.</h1>

<form action="/pizza-order" method="POST">

    <div class="form-check">
        <input class="form-check-input" type="radio" name="size" id="small" value="small" checked>
        <label class="form-check-label" for="small">
            Small
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="size" id="medium" value="medium">
        <label class="form-check-label" for="medium">
            Medium
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="radio" name="size" id="large" value="large">
        <label class="form-check-label" for="large">
            Large
        </label>
    </div>

    <div class="form-group">
        <label for="crust">Select Your Crust</label>
        <select class="form-control" id="crust" name="crust">
            <option value="thin">Thin</option>
            <option value="handtossed">Handtossed</option>
            <option value="pan">Pan</option>
        </select>
    </div>
    <div class="form-group">
        <label for="sauce">Select Your Sauce</label>
        <select class="form-control" id="sauce" name="sauce">
            <option value="red">Red</option>
            <option value="white">White</option>
            <option value="buffalo">Buffalo</option>
        </select>
    </div>

    <p>Select your toppings</p>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="cheese" id="cheese" name="topping">
        <label class="form-check-label" for="cheese">
            Cheese
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="pepperoni" id="pepperoni" name="topping">
        <label class="form-check-label" for="pepperoni">
            Pepperoni
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="sausage" id="sausage" name="topping">
        <label class="form-check-label" for="sausage">
            Sausage
        </label>
    </div>

    <div class="form-group">
        <label for="address">Enter Your Address</label>
        <textarea class="form-control" id="address" name="address" rows="3"></textarea>
    </div>
    <button type="submit">Submit pizza order</button>
</form>
</body>
</html>