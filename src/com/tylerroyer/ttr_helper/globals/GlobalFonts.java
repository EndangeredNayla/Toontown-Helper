package com.tylerroyer.ttr_helper.globals;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class GlobalFonts {
	public static Font cogFont, standardFont, mickeyFont, minnieFont;
	
	public static void initFonts() {
		try {
			cogFont = Font.createFont(Font.TRUETYPE_FONT, GlobalFonts.class.getResourceAsStream("/resources/fonts/Cog.ttf")).deriveFont(30f);
			standardFont = Font.createFont(Font.TRUETYPE_FONT, GlobalFonts.class.getResourceAsStream("/resources/fonts/Standard.ttf")).deriveFont(30f);
			mickeyFont = Font.createFont(Font.TRUETYPE_FONT, GlobalFonts.class.getResourceAsStream("/resources/fonts/Mickey.ttf")).deriveFont(30f);
			minnieFont = Font.createFont(Font.TRUETYPE_FONT, GlobalFonts.class.getResourceAsStream("/resources/fonts/Minnie.ttf")).deriveFont(30f);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
