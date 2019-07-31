package api;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class DrawImage extends JPanel {
	private Image image;

	public DrawImage(Image image, int width, int height) {
		super();
		
		setOpaque(false);
		
		this.image = image;
		setPreferredSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		graphics.drawImage(image, 0, 0, this);
	}
}
