package tk.beyondsky.UI;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import tk.beyondsky.UI.InfoPanel.InfoTabPanel;

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
	// 窗口默认大小
	private int DefaultWidth = 500;
	private int DefaultHeight = 390;

	// 选项卡面板
	private JTabbedPane tabbedPane;
	// private JPanel infoManage;
	// private JPanel borrow;
	// private JPanel search;
	// private JPanel subscription;
	// private GridBagConstraints gridConfig;

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
			// 将LookAndFeel设置成gtk样式
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception ex) {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// ex.printStackTrace();
		}
		
		initTabPanel();
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
		// infoManage = new JPanel();
		// infoManage.setLayout(new GridBagLayout());
		InfoTabPanel infoTabPanel = new InfoTabPanel();
		tabbedPane.addTab("  信息管理  ", infoTabPanel.getInfoManage());
		
		JPanel borrow = new JPanel();
		borrow.setLayout(new GridLayout());
		tabbedPane.addTab("  期刊借阅  ", borrow);
		
		JPanel search = new JPanel();
		search.setLayout(new GridLayout());
		tabbedPane.addTab("  期刊检索  ", search);
		
		JPanel subscription = new JPanel();
		subscription.setLayout(new GridLayout());
		tabbedPane.addTab("  期刊征订  ", subscription);
	}

}