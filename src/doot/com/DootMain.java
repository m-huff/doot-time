package doot.com;

public class DootMain {
	
	/**
	 * TODO - maybe include countdown for hours, minute, seconds
	 *      - configuration window so you can edit stuff while program runs
	 *      - more doots
	 */
	
	public static void main(String[] args) {
		if (!ConfigLoader.checkConfigExists()) {
			ConfigLoader.setToDefaults();
			ConfigLoader.saveConfig();
		}
		ConfigLoader.loadConfig();
		final DootWindow d = new DootWindow();
	}

}
