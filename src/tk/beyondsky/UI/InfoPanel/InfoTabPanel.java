package tk.beyondsky.UI.InfoPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tk.beyondsky.UI.CommonUI;

public class InfoTabPanel extends CommonUI{
	// 面板
	private JPanel infoManage;
	private static JPanel infoLeft;
	private static JPanel infoRight;

	private GridBagConstraints gridConfig;
	private CardLayout cardL;
			
	// 左侧按钮
	private JLabel magazineL;
	private JButton magInputB;
	private JButton magModifyB;

	private JLabel readerL; 
	private JButton readerInputB;
	private JButton readerModifyB;

	// 右侧面板
	private JPanel magModifyPanel;
	private JPanel readerModifyPanel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				InfoTabPanel infoTabPanel = new InfoTabPanel();

				JFrame jf = new JFrame();
				jf.setSize(500,390);
				jf.setTitle("Test infoTabPanel");
				jf.setResizable(false);
				
				jf.add(infoTabPanel.getInfoManage());
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setVisible(true);
				jf.toFront();
			}
		});
	}

	public InfoTabPanel(){
		gridConfig = new GridBagConstraints();
		infoManage = new JPanel();
		infoManage.setLayout(new GridBagLayout());
		initInfoTabLeftPanel();
		initInfoTabRightPanel();
		
		addToGrid(infoLeft, infoManage, gridConfig, 0, 0, 1, 1, 0.0, 1, GridBagConstraints.BOTH);
		addToGrid(infoRight, infoManage, gridConfig, 0, 1, 1, 1, 0.1, 1, GridBagConstraints.BOTH);
	}
	public JPanel getInfoManage(){
		return infoManage;
	}
	
	private void initInfoTabLeftPanel(){
		infoLeft = new JPanel();
		// 左侧按钮
		magazineL = new JLabel("期刊信息管理");
		magInputB = new JButton("录入");
		magModifyB = new JButton("修改");
		readerL = new JLabel("读者信息管理");
		readerInputB = new JButton("录入");
		readerModifyB = new JButton("修改");
		
		infoLeft.setLayout(new GridBagLayout());
		infoLeft.setBorder(BorderFactory.createTitledBorder("选项")); 
		// addToGrid(infoLeft, infoManage, gridConfig, 0, 0, 1, 1, 0.0, 1, GridBagConstraints.BOTH);
		
		// gridConfig = new GridBagConstraints();
		
		magazineL.setBorder(BorderFactory.createEtchedBorder());
		readerL.setBorder(BorderFactory.createEtchedBorder());
		
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
	
	private void initInfoTabRightPanel(){
		// 右侧面板 放置卡片 分别管理期刊／读者信息
		cardL = new CardLayout(3, 3); // 卡片布局对象
		infoRight = new JPanel(cardL);
		infoRight.setBorder(BorderFactory.createTitledBorder("期刊信息录入"));
		// addToGrid(infoRight, infoManage, gridConfig, 0, 1, 1, 1, 0.9, 1.0, GridBagConstraints.BOTH);
		
		// 期刊录入卡片
		MagInputCard magInputCard = new MagInputCard();
		// 读者录入卡片
		ReaderInputCard readerInputCard = new ReaderInputCard();

		// 期刊修改卡片
		magModifyPanel = new JPanel();
		magModifyPanel.setLayout(new GridBagLayout());
		magModifyPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel magInfo2Tip = new JLabel("magMP");
		magInfo2Tip.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		addToGrid(magInfo2Tip, magModifyPanel, gridConfig, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);

		// 读者修改卡片
		readerModifyPanel = new JPanel();
		readerModifyPanel.setLayout(new GridBagLayout());
		readerModifyPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel readerInfo2Tip = new JLabel("readerMP");
		readerInfo2Tip.setFont(new Font("文泉驿正黑", Font.PLAIN, 14));
		addToGrid(readerInfo2Tip, readerModifyPanel, gridConfig, 0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		
		// 将卡片添加到右侧面板
		infoRight.add(magInputCard.getMagInputCard(), "magP");
		infoRight.add(magModifyPanel, "magMP");
		infoRight.add(readerInputCard.getReaderInputCard(), "readerP");
		infoRight.add(readerModifyPanel, "readerMP");
		
	}
	
}
