package doot.com;

public class DootMain {
	
	public static void main(String[] args) {
		ConfigLoader.loadConfig();
		final DootWindow d = new DootWindow();
	}

}
