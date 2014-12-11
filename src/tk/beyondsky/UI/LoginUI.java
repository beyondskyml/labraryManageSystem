package tk.beyondsky.UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI {
	public static void main(String[] args){
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
	private int DefaultWidth = 300;
	private int DefaultHeight = 120;
//	private JPanel namePanel;
//	private JPanel passwordPanel;

	public LoginFrame(){
		setSize(DefaultWidth, DefaultHeight);
		setTitle("Sky | Welcome to Sky");
		
		initLoginPanel();
		setResizable(false);
//		add(namePanel);
//		add(passwordPanel);
		//pack();
	}
	
	private void initLoginPanel(){
		/*namePanel= new JPanel();
		passwordPanel = new JPanel();*/
		setLayout(new GridBagLayout());
		GridBagConstraints gridConfig = new GridBagConstraints();
		// add JLabel
		JLabel userNameL = new JLabel("用户名：", JLabel.RIGHT);
		userNameL.setFont(new Font("宋体", Font.PLAIN, 14));
		addToGrid(userNameL, gridConfig, 0, 0, 1, 1, 0.1, 0.0, GridBagConstraints.NONE);
		
		JTextField userNameF = new JTextField();
		addToGrid(userNameF, gridConfig, 0, 1, 1, 1, 0.6, 0.0, GridBagConstraints.HORIZONTAL);
//		userNameF.setFont(new Font("Arial",Font.PLAIN, 14));
//		userNameF.setColumns(12);

		JButton entry = new JButton("登录");
		entry.setFont(new Font("宋体", Font.PLAIN, 14));
		addToGrid(entry, gridConfig, 0, 2, 1, 1, 0.1, 0.0, GridBagConstraints.NONE);
		
		JLabel passwordL = new JLabel("密码：", JLabel.RIGHT);
		passwordL.setFont(new Font("宋体", Font.PLAIN, 14));
		addToGrid(passwordL, gridConfig, 1, 0, 1, 1, 0.1, 0.0, GridBagConstraints.NONE);
		
		JPasswordField passwordF = new JPasswordField();
		addToGrid(passwordF, gridConfig, 1, 1, 1, 1, 0.6, 0.0, GridBagConstraints.HORIZONTAL);
//		passwordF.setColumns(12);
		//passwordF.setFont(new Font("", Font.PLAIN, 14));
		JButton register = new JButton("注册");
		register.setFont(new Font("宋体", Font.PLAIN, 14));
		addToGrid(register, gridConfig, 1, 2, 1, 1, 0.1, 0.0, GridBagConstraints.NONE);
	}
	
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