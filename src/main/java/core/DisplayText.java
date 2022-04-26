package core;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;

public class DisplayText {

	private InputStream getFont;
	private Font font;
	private Panel gp;
	protected Graphics g2;

	
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

	public void setGp(Panel gp) {
		this.gp = gp;
	}

	public void setGraphics(Graphics g2) {
		this.g2 = g2;
	}
	
	public void draw(int fontSize) {
		initialiseFont();
		g2.setFont(font.deriveFont(Font.PLAIN,fontSize));
	}
	
    public int centerText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gp.screenWidth/2 - length/2;
    }
	
}
