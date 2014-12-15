package tk.beyondsky.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import tk.beyondsky.TransportInfo.LoginInfo;
import tk.beyondsky.TransportInfo.OnlineUserTable;
import tk.beyondsky.TransportInfo.UserInfo;


public class Client {
	private Socket socket;

	private final static String host = "localhost";
	private final static int port = 8888;

	private OutputStream outStream;
	private InputStream inStream;

	private ObjectOutputStream outObject;
	private ObjectInputStream inObject;

	private OnlineUserTable onlineUserTable;
	private UserInfo userInfo;
	
	// 打开接口
	public void connectServer(){
		try {
			socket = new Socket(host, port);

			outStream = socket.getOutputStream();
			outObject = new ObjectOutputStream(outStream);

			inStream = socket.getInputStream();
			inObject = new ObjectInputStream(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 验证登陆信息
	public boolean checkLoginInfo(LoginInfo loginInfo){
		try {
			outObject.writeObject(loginInfo);
			outObject.flush();
			loginInfo = null;
			
			onlineUserTable = (OnlineUserTable)inObject.readObject();
			userInfo = (UserInfo)inObject.readObject();
			
			if (onlineUserTable == null || userInfo == null) {
				closeConnectServer();
				return false;
			}
			return true;
			
		} catch (IOException e) {
			closeConnectServer();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			// 处理没有找到类型异常
			System.out.println("Client: ClassNotFoundException");
			closeConnectServer();
			e.printStackTrace();
		}
		return false;
	}

	// 关闭服务器连接
	private void closeConnectServer(){
		// 关闭输入输出流，关闭socket
		try {
			if (outObject != null) outObject.close();
			if (outStream != null) outStream.close();

			if (inObject != null) inObject.close();
			if (inStream != null) inStream.close();

			if (socket != null) socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Client: Close connect error.");
			e.printStackTrace();
		}
	}

}
