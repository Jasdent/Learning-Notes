package JDBC.Pooling;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.*;
/*
* This class is gonna be created whenever needed in the main;
* */
public class TraditionalWorkingConn extends Thread{


    private String DB_URL = "jdbc:mysql://zhuokun@localhost";
    private Connection conn = null;
    @Override
    public void run(){
        try {
            Class.forName("com.sql.jdbc.Driver");
            this.conn = DriverManager.getConnection(DB_URL);
            String sql =
                    "INSERT INTO hero " +
                            "VALUES " +
                            "(?,?,?,?);";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1,null);
            ps.setString(2,"Temo");
            ps.setFloat(3,313.0f);
            ps.setInt(4,50);

            ps.executeUpdate();
            ps.close();
            this.conn.close();

        }catch (ClassNotFoundException e){e.printStackTrace();}
        catch (SQLException e){e.printStackTrace();}


    }


}
