package tk.beyondsky.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import tk.beyondsky.transportInfo.UserInfoManager;


public class Server {
	private ServerSocket serverSocket;
	private Socket socketToClient;
	private int clientCount;
	
	public static void main(String[] args) {
		UserInfoManager.init();
		Server server = new Server();
		server.StartServer();
	}
	
	public void StartServer(){
		try {
			
			serverSocket = new ServerSocket(8888);
			socketToClient = null;
			clientCount = 0;
			System.out.println("***Server: 服务器即将启动，等待客户端的连接***");
			
			while(true){
				
				socketToClient = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socketToClient);
				serverThread.setPriority(4);	// 优先级范围为[1,10] , default = 5
				serverThread.start();
				
				System.out.println("Server: 客户端的数量为: " + (++clientCount));

				InetAddress clientAddress = socketToClient.getInetAddress();
				System.out.println("Server: 当前客户端的IP地址为: " + clientAddress.getHostAddress() 
																	 + " 主机名为: " + clientAddress.getHostName());
			
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
}
