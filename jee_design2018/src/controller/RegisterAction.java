package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import dao.UserDAOImp;
import domain.User;

@SuppressWarnings("serial")
public class RegisterAction extends ActionSupport{
	
	private List<User> usersByObj;
	User user=new User();
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getUserByObj() {
		return usersByObj;
	}
	public void setUserByObj(List<User> userByObj) {
		this.usersByObj = userByObj;
	}
	public List<User> getUsersByObj() {
		return usersByObj;
	}
	public void setUsersByObj(List<User> usersByObj) {
		this.usersByObj = usersByObj;
	}


@Override public String execute()throws Exception{
		UserDAO dao=new UserDAOImp();
		dao.save(user);
		return SUCCESS;
	}

}
