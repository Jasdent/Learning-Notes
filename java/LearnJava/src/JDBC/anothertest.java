package JDBC;

// import com.mysql.jdbc.*;
import java.sql.*;

/*
 构建JDBC应用程序涉及以下六个步骤
导入包：需要包含包含数据库编程所需的JDBC类的包。 大多数情况下，使用import java.sql.*就足够了。
注册JDBC驱动程序：需要初始化驱动程序，以便可以打开与数据库的通信通道。打开一个连接：需要使用DriverManager.getConnection()方法创建一个Connection对象，它表示与数据库的物理连接。
执行查询：需要使用类型为Statement的对象来构建和提交SQL语句到数据库。
从结果集中提取数据：需要使用相应的ResultSet.getXXX()方法从结果集中检索数据。
清理环境：需要明确地关闭所有数据库资源，而不依赖于JVM的垃圾收集。

* */

public class anothertest {
    static final String DB_URL = "jdbc:mysql://localhost:3306/events?useSSL=false";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public static void main(String[] args){
        // Class.forName(JDBC_DRIVER);


        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to "+DB_URL);
            conn = DriverManager.getConnection(DB_URL,"zhuokun","CserJasdent19");
            stmt = conn.createStatement();

            System.out.println("Connected");

            String sql;
            sql = "select * from studentlist";


            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.print("Student ID: "+rs.getInt("studentID")+" ");
                System.out.print("Name: "+rs.getString("lastname")+" "+rs.getString("firstname")+"\n");
            }
            rs.close();
            stmt.close();
            conn.close();


        }catch (SQLException e){e.printStackTrace();}
        catch (ClassNotFoundException e){e.printStackTrace();}
    }

    public void testDBMetaData(Connection conn){
        ResultSet rs = null;
            try {

                DatabaseMetaData data = conn.getMetaData(); // 数据库的元数据
                System.out.println(data.getUserName());
                rs = data.getCatalogs();
                while(rs.next()){
                    System.out.println(rs.getString(1));
                }

                ResultSetMetaData metadata = rs.getMetaData(); // 结果集的元数据，table

            }catch (SQLException e){e.printStackTrace();}
    }



}

class gene<T>{
    }