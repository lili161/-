import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class ui {

	private JFrame UI;
	private static int tip = 0;
	public static int Width, Height;
	public static int X, Y;
	public static int num = 0;
	public static String text[] = new String[120];
	public static int x[] = new int[120], y[] = new int[120];
	public static String Filepath = select.FilePath;
	public static BufferedImage image, image2;
	/**
	 * Launch the application.
	 */
	private static File file = new File(Filepath);

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public ui() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		System.out.println(Filepath);
		image = ImageIO.read(file);

		Width = image.getWidth();
		Height = image.getHeight();
		while (Width > 1728 || Height > 972) {
			Width = (int) (Width * 0.9);
			Height = (int) (Height * 0.9);
		}
		image2 = image;

		UI = new JFrame();

		UI.setTitle("ui");
		UI.setBounds(0, 0, Width + 110, Height + 20);
		UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UI.getContentPane().setLayout(null);
		System.out.println("before");
		Mypanel m = new Mypanel();
		System.out.println("after");
		UI.getContentPane().add(m);

		JTextPane txt = new JTextPane();
		txt.setEnabled(false);
		txt.setEditable(false);
		txt.setVisible(false);
		txt.setBounds(219, 275, 78, 21);
		UI.getContentPane().add(txt);

		JButton bt = new JButton("\u4FDD\u5B58");

		bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new save();
					save.it();
					System.out.println("click");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor c1 = new Cursor(0);
				bt.setCursor(c1);

			}
		});
		bt.setBounds(Width + 5, 0, 93, 23);
		UI.getContentPane().add(bt);
		m.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				Cursor c = new Cursor(2);
				m.setCursor(c);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub111111111111111111111111111111111

				if (tip == 0) {
					tip = 1;

					X = e.getX();
					Y = e.getY();
					txt.setBounds(X, Y-10, 100, 20);

					txt.setVisible(true);
					txt.setEnabled(true);
					txt.setEditable(true);
					txt.requestFocus();
				} else {
					txt.setVisible(false);
					txt.setEnabled(false);
					txt.setEditable(false);
					tip = 0;
				}
				if (!txt.getText().equals("") && tip == 0) {
					num++;
					text[num] = txt.getText();
					x[num] = X;
					y[num] = Y;
					txt.setText("");
				}
				System.out.println(txt.getText());
				System.out.println(X + " " + Y);
			}
		});
		m.setSize(Width, Height);
		m.setVisible(true);
		UI.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

		});
		UI.setVisible(true);
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m.repaint();
				// System.out.println(Width+" "+Height);
			}
		});
		timer.start();

	}

	public class Mypanel extends JPanel {

		@Override
		public void paint(Graphics g) {
			int flag = 0;

			while (Width > 1728 || Height > 972) {
				Width = (int) (Width * 0.9);
				Height = (int) (Height * 0.9);
			}

			g.drawImage(image2, 0, 0, Width, Height, null);

			if (num >= 1) {
				for (int i = 1; i <= num; i++) {
					g.setColor(Color.black);
					g.setFont(new Font("Á¥Êé", Font.BOLD, 20));
					g.drawString(text[i], x[i], y[i]+10 );
				}
			}
		}
	}
}
