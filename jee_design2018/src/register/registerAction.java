package register;
import com.opensymphony.xwork2.ActionSupport;
public class registerAction extends ActionSupport{
	private String username;
	private String userTelephobe;
	private String userID;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserTelephobe() {
		return userTelephobe;
	}
	public void setUserTelephobe(String userTelephobe) {
		this.userTelephobe = userTelephobe;
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
	public String execute(){
		return "success";
	}
}
