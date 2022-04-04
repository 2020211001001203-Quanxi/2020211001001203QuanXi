package com.QuanXi.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter writer = response.getWriter();
        //get parameter -<input type="text" name="txt" size=30/> and
        //get parameter -<select name ="search">
        String txt = request.getParameter("txt");
        String search = request.getParameter("search");
        System.out.println(search);
        //check is txt null
        System.out.println(txt);
        txt=new String(txt.getBytes("GBK"),"ISO8859_1"); //   Solve Chinese garbled code

        if(txt.equals("")) {
            //redirect to home page --index.jsp
            System.out.println("1");
            response.sendRedirect("index.jsp");
        }
        else{

            if (search.equals("baidu")) {
                //redirect to baidu
                System.out.println("2");
                response.sendRedirect("https://baidu.com/s?wd=" + txt);
            } else if (search.equals("bing")) {
                System.out.println("3");
                response.sendRedirect("https://cn.bing.com/search?q=" + txt);
            } else if (search.equals("google")) {
                System.out.println("4");
                response.sendRedirect("https://www.google.com/search?q=" + txt);
            }

        }//end doget
    }//end class
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
