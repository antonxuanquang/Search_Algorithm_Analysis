package Theme;

import java.awt.Color;

public class ColorTheme {
	static Color primary = new Color(102, 102, 255);
	static Color secondary = new Color(51, 51, 255);
	
	public ColorTheme() {}
	
	public static Color getPrimaryColor() {
		return primary;
	}
	
	public static Color getSecondaryColor() {
		return secondary;
	}
}
