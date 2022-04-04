package com.QuanXi.week5;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws  ServletException {
        super.init();

        //TODO 1: Get 4 CONTEXT PARAM - DRIVER , URL , USERNAME , PASSWORD
        //TODO 2: GET JDBC connection

       /* ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection --> in JDBCDemoServlet" + con);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

        // only one one
        con = (Connection) getServletContext().getAttribute("con");
        //check the video live demo#4
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response); //call dopost
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 3: GET REQUEST PARAMETER - USERNAME AND PASSWORD
        //TODO 4: validate user - select * from usertable where username = "xxx"
        //TODO 5: check if (user is valid){
        //out.println(“LOGIN SUCCESS !!!");
        //out.println("WELCOME ,USERNAME ");
        //  }ELSE}
        // out.println("LOGIN ERROR");
        // }

        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");//name of input type
        String password = request.getParameter("password");
        String sql = "select * from usertable where username='"+username+"' and password='"+password+"' ";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
        try {
/*          String sql = "select * from usertable where username=? and password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();*/
            ResultSet rs = con.createStatement().executeQuery(sql);
            if (rs.next()) {
//                writer.println("<h1>Login Success!!!</h1>");
//                writer.println("<h1>Welcome," + username + "</h1>");
                //get from rs and set into request attribute

                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthDate",rs.getString("birthDate"));

                // forward to userInfo.jsp
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            } else {
//                writer.println("<h1>Login Error!!!</h1>");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
