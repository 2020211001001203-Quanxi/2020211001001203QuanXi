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
<%
    if(!(request.getAttribute("message")==null)){
        //error
        out.println(request.getAttribute("message"));
    }
%>
<%
    //read cookies
    Cookie[] allCookies=request.getCookies(); //give all cookies
    String username="", password="",rememberMeVal="";
    if(allCookies!=null){
        //we read 3 cookies
        for (Cookie c: allCookies){
            if (c.getName().equals("cUsername")){
                //get values of this cookies
                username=c.getValue();
            }
            if (c.getName().equals("cPassword")){
                //get values of this cookies
                password=c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                //get values of this cookies
                rememberMeVal=c.getValue();
            }




        }
    }
%>
<h1>Login</h1>

    <form method="post" action="login">
        username<input type="text" name="username" value="<%=username%>"><br/>
        password<input type="password" name="password" value="<%=password%>" ><br/>
        <input type="checkbox" value="1" name="rememberMe" <%=rememberMeVal.equals("1")?"checked" : ""%>checked/>Remember<br/>
        <input type="submit" value="Login">
    </form>
<%@include file="footer.jsp"%>