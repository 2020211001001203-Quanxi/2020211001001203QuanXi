<%@ page import="com.QuanXi.model.User" %><%--
  Created by IntelliJ IDEA.
  User: QXxx
  Date: 2022/4/4
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Info</h1>
<%--<%
// read cookies
    Cookie [] allCookies=request.getCookies(); //all cookies
    for (Cookie c: allCookies){
        //get one by one
        out.println("<br/>"+c.getName()+" --- "+c.getValue());
    }
%>
<%
    User u=(User)request.getAttribute("user");
%>--%>
<% //get user from request
    User u=(User) session.getAttribute("user");
    %>
<table>
    <tr>
    <tr><td>Username:</td><td><%=u.getUsername()%></td></tr>
    <tr> <td>Password:</td><td><%=u.getPassword()%></td></tr>
    <tr><td>Email:</td><td><%=u.getEmail()%></td></tr>
    <tr> <td>Gender:</td><td><%=u.getGender()%></td></tr>
    <tr> <td>BirthDate:</td><td><%=u.getBirthDate()%></td></tr>


    </tr>

</table>
<tr> <a href="updateUser">Update User</a></tr>
<%@include file="footer.jsp"%>