package tk.beyondsky.UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class AdminUI {
	public static void main(String[] args){
		AdminUI au = new AdminUI();
	}
	public AdminUI(){
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				AdminFrame af = new AdminFrame();
				af.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				af.setVisible(true);
				af.toFront();	
			}
		});
	}
}

class AdminFrame extends JFrame{
	private int DefaultWidth = 500;
	private int DefaultHeight = 390;

	private JTabbedPane tabbedPane;
	private JPanel infoManage;
	private JPanel borrow;
	private JPanel search;
	private JPanel subscription;
	private GridBagConstraints gridConfig;

	private CardLayout cardL;
	private JPanel infoRight;
	
	//private JTextField ;
	//private JLabel tip;
	
	public AdminFrame(){
		setSize(DefaultWidth, DefaultHeight);
		setTitle("Sky | Administrator");
		setResizable(true);

		try {
			initAdminFrame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initAdminFrame() throws Exception{
		try {
			// 将LookAndFeel设置成Windows样式
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception ex) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			ex.printStackTrace();
		}
		
		initTabPanel();
		gridConfig = new GridBagConstraints();	
		
		initInfoTabLeftPanel();
		initInfoTabRightPanel();

		
		
		
		JLabel tip2 = new JLabel("hi2");
		tip2.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));

		JLabel tip3 = new JLabel("hi3");
		tip3.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));

		JLabel tip4 = new JLabel("hi4");
		tip4.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));

		
		addToGrid(tip2, borrow, gridConfig, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(tip3, search, gridConfig, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(tip4, subscription, gridConfig, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		add(tabbedPane, "Center");
		
	}

	/*
	 * 选项卡面板
	 *
	 *
	*/
	private void initTabPanel(){
		// 选项卡面板
		tabbedPane = new JTabbedPane();
		infoManage = new JPanel();
		infoManage.setLayout(new GridBagLayout());
		tabbedPane.addTab("Info Management", infoManage);
		
		borrow = new JPanel();
		borrow.setLayout(new GridLayout());
		tabbedPane.addTab("Magazine Borrow", borrow);
		
		search = new JPanel();
		search.setLayout(new GridLayout());
		tabbedPane.addTab("Advanced Search", search);
		
		subscription = new JPanel();
		subscription.setLayout(new GridLayout());
		tabbedPane.addTab("Subscription", subscription);
	}

	/*
	 * infoManagement 选项卡 左侧面板
	 */
	private void initInfoTabLeftPanel(){
		// 左侧面板 放置按钮
		JPanel infoLeft = new JPanel();
		infoLeft.setLayout(new GridBagLayout());
		infoLeft.setBorder(BorderFactory.createTitledBorder("选项")); 
		addToGrid(infoLeft, infoManage, gridConfig, 0, 0, 1, 1, 0.0, 1, GridBagConstraints.BOTH);
		
		// 左侧按钮
		JLabel magazineL = new JLabel("期刊信息管理");
		magazineL.setBorder(BorderFactory.createEtchedBorder()); 
		JButton magInputB = new JButton("录入");
		JButton magModifyB = new JButton("修改");
		
		JLabel readerL = new JLabel("读者信息管理");
		readerL.setBorder(BorderFactory.createEtchedBorder()); 
		JButton readerInputB = new JButton("录入");
		JButton readerModifyB = new JButton("修改");
		
		// 将按钮与标签添加到面板中
		int row = 0;
		gridConfig.anchor = GridBagConstraints.NORTH;
		addToGrid(magazineL, infoLeft, gridConfig, row, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(magInputB, infoLeft, gridConfig, ++row, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(magModifyB, infoLeft, gridConfig, ++row, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(new JLabel(" "), infoLeft, gridConfig, ++row, 0, 1, 2, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		++row;
		addToGrid(readerL, infoLeft, gridConfig, ++row, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(readerInputB, infoLeft, gridConfig, ++row, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(readerModifyB, infoLeft, gridConfig, ++row, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(new JLabel(" "), infoLeft, gridConfig, ++row, 0, 1, 2, 0.0, 0.1, GridBagConstraints.HORIZONTAL);
		
		// 按钮事件处理
		magInputB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardL.show(infoRight, "magP");
				infoRight.setBorder(BorderFactory.createTitledBorder("期刊信息录入"));
			}
		});
		magModifyB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardL.show(infoRight, "magMP");
				infoRight.setBorder(BorderFactory.createTitledBorder("期刊信息修改"));
			}
		});
		readerInputB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardL.show(infoRight, "readerP");
				infoRight.setBorder(BorderFactory.createTitledBorder("读者信息录入"));
			}
		});
		readerModifyB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				cardL.show(infoRight, "readerMP");
				infoRight.setBorder(BorderFactory.createTitledBorder("读者信息修改"));
			}
		});
		
	}
	/*
	 * infoManagement 选项卡 右侧面板
	 */
	private void initInfoTabRightPanel(){
		// 右侧面板 放置卡片 分别管理期刊／读者信息
		cardL = new CardLayout(3, 3); // 卡片布局对象
		infoRight = new JPanel(cardL);
		infoRight.setBorder(BorderFactory.createTitledBorder("期刊信息录入"));
		addToGrid(infoRight, infoManage, gridConfig, 0, 1, 1, 1, 0.9, 1.0, GridBagConstraints.BOTH);
		
		
		// 期刊修改卡片
		JPanel magModifyPanel = new JPanel();
		magModifyPanel.setLayout(new GridBagLayout());
		magModifyPanel.setBackground(Color.LIGHT_GRAY);
		JLabel magInfo2Tip = new JLabel("magMP");
		magInfo2Tip.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		addToGrid(magInfo2Tip, magModifyPanel, gridConfig, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);

		// 读者修改卡片
		JPanel readerModifyPanel = new JPanel();
		readerModifyPanel.setLayout(new GridBagLayout());
		readerModifyPanel.setBackground(Color.LIGHT_GRAY);
		JLabel readerInfo2Tip = new JLabel("readerMP");
		readerInfo2Tip.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		addToGrid(readerInfo2Tip, readerModifyPanel, gridConfig, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		
		// 将卡片添加到右侧面板
		infoRight.add(getMagInputCard(), "magP");
		infoRight.add(magModifyPanel, "magMP");
		infoRight.add(getReaderInputPanel(), "readerP");
		infoRight.add(readerModifyPanel, "readerMP");
		
	}

	private JPanel getMagInputCard(){
		//  期刊录入卡片
		JPanel magInputPanel = new JPanel();
		magInputPanel.setLayout(new GridBagLayout());
		// magInputPanel.setBackground(Color.LIGHT_GRAY);

		gridConfig.anchor = GridBagConstraints.CENTER;
		gridConfig.insets = new Insets(2,2,2,2);
		JLabel magInputTipL = new JLabel("请输入新期刊信息："); //magInfoTip.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		JLabel nameL = new JLabel("名称");		final JTextField nameF = new JTextField();
		JLabel ISBNL = new JLabel("刊号");		final JTextField ISBNF = new JTextField();
		JLabel pressL = new JLabel("出版社");		final JTextField pressF = new JTextField();
		JLabel categoryL = new JLabel("分类");		final JComboBox categoryCB = new JComboBox();
		JLabel stockL = new JLabel("库存");		final JTextField stockF = new JTextField();
		JLabel priceL = new JLabel("价格");		final JTextField priceF = new JTextField();
		JLabel keywordL = new JLabel("关键词");	final JTextField keywordF = new JTextField();

		JButton resetB = new JButton("重置");
		JButton submitB= new JButton("提交");

		int row = 0;
		// gridConfig.anchor = GridBagConstraints.CENTER;
		addToGrid(magInputTipL, magInputPanel, gridConfig, row, 0, 3, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(nameL, magInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(ISBNL, magInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(pressL, magInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(categoryL, magInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(stockL, magInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(priceL, magInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(keywordL, magInputPanel, gridConfig, ++row, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(new JLabel("          "), magInputPanel, gridConfig, ++row, 0, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH);
		addToGrid(resetB, magInputPanel, gridConfig, ++row, 2, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(new JLabel("          "), magInputPanel, gridConfig, row, 3, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH);//按钮间占位
		addToGrid(new JLabel("          "), magInputPanel, gridConfig, row, 4, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH);//按钮间占位
		addToGrid(submitB, magInputPanel, gridConfig, row, 5, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(new JLabel("          "), magInputPanel, gridConfig, ++row, 6, 1, 1, 0.1, 0.1, GridBagConstraints.BOTH);//右下角占位
		// addToGrid(new JLabel("                                        "), magInputPanel, gridConfig, row, 6, 1, 1, 0.0, 0.1, GridBagConstraints.BOTH);//最下方占位
		// addToGrid(new JLabel("          "), magInputPanel, gridConfig, row, 7, 1, 1, 0.1, 0.1, GridBagConstraints.BOTH);//右下角占位

		// 设置按钮大小
		resetB.setMargin(new Insets(2, 2, 2, 2));// 按钮内容与边框距离
		submitB.setMargin(new Insets(2, 2, 2, 2));// 按钮内容与边框距离

		row = 1;
		addToGrid(nameF, magInputPanel, gridConfig, row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(ISBNF, magInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(pressF, magInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(categoryCB, magInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(stockF, magInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(priceF, magInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(keywordF, magInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);

		// 期刊类别复选框配置
		categoryCB.setEditable(false);
		categoryCB.addItem("一般期刊");
		categoryCB.addItem("学术期刊");
		categoryCB.addItem("行业期刊");
		categoryCB.addItem("检索期刊");

		resetB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				nameF.setText("");
				ISBNF.setText("");
				pressF.setText("");
				stockF.setText("");
				priceF.setText("");
				keywordF.setText("");
			}
		});
		submitB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// ToDo - 把期刊信息保存到magInfo并发送
			}
		});

		return magInputPanel;
	}

	private JPanel getReaderInputPanel(){
		// 读者录入卡片
		JPanel readerInputPanel = new JPanel();
		readerInputPanel.setLayout(new GridBagLayout());
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
		addToGrid(new JLabel("                                        "), readerInputPanel, gridConfig, ++row, 6, 1, 1, 0.1, 0.1, GridBagConstraints.BOTH);
		// addToGrid(new JLabel("          "), readerInputPanel, gridConfig, row, 5, 1, 1, 0.1, 0.1, GridBagConstraints.BOTH);

		// 设置按钮大小
		resetB.setMargin(new Insets(2, 2, 2, 2));// 按钮内容与边框距离
		submitB.setMargin(new Insets(2, 2, 2, 2));// 按钮内容与边框距离

		row = 1;
		gridConfig.insets = new Insets(2, 2, 2, 2);
		addToGrid(nameF, readerInputPanel, gridConfig, row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL); row++;
		addToGrid(ageF, readerInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(IDF, readerInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(userNameF, readerInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		addToGrid(passwordF, readerInputPanel, gridConfig, ++row, 2, 4, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		
		return readerInputPanel;
	}

	private void addRadioButton(ButtonGroup radioButtonGroup, JPanel jpanel, String name, final int sex, int row, int cols){
		JRadioButton button = new JRadioButton(name, sex == 0);
		radioButtonGroup.add(button);
		addToGrid(button, jpanel, gridConfig, row, cols, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// ToDo - 把sex传递给readerInfo对象
				// SELECT_SEX = sex;
			}
		});
	}
	/*
	 * 添加组件到网格中
	 * 参数说明：组件，网格约束，行，列，宽几列，高几行，宽度权重，高度权重，缩放属性	
	*/
	private void addToGrid(JComponent com, JPanel jpanel, GridBagConstraints gbc, int row, int cols, int width, int height, double weightx, double weighty, int fill){
		gbc.gridy = row;
		gbc.gridx = cols;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.fill = fill;
		jpanel.add(com, gbc);
	}

	/*
	 * 添加容器到网格中
	 * 参数说明：组件，网格约束，行，列，宽几列，高几行，宽度权重，高度权重，缩放属性	
	*/
	private void addToGrid(JPanel panel, JPanel jpanel, GridBagConstraints gbc, int row, int cols, int width, int height, double weightx, double weighty, int fill){
		gbc.gridy = row;
		gbc.gridx = cols;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbc.fill = fill;
		jpanel.add(panel, gbc);
	}
	
}