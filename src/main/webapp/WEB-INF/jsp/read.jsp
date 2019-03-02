<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Anita Yadav
  Date: 23-02-2019
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="100%" border="1">
    <tr bgcolor="aqua">

        <th>Id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Delete/Update</th>
    </tr>
<c:forEach var="items" items= "${blogs}">
          <tr bgcolor="#7fff00">
             <th>${items.id}</th>
            <th> ${items.title}</th>
            <th>${items.description}</th>
              <th><a href="/blog/delete?id=${items.id}">Delete</a>
              <a href="/blog/get?id=${items.id}" >Edit</a></th>

        </tr>
    </c:forEach>
</table>
</body>
</html>
