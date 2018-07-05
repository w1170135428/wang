package dao;

import java.sql.*;
import java.util.*;

import domain.Bus;

public class BusDAOImp implements BusDAO {
  String url = "jdbc:hsqldb:hsql://localhost";
  String driver = "org.hsqldb.jdbcDriver";
  String user = "sa";
  String pass = "";

  @Override
  public boolean check(String username) throws Exception {
    Class.forName(driver);
    String sql = "select * from stu where username =?";
    boolean isHave = false;
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setString(1, username);
      try (ResultSet rs = pstmt.executeQuery();) {
        isHave = rs.next();
      }
    }
    return isHave;
  }

  /**
   * 得到所有学生 select * from stu last,getRow当前时第几行,beforeFirst List<String[]>
   */
  // List<Stu>
  @Override
  public List<String[]> getAllBus() throws Exception {
    List<String[]> bus = new ArrayList<>();
    Class.forName(driver);
    String sql = "select * from bus";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      try (ResultSet rs = pstmt.executeQuery();) {
        while (rs.next()) {// 保存每行的数据
          String[] row = new String[10];
          row[0] = rs.getString("id");
          row[1] = rs.getString("st_city");
          row[2] = rs.getString("ar_city");
          row[3] = rs.getString("st_time");
          row[4] = rs.getString("ar_time");
          row[5] = rs.getString("price");
          row[6] = rs.getString("passenger_num");
          row[7] = rs.getString("st_station");
          bus.add(row);
        }
      }
    }
    return bus;
  }

  @Override
  public List<Bus> getAllBusByObj() throws Exception {
    List<Bus> bus = new ArrayList<>();
    Class.forName(driver);
    String sql = "select * from stu";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      try (ResultSet rs = pstmt.executeQuery();) {
        while (rs.next()) {// 保存每行的数据
          Bus buss = new Bus();
          buss.setId(rs.getLong("id"));
          bus.add(buss);
        }
      }
      return bus;
    }
  }
   @Override
  public Bus findById(long ar_city) throws Exception {
    Bus bus=new Bus();
    Class.forName(driver);
    String sql = "select * from bus where ar_city=?";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setLong(1,ar_city);
      try (ResultSet rs = pstmt.executeQuery();) {
        rs.next();
        bus.setId(rs.getLong("id"));
        bus.setSt_city(rs.getString("st_city"));
        bus.setAr_city(rs.getString("ar_city"));
        bus.setSt_time(rs.getString("st_time"));
        bus.setAr_time(rs.getString("ar_time"));
        bus.setPrice(rs.getDouble("price"));
        bus.setPassenger_num(rs.getDouble("passenger_num"));
        bus.setSt_station(rs.getString("st_station"));
      }
    }
    return bus;
  }

  @Override
  public boolean save(Bus stu) throws Exception {
    boolean isSuc=false;
    Class.forName(driver);
    String sql = "insert into stu(username,java,math,os) values(?,?,?,?)";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setString(1,stu.getUsername());
      pstmt.setDouble(2,stu.getJava());
      pstmt.setDouble(3,stu.getMath());
      pstmt.setDouble(4, stu.getOs());      
      int row=pstmt.executeUpdate();
      isSuc=row>0;
    }
    return isSuc;
  }
  @Override
  public boolean update(Bus stu) throws Exception {
    boolean isSuc=false;
    Class.forName(driver);
    String sql = "update stu set username=?,java=?,math=?,os=? where id=?";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setString(1,stu.getUsername());
      pstmt.setDouble(2,stu.getJava());
      pstmt.setDouble(3,stu.getMath());
      pstmt.setDouble(4, stu.getOs()); 
      pstmt.setLong(5, stu.getId());
      int row=pstmt.executeUpdate();
      isSuc=row>0;
    }
    return isSuc;
  }

  @Override
  public boolean delById(long id) throws Exception {
    boolean isSuc=false;
    Class.forName(driver);
    String sql = "delete from stu where id=?";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setLong(1,id);
      int row=pstmt.executeUpdate();
      isSuc=row>0;
    }
    return isSuc;
  }
}
