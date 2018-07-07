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
  public boolean check(Long id) throws Exception {
    Class.forName(driver);
    String sql = "select * from bus where id =?";
    boolean isHave = false;
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setLong(1, id);
      try (ResultSet rs = pstmt.executeQuery();) {
        isHave = rs.next();
      }
    }
    return isHave;
  }

  /**
   * 得到所有车次 select * from bus last,getRow当前时第几行,beforeFirst List<String[]>
   */
  // List<Bus>
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
    String sql = "select * from bus";
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
  public Bus findByAr_city(String ar_city) throws Exception {
    Bus bus=new Bus();
    Class.forName(driver);
    String sql = "select * from bus where ar_city=?";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setString(1,ar_city);
      try (ResultSet rs = pstmt.executeQuery();) {
        rs.next();
        bus.setId(rs.getLong("id"));
        bus.setSt_city(rs.getString("st_city"));
        bus.setAr_city(rs.getString("ar_city"));
        bus.setSt_time(rs.getString("st_time"));
        bus.setAr_time(rs.getString("ar_time"));
        bus.setPrice(rs.getDouble("price"));
        bus.setPassenger_num(rs.getLong("passenger_num"));
        bus.setSt_station(rs.getString("st_station"));
      }
    }
    return bus;
  }

   @Override
   public Bus findById(Long id) throws Exception {
     Bus bus=new Bus();
     Class.forName(driver);
     String sql = "select * from bus where id=?";
     try (Connection con = DriverManager.getConnection(url, user, pass);
         PreparedStatement pstmt = con.prepareStatement(sql);) {
       pstmt.setLong(1,id);
       try (ResultSet rs = pstmt.executeQuery();) {
         rs.next();
         bus.setId(rs.getLong("id"));
         bus.setSt_city(rs.getString("st_city"));
         bus.setAr_city(rs.getString("ar_city"));
         bus.setSt_time(rs.getString("st_time"));
         bus.setAr_time(rs.getString("ar_time"));
         bus.setPrice(rs.getDouble("price"));
         bus.setPassenger_num(rs.getLong("passenger_num"));
         bus.setSt_station(rs.getString("st_station"));
       }
     }
     return bus;
   }

   
  @Override
  public boolean save(Bus bus) throws Exception {
    boolean isBus=false;
    Class.forName(driver);
    String sql = "insert into bus(id,st_city,ar_city,st_time,ar_time,price,passenger_num,st_station) values(?,?,?,?,?,?,?,?)";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setDouble(1,bus.getId());
      pstmt.setString(2,bus.getSt_city());
      pstmt.setString(2,bus.getAr_city());
      pstmt.setString(2,bus.getSt_time());
      pstmt.setString(2,bus.getAr_time());
      pstmt.setDouble(3,bus.getPrice());
      pstmt.setDouble(4,bus.getPassenger_num());    
      pstmt.setString(2,bus.getSt_station());
      int row=pstmt.executeUpdate();
      isBus=row>0;
    }
    return isBus;
  }
  @Override
  public boolean update(Bus bus) throws Exception {
    boolean isBus=false;
    Class.forName(driver);
    String sql = "update bus set id=?,st_city=?,ar_city=?,st_time=? ar_time=?,price=?,passenger_num=?,st_station=?,where id=?";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setDouble(1,bus.getId());
      pstmt.setString(1,bus.getSt_city());
      pstmt.setString(1,bus.getAr_city());
      pstmt.setString(1,bus.getSt_time());
      pstmt.setString(1,bus.getSt_time());
      pstmt.setDouble(1,bus.getPrice());
      pstmt.setDouble(1,bus.getPassenger_num());
      pstmt.setString(1,bus.getSt_station());
      int row=pstmt.executeUpdate();
      isBus=row>0;
    }
    return isBus;
  }

  @Override
  public boolean delById(Long id) throws Exception {
    boolean isBus=false;
    Class.forName(driver);
    String sql = "delete from stu where id=?";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setDouble(1,id);
      int row=pstmt.executeUpdate();
      isBus=row>0;
    }
    return isBus;
  }


}
