package JDBC.Pooling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoolWorkingConn extends Thread{

    private String DB_URL = "jdbc:mysql://zhuokun@localhost";
    private ConnectionPool cp= null;

    public PoolWorkingConn(ConnectionPool cp){
        this.cp = cp;
    }

    @Override
    public void run(){
        Connection conn = this.cp.getConnection();
        try {

            String sql =
                    "INSERT INTO hero " +
                            "VALUES " +
                            "(?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,null);
            ps.setString(2,"Temo");
            ps.setFloat(3,313.0f);
            ps.setInt(4,50);
            ps.executeUpdate();

            ps.close();

        }
        catch (SQLException e){e.printStackTrace();}

        this.cp.returnConnection(conn);

    }

}


