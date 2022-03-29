<%--
  Created by IntelliJ IDEA.
  User: QXxx
  Date: 2022/3/28
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>MyEclipse</title>
<%@include file="header.jsp"%>
<h1>Login</h1>

    <form method="post" action="login">
        username<input type="text" name="username"><br/>
        password<input type="password" name="password"><br/>
        <input type="submit" value="Login">
    </form>
<%@include file="footer.jsp"%>