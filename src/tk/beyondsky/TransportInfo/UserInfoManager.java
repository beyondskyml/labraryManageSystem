package tk.beyondsky.TransportInfo;

import java.util.ArrayList;

public class UserInfoManager{
	private static ArrayList<UserInfo> userInfoList;
	private static UserInfo[] userInfo = null;
	private static int userInfoID;
	
	public UserInfoManager(){
		init();
	}
	
	public static UserInfo getCurrentUserInfo(){
		return userInfo[userInfoID];
	}
	
	public static void init(){
		userInfo = new UserInfo[3];
		for (userInfoID = 0; userInfoID < userInfo.length; userInfoID ++) {
			userInfo[userInfoID] = new UserInfo();
		}
		userInfo[0].setAllInfo("0001", "1234", "sky", "res/photo/001.png", "hello world", false);
		userInfo[1].setAllInfo("0002", "1235", "joy", "res/photo/002.png", "hi", false);
		userInfo[2].setAllInfo("0003", "1236", "li", "res/photo/003.png", "di du du", false);
	}
	
	public static boolean login(String userName, String password){
		for (userInfoID = 0; userInfoID < userInfo.length; userInfoID ++) {
			if (userInfo[userInfoID].getUserName().equals(userName)
					&& userInfo[userInfoID].getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
