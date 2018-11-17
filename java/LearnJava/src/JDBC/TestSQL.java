package JDBC;

import java.sql.*;
public class TestSQL {
    static final String DB_URL = "jdbc:mysql://localhost:3306/events?characterEncoding=utf8&useSSL=true";
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String USER = "zhuokun";
    static final String PWD = "CserJasdent19";
    
    public static void main(String[] args){

//        try{
//            // Class.forName(JDBC_DRIVER);
//            System.out.println("Load successful");
//        }catch (ClassNotFoundException e){e.printStackTrace();}

//        Connection conn = null;
//        Statement stmt = null;
//
//        try{
//            System.out.println("Connecting to "+DB_URL);
//            conn = DriverManager.getConnection(DB_URL,USER,PWD);
//            stmt = conn.createStatement();
//
//            System.out.println("Connected");
//
//            String sql;
//            sql = "select * from studentlist";
//
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                System.out.print("Student ID: "+rs.getInt("studentID")+" ");
//                System.out.print("Name: "+rs.getString("lastname")+" "+rs.getString("firstname")+"\n");
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//
//
//        }catch (SQLException e){e.printStackTrace();}


//        Connection conn = null;
//        Statement stmt = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PWD);
//            stmt = conn.createStatement();
//            String sql;
//            sql = "USE events "+
//                    "SELECT studentID,lastname,firstname,email FROM studentlist";
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                System.out.print("Student ID: "+rs.getInt("studentID")+" ");
//                System.out.print("Name: "+rs.getString("lastname")+" "+rs.getString("firstname")+" ");
//                System.out.print("Student Addr: "+rs.getInt("email")+"\n");
//
//            }
//            rs.close();
//            stmt.close();
//            conn.close();
//
//        }catch (SQLException e){e.printStackTrace();}
//        catch (ClassNotFoundException e){e.printStackTrace();}
//        System.out.println("End");
    }

}
