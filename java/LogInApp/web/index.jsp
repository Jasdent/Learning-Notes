<%--
  Created by IntelliJ IDEA.
  User: zhuokun
  Date: 1/11/18
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  Index Page
    <a href="Hello.jsp">Module 1</a> <br>
    <% if (session.getAttribute("login_status") != null && ((String) session.getAttribute("login_status")).equals("ok")){%>
      <a href="/LogoutServlet">Logout</a>
    <%}else{%>
      <a href="login.jsp">login</a>
    <%}%>
  </body>
</html>
