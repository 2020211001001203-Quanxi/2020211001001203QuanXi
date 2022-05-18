package com.QuanXi.Lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Excise1Servlet", value = "/count")
public class Exercise1Servlet extends HttpServlet {
    private int n=0;
    public void init() throws ServletException {
        super.init();
        System.out.println("I Am from default constructor");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        n++;
        PrintWriter out = response.getWriter();
        out.println("<div style='text-align:center;'><h2>since loading,this servlet has been accessed "+n+" times !!</h2></div>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}

