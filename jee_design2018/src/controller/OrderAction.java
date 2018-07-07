package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import dao.OrderDAO;
import dao.OrderDAOImp;
import domain.Order;

public class OrderAction extends ActionSupport {
	private List<String[]> orders;
	private List<Order> ordersByObj;
	Order order;
	
	
	public List<String[]> getOrders() {
		return orders;
	}
	public void setOrders(List<String[]> orders) {
		this.orders = orders;
	}
	public List<Order> getOrdersByObj() {
		return ordersByObj;
	}
	public void setOrdersByObj(List<Order> ordersByObj) {
		this.ordersByObj = ordersByObj;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String execute() throws Exception {
		OrderDAO dao = new OrderDAOImp();
		order = (Order) dao.getAllOrder();
		getAllOrderByObj();
		return SUCCESS;
	}
	public void getAllOrderByObj()throws Exception {
	  OrderDAO dao=new OrderDAOImp();
	  ordersByObj=dao.getAllOrderByObj();	  
	}
	//public String update() throws Exception{
	   // OrderDAO dao=new OrderDAOImp();
	   // boolean isOrder=dao.update(order);
	   // return isOrder?SUCCESS:ERROR;
	 // }
}
