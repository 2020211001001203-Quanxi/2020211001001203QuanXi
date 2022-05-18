<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022/5/16
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>I am MyJsp.jsp</h4>
 <form method="post" action="<%=request.getContextPath()+"/exercise2"%>">
     name<input type="text" name="name"></br>
     class<input type="text" name="class"></br>
     ID<input type="text" name="id"></br>
     <input type="submit"  name="submit" value="Send data to the server">
 </form>
</body>
</html>
