<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>

<form action="/login" method="post">
    <!--action 的 值用于映射到 web.xml-->

    <%if (request.getAttribute("intendedPath")!=null){%>
        <input type="hidden" name="intendedPath" value="<%request.getAttribute("intendedPath");%>">
    <%}%>
    Username <input type="email" name="email"><br>
    Password <input type="password" name="password"><br>
    <input type="submit" name="submit">
    <input type="reset" name="reset">
</form>
<a href="index.jsp">index</a>

</body>
</html>