package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//数据库处理类:(1)进行数据库连接的初始化操作 （2）进行select * from jiance;将数据全部查询出来
public class Connect {
    //此类的全局变量设置
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    List<HashMap<String, String>> list=new ArrayList<HashMap<String,String>>();
    //数据库连接的初始化操作
    public void initDB(){
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/jiankong?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String user="root";
        String password="111111";

        try{
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.printf("数据库创建连接失败");
            e.printStackTrace();
        }
    }

    //查询数据类
    public void selectAll() throws SQLException {
        preparedStatement=connection.prepareStatement("select * from jiance");
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            HashMap<String,String> map=new HashMap<String, String>();
            map.put("id",resultSet.getString(1));
            map.put("time",resultSet.getString(2));
            map.put("station",resultSet.getString(3));
            map.put("zuobiao",resultSet.getString(4));
            map.put("energy",resultSet.getString(5));
            map.put("jibie",resultSet.getString(6));
            list.add(map);
        }
        //检查是否完成了查询操作
        for(HashMap<String, String>lists:list) {
            System.out.println(lists);
        }
    }
}
