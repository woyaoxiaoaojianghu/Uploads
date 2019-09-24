package com.qf.Servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

@WebServlet("/ServletUploads")
public class ServletUploads extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Uploads(request,response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    private void Uploads(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploads = new ServletFileUpload(factory);
        List<FileItem> list = uploads.parseRequest(request);
        for (FileItem f :
                list) {
            if (!f.isFormField()){
                InputStream inputStream = f.getInputStream();
                String uploads1 = request.getServletContext().getRealPath("uploads");
                File file = new File(uploads1);
                if (!file.exists()){
                    file.mkdir();
                }
                UUID uuid = UUID.randomUUID();
                System.out.println(uuid);
                System.out.println(uuid.toString());
                String fName = uuid.toString()+"_"+f.getName();
                System.out.println(fName);
                String filePath = uploads1+File.separator+fName;
                FileOutputStream fos = new FileOutputStream(filePath);
                IOUtils.copy(inputStream,fos);
                fos.close();
                inputStream.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
