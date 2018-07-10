package controller;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import domain.City;
import domain.User;
import dao.CityDAO;
import dao.CityDAOImp;
import dao.UserDAO;
import dao.UserDAOImp;

public class LoginAction extends ActionSupport {
	private String password;
	private String username;
	private List<User> usersByObj;
	private List<City> citysByObj;
	

	public List<User> getUsersByObj() {
		return usersByObj;
	}

	public void setUsersByObj(List<User> usersByObj) {
		this.usersByObj = usersByObj;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<City> getCitysByObj() {
		return citysByObj;
	}

	public void setCitysByObj(List<City> citysByObj) {
		this.citysByObj = citysByObj;
	}

	@Override
	public void validate() {
		if (username.isEmpty()) {
			addFieldError("username", "没有输入用户名!");
		}
		if (password.isEmpty()) {
			addFieldError("password", "没有输入密码!");
		}
	}

	@Override
	public String execute() throws Exception {
		UserDAO dao = new UserDAOImp();
		usersByObj = dao.getAllUsersByObj();
		CityDAO city = new CityDAOImp();
		citysByObj = city.getAllCitysByObj();
		for (User object : usersByObj) {
			if ("admin".equals(username) && password.equals(object.getPassword())) {
				return "suc_ad";
			} else if (username.equals(object.getUsername()) && password.equals(object.getPassword())) {
				return "suc";
			}
		}
		return "fail";

	}


}
