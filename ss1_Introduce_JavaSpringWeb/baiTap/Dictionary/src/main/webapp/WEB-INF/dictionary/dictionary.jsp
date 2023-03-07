<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/6/2023
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Từ điển Việt - Anh</h1>
<h3>{"Trái chuối", "Quả đào", "Trái nho", "Trái dứa"}</h3>
<h3>{"Banana", "Peach", "Grape", "Pineapple"}</h3>
<form action="/dictionary">
    <label>Nhập từ cần tra cứu</label>
    <input type="text" name="word">
    <input type="submit" value="Submit">
</form>
<h3>Từ cần dịch là: ${word}</h3>
<h3>Sau khi dịch: ${dictionary}</h3>
</body>
</html>
