<%@ page import="com.QuanXi.week11.Person" %>
<%@ page import="com.QuanXi.week11.Dog" %><%--
  Created by IntelliJ IDEA.
  User: QXxx
  Date: 2022/5/9
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 2 -week 11</title>
</head>
<body>
<%
    //create objects

        com.QuanXi.week11.Person person=new Person();
        person.setName("Tom");

        Dog dog =new Dog();
        dog.setName("Tommy");

        person.setDog(dog);


    //set attribute any one scope
    request.setAttribute("personAtt",person);

%>
<h2>get person's dog name - using java code</h2>

<%
   Person p = (Person) pageContext.findAttribute("personAtt"); //line 1
    Dog d = p.getDog();   //line 2
    out.println(p.getName()+"s' Dog name -->" +d.getName());  //line 3
%>

<h2>get person's dog name -  using EL code</h2>

    Person's Dog name :${personAtt.name}s' Dog name---> ${personAtt.dog.name}


</body>
</html>
