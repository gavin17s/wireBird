package com.gsoo.wirebird.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gsoo.wirebird.wbGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Wire Bird";
		config.width = 272;
		config.height = 408;
		new LwjglApplication(new wbGame(), config);
	}
}