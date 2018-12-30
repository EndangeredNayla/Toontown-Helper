package com.tylerroyer.ttr_helper.driver;

import javax.swing.UIManager;

import com.tylerroyer.ttr_helper.display.Window;
import com.tylerroyer.ttr_helper.globals.GlobalFonts;
import com.tylerroyer.ttr_helper.globals.GlobalHandles;

public class Driver {
	public static boolean running = true;
	
	public static void main(String[] args) {
		GlobalFonts.initFonts();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Window window = new Window();
		GlobalHandles.windowHandle = window;
		
		while(running) {
			window.update();
		}
	}
}
