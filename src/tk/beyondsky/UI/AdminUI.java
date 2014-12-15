package tk.beyondsky.UI;

import java.awt.EventQueue;

import javax.swing.JFrame;

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
	private int DefaultWidth = 800;
	private int DefaultHeight = 600;
	
	/*private JTextField ;
	private JLabel tip;
	*/
	public AdminFrame(){
		setSize(DefaultWidth, DefaultHeight);
		setTitle("Sky | Administrator");
		setResizable(true);

		//initAdminFrame();
	}
}
