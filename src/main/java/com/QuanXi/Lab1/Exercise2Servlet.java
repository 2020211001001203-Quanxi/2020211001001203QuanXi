package com.QuanXi.Lab1;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Exercise2Servlet", value = "/exercise2")
public class Exercise2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/lab1/exercise2.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    String name=request.getParameter("name");
                    String submit=request.getParameter("submit");
                    String cla=request.getParameter("class");
                    String id=request.getParameter("id");

                    request.setAttribute("name",name);
                    request.setAttribute("submit",submit);
                    request.setAttribute("cla",cla);
                    request.setAttribute("id",id);
                    request.getRequestDispatcher("/lab1/MyDear.jsp").forward(request,response);
    }
}
