package com.qf.Servlet;

import com.qf.dao.Impl.User2DaoImpl;
import com.qf.dao.Impl.UserDaoImpl;
import com.qf.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            register(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        User user = new User(username,password,email,name,phone,sex,parse);
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.addUser(user);
        if (i>0){
            User2DaoImpl user2Dao = new User2DaoImpl();
            user2Dao.add(username,password);
            String s = request.getContextPath();
            response.sendRedirect(s+"/login.jsp");
        }else {
            request.setAttribute("omg","登录失败请检查内容是否填正确");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
