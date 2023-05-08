<%--
  Created by IntelliJ IDEA.
  User: minhkhiet
  Date: 07/05/2023
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create student</title>
</head>
<body>
<h3 style="text-align: center">Create Student</h3>
<form action="<%=request.getContextPath()%>/studentController/create" method="post" style="margin: auto">
    <lable>ID</lable>
    <br>
    <input type="text"name="id">
    <br>
    <lable>Name</lable>
    <br>
    <input type="text"name="name">
    <br>
    <lable>age</lable>
    <br>
    <input type="text"name="age">
    <br>
    <lable>Address</lable>
    <br>
    <input type="text"name="address">
    <br>
    <lable>Phone</lable>
    <br>
    <input type="text"name="phone">
    <br>
    <input type="submit" value="create">
</form>
</body>
</html>
