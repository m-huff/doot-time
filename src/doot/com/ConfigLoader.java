package doot.com;

import java.io.File;
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

	public static boolean showX;
	
	static Properties config = new Properties();
	static InputStream input = null;
	static OutputStream output = null;
	
	static File prop = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\DootTime\\");
	static File cfg = new File(System.getProperty("user.home") + "\\AppData\\Roaming\\DootTime\\config.properties");
	
	public static void loadConfig() {
		try {			
			input = new FileInputStream(cfg);
			config.load(input);

			text_r = Integer.parseInt(config.getProperty("textcolor_r"));
			text_g = Integer.parseInt(config.getProperty("textcolor_g"));
			text_b = Integer.parseInt(config.getProperty("textcolor_b"));
			
			screenX = Integer.parseInt(config.getProperty("screen_pos_x"));
			screenY = Integer.parseInt(config.getProperty("screen_pos_y"));

			showX = Boolean.parseBoolean(config.getProperty("show_exit_button"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveConfig() {
		try {
			prop.mkdirs();
			if(!prop.exists()) {
				try {
					prop.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} 
			
			if(!cfg.exists()) {
				try {
					cfg.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			output = new FileOutputStream(cfg);

			config.setProperty("textcolor_r", String.valueOf(text_r));
			config.setProperty("textcolor_g", String.valueOf(text_g));
			config.setProperty("textcolor_b", String.valueOf(text_b));
			
			config.setProperty("screen_pos_x", String.valueOf(screenX));
			config.setProperty("screen_pos_y", String.valueOf(screenY));
			
			config.setProperty("show_exit_button", String.valueOf(showX));
			
			config.store(output, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isInt(String in) {
	    try {
	        Integer.parseInt(in);
	        return true;
	    }
	    catch(NumberFormatException e) {
	        return false;
	    }
	}
	
	public static boolean isBoolean(String in) {
	    try {
	        Boolean.parseBoolean(in);
	        return true;
	    }
	    catch(NumberFormatException e) {
	        return false;
	    }
	}
	
	public static boolean checkConfigExists() {
		return cfg.exists();
	}
	
	public static void setToDefaults() {
		text_r = 255;
		text_g = 255;
		text_b = 255;
		
		screenX = 400;
		screenY = 400;

		showX = false;
	}
}
