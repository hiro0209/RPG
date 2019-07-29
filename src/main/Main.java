package main;

public class Main {
	private static String gameTitle = "ポンコツ勇者の異世界生活";
	private static Window window;
	private static Title title;

	public static void main(String[] args) {
		//ウィンドウを表示してタイトル画面を表示
		window = new Window(gameTitle, 1280, 720);


		/*ImageResourceManager irm = new ImageResourceManager("src/images/cave-rock-obj.png", 32, 32);
		BufferedImage image = irm.getResource(5);
		DrawImage drawable = new DrawImage(image, 0, 0);
		window.add(drawable);*/
		title = new Title(window);
		window.add(title);

		window.show();
	}
}
