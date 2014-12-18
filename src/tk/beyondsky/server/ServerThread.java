package tk.beyondsky.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import tk.beyondsky.transportInfo.LoginInfo;
import tk.beyondsky.transportInfo.OnlineUserTable;
import tk.beyondsky.transportInfo.UserInfoManager;

public class ServerThread extends Thread {
	// 和本线程相关的Socket
	private Socket socket;

	private OutputStream outStream;
	private InputStream inStream;
	
	private ObjectOutputStream outObject;
	private ObjectInputStream inObject;
	
	// 通过构造方法，在创建线程实例的时候初始化Socket
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	// 执行线程操作，响应客户端的请求
	public void run() {
		connectServer();
		checkLoginInfo();
	}
	
	private void connectServer(){
		try {

			inStream = socket.getInputStream();
			inObject = new ObjectInputStream(inStream);
			
			outStream = socket.getOutputStream();
			outObject = new ObjectOutputStream(outStream);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void checkLoginInfo(){
		try {

			LoginInfo loginInfo = (LoginInfo)inObject.readObject();
			System.out.println("userName: " + loginInfo.getUserName() + "  password: " + loginInfo.getPassword());
			
			if(UserInfoManager.login(loginInfo.getUserName(), loginInfo.getPassword())){
				System.out.println("Server: " + loginInfo.getUserName() + "通过认证");
				outObject.writeObject(new OnlineUserTable("123"));
				outObject.writeObject(UserInfoManager.getCurrentUserInfo());
				outObject.flush();
			}
			else{
				System.out.println("Server: " + loginInfo.getUserName() + "认证失败");
				outObject.writeObject(null);
				outObject.writeObject(null);
				outObject.flush();
				closeConnectServer();
			}
			loginInfo = null;
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			closeConnectServer();
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			closeConnectServer();
			e.printStackTrace();
		}
	}
	
	private void closeConnectServer(){
		try {

			if (inObject != null) inObject.close();
			if (inStream != null) inStream.close();

			if (outObject != null) outObject.close();
			if (outStream != null) outStream.close();

			if (socket != null) socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}