package tk.beyondsky.TransportInfo;

import java.io.Serializable;

public class OnlineUserTable implements Serializable{
		private static final long serialVersionUID = 1L;
	private String passKey;
	public static String[] onlineUserName;
	
	public String getPassKey(){
		return passKey;
	}

	public void setPassKey(String passKey) {
		this.passKey = passKey;
	}
	
	public OnlineUserTable(String passKey){
		this.passKey = passKey;
	}
}
