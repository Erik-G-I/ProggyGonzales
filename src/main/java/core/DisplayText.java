package core;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;

public class DisplayText {

	private InputStream getFont;
	private Font font;
	
	private void initialiseFont() {
		getFont = getClass().getResourceAsStream("/font/ExpressionPro.ttf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getFont);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g2, int fontSize) {
		initialiseFont();
		g2.setFont(font.deriveFont(Font.PLAIN,fontSize));
	}
	
	
}
