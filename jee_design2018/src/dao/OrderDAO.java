package dao;

import java.util.List;
import domain.Order;

public interface OrderDAO {

	boolean check(String username) throws Exception;
	List<String[]> getAllOrder() throws Exception;
	List<Order> getAllOrderByObj() throws Exception;
	Order findByUsername(String username) throws Exception;
	Order findById(Long id) throws Exception;
	
	

}
