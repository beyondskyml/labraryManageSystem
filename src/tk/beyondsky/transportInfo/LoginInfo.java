package tk.beyondsky.transportInfo;

import java.io.Serializable;

public class LoginInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	// 用户名和密码长度设置
	private final static int userNameLengthMax = 16;
	private final static int userNameLengthMin = 4;
	private final static int passwordLengthMax = 16;
	private final static int passwordLengthMin = 4;
	
	
	public LoginInfo(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	// 判断登录信息长度是否合法
	public boolean isLoginInfoStrLengthLegal(){
		if (userName.length() > userNameLengthMax
				|| userName.length() < userNameLengthMin
				|| password.length() > passwordLengthMax
				|| password.length() < passwordLengthMin) {
			return false;
		}
		return true;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
