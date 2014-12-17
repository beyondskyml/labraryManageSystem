package tk.beyondsky.UI.InfoPanel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tk.beyondsky.UI.CommonUI;

public class ReaderInputCard extends CommonUI {
	private JPanel readerInputPanel;
	private GridBagConstraints gridConfig;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ReaderInputCard readerInputCard = new ReaderInputCard();
				
				JFrame jf = new JFrame();
				jf.setSize(500, 390);
				jf.setTitle("Test ReaderInputPanel");
				jf.setResizable(false);
				
				jf.add(readerInputCard.getReaderInputCard());
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setVisible(true);
				jf.toFront();
			}
		});
		
	}
	public ReaderInputCard(){
		initReaderInputCard();
	}
	public JPanel getReaderInputCard(){
		return readerInputPanel;
	}
	private void initReaderInputCard(){
		// 读者录入卡片
		readerInputPanel = new JPanel();
		readerInputPanel.setLayout(new GridBagLayout());
		gridConfig = new GridBagConstraints();
		//readerInputPanel.setBackground(Color.LIGHT_GRAY);

		// 性别单选按钮配置
		// final int SELECT_SEX;
		ButtonGroup radioButtonGroup = new ButtonGroup();
		
		// 组件
		gridConfig.anchor = GridBagConstraints.CENTER;
		gridConfig.insets = new Insets(2, 2, 2, 2);
		JLabel readerInputTipL = new JLabel("请输入新读者信息："); //magInfoTip.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		JLabel nameL = new JLabel("姓名");		final JTextField nameF = new JTextField();
		JLabel sexL = new JLabel("性别");		addRadioButton(radioButtonGroup, readerInputPanel, "男", 0, 2, 2); addRadioButton(radioButtonGroup, readerInputPanel, "女", 1, 2, 3);
		JLabel ageL = new JLabel("年龄");		final JTextField ageF = new JTextField();
		JLabel IDL = new JLabel("身份证");		final JTextField IDF = new JTextField();
		JLabel userNameL = new JLabel("用户名");	final JTextField userNameF = new JTextField();
		JLabel passwordL = new JLabel("密码");		final JTextField passwordF = new JTextField();
		JButton resetB = new JButton("重置");
		JButton submitB= new JButton("提交");

		int row = 0;
		gridConfig.anchor = GridBagConstraints.CENTER;
		// gridConfig.insets = new Insets(2, 2, 2, 2);
		addToGrid(readerInputTipL, readerInputPanel, gridConfig, row, 0, 3, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(nameL, readerInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(sexL, readerInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(ageL, readerInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(IDL, readerInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(userNameL, readerInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(passwordL, readerInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(new JLabel("          "), readerInputPanel, gridConfig, ++row, 0, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH);
		addToGrid(resetB, readerInputPanel, gridConfig, ++row, 2, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(new JLabel("          "), readerInputPanel, gridConfig, row, 3, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH);
		addToGrid(new JLabel("          "), readerInputPanel, gridConfig, row, 4, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH);
		addToGrid(submitB, readerInputPanel, gridConfig, row, 5, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(new JLabel(" "), readerInputPanel, gridConfig, ++row, 6, 1, 1, 0.1, 0.1, GridBagConstraints.BOTH);
		// addToGrid(new JLabel("          "), readerInputPanel, gridConfig, row, 5, 1, 1, 0.1, 0.1, GridBagConstraints.BOTH);

		// 设置按钮大小
		resetB.setMargin(new Insets(2, 2, 2, 2));// 按钮内容与边框距离
		submitB.setMargin(new Insets(2, 2, 2, 2));// 按钮内容与边框距离

		 // 添加按钮事件
		resetB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				nameF.setText("");
				ageF.setText("");
				IDF.setText("");
				userNameF.setText("");
				passwordF.setText("");
			}
		});
		submitB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// ToDo - 把期刊信息保存到magInfo并发送
			}
		});

		// 添加信息录入框等
		row = 1;
		gridConfig.insets = new Insets(2, 2, 2, 2);
		addToGrid(nameF, readerInputPanel, gridConfig, row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL); row++;
		addToGrid(ageF, readerInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(IDF, readerInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(userNameF, readerInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(passwordF, readerInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
			
	}

}
