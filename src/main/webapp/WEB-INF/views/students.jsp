<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minhkhiet
  Date: 07/05/2023
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h1 style="text-align: center">Student Manager</h1>
<br>
<h2><a href="<%=request.getContextPath()%>/studentController/initCreate">Create Student</a></h2>
<table border="1" style="text-align: center;margin: auto; width: 80%; background-color: aqua" >
    <thead>
    <tr>
    <th>STT</th>
    <th>ID</th>
    <th>NAME</th>
    <th>AGE</th>
    <th>ADDRESS</th>
    <th>PHONE</th>
    <th colspan="2">ACTION</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${listStudent}" var="st" varStatus="sta">
        <tr style="${sta.count % 2 == 0 ? 'background-color: chocolate' : ''}">
        <td>${sta.count}</td>
        <td>${st.id}</td>
        <td>${st.name}</td>
        <td>${st.age}</td>
        <td>${st.address}</td>
        <td>${st.phone}</td>
        <td><a href="<%=request.getContextPath()%>/studentController/delete?id=${st.id}">delete</a></td>
        <td><a href="<%=request.getContextPath()%>/studentController/edit?id=${st.id}">edit</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<script>
</script>
</body>
</html>
