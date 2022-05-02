<%@ page import="com.QuanXi.week10.StringBean" %><%--
  Created by IntelliJ IDEA.
  User: QXxx
  Date: 2022/4/30
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo -2- week 10</title>
</head>
<body>
<h1>use java code to access String bean class</h1>
<jsp:useBean id="bean" class="com.QuanXi.week10.StringBean"/>
<%
  //  com.QuanXi.week10.StringBean bean=new StringBean(); //change with useBean- step 6
    //step-4
  //  bean.setMessage("Hello Mr bean - from java code"); //change with setProperty

%>
<jsp:setProperty name="bean" property="message" value='<%=request.getParameter("message")%>'></jsp:setProperty>
Message(using java code) : <%=bean.getMessage()%>
<h2>use usebean to access StringBean class in jsp</h2>
Message(using getProperty): <jsp:getProperty name="bean" property="message"/>
</body>
</html>
