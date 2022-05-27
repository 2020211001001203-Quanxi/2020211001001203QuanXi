package com.QuanXi.controller;

import com.QuanXi.dao.UserDao;
import com.QuanXi.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
      con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //write code
        //TODO 1: forward WEB-INF/views/updateUser.jsp
        //TODO 2: create one jsp page - update User
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // write code to update user info- can update password ,email ,gender ,birthDate

        //TODO 1: get all (6)  request parameters
        //TODO 2: create an object of User Model
        //TODO 3: set all 6 request parameters values into User model -- setXXX()
        //TODO 4: create an object of UserDao
        //TODO 5: Call updateUser in UserDao

        //TODO 6: forward to web-inf/views/userInfo.jsp
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthDate= request.getParameter("birthDate");
        User user=new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthDate(birthDate);
        UserDao userDao=new UserDao();
        try {

            userDao.updateUser(con,user);
            userDao.findById(con, Integer.valueOf(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session=request.getSession();
        System.out.println("session id-->"+session.getId());
        session.setMaxInactiveInterval(10);
        session.setAttribute("user",user);
        request.getRequestDispatcher("accountDetails").forward(request,response);
    }
}
