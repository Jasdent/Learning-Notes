package webserv;

import DAOImplement.UserImpl;
import DAO.UserDao;
import java.sql.*;

public class AuthenServlet{

    static final String DB_URL = "jdbc:mysql://localhost:3306/events?useSSL=false";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private UserDao userDao = new UserImpl();


    public boolean check(User user) {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,"zhuokun","---------"); 
            conn.setAutoCommit(false);
            ResultSet rs = this.userDao.get(conn,user);
//            conn.commit();
            if(rs.next()){
                // user is valid
                System.out.println("User verified");
                return true;
            }
            else{
                // invalid user name
                System.out.println("Invalid entries");
                return false;
            }

        }catch (ClassNotFoundException e){e.printStackTrace();}
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){e.printStackTrace();}
        }
        return false;
    }
}
