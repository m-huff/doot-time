package doot.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigLoader {

	public static int text_r;
	public static int text_g;
	public static int text_b;
	
	public static int screenX;
	public static int screenY;
	
	public static boolean useSkeleton;
	public static boolean showHoursMinsSecs;
	public static boolean showX;
	
	static Properties config = new Properties();
	static InputStream input = null;
	static OutputStream output = null;
	
	
	public static void loadConfig() {
		try {
			input = new FileInputStream("config.properties");
			config.load(input);

			text_r = Integer.parseInt(config.getProperty("textcolor_r"));
			text_g = Integer.parseInt(config.getProperty("textcolor_g"));
			text_b = Integer.parseInt(config.getProperty("textcolor_b"));
			
			screenX = Integer.parseInt(config.getProperty("screen_pos_x"));
			screenY = Integer.parseInt(config.getProperty("screen_pos_y"));
			
			useSkeleton = Boolean.parseBoolean(config.getProperty("skeleton_gif"));
			showHoursMinsSecs = Boolean.parseBoolean(config.getProperty("show_hours_mins_secs"));
			showX = Boolean.parseBoolean(config.getProperty("show_exit_button"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveConfig() {
		try {
			output = new FileOutputStream("config.properties");

			config.setProperty("textcolor_r", String.valueOf(text_r));
			config.setProperty("textcolor_g", String.valueOf(text_g));
			config.setProperty("textcolor_b", String.valueOf(text_b));
			
			config.setProperty("screen_pos_x", String.valueOf(screenX));
			config.setProperty("screen_pos_y", String.valueOf(screenY));
			
			config.setProperty("skeleton_gif", String.valueOf(useSkeleton));
			config.setProperty("show_hours_mins_secs", String.valueOf(showHoursMinsSecs));
			config.setProperty("show_exit_button", String.valueOf(showX));
			
			config.store(output, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}