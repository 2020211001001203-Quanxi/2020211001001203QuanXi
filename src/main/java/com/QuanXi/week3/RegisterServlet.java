package com.QuanXi.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
//automatic -new --> servlet
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//request come here- <from method=post>
        //get parameter from request
        String username =request.getParameter("username"); //name of input type -username<input type="text" name="username">
        String password =request.getParameter("password"); //password<input type="password" name="password">
        String email =request.getParameter("email"); // Email<input type="text" name="email">
        String gender =request.getParameter("gender"); //Gender:<input type="radio" name="gender">
        String birthDate =request.getParameter("birthDate"); // Date of Birth: <input type="text name=" name="birthDate">

        //print - write into response
        PrintWriter writer= response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>email :"+email);
        writer.println("<br>gender :"+gender);
        writer.println("<br>birthDate :"+birthDate);
        writer.close();
    }
}
