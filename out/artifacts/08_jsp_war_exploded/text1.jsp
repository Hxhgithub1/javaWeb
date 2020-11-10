<%--
  Created by IntelliJ IDEA.
  User: 51051
  Date: 2020/11/7
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">

<%
    for (int i =1 ; i <10 ; i++) { %>
    <tr>
<%
    for (int j = 1; j <=i ; j++) {
%>
<td><%=i+"x"+j+"="+i*j%><td/>
<%
    }
%>
  <tr/>

<%
    }
%>
</table>
</body>
</html>
