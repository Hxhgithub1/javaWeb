<%--
  Created by IntelliJ IDEA.
  User: 51051
  Date: 2020/11/7
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error500.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

一二三四五
<table border="1" width="50%">
    <tr>
        <th>序号</th>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <%
        for(int i = 0; i < 10; i++) {
    %>
    <tr>
        <td><%=i+1 %></td>
        <td>user<%=i %></td>
        <td><%=100 + 1 %></td>
        <td>i+1</td>
    </tr>
    <%
        }
    %>
</table>
<%=12 %> <br> <%=12.12 %> <br> <%="我是字符串" %> <br>
<br> <%request.getParameter("username");%>

</body>
</html>
