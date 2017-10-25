package jDbHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
}
