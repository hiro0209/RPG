package main;

import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Window {
	private JFrame window;
	private int width;
	private int height;

	public Window(String windowName, int width, int height) {
		//ウィンドウ表示設定
		window = new JFrame(windowName);
		Insets insets = window.getInsets();
		int width2 = width + insets.left + insets.right;
		int height2 = height + insets.top + insets.bottom;
		window.setSize(width2, height2);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setResizable(false);

		this.width = width;
		this.height = height;
	}

	public void show() {
		//ウィンドウ表示
		window.setVisible(true);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void add(JComponent conponent) {
		//コンポーネント追加
		window.getContentPane().add(conponent);
	}
}
