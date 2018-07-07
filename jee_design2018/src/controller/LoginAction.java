package controller;

import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import dao.*;
import domain.User;
import dao.UserDAO;
import dao.UserDAOImp;

public class LoginAction extends ActionSupport {
   private String pass;
   private String username;
   private List<User> usersByObj;

public List<User> getUsersByObj() {
	return usersByObj;
}
public void setUsersByObj(List<User> usersByObj) {
	this.usersByObj = usersByObj;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}


@Override public void validate(){
	if(username.isEmpty()){
		addFieldError("username","没有输入用户名!");			
	}
	if(pass.isEmpty()){
		addFieldError("pass","没有输入密码!");
	}
}

@Override public String execute() throws Exception{
	UserDAO dao=new UserDAOImp();
	usersByObj=dao.getAllUsersByObj();
	if("admin".equals(getUsername())||pass.equals(getPass())){
		return "suc_ad";
	}else if(username.equals(getUsername())||pass.equals(getPass())){
		return "suc";
	}else{
		return "fail";
	}
}
	 
}
