package dao;

import java.sql.*;
import java.util.*;
import domain.Order;

public class OrderDAOImp implements OrderDAO {
	  String url = "jdbc:hsqldb:hsql://localhost";
	  String driver = "org.hsqldb.jdbcDriver";
	  String user = "sa";
	  String pass = "";
	  
@Override
public boolean check(String username) throws Exception {
	    Class.forName(driver);
	    String sql = "select * from order where username =?";
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
 * 得到所有订单 select * from order last,getRow当前时第几行,beforeFirst List<String[]>
 */
// List<order>
@Override
public List<String[]> getAllOrder() throws Exception {
  List<String[]> order = new ArrayList<>();
  Class.forName(driver);
  String sql = "select * from order";
  try (Connection con = DriverManager.getConnection(url, user, pass);
      PreparedStatement pstmt = con.prepareStatement(sql);) {
    try (ResultSet rs = pstmt.executeQuery();) {
      while (rs.next()) {// 保存每行的数据
        String[] row = new String[5];
        row[0] = rs.getString("username");
        row[1] = rs.getString("id");
        order.add(row);
      }
    }
  }
  return order;
}

@Override
public List<Order> getAllOrderByObj() throws Exception {
  List<Order> order = new ArrayList<>();
  Class.forName(driver);
  String sql = "select * from order";
  try (Connection con = DriverManager.getConnection(url, user, pass);
      PreparedStatement pstmt = con.prepareStatement(sql);) {
    try (ResultSet rs = pstmt.executeQuery();) {
      while (rs.next()) {// 保存每行的数据
        Order orders = new Order();
        orders.setUsername(rs.getString("username"));
        orders.setId(rs.getLong("id"));
        order.add(orders);
      }
    }
    return order;
  }
}
 @Override
public Order findByUsername(String username) throws Exception {
  Order order=new Order();
  Class.forName(driver);
  String sql = "select * from order where username=?";
  try (Connection con = DriverManager.getConnection(url, user, pass);
      PreparedStatement pstmt = con.prepareStatement(sql);) {
    pstmt.setString(1,username);
    try (ResultSet rs = pstmt.executeQuery();) {
      rs.next();
      order.setUsername(rs.getString("username"));
      order.setId(rs.getLong("id"));
    }
  }
  return order;
}

 @Override
 public Order findById(Long id) throws Exception {
   Order order=new Order();
   Class.forName(driver);
   String sql = "select * from order where id=?";
   try (Connection con = DriverManager.getConnection(url, user, pass);
       PreparedStatement pstmt = con.prepareStatement(sql);) {
     pstmt.setLong(1,id);
     try (ResultSet rs = pstmt.executeQuery();) {
       rs.next();
       order.setUsername(rs.getString("username"));
       order.setId(rs.getLong("id"));
     }
   }
   return order;
 }
 
}
