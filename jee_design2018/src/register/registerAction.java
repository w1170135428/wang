package register;

import java.sql.SQLException;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import dao.UserDAO;
import dao.UserDAOImp;
import domain.User;

public class RegisterAction extends ActionSupport{
	private String username;
	private String userTelephone;
	private String userID;
	private String password;
	private String message="Error";
	private List<User> usersByObj;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void validate(){
		if(getUsername()==null){
			addFieldError("username","�û�������Ϊ�գ�");
		}else{
			try{
				UserDAO dao=new UserDAOImp();
				usersByObj=dao.getAllUsersByObj();
				if(username.equals(getUsername())){
					addFieldError("username","�û����Ѵ��ڣ�");
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(getPassword()==null){
			addFieldError("password","���벻��Ϊ�գ�");
		}
		if(getUserTelephone()==null){
			addFieldError("userTelephone","�ֻ����벻��Ϊ�գ�");
		}
		if(getUserID()==null){
			addFieldError("userID","���֤���벻��Ϊ�գ�");
		}
	}

@Override public String execute()throws Exception{
		UserDAO dao=new UserDAOImp();
		usersByObj=dao.getAllUsersByObj();
		//if(mess.equals("ok")){
		//	message="success";
		//}else if(mess.equals("one")){
		//	message="input";
		//}
		return message;
	}

}
