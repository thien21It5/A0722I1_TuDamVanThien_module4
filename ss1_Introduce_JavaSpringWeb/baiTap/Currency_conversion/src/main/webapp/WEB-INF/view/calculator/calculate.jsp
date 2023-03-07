<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/5/2023
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tranfer money</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate">
    Nhập chỉ số chuyển đổi : <input type="text" name="rate">
    nhập giá trị tiền tệ : <input type="text" name="usd">
    <input type="submit" value="Submit">
</form>
<h1>USA->VND: ${calculator}</h1>

</body>
</html>
