package api;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ImageResourceManager {
	private BufferedImage image;
	private ArrayList<BufferedImage> images;
	private int imageWidth;
	private int imageHeight;
	private int subcountX = 0;
	private int subcountY = 0;

	public ImageResourceManager(String imageLink, int subWidth, int subHeight) {
		//画像読み込み
		image = readImage(imageLink);

		//切り出し画像格納リスト
		images = new ArrayList<BufferedImage>();

		//画像サイズ取得
		imageWidth = image.getWidth();
		imageHeight = image.getHeight();

		//画像を指定サイズごとに切り出してリストに保存
		while(subcountX < imageWidth && subcountY < imageHeight) {
			images.add(image.getSubimage(subcountX,  subcountY,  subWidth,  subHeight));
			subcountX += subWidth;
			if(subcountX >= imageWidth) {
				subcountX = 0;
				subcountY += subHeight;
			}
		}
	}

	public BufferedImage getResource(int index) {
		return images.get(index);
	}

	public static BufferedImage readImage(String imageLink) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(imageLink));
		} catch(IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
