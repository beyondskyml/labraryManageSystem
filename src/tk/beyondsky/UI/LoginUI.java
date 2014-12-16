package tk.beyondsky.UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import tk.beyondsky.Client.Client;
import tk.beyondsky.TransportInfo.LoginInfo;

public class LoginUI {
	public static void main(String[] args) {

		// 加载登录界面
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				LoginFrame lf = new LoginFrame();
				lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				lf.setVisible(true);
				lf.toFront();
			}
		});

	}
}

class LoginFrame extends JFrame{
	// 窗口大小设置
	private int DefaultWidth = 300;
	private int DefaultHeight = 120;
	
	private JTextField userNameF;
	private JPasswordField passwordF;
	private JLabel tip;
	
	public LoginFrame(){
		setSize(DefaultWidth, DefaultHeight);
		setTitle("Sky | Welcome to Sky");
		setResizable(false);

		initLoginPanel();
	}
	
	private void initLoginPanel(){
		try {
			// 将LookAndFeel设置成Windows样式
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		setLayout(new GridBagLayout());
		GridBagConstraints gridConfig = new GridBagConstraints();

		JLabel userNameL = new JLabel("用户名：", JLabel.RIGHT);
		userNameL.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		addToGrid(userNameL, gridConfig, 0, 0, 1, 1, 0.1, 0.0, GridBagConstraints.NONE);
		
		userNameF = new JTextField();
		addToGrid(userNameF, gridConfig, 0, 1, 1, 1, 0.6, 0.0, GridBagConstraints.HORIZONTAL);

		JButton entry = new JButton("登录");
		entry.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		addToGrid(entry, gridConfig, 0, 2, 1, 1, 0.1, 0.0, GridBagConstraints.NONE);
		
		JLabel passwordL = new JLabel("密码：", JLabel.RIGHT);
		passwordL.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		addToGrid(passwordL, gridConfig, 1, 0, 1, 1, 0.1, 0.0, GridBagConstraints.NONE);
		
		passwordF = new JPasswordField();
		addToGrid(passwordF, gridConfig, 1, 1, 1, 1, 0.6, 0.0, GridBagConstraints.HORIZONTAL);

		JButton register = new JButton("注册");
		register.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		addToGrid(register, gridConfig, 1, 2, 1, 1, 0.1, 0.0, GridBagConstraints.NONE);
		
		tip = new JLabel("请输入您的用户名和密码。");
		tip.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		addToGrid(tip, gridConfig, 2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		
		// 登录按钮监听器
		entry.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// check user login info is legal
				LoginInfo loginInfo = new LoginInfo( userNameF.getText(), String.valueOf( passwordF.getPassword() ) );
				if (loginInfo.isLoginInfoStrLengthLegal()) {
					tip.setText("正在拼命登录... >_<");
					Client client = new Client();
					client.connectServer();
					if(client.checkLoginInfo(loginInfo) ){
						System.out.println("登录成功，可以加载聊天界面了！");
					}
					else {
						System.out.println("登录失败，释放资源，重置登录窗。");
						resetLogin();
					}
				}
				else{
					resetLogin();
				}
				
				// legal - save user info to LoginInfo
				
				// call Client to send LoginInfo
				
				// if loginInfo is right - run chat frame
				
				// try - catch all exception - info illegal or wrong
			}
		});
	}

	// 登录失败后调用该方法重置登录窗口
	private void resetLogin(){
		userNameF.setText("");
		passwordF.setText("");
		tip.setText("用户名或密码错误，请重新输入！");
	}
	
	/*
	 * 添加组件到网格中
	 * 参数说明：组件，网格约束，行，列，宽几列，高几行，宽度权重，高度权重，缩放属性	
	*/
	private void addToGrid(JComponent com, GridBagConstraints gbc, int row, int cols, int width, int height, double weightx, double weighty, int fill){
		gbc.gridy = row;
		gbc.gridx = cols;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.fill = fill;
		add(com, gbc);
	}
	
}