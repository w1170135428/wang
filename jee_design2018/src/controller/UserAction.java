package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import dao.UserDAOImp;
import domain.User;

public class UserAction extends ActionSupport {
	private List<String[]> users;
	private List<User> usersByObj;
	User user;
	public List<String[]> getUsers() {
		return users;
	}
	public void setUsers(List<String[]> users) {
		this.users = users;
	}
	public List<User> getUsersByObj() {
		return usersByObj;
	}
	public void setUsersByObj(List<User> usersByObj) {
		this.usersByObj = usersByObj;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
@Override public String execute() throws Exception {
		UserDAO dao = new UserDAOImp();
		usersByObj = dao.getAllUsersByObj();
		//getAllUserByObj();
		return SUCCESS;
	}
	public void getAllUserByObj()throws Exception {
	  UserDAO dao=new UserDAOImp();
	  usersByObj=dao.getAllUsersByObj();	  
	}
	public String save() throws Exception{
	  UserDAO dao=new UserDAOImp();
	  boolean isUser=dao.save((User) user);
	  return isUser?SUCCESS:ERROR;
	}
	public String update() throws Exception{
	    UserDAO dao=new UserDAOImp();
	    boolean isUser=dao.update(user);
	    return isUser?SUCCESS:ERROR;
	  }
	
	

}
