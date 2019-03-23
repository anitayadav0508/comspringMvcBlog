<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anita Yadav
  Date: 23-03-2019
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr bgcolor="#dc143c">
        <th>Id</th>
        <th>Title</th>
        <th>BookName</th>
        <th>No of Pages</th>
    </tr>


    <c:forEach var="item" items="${listofbooks}">

        <tr bgcolor="anita yadav">
            <td> ${item.getBook().getId()}</td>
            <td>${item.getTitle()}</td>
            <td>${item.getBook().getName()}</td>
            <td>${item.getNo_of_pages()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
