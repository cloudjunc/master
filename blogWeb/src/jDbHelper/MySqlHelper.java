package jDbHelper;

import JEntity.JBlogEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MySqlHelper {
    public List<String> GetBlogContent(String sqlstr){
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "123456";
        List<String> strList=new ArrayList<String>();

        if(sqlstr==null || sqlstr.isEmpty()){
           return strList;
        }

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed()){
                strList.add("Succeeded connecting to the Database!");
            }
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlstr);
            String name = null;
            String blogText = null;
            while(rs.next()){
                //获取stuname这列数据
                name = rs.getString("writer");
                //获取stuid这列数据
                blogText = rs.getString("content");
                //首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
                //然后使用GB2312字符集解码指定的字节数组。
//                name = new String(name.getBytes("ISO-8859-1"),"gbk");
//                blogText = new String(blogText.getBytes("ISO-8859-1"),"gbk");
                strList.add(name+"\t"+blogText);
            }
            rs.close();
            con.close();

        } catch (ClassNotFoundException e) {
            strList.add("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return strList;
        }
    }

    private  boolean IsEmptyOrNull(String str){
        return str==null || str.isEmpty();
    }


    public void InsertBlog(String name,String content){
        if(IsEmptyOrNull(name) || IsEmptyOrNull(content)){
            return;
        }
        Calendar cal= Calendar.getInstance();
//        Date date= (Date) cal.getTime();

        int max=2000000000;
        int min=1000000000;
        Random random = new Random();
        int id = random.nextInt(max)%(max-min+1) + min;

        String sqlstr=String.format("INSERT INTO blogreport(writer,id,content,createtime) " +
                "VALUES('%s',%d,'%s',NOW());",name,id,content);

        MysqlConfigue configue=new MysqlConfigue();
        Connection con;

        try {
            Class.forName(configue.driver);
            con = DriverManager.getConnection(configue.url,configue.user,configue.password);
            Statement statement = con.createStatement();
            int rs = statement.executeUpdate(sqlstr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<JBlogEntity> GetBlogEntity(String sqlstr){
        Connection con;
        MysqlConfigue configue=new MysqlConfigue();
        List<JBlogEntity> entityList=new ArrayList<JBlogEntity>();

        if(sqlstr==null || sqlstr.isEmpty()){
            return entityList;
        }

        try{
            Class.forName(configue.driver);
            con = DriverManager.getConnection(configue.url,configue.user,configue.password);

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlstr);

            while(rs.next()){
                JBlogEntity entityTemp=new JBlogEntity();
                entityTemp.setName(rs.getString("writer"));
                entityTemp.setContent( rs.getString("content"));
                entityTemp.setID ( rs.getLong("ID"));
                entityTemp.setCreateTime( rs.getTimestamp("createtime").toString());
                entityList.add(entityTemp);
            }
            rs.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            return entityList;
        }
    }
}
