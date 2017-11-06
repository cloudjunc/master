package jDemo;

import JEntity.JBlogEntity;
import jDbHelper.MySqlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MainIndexServlet")
public class MainIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String content=request.getParameter("content");

        MySqlHelper mySqlHelper=new MySqlHelper();
        mySqlHelper.InsertBlog(name,content);


        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw=response.getWriter();
        String sqlStr= "SELECT * FROM blogreport ORDER BY createtime";
        List<JBlogEntity> blogEntity=mySqlHelper.GetBlogEntity(sqlStr);
        StringBuilder MyStringBuilder = new StringBuilder("");

        MyStringBuilder.append("<div id=\"contentShow\">");
        for (JBlogEntity item :blogEntity
                ) {
            MyStringBuilder.append("<div>");
            MyStringBuilder.append("<h1>"+item.Name+"【"+item.CreateTime+"】"+"</h1>");
            MyStringBuilder.append("<p>"+item.Content+"</p>");
            MyStringBuilder.append("</div>");
            MyStringBuilder.append("<hr/>");
        }
        MyStringBuilder.append("</div>");
        pw.write(MyStringBuilder.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
