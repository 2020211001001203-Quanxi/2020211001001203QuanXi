package com.QuanXi.week5;

import com.QuanXi.dao.UserDao;
import com.QuanXi.model.User;

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
 /*   doPost(request,response); //call dopost*/
        //when user click login menu - request is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
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

        //now move jdbc code in dao - MVC design
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");//name of input type
        String password = request.getParameter("password");

        //now move jdbc code in dao - MVC design
        //write mvc code
        //use model and dao



        try {
            //let change code to make mvc
            UserDao userDao=new UserDao();
            User user= userDao.findByUsernamePassword(con,username,password); //this method use for login

            if(user!=null){
                //valid--login
                //week 8 code - demo #1- use cookie for session
               /* //create cookie
                //step 1 : create an object of cookie class
                Cookie c=new Cookie("sessionid",""+user.getId()); // sessionid = user-id
                //step 2: set age of cookie
                c.setMaxAge(10*60); //in sec -10min -7 days - 7*24*60*60
                //step 3: add cookie into response
                response.addCookie(c);

                request.setAttribute("user",user); //get user info in jsp
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);*/

                String rememberMe=request.getParameter("rememberMe"); //1=checked,null if checked
                if(rememberMe!=null && rememberMe.equals("1")){
                    //want to remember me
                    //create 3 cookies
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getUsername());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",user.getUsername());

                    //set age of cookies
                    usernameCookie.setMaxAge(5); //5 sec - test ---15days = 60*60*24*15
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    //add 3 cookies into response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);

                }
                //create a session
                HttpSession session= request.getSession(); //create a new session if session doesnot exist - otherwise return existing session
                //check session id
                System.out.println("session id--->"+session.getId()); //session id
                //set time for session
                session.setMaxInactiveInterval(10); //for 5 10section if request not come in - tomcat kill session - set 60*60* == 1h
                //set user model into request
                // week 8 0- change request(one page)  to session  -so we can get session attribute in many jsp page -login.jsp and header.jsp
                session.setAttribute("user",user); //set user info in session
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

                //forward
            }else{
                //invalid
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

            }
            //Forward - JSP
        } catch (SQLException e) {
            e.printStackTrace();
        }


      /* String sql = "select * from usertable where username='"+username+"' and password='"+password+"' ";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
        try {
*//*          String sql = "select * from usertable where username=? and password=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();*//*
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
        }*/
    }
}
