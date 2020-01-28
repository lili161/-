import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class save {
	public static String path = "";
	public static int key;

	static public void it() throws Exception {
		try {
			for (int i = 0; i < ui.Filepath.length(); i++) {
				if (ui.Filepath.charAt(i) != '.') {
					path += ui.Filepath.charAt(i);
				} else if (ui.Filepath.charAt(i) == '.') {
					path += "(1).";
					continue;
				}
			}

			System.out.println(path);
			if (!new File(path).exists()) {
				new File(path).createNewFile();
			}


			// TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
			// into integer pixels
			BufferedImage bi = new BufferedImage(ui.Width, ui.Height, BufferedImage.TYPE_INT_RGB);

			Graphics ig2 = bi.createGraphics();

			ig2.drawImage(ui.image, 0, 0, ui.Width, ui.Height, null);

			if (ui.num >= 1) {
				for (int i = 1; i <= ui.num; i++) {
					ig2.setColor(Color.black);
					ig2.setFont(new Font("Á¥Êé", Font.BOLD, 20));
					ig2.drawString(ui.text[i], ui.x[i], ui.y[i]+10);
				}
				ig2.dispose();
			}
			if (ImageIO.write(bi, "jpg", new File(path)) == true) {
				key = 1;
			} else {
				key = 0;
			}
			feedBack.it();
		} catch (IOException ie) {
			ie.printStackTrace();
		}

	}
}
