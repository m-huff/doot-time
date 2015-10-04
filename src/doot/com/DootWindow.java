package doot.com;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class DootWindow extends JFrame {
	
	private static final int BORDER_SIDE = 8;
	private static final int BORDER_TOP = 25;
	private static final int WIDTH = 250 + (BORDER_SIDE / 2);
	private static final int HEIGHT = 260 + BORDER_TOP;

	private static final ImageIcon doot = new ImageIcon(DootWindow.class.getResource("/doot/assets/skeleton.gif"));
	private static final ImageIcon trumpet = new ImageIcon(DootWindow.class.getResource("/doot/assets/trumpet.png"));
	private static final ImageIcon x = new ImageIcon(DootWindow.class.getResource("/doot/assets/x.png"));
	private static final ImageIcon x_hover = new ImageIcon(DootWindow.class.getResource("/doot/assets/x_hover.png"));
	
	private static final String NEWLINE = "\n";
	private static final String LEFT = " left until Halloween";

	private static JLabel timeLeft;
	
	private static JButton exit;
	
	private static JLabel skeleton;

	public DootWindow() {
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(trumpet.getImage());
		setUndecorated(true);
		setVisible(true);
		setLocation(ConfigLoader.screenX, ConfigLoader.screenY);		
		setBackground(new Color(0, 0, 0, 0));
		((JComponent) getContentPane()).setOpaque(false);

		exit = new JButton(x);
		exit.setBackground(new Color(0,0,0,0));
		exit.setBorder(null);
		exit.setBounds(200, 0, x.getImage().getWidth(this), x.getImage().getHeight(this));
		exit.setRolloverIcon(x_hover);
		exit.setVisible(ConfigLoader.showX ? true : false);
		add(exit);
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		Date now = Calendar.getInstance().getTime();
		Date halloween = new Date();
		halloween.setMonth(9);
		halloween.setDate(31);
		
		int days = (int)((halloween.getTime() - now.getTime()) / (1000 * 60 * 60 * 24)) % 60;
		
		timeLeft = new JLabel();
		timeLeft.setFont(new Font("Arial Bold", Font.PLAIN, 18));
		timeLeft.setText(days + " days" + LEFT);
		timeLeft.setForeground(new Color(ConfigLoader.text_r, ConfigLoader.text_g, ConfigLoader.text_b));
	    add(timeLeft);
		timeLeft.setBounds(10, 200, 500, 20);
		
		skeleton = new JLabel(doot);
		skeleton.setBounds((WIDTH - doot.getImage().getWidth(this)) / 2, 0, doot.getImage().getWidth(this), doot.getImage().getHeight(this));
		skeleton.setOpaque(false);
		skeleton.setVisible(true);
		skeleton.setBackground(new Color(0,0,0,0));
		add(skeleton);

		revalidate();
		repaint();
	}
}