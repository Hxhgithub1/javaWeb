<%--
  Created by IntelliJ IDEA.
  User: 51051
  Date: 2020/11/7
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope.jsp 页面</h1>
<% // 往 四 个 域 中 都 分 别 保 存 了 数 据
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "request");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
pageContext 域是否有值：<%=
pageContext.getAttribute("key")%> <br>
request 域是否有值：<%=request.getAttribute("key")%> <br>
session 域是否有值：<%=session.getAttribute("key")%> <br>
application 域是否有值：<%=application.getAttribute("key")%> <br>
<%--#<% request.getRequestDispatcher("/scope2.jsp").forward(request,response); %>--%>
<js

foot
</body>
</html>
