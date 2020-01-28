import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class feedBack {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void it() {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedBack window = new feedBack();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public feedBack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 207);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBa = new JLabel("");
		lblBa.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 19));
		lblBa.setBounds(95, 35, 254, 47);
		if(save.key==0) {
			lblBa.setText("±£¥Ê ß∞‹");
		}else if(save.key==1) {
			lblBa.setText("±£¥Ê≥…π¶");
		}
		frame.getContentPane().add(lblBa);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
			}
		});
		btnNewButton.setBounds(165, 112, 99, 32);
		frame.getContentPane().add(btnNewButton);
	}
}
