package com.qf.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/Demo3.jsp")
public class DemoFilter implements Filter {
    public void destroy() {
        System.out.println("执行destroy（）方法");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("执行doFilter()方法");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("执行init()方法");
    }

}
