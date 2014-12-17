package tk.beyondsky.UI.InfoPanel;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tk.beyondsky.UI.CommonUI;

public class MagInputCard extends CommonUI {
	private GridBagConstraints gridConfig;
	private JPanel magInputPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MagInputCard magInputCard = new MagInputCard();

				JFrame jf = new JFrame();
				jf.setSize(600,400);
				jf.setTitle("Test InfoMagInputCard");
				jf.setResizable(false);
				
				jf.add(magInputCard.getMagInputCard());
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setVisible(true);
				jf.toFront();
			}
		});
		
	}

	public MagInputCard(){
		initMagInputCard();
	}
	public JPanel getMagInputCard(){
		return magInputPanel;
	}
	private void initMagInputCard(){
		gridConfig = new GridBagConstraints();
		//  期刊录入卡片
		magInputPanel = new JPanel();
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
		addToGrid(new JLabel(" "), magInputPanel, gridConfig, ++row, 6, 1, 1, 0.1, 0.1, GridBagConstraints.BOTH);//右下角占位
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

	}
}
