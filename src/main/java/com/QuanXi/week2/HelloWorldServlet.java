package com.QuanXi.week2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //when client request method is Get -here - inside doGet()
        //we want to send Hello to client
        //we need to write Hello in response
        //get writer -java .io
        PrintWriter writer= response.getWriter();
        Date d = new Date();

        writer.println("Name: Quanxi");
        writer.println("ID: 2020211001001203");
        writer.println(d);

        //that all
        //next we need to tell about this serlvet to tomcat -how ? -web.xml


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        //when client request method is Post -here - inside doGet()
    }
}
