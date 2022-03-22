package com.QuanXi.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;

@WebServlet("/config")
public class ConfigDemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*   Exercise#1 task1
      ServletConfig config=getServletConfig();

        String name =config.getInitParameter("name"); //get <param-name>name</param-name>
        String StudentId =config.getInitParameter("StudentId"); // <param-name>StudentId</param-name>*/

        /* Exercise#1 task2 */
        ServletContext context = getServletContext();
        String name = context.getInitParameter("name");
        String StudentId = context.getInitParameter("StudentId");

        PrintWriter writer= response.getWriter();

        writer.println("name :" + name);
        writer.println("studentid:"+StudentId) ;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
