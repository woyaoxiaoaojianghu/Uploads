package com.qf.Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/ServletDemo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        downLoad(request,response);
    }

    private void downLoad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = request.getParameter("filename");
        String realPath = request.getServletContext().getRealPath("/img/" + filename);
        System.out.println(realPath);
        FileInputStream fileInputStream = new FileInputStream(realPath);
        response.setHeader("content-disposition","attachment;filename="+filename);
        ServletOutputStream stream = response.getOutputStream();
        byte[] buff = new byte[1024];
        int len = 0;
        while((len=fileInputStream.read(buff))!=-1){
            stream.write(buff,0,len);
        }
        stream.close();
        fileInputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
