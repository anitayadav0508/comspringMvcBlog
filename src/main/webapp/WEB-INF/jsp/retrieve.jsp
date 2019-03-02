<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anita Yadav
  Date: 02-03-2019
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Retrieve Data</title>
</head>
<body>
<form action="/blog/update" method="post">
    Id : ${blog.id}<br>
    <input type="hidden" name="id" value="${blog.id}">
    Title<input type="text" name="title" value="${blog.title}"><br>
    Description <textarea cols="10" rows="12" name="description">${blog.description}</textarea><br>
    <input type="submit" value="update">
</form>
</body>
</html>
