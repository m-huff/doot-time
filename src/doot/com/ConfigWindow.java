package doot.com;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class ConfigWindow extends JFrame {

	private static final int BORDER_SIDE = 8;
	private static final int BORDER_TOP = 25;
	private static final int WIDTH = 500 + (BORDER_SIDE / 2);
	private static final int HEIGHT = 300 + BORDER_TOP;

	private static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	private static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private static final int CENTER_X = (SCREEN_WIDTH / 2) - (WIDTH / 2);
	private static final int CENTER_Y = (SCREEN_HEIGHT / 2) - (HEIGHT / 2);

	private static final Image icon = new ImageIcon(ConfigWindow.class.getResource("/doot/assets/trumpet.png")).getImage();
	
	private static final String HEADER = "DootTime Configuration";
	
	private static final String INVALID_HEADER = "Invalid!";
	private static final String INVALID_COLOR = " is not a valid color!";
	private static final String INVALID_COLOR_NUMBER = "Numbers are not within the 0-255 boundaries!";
	
	private static final String INVALID_POS = " is not a valid screen position!";

	private static final String COLOR_TEST = "Change Color";
	private static final String COLOR_PROMPT = "Countdown Text Color";
	private static final String SHOW_PROMPT = "Show \"X\" Button";
	private static final String POS_PROMPT = "Change Screen Position";
	
	private static final String RETURN = "Save and Return to Database";
	private static final String YES = "Yes";
	private static final String NO = "No";

	private static final int BUTTON_Y = 30;
	private static final int BUTTON_X_SMALL = 70;
	private static final int BUTTON_X_MEDIUM = 100;
	private static final int BUTTON_X_LARGE = 150;
	private static final int INPUT_MAX = 10;
	
	private static JLayeredPane mainpanel;
	
	private static JLabel color_text;
	private static JTextField color_r;
	private static JTextField color_g;
	private static JTextField color_b;
	private static JButton color_test;

	private static JLabel show_text;
	private static JToggleButton showXYes;
	private static JToggleButton showXNo;
	
	private static JLabel pos_text;
	private static JTextField posX;
	private static JTextField posY;
	private static JButton posChange;

	private static JButton ret;
	
	private JFrame frame = this;
	private final DootWindow dootWindow;

	public ConfigWindow(final DootWindow _data) {
		setSize(WIDTH, HEIGHT);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setIconImage(icon);
		setTitle(HEADER);
		setVisible(true);
		setLocation(CENTER_X, CENTER_Y);
		setBackground(Color.white);
		
		dootWindow = _data;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				_data.cfg = null;
			}
		});
		
		mainpanel = new JLayeredPane();
		mainpanel.setOpaque(true);
		mainpanel.setBackground(new Color(100, 100, 100));
		add(mainpanel);
		mainpanel.setBounds(0, 0, WIDTH, HEIGHT);
		
		color_text = new JLabel();
		color_text.setText(COLOR_PROMPT);
		color_text.setForeground(Color.white);
		mainpanel.add(color_text, 1);
		color_text.setBounds(50, 25, 300, 30);
		
		show_text = new JLabel();
		show_text.setText(SHOW_PROMPT);
		show_text.setForeground(Color.white);
		mainpanel.add(show_text, 1);
		show_text.setBounds(50, 105, 300, 30);
		
		pos_text = new JLabel();
		pos_text.setText(POS_PROMPT);
		pos_text.setForeground(Color.white);
		mainpanel.add(pos_text, 1);
		pos_text.setBounds(50, 185, 300, 30);

		color_r = new JTextField(INPUT_MAX);
		color_r.setText(" " + String.valueOf(ConfigLoader.text_r));
		color_r.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		mainpanel.add(color_r, 1);
		color_r.setBounds(50, 55, BUTTON_X_SMALL, BUTTON_Y);
		color_r.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				color_r.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (color_r.getText().isEmpty())
					color_r.setText((" " + String.valueOf(ConfigLoader.text_r)));
			}
		});
		
		color_g = new JTextField(INPUT_MAX);
		color_g.setText(" " + String.valueOf(ConfigLoader.text_g));
		color_g.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		mainpanel.add(color_g, 1);
		color_g.setBounds(50 + BUTTON_X_SMALL + 10, 55, BUTTON_X_SMALL, BUTTON_Y);
		color_g.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				color_g.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (color_g.getText().isEmpty())
					color_g.setText((" " + String.valueOf(ConfigLoader.text_g)));
			}
		});
		
		color_b = new JTextField(INPUT_MAX);
		color_b.setText(" " + String.valueOf(ConfigLoader.text_b));
		color_b.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		mainpanel.add(color_b, 1);
		color_b.setBounds(50 + BUTTON_X_SMALL * 2 + 20, 55, BUTTON_X_SMALL, BUTTON_Y);
		color_b.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				color_b.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (color_b.getText().isEmpty())
					color_b.setText((" " + String.valueOf(ConfigLoader.text_b)));
			}
		});
		
		color_test = new JButton();
		color_test.setText(COLOR_TEST);
		mainpanel.add(color_test, 1);
		color_test.setBounds(50 + BUTTON_X_SMALL * 3 + 50, 55, BUTTON_X_LARGE - 20, BUTTON_Y);
		color_test.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (ConfigLoader.isInt(color_r.getText().trim()) && ConfigLoader.isInt(color_b.getText().trim()) &&
					ConfigLoader.isInt(color_b.getText().trim())) {
					
					int r = Integer.parseInt(color_r.getText().trim());
					int g = Integer.parseInt(color_g.getText().trim());
					int b = Integer.parseInt(color_b.getText().trim());
					
					if (r >= 0 && r < 256 && g >= 0 && g < 256 && g >= 0 && g < 256) {
						ConfigLoader.text_r = r;
						ConfigLoader.text_g = g;
						ConfigLoader.text_b = b;
						ConfigLoader.saveConfig();
						
						dootWindow.setTextColor(new Color(Integer.parseInt(color_r.getText().trim()),
						Integer.parseInt(color_g.getText().trim()),Integer.parseInt(color_b.getText().trim()), 150));
					}
					else JOptionPane.showMessageDialog(frame, INVALID_COLOR_NUMBER,
						    INVALID_HEADER, JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(frame, "(" + color_r.getText().trim() + ", "
				    + color_g.getText().trim() + ", "  + color_b.getText().trim() + ") " + INVALID_COLOR,
				    INVALID_HEADER, JOptionPane.INFORMATION_MESSAGE);
					
			}
		});
		
		showXYes = new JToggleButton();
		showXYes.setText(YES);
		mainpanel.add(showXYes, 1);
		showXYes.setBounds(50, 130, 60, BUTTON_Y);
		showXYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showXYes.isSelected()) {
					showXYes.setEnabled(false);
					showXNo.setEnabled(true);
					showXNo.setSelected(false);
					ConfigLoader.showX = true;
					_data.setX(true);
					ConfigLoader.saveConfig();
				}
			}
		});
		
		showXNo = new JToggleButton();
		showXNo.setText(NO);
		mainpanel.add(showXNo, 1);
		showXNo.setBounds(115, 130, 60, BUTTON_Y);
		showXNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showXNo.isSelected()) {
					showXNo.setEnabled(false);
					showXYes.setEnabled(true);
					showXYes.setSelected(false);
					ConfigLoader.showX = false;
					_data.setX(false);
					ConfigLoader.saveConfig();
				}
			}
		});
		
		posX = new JTextField(INPUT_MAX);
		posX.setText(" " + String.valueOf(ConfigLoader.text_r));
		posX.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		mainpanel.add(posX, 1);
		posX.setBounds(50, 210, BUTTON_X_SMALL, BUTTON_Y);
		posX.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				posX.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (posX.getText().isEmpty())
					posX.setText((" " + String.valueOf(ConfigLoader.screenX)));
			}
		});
		
		posY = new JTextField(INPUT_MAX);
		posY.setText(" " + String.valueOf(ConfigLoader.text_g));
		posY.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
		mainpanel.add(posY, 1);
		posY.setBounds(50 + BUTTON_X_SMALL + 10, 210, BUTTON_X_SMALL, BUTTON_Y);
		posY.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				posY.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (posY.getText().isEmpty())
					posY.setText((" " + String.valueOf(ConfigLoader.screenY)));
			}
		});
		
		posChange = new JButton();
		posChange.setText(COLOR_TEST);
		mainpanel.add(posChange, 1);
		posChange.setBounds(50 + BUTTON_X_SMALL * 2 + 50, 210, BUTTON_X_LARGE - 20, BUTTON_Y);
		posChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (ConfigLoader.isInt(posX.getText().trim()) && ConfigLoader.isInt(posY.getText().trim())) {
					
					int r = Integer.parseInt(posX.getText().trim());
					int g = Integer.parseInt(posY.getText().trim());

					ConfigLoader.screenX = r;
					ConfigLoader.screenY = g;
					ConfigLoader.saveConfig();
						
					dootWindow.setScreenPos(r, g);
				}
				else
					JOptionPane.showMessageDialog(frame, "(" + posX.getText().trim() + ", "
				    + posY.getText().trim() + ") " + INVALID_POS, INVALID_HEADER, JOptionPane.INFORMATION_MESSAGE);
					
			}
		});

		if (ConfigLoader.showX) {
			showXYes.setEnabled(false);
			showXNo.setEnabled(true);
			showXNo.setSelected(false);
		} else if (!ConfigLoader.showX) {
			showXNo.setEnabled(false);
			showXYes.setEnabled(true);
			showXYes.setSelected(false);
		}
		
		ret = new JButton();
		ret.setText(RETURN);
		mainpanel.add(ret, 1);
		ret.setBounds(143, 515, BUTTON_X_LARGE + 60, BUTTON_Y);
		ret.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				_data.cfg = null;
				((Window) frame).dispose();
				}
		});
		
		revalidate();
		repaint();
	}
	
	public void setWindowColor(Color c) {
		if (c != null) {
			mainpanel.setBackground(c);
		}
	}
}
