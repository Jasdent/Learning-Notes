package DAOImplement;

import DAO.UserDao;
import webserv.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl implements UserDao {
    @Override
    public void save(Connection conn, User user) throws SQLException {
        String sql =
                "INSERT INTO users\n" +
                        "    (lastname,firstname,email,username,password)\n" +
                        "values\n" +
                        "    (?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,user.getLastname());
        ps.setString(2,user.getFirstname());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getUsername());
        ps.setString(5,user.getPassword());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void delete(Connection conn, User user) throws SQLException {
        String sql = "DELETE FROM TABLE users\n" +
                "WHERE users.id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,user.getId());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void update(Connection conn, int id, User user) throws SQLException{
        String sql = "UPDATE TABLE users\n" +
                "SET (lastname=?,firstname=?,email=?,username=?,password=?) WHERE users.id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,user.getLastname());
        ps.setString(2,user.getFirstname());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getUsername());
        ps.setString(5,user.getPassword());
        ps.setInt(6,id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public ResultSet get(Connection conn, User user) throws SQLException{
        String sql = "SELECT * FROM users where users.email = ? and users.password=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,user.getEmail());
        ps.setString(2,user.getPassword());
        return ps.executeQuery();
    }

//    public void print(){
//        System.out.println("Hello World");
//    }
}

