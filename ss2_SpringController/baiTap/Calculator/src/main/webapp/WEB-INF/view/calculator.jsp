<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/10/2023
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="post">
    <input type="text" name="s1" required>
    <input type="text" name="s2" required>
    <br>
    <br>
    <input type="submit" name="operand" value="Addition(+)">
    <input type="submit" name="operand" value="Subtraction(-)">
    <input type="submit" name="operand" value="Multiplication(X)">
    <input type="submit" name="operand" value="Division(/)">
</form>

<h1>Result: ${result}</h1>

</body>
</html>
