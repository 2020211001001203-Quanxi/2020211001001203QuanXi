<%@ page import="com.QuanXi.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: QXxx
  Date: 2022/4/18
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<!-- need form -->
<%
    //get user from session
    User u =(User) session.getAttribute("user");
    System.out.println("你和");
    System.out.println(u);
%>
<form method="post" action="updateUser"> <!-- within doPost()in servlet-->
    <input type="hidden" name="id" value="<%=String.valueOf(u.getId())%>">
    username<input type="text" name="username" value="<%=u.getUsername()%>"><br/>
    password<input type="password" name="password" value="<%=u.getPassword()%>"><br/>
    Email<input type="text" name="email" value="<%=u.getEmail()%>"><br/>
    Gender:<input type="radio" name="gender" value="male" <%= "male".equals(u.getGender())?"checked" : ""%> > Male
    <input type="radio" name="gender" value="female"  <%= "female".equals(u.getGender())?"checked" : ""%> > Female <br/>

    <%--        if name is same it make array--%>
    Date of Birth: <input type="text name=" name="birthDate" value="<%=u.getBirthDate()%>"> <br/>
    <input type="submit" value="Save Changes">

</form>

<%@include file="footer.jsp"%>