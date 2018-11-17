<%--
  Created by IntelliJ IDEA.
  User: zhuokun
  Date: 13/11/18
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Title</title>
</head>
<body>

<h1>${message}</h1>

<form action="/login" role="form" method="post">
    Username: <input type="text" name="username"><<br>
    Password: <input type="password" name="password"><<br>
    <input type="submit" value="submit">
</form>
</body>
</html>
