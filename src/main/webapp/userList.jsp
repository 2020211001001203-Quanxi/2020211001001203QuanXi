<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: QXxx
  Date: 2022/4/4
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.ResultSet" %>
    <title>Title</title>
<%@include file="header.jsp"%>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>Id</td><td>Username</td><td>password</td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>

    <%
        //get rs from request attribute
        ResultSet resultSet =(ResultSet) request.getAttribute("resultSetname"); // name of attribute -
        System.out.println(request);
        if(resultSet == null)    {
    %>

        <tr>
         <th>NO Data!!!</th>
        </tr>
    <% }else {
        while (resultSet.next()) {
            //get one by one
            out.println("<tr>");
            out.println("<td>" + resultSet.getInt("id") + "</td>");
            out.println("<td>" + resultSet.getString("username") + "</td>");
            out.println("<td>" + resultSet.getString("password") + "</td>");
            out.println("<td>" + resultSet.getString("email") + "</td>");
            out.println("<td>" + resultSet.getString("gender") + "</td>");
            out.println("<td>" + resultSet.getString("birthDate") + "</td>");

            out.println("</tr>");

            // we will get data in next demo -6.liveDemo #2
        }
    }
    %>

    </table>  
<%@include file="footer.jsp"%>