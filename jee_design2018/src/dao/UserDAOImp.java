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
  public boolean check(String username) throws Exception {
    Class.forName(driver);
    String sql = "select * from user where username =?";
    boolean isHave = false;
    try (Connection con = DriverManager.getConnection(url, username1, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setString(1, username);
      try (ResultSet rs = pstmt.executeQuery();) {
        isHave = rs.next();
      }
    }
    return isHave;
  }

  /**
   * 得到所有用户 select * from user last,getRow当前时第几行,beforeFirst List<String[]>
   */
  // List<user>
  @Override
  public List<String[]> getAllUsers() throws Exception {
    List<String[]> user = new ArrayList<>();
    Class.forName(driver);
    String sql = "select * from user";
    try (Connection con = DriverManager.getConnection(url, username1, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      try (ResultSet rs = pstmt.executeQuery();) {
        while (rs.next()) {// 保存每行的数据
          String[] row = new String[5];
          row[0] = rs.getString("username");
          row[1] = rs.getString("userid");
          row[2] = rs.getString("usertelephone");
          row[3] = rs.getString("password");
          user.add(row);
        }
      }
    }
    return user;
  }

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
          users.setUserid(rs.getString("userid"));
          users.setUsername(rs.getString("username"));
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
      pstmt.setString(1,user.getUserid()); 
      pstmt.setString(1,user.getUsertelephone()); 
      pstmt.setString(1,user.getPassword());     
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
        pstmt.setString(1,user.getUserid()); 
        pstmt.setString(1,user.getUsertelephone()); 
        pstmt.setString(1,user.getPassword()); 
      int row=pstmt.executeUpdate();
      isuser=row>0;
    }
    return isuser;
  }


}
