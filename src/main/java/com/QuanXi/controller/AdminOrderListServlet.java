package com.QuanXi.controller;

import com.QuanXi.dao.OrderDao;
import com.QuanXi.model.Order;
import com.QuanXi.model.Payment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "AdminOrderListServlet", value = "/admin/orderList")
public class AdminOrderListServlet extends HttpServlet {
    private Connection con=null;
   public void init(){
       con = (Connection) getServletContext().getAttribute("con");
   }

    @Override
    public void destroy() {
        super.destroy();  //just puts "destroy" string in log
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> paymentTypeList=Payment.findAllPayment(con);
        request.setAttribute("paymentTypeList",paymentTypeList);
        OrderDao orderDao=new OrderDao();
        List<Order> orderList=orderDao.findAll(con);
        request.setAttribute("orderList",orderList);
        String path="/WEB-INF/views/admin/orderList.jsp";
        request.getRequestDispatcher(path).forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
