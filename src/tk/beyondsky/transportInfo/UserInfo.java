package tk.beyondsky.transportInfo;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private String nickname;
	private String photo;
	private String sign;
	private boolean status;
	
	public void setAllInfo(String userName, String password, String nickname, String photo, String sign, boolean status){
		this.userName = userName;
		this.password = password;
		this.nickname = nickname;
		this.photo = photo;
		this.sign = sign;
		this.status = status;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}

