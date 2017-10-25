package jDemo;

import jDbHelper.MySqlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw=response.getWriter();
        pw.write("<h1>hello  first User!</h1>");
        MySqlHelper mySqlHelper=new MySqlHelper();
        String sqlStr= "SELECT * FROM blogreport";
        List<String> blogStrs=mySqlHelper.GetBlogContent(sqlStr);
        StringBuilder MyStringBuilder = new StringBuilder("");

        for (String item :blogStrs
             ) {
            MyStringBuilder.append("<h2>"+item+"</h2>");
        }
        pw.write(MyStringBuilder.toString());
    }

}
