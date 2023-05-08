<%--
  Created by IntelliJ IDEA.
  User: minhkhiet
  Date: 07/05/2023
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h3 style="text-align: center">Update Student</h3>
<form action="<%=request.getContextPath()%>/studentController/update" method="post" style="margin: auto">
    <lable>ID</lable>
    <br>
    <input type="text"name="id" readonly value="${stUpdate.id}">
    <br>
    <lable>Name</lable>
    <br>
    <input type="text"name="name" value="${stUpdate.name}">
    <br>
    <lable>age</lable>
    <br>
    <input type="text"name="age" value="${stUpdate.age}">
    <br>
    <lable>Address</lable>
    <br>
    <input type="text"name="address" value="${stUpdate.address}">
    <br>
    <lable>Phone</lable>
    <br>
    <input type="text"name="phone" value="${stUpdate.phone}">
    <br>
    <input type="submit" value="update">
</form>
</body>
</html>
