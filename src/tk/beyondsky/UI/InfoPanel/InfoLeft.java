package tk.beyondsky.UI.InfoPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tk.beyondsky.UI.CommonUI;

public class InfoLeft extends CommonUI{
	// 左侧面板 放置按钮
	JPanel infoLeft;
			
	// 左侧按钮
	JLabel magazineL;
	JButton magInputB;
	JButton magModifyB;
	JLabel readerL; 
	JButton readerInputB;
	JButton readerModifyB;
	
	GridBagConstraints gridConfig;
			
	public InfoLeft(){
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
		
		gridConfig = new GridBagConstraints();
		
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
	
}
