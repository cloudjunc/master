package jDemo;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;

public class TextServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        PrintWriter out=response.getWriter();
            out.print("hello text \r\n"+request.getParameter("TextContent"));
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        pw.write("<h1>hello  first servlet!</h1>");
    }
}
