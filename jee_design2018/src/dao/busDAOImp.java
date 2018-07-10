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
          buss.setSt_city(rs.getString("st_city"));
          buss.setAr_city(rs.getString("ar_city"));
          buss.setSt_time(rs.getString("st_time"));
          buss.setAr_time(rs.getString("ar_time"));
          buss.setPrice(rs.getDouble("price"));
          buss.setPassenger_num(rs.getLong("passenger_num"));
          buss.setSt_station(rs.getString("st_station"));
          bus.add(buss);
        }
      }
      return bus;
    }
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
   public Bus findByPassenger(String st_city,String ar_city,String st_time) throws Exception {
     Bus bus=new Bus();
     Class.forName(driver);
     String sql = "select * from bus where st_city=? and ar_city=? and st_time=?";
     try (Connection con = DriverManager.getConnection(url, user, pass);
         PreparedStatement pstmt = con.prepareStatement(sql);) {
       pstmt.setString(1,st_city);
       pstmt.setString(2,ar_city);
       pstmt.setString(3,st_time);
       try (ResultSet rs = pstmt.executeQuery();) {
         
         while(rs.next()){
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
      pstmt.setString(3,bus.getAr_city());
      pstmt.setString(4,bus.getSt_time());
      pstmt.setString(5,bus.getAr_time());
      pstmt.setDouble(6,bus.getPrice());
      pstmt.setLong(7, bus.getPassenger_num());    
      pstmt.setString(8,bus.getSt_station());
      int row=pstmt.executeUpdate();
      isBus=row>0;
    }
    return isBus;
  }
  @Override
  public boolean update(Bus bus) throws Exception {
    boolean isBus=false;
    Class.forName(driver);
    String sql = "update bus set id=?,st_city=?,ar_city=?,st_time=?,ar_time=?,price=?,passenger_num=?,st_station=? where id=?";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setLong(1,bus.getId());
      pstmt.setString(2,bus.getSt_city());
      pstmt.setString(3,bus.getAr_city());
      pstmt.setString(4,bus.getSt_time());
      pstmt.setString(5,bus.getAr_time());
      pstmt.setDouble(6,bus.getPrice());
      pstmt.setLong(7,bus.getPassenger_num());
      pstmt.setString(8,bus.getSt_station());
      pstmt.setLong(1,bus.getId());
      int row=pstmt.executeUpdate();
      isBus=row>0;
    }
    return isBus;
  }

  @Override
  public boolean delById(Long id) throws Exception {
    boolean isBus=false;
    Class.forName(driver);
    String sql = "delete from bus where id=?";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setDouble(1,id);
      int row=pstmt.executeUpdate();
      isBus=row>0;
    }
    return isBus;
  }


}
