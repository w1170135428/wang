package dao;



import java.util.List;

import org.junit.Test;

import domain.User;

public class test {

	@Test
	public void test() throws Exception {
		UserDAO dao = new UserDAOImp();

		List<User> usersByObj = dao.getAllUsersByObj();
		for (User object : usersByObj) {
			System.out.println(object.getUsername());

			System.out.println(object.getPassword());
		}
	}

}
