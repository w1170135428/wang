package dao;

import java.sql.*;
import java.util.*;
import domain.City;

public class CityDAOImp implements CityDAO {
  String url = "jdbc:hsqldb:hsql://localhost";
  String driver = "org.hsqldb.jdbcDriver";
  String user = "sa";
  String pass = "";

  @Override
  public boolean check(String name) throws Exception {
    Class.forName(driver);
    String sql = "select * from city where username =?";
    boolean isHave = false;
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      pstmt.setString(1, name);
      try (ResultSet rs = pstmt.executeQuery();) {
        isHave = rs.next();
      }
    }
    return isHave;
  }

  /**
   * �õ����г��� select * from city last,getRow��ǰʱ�ڼ���,beforeFirst List<String[]>
   */
  // List<City>
  @Override
  public List<String[]> getAllCitys() throws Exception {
    List<String[]> citys = new ArrayList<>();
    Class.forName(driver);
    String sql = "select * from city";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      try (ResultSet rs = pstmt.executeQuery();) {
        while (rs.next()) {// ����ÿ�е�����
          String[] row = new String[5];
          row[0] = rs.getString("name");
          citys.add(row);
        }
      }
    }
    return citys;
  }

  @Override
  public List<City> getAllCitysByObj() throws Exception {
    List<City> citys = new ArrayList<>();
    Class.forName(driver);
    String sql = "select * from city";
    try (Connection con = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = con.prepareStatement(sql);) {
      try (ResultSet rs = pstmt.executeQuery();) {
        while (rs.next()) {// ����ÿ�е�����
          City city = new City();
          city.setName(rs.getString("name"));
          citys.add(city);
        }
      }
      return citys;
    }
  }
  
}
