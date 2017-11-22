package jDemo;

import JEntity.JBlogEntity;
import jDbHelper.MySqlHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

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
//        StringBuilder MyStringBuilder = new StringBuilder("");
//
//        MyStringBuilder.append("<div id=\"contentShow\">");
//        for (JBlogEntity item :blogEntity
//                ) {
//            MyStringBuilder.append("<div>");
//            MyStringBuilder.append("<h1>"+item.Name+"【"+item.CreateTime+"】"+"</h1>");
//            MyStringBuilder.append("<p>"+item.Content+"</p>");
//            MyStringBuilder.append("</div>");
//            MyStringBuilder.append("<hr/>");
//        }
//        MyStringBuilder.append("</div>");
//        pw.write(MyStringBuilder.toString());

//        JSONArray listArray= JSONArray.fromObject(blogEntity);
//        String str=listArray.toString();
        JsonConfig config = new JsonConfig();
        config.setExcludes(new String[] { "Name" });

//        config.setIgnorePublicFields(false);
        // 指定在转换时不包含哪些属性
        JSONObject jsonObject = JSONObject.fromObject(blogEntity.get(0), config);
        JBlogEntity obj=blogEntity.get(0);
        JSONObject listArray= JSONObject.fromObject(obj,config);
        JSONObject listArray2= JSONObject.fromObject(obj,config);
        JSONObject listArray3= JSONObject.fromObject(obj,config);
        JSONObject listArray4= JSONObject.fromObject(obj,config);
        JSONObject listArray5= JSONObject.fromObject(obj,config);
        JSONObject listArray6= JSONObject.fromObject(obj,config);
        String[] str = { "Jack", "Tom", "90", "true" };
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("test", blogEntity);
        JSONArray json = JSONArray.fromObject(blogEntity,config);
        pw.write(json.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
