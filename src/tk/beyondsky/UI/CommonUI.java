package tk.beyondsky.UI;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public abstract class CommonUI extends JPanel{
	public static void addRadioButton(ButtonGroup radioButtonGroup, JPanel jpanel, String name, final int sex, int row, int cols){
		JRadioButton button = new JRadioButton(name, sex == 0);
		radioButtonGroup.add(button);
		addToGrid(button, jpanel, new GridBagConstraints(), row, cols, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
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
	public static void addToGrid(JComponent com, JPanel jpanel, GridBagConstraints gbc, int row, int cols, int width, int height, double weightx, double weighty, int fill){
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
	public static void addToGrid(JPanel panel, JPanel jpanel, GridBagConstraints gbc, int row, int cols, int width, int height, double weightx, double weighty, int fill){
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
