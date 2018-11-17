package JDBC.Pooling;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ConnectionPool {
    private int size;
    List<Connection> cp = new ArrayList<>();
    private String DB_URL = "jdbc:mysql://zhuokun@localhost";
    public ConnectionPool(int size){
        this.size = size;
        this.init();
    }

    private void init(){
        try {
            Class.forName("com.sql.jdbc.Driver");
            for(int i = 0;i<size;i++) {
                Connection conn = DriverManager.getConnection(DB_URL);
                cp.add(conn);
            }
        }catch (SQLException e){e.printStackTrace();}
        catch (ClassNotFoundException e){e.printStackTrace();}
    }

    // only one thread can get 1 connection at time
    public synchronized Connection getConnection(){

        while(cp.isEmpty()){
            try{
                this.wait();
                // the lock is released by the thread, waiting for
                // notification from another thread when a connection is released or created
            }catch (InterruptedException e){e.printStackTrace();}

        }
        this.notifyAll();
        Connection conn = cp.remove(0);
        return conn;
    }

    public synchronized void returnConnection(Connection conn){
        cp.add(conn);
        this.notifyAll(); // notify the waiting thread
        return;
    }

}
