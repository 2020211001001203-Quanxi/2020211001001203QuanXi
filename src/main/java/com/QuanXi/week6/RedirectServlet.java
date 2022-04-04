package com.QuanXi.week6;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //redirect - same server - Relative URL
        //1. start without /
        System.out.println("before redirect");

//        response.sendRedirect("index.jsp"); //url - change to index.jsp
        //http://localhost:8080/2020211001001203Quanxi_war/redirect
        //http://localhost:8080/2020211001001203Quanxi_war/index.jsp
        // see the url - only last part of url changed ( redirect --> index.jsp)

        System.out.println("after redirect");
        //2. start with /
        response.sendRedirect("/2020211001001203Quanxi_war/index.jsp"); //-???
        //why ?  -look url
        //http://localhost:8080/2020211001001203Quanxi_war/redirect
        //http://localhost:8080/index.jsp
        //url change after 8080 - means tomcat
        //add /2020211001001203Quanxi_war_exploded/

        //redirect - another server - Absolute URL
//        response.sendRedirect("https://www.baidu.com/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
