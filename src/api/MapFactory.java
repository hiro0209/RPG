package api;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MapFactory {
	public static final int BASE_LAYER = JLayeredPane.DEFAULT_LAYER;
	public static final int SUB_BASE_LAYER = JLayeredPane.PALETTE_LAYER;
	public static final int OBJECT_LAYER = JLayeredPane.MODAL_LAYER;
	private int width;
	private int height;
	private int subWidth;
	private int subHeight;
	private Maps[][] mapData;
	private ArrayList<ImageResourceManager> irm;
	private JPanel mapBase;
	private JLayeredPane map;
	private GridBagLayout gridBagLayout;

	public MapFactory(int width, int height) {
		this.width = width;
		this.height = height;
		irm = new ArrayList<ImageResourceManager>();
	}

	public int addImageResource(String imageLink, int subWidth, int subHeight) {
		this.subWidth = subWidth;
		this.subHeight = subHeight;
		irm.add(new ImageResourceManager(imageLink, subWidth, subHeight));
		return irm.size() - 1;
	}

	public void setMapData(Maps[][] mapData) {
		this.mapData = mapData;
	}

	public void setMapPanel() {
		mapBase = new JPanel();
		map = new JLayeredPane();
		FlowLayout layout = new FlowLayout();
//		FlowLayout layout2 = new FlowLayout();
		gridBagLayout = new GridBagLayout();
		layout.setAlignment(FlowLayout.CENTER);
		layout.setVgap(0);
		layout.setHgap(0);
//		layout2.setVgap(0);
//		layout2.setHgap(0);
		mapBase.setLayout(layout);
		mapBase.setBounds(0, 0, width, height);
		mapBase.setBackground(Color.BLACK);
//		map.setLayout(layout2);
		map.setLayout(gridBagLayout);
		map.setPreferredSize(new Dimension(subWidth * mapData[0].length, subHeight * mapData.length));
		mapBase.add(map);
	}

	public void createMap(int mapLayer) {
		//リソース画像をマップデータを元に配置
		if(irm != null) {
			for(int i = 0; i < mapData.length; i++) {
				for(int ii = 0; ii < mapData[i].length; ii++) {
					if(mapData[i][ii] != null) {
						BufferedImage image = irm.get(mapData[i][ii].id).getResource(mapData[i][ii].index);
						DrawImage drawable = new DrawImage(image, subWidth, subHeight);
//						map.setLayer(drawable, mapLayer);
//						map.add(drawable);
						addToMap(drawable, i, ii, mapLayer);
					} else {
//						map.add(Box.createHorizontalStrut(subWidth));
					}
				}
			}
		} else {
			System.out.println("bbb");
			throw new NullPointerException("createMapより先にsetImageResourceを呼び出す必要があります。");
		}
	}
	
    private void addToMap(DrawImage drawable, int x, int y, int mapLayer) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = y;
        gbc.gridy = x;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gridBagLayout.setConstraints(drawable, gbc);
        map.add(drawable);
        map.setLayer(drawable, mapLayer);
    }

	public JPanel getMap() {
		return mapBase;
	}
}
