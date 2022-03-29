<%--
  Created by IntelliJ IDEA.
  User: QXxx
  Date: 2022/3/28
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Life Cycle JSP</title>
</head>
<body>
    <%System.out.println("i'm in jspservice()");%>

</body>
</html>
<%--service--%>
<%!
public void jspDestroy(){
    System.out.println("I'm in jspDestroy()");
    }
%>