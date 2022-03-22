package com.QuanXi.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/life") //only url -  no web.xml code
public class LifeCycleServlet extends HttpServlet {
    //1. tomcat read wen.xml file and find out all servlet class
    //2. load servlet - when? 2 first request for this servlet come in - from client
    //3. call default constructor - add code

 Connection con=null;
    public  LifeCycleServlet(){
        System.out.println("I am in constructor -->LifeCycleServlet");
    }

    //4. init() -add code
    //user for
    @Override
    public void init(){
        // we can use in many servlet
        //demo #3 -use Servletcontext

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

        System.out.println("I am in init() -->LifeCycleServlet -->" + con);

    }

    //5.tomcat call service() --> call doGet() or doPost()

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am in service() --> Doget()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy() {

        System.out.println("I am in destroy() ");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
