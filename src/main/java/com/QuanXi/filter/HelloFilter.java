package com.QuanXi.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// 2 ways of mapping filter to servlet
// way1 - use web.xml
// way2 - user WebFilter
@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/hello"}
)

//test 1 : url /hello - filter is only for one Servlet - HelloServlet
//test 2 : url /* - this filter of for all servlet
//test 3 : 3 url - this filter for these 3 url only
public class HelloFilter implements Filter { //remember
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter-->init() "); //when called? - start tomcat
    }

    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy() "); //when called? - stop tomcat
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request come here - before go to servlet - doGet() or doPost()
        System.out.println("i am in HelloFilter-->doFilter() - before servlet - (request come here )"); //when called?

        chain.doFilter(request, response); //call next filter - if no next filter - then go to servlet
        //response after servlet come back here
        System.out.println("i am in HelloFilter-->doFilter() - afrer servlet - (request come here )"); //when called?
    }
}
