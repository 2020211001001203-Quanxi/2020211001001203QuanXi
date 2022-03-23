package com.QuanXi.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

//@WebServlet( urlPatterns = "/register",loadOnStartup = 1,name = "RegisterServlet", value = "/RegisterServlet")
@WebServlet("/register")
//automatic -new --> servlet
public class RegisterServlet extends HttpServlet {
    Connection con = null; // class variable
//    Statement stmt=null;

    @Override
    public void init() throws  ServletException{
        super.init();
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        //now use 4 variables to get connection

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoServlet"+con);   //just print for test

            //one connection -

        } catch (ClassNotFoundException | SQLException e ){
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer= response.getWriter();
        writer.println("Name: QuanXi");
        writer.println("ID: 2020211001001203");
//        response.sendRedirect("./register.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//request come here- <from method=post>
        //get parameter from request
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");//name of input type
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        System.out.println(gender);
        System.out.println(birthDate);
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into usertable values(?,?,?,?,?)";
        try {

            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,gender);
            ps.setString(5,birthDate);
            ps.executeUpdate();
            System.out.println("insert successfully");
            // select all rows from usertable
            sql = "select * from [usertable]";
            con.setAutoCommit(false);
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            writer.println("<table border=\"1\">");
            writer.println("<tr>");
            writer.println("<th>ID</th>");
            writer.println("<th>username</th>");
            writer.println("<th>password</th>");
            writer.println("<th>email</th>");
            writer.println("<th>gender</th>");
            writer.println("<th>birthDate</th>");
            writer.println("</tr>");
            while (resultSet.next()) {
                writer.println("<tr>");
                writer.println("<td>"+resultSet.getString("id")+"</td>");
                writer.println("<td>"+resultSet.getString("username")+"</td>");
                writer.println("<td>"+resultSet.getString("password")+"</td>");
                writer.println("<td>"+ resultSet.getString("email")+"</td>");
                writer.println("<td>"+resultSet.getString("gender")+"</td>");
                writer.println("<td>"+ resultSet.getString("birthDate")+"</td>");
                writer.println("<tr>");
            }
            writer.println("</table>");
            con.commit();

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
            //print - write into response
        PrintWriter writer= response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>email :"+email);
        writer.println("<br>gender :"+gender);
        writer.println("<br>birthDate :"+birthDate);
        writer.close();*/

    @Override
    public void destroy(){
        super.destroy();
        //close connection here - when stop tomcat
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
