package dao;

import java.sql.*;
import java.util.*;
import domain.User;

public  class UserDAOImp implements UserDAO {
  String url = "jdbc:hsqldb:hsql://localhost";
  String driver = "org.hsqldb.jdbcDriver";
  String username1 = "sa";
  String pass = "";

 
  @Override
  public List<User> getAllUsersByObj() throws Exception {
    List<User> user = new ArrayList<>();
    Class.forName(driver);
    String sql = "select * from user";
    try (Connection con = DriverManager.getConnection(url, username1, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      try (ResultSet rs = pstmt.executeQuery();) {
        while (rs.next()) {// 保存每行的数据
          User users = new User();
          users.setPassword(rs.getString("password"));
          users.setUsername(rs.getString("username"));
          users.setUsertelephone(rs.getString("usertelephone"));
          users.setUserid(rs.getString("userid"));
          user.add(users);
        }
      }
      return user;
    }
  }
   

  @Override
  public boolean save(User user) throws Exception {
    boolean isuser=false;
    Class.forName(driver);
    String sql = "insert into user(username,userid,usertelephone,password) values(?,?,?,?)";
    try (Connection con = DriverManager.getConnection(url, username1, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setString(1,user.getUsername());
      pstmt.setString(2,user.getUserid()); 
      pstmt.setString(3,user.getUsertelephone()); 
      pstmt.setString(4,user.getPassword());     
      int row=pstmt.executeUpdate();
      isuser=row>0;
    }
    return isuser;
  }
  @Override
  public boolean update(User user) throws Exception {
    boolean isuser=false;
    Class.forName(driver);
    String sql = "update user set username=?,userid=?,usertelephone=?,password=? where userid=?";
    try (Connection con = DriverManager.getConnection(url, username1, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
        pstmt.setString(1,user.getUsername());
        pstmt.setString(2,user.getUserid()); 
        pstmt.setString(3,user.getUsertelephone()); 
        pstmt.setString(4,user.getPassword()); 
      int row=pstmt.executeUpdate();
      isuser=row>0;
    }
    return isuser;
  }





}
