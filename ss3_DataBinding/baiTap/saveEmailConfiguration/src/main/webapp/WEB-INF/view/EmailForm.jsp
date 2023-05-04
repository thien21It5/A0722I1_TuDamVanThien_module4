<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 3/18/2023
  Time: 1:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Email Form</title>
</head>
<style>
    table{
        border-collapse: collapse;
    }
    table th{
        width: 100px;
        height: 50px;
    }
    table td{
        width: 100px;
        height: 50px;
    }
</style>
<body>
<h1>Settings</h1>
<form:form action="save" method="post" modelAttribute="email">
    <table border="1px">
        <tr>
            <th><form:label path="language">Languages</form:label></th>
            <td><form:select path="language">
                <form:option value="None"/>
                <form:options items="${listLanguages}"/>
            </form:select></td>
        </tr>
        <tr>
            <th><form:label path="pageSize">Page Size</form:label></th>
            <td>Show <form:select path="pageSize">
                <form:option value="None"/>
                <form:options items="${listPageSize}"/>
            </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <th><form:label path="spamFilter">Spams filter</form:label></th>
            <td><form:radiobutton path="spamFilter" value="True"/> Enable spams filter</td>
        </tr>
        <tr>
            <th><form:label path="signature">Signature</form:label></th>
            <td><form:textarea path="signature" cols="20" rows="10"/></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" role="button" value="Update">
                <input type="reset" role="button" value="Cancel">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
