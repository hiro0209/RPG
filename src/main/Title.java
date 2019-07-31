package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import api.MapFactory;
import api.Maps;

public class Title extends JLayeredPane {
	private JButton playButton;
	private JButton optionButton;
	private int width;
	private int height;

	public Title(Window window) {
		width = window.getWidth();
		height = window.getHeight();

		//タイトル画面のレイアウト設定
		setLayout(null);
		setPreferredSize(new Dimension(width, height));

		/* 背景のマップ風絵を貼り付け */
		//マップデータ
		MapFactory map = new MapFactory(width, height);
		int crw = map.addImageResource("src/images/cave-rock-wall.png", 32, 32);
		int cro = map.addImageResource("src/images/cave-rock-obj.png", 32, 32);
		Maps[][] baseMapData = {
				{new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false)},
				{new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false)},
				{new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false), new Maps(crw, 87, false)},
				{new Maps(crw, 95, false), new Maps(crw, 95, false), new Maps(crw, 95, false), new Maps(crw, 95, false), new Maps(crw, 95, false), new Maps(crw, 95, false), new Maps(crw, 95, false), new Maps(crw, 95, false)},
				{new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true)},
				{new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true), new Maps(crw, 23, true)},
				{new Maps(crw, 101, true), new Maps(crw, 101, true), new Maps(crw, 101, true), new Maps(crw, 101, true), new Maps(crw, 101, true), new Maps(crw, 101, true), new Maps(crw, 101, true), new Maps(crw, 101, true)},
				{new Maps(crw, 38, false), new Maps(crw, 38, false), new Maps(crw, 38, false), new Maps(crw, 38, false), new Maps(crw, 38, false), new Maps(crw, 38, false), new Maps(crw, 38, false), new Maps(crw, 38, false)},
				{new Maps(crw, 47, false), new Maps(crw, 47, false), new Maps(crw, 47, false), new Maps(crw, 47, false), new Maps(crw, 47, false), new Maps(crw, 47, false), new Maps(crw, 47, false), new Maps(crw, 47, false)},
				{new Maps(crw, 56, false), new Maps(crw, 56, false), new Maps(crw, 56, false), new Maps(crw, 56, false), new Maps(crw, 56, false), new Maps(crw, 56, false), new Maps(crw, 56, false), new Maps(crw, 56, false)},
				{new Maps(crw, 65, false), new Maps(crw, 65, false), new Maps(crw, 65, false), new Maps(crw, 65, false), new Maps(crw, 65, false), new Maps(crw, 65, false), new Maps(crw, 65, false), new Maps(crw, 65, false)},
				{new Maps(crw, 74, false), new Maps(crw, 74, false), new Maps(crw, 74, false), new Maps(crw, 74, false), new Maps(crw, 74, false), new Maps(crw, 74, false), new Maps(crw, 74, false), new Maps(crw, 74, false)},
				{new Maps(crw, 83, false), new Maps(crw, 83, false), new Maps(crw, 83, false), new Maps(crw, 83, false), new Maps(crw, 83, false), new Maps(crw, 83, false), new Maps(crw, 83, false), new Maps(crw, 83, false)}
		};
		Maps[][] objMapData = {
				{null, new Maps(cro, 2, false), null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, new Maps(cro, 177, false), new Maps(cro, 178, false), new Maps(cro, 179, false), null, null, null},
				{null, null, new Maps(cro, 193, false), new Maps(cro, 194, false), new Maps(cro, 195, false), null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null}
		};
		//ベースマップ生成
		map.setMapData(baseMapData);
		map.setMapPanel();
		map.createMap(MapFactory.BASE_LAYER);
		//オブジェクト配置
		map.setMapData(objMapData);
		map.createMap(MapFactory.OBJECT_LAYER);
		//マップを配置
		JPanel mapPanel = map.getMap();
		setLayer(mapPanel, DEFAULT_LAYER);
		add(mapPanel);

		//ボタン配置
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
		playButton = new JButton("プレイ");
		optionButton = new JButton("設定");
		buttons.add(playButton);
		buttons.add(Box.createHorizontalStrut(40));
		buttons.add(optionButton);
		buttons.setBounds(600, 500, 560, 100);
		buttons.setOpaque(false);
		setLayer(buttons, PALETTE_LAYER, 0);
		setButtonStyle();
		add(buttons);
	}

	public void setButtonStyle() {
		//ボタンのスタイル設定
		playButton.setMaximumSize(new Dimension(260, 100));
		playButton.setFont(new Font("MS ゴシック", Font.BOLD, 28));
		playButton.setBackground(Color.BLACK);
		playButton.setForeground(Color.YELLOW);
		playButton.setFocusPainted(false);
		playButton.setIcon(new ImageIcon("src/images/sword.png"));

		optionButton.setMaximumSize(new Dimension(260, 100));
		optionButton.setFont(new Font("MS ゴシック", Font.BOLD, 28));
		optionButton.setBackground(Color.BLACK);
		optionButton.setForeground(Color.YELLOW);
		optionButton.setFocusPainted(false);
		optionButton.setIcon(new ImageIcon("src/images/option.png"));
	}
}
