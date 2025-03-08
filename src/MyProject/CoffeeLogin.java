package MyProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.Document;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CoffeeLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField Username;
	private JPasswordField Password;
	private static int x;
    private static int y;
    static User user = new User();
    public CoffeeLogin() {
    	addWindowFocusListener(new WindowFocusListener() {
    		public void windowGainedFocus(WindowEvent e) {
    			requestFocusInWindow();
    		}
    		public void windowLostFocus(WindowEvent e) {
    		}
    	});
    	
    	setPreferredSize(new Dimension(483, 450));
    	getContentPane().setBackground(new Color(102, 66, 41));
    	getContentPane().setLayout(null);
    	
    	JPanel panel = new JPanel();
    	panel.setOpaque(false);
    	panel.setBounds(84, 176, 318, 210);
    	panel.setBorder(new EmptyBorder(100, 100, 100, 100));
    	getContentPane().add(panel);
    	panel.setLayout(null);
    	
    	Username = new JTextField();
    	Username.addFocusListener(new FocusAdapter() {
    		@Override
    		public void focusGained(FocusEvent e) {
    			if(Username.getText().equals("Username")) {
    				Username.setText(null);
    				Username.requestFocus();
    				removePlaceholderStyle(Username);
    			}
    		}
    		@Override
    		public void focusLost(FocusEvent e) {
    			if(Username.getText().length()==0) {
    				addPlaceholderStyle(Username);
    				Username.setText("Username");
    			}
    		}
    	});
    	Username.setMargin(new Insets(2, 15, 2, 12));
    	Username.setText("Username");
    	Username.setFont(new Font("Verdana", Font.BOLD, 15));
    	Username.setBorder(new EmptyBorder(5, 10, 5, 5));
    	Username.setCaretColor(new Color(250, 197, 99));
    	Username.setBounds(10, 11, 298, 39);
    	panel.add(Username);
    	Username.setColumns(10);
    	addPlaceholderStyle(Username);
    	Password = new JPasswordField();
    	Password.addFocusListener(new FocusAdapter() {
    		@Override
    		public void focusGained(FocusEvent e) {
    			if(Password.getText().equals("Password")) {
    				Password.setText(null);
    				Password.requestFocus();
    				Password.setEchoChar('*');
    				removePlaceholderStyle(Password);
    			}
    		}
    		@Override
    		public void focusLost(FocusEvent e) {
    			if(Password.getText().length()==0) {
    				addPlaceholderStyle(Password);
    				Password.setText("Password");
    				Password.setEchoChar('\u0000');
    			}
    		}
    	});
    	Password.setMargin(new Insets(2, 15, 2, 2));
    	Password.setEchoChar('\u0000');
    	Password.setText("Password");
    	Password.setFont(new Font("Verdana", Font.BOLD, 15));
    	Password.setBorder(new EmptyBorder(5, 10, 5, 5));
    	Password.setCaretColor(new Color(250, 197, 99));
    	Password.setBounds(10, 61, 298, 39);
    	panel.add(Password);
    	addPlaceholderStyle(Password);
    	JButton btnNewButton = new JButton("LOGIN");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			user.setuName("Admin");
    			user.setpWord("Admin123");
    			if(user.authenticate(Username.getText(), Password.getText())) {
    				Frame f = new Frame();
    				f.setVisible(true);
    				f.setLocationRelativeTo(null);
        			dispose();
    			}else {
    				JOptionPane.showMessageDialog(null,"Wrong Password!");
    			}
    		}
    	});
    	btnNewButton.setForeground(new Color(255, 255, 255));
    	btnNewButton.setBackground(new Color(62, 36, 35));
    	btnNewButton.setFocusable(false);
    	btnNewButton.setBorder(null);
    	btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
    	btnNewButton.setFont(new Font("Verdana", Font.BOLD, 17));
    	btnNewButton.setBounds(10, 111, 298, 39);
    	panel.add(btnNewButton);
    	
    	JPanel panel_1 = new JPanel();
    	panel_1.setBackground(new Color(62, 36, 35));
    	panel_1.setOpaque(false);
    	panel_1.setBounds(84, 85, 318, 78);
    	getContentPane().add(panel_1);
    	panel_1.setLayout(null);
    	
    	JLabel lblNewLabel = new JLabel("");
    	lblNewLabel.setBounds(132, 0, 45, 78);
    	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel.setIcon(new ImageIcon(CoffeeLogin.class.getResource("/Images/Logo.png")));
    	panel_1.add(lblNewLabel);
    	
    	JLabel lblNewLabel_1 = new JLabel("Café");
    	lblNewLabel_1.setForeground(new Color(255, 255, 255));
    	lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
    	lblNewLabel_1.setIconTextGap(5);
    	lblNewLabel_1.setBounds(72, 0, 68, 78);
    	lblNewLabel_1.setFont(new Font("Ananda Black Personal Use", Font.BOLD, 25));
    	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    	lblNewLabel_1.setPreferredSize(new Dimension(130, 14));
    	panel_1.add(lblNewLabel_1);
    	
    	JLabel lblNewLabel_2 = new JLabel("Mate");
    	lblNewLabel_2.setForeground(new Color(255, 255, 255));
    	lblNewLabel_2.setBounds(174, 0, 90, 78);
    	lblNewLabel_2.setFont(new Font("Ananda Black Personal Use", Font.BOLD, 25));
    	lblNewLabel_2.setPreferredSize(new Dimension(130, 14));
    	panel_1.add(lblNewLabel_2);
    	
    	JSeparator separator = new JSeparator();
    	separator.setForeground(new Color(255, 255, 255));
    	separator.setBounds(50, 65, 224, 1);
    	panel_1.add(separator);
    	
    	JButton btnNewButton_1_1 = new JButton("");
    	btnNewButton_1_1.setBackground(new Color(102, 66, 41));
    	btnNewButton_1_1.setIcon(new ImageIcon(CoffeeLogin.class.getResource("/Images/minimize.png")));
    	btnNewButton_1_1.setFocusable(false);
    	btnNewButton_1_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			setState(JFrame.ICONIFIED);
    		}
    	});
    	btnNewButton_1_1.setBounds(434, 0, 25, 25);
    	getContentPane().add(btnNewButton_1_1);
    	btnNewButton_1_1.setOpaque(false);
    	btnNewButton_1_1.setMargin(new Insets(2, 2, 2, 2));
    	btnNewButton_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
    	btnNewButton_1_1.setFont(new Font("Verdana", Font.BOLD, 17));
    	btnNewButton_1_1.setBorder(null);
    	
    	JButton btnNewButton_1 = new JButton("");
    	btnNewButton_1.setBackground(new Color(102, 66, 41));
    	btnNewButton_1.setIcon(new ImageIcon(CoffeeLogin.class.getResource("/Images/close.png")));
    	btnNewButton_1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	btnNewButton_1.setFocusable(false);
    	btnNewButton_1.setBounds(459, 0, 25, 25);
    	getContentPane().add(btnNewButton_1);
    	btnNewButton_1.setBorder(null);
    	btnNewButton_1.setOpaque(false);
    	btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 11));
    	btnNewButton_1.setMargin(new Insets(2, 2, 2, 2));
    	btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
    	
    	JPanel panel_2 = new JPanel();
    	panel_2.addMouseMotionListener(new MouseMotionAdapter() {
    		@Override
    		public void mouseDragged(MouseEvent evt) {
                int x = evt.getXOnScreen()-CoffeeLogin.x;
                int y = evt.getYOnScreen()-CoffeeLogin.y;
                setLocation(x,y); 

            }
    	});
    	panel_2.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mousePressed(MouseEvent ev){
    	        x = ev.getX ();
    	        y = ev.getY();
    	       }
    	});
    	panel_2.setOpaque(false);
    	panel_2.setBounds(0, 0, 430, 30);
    	getContentPane().add(panel_2);

    	setResizable(false);
        initComponents();
      
    }
    public void addPlaceholderStyle(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.GRAY);
    }
    public void removePlaceholderStyle(JTextField textField){
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN|Font.BOLD);
        textField.setFont(font);
        textField.setForeground(Color.BLACK);
    }
             
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JavaCoffee - SIGN IN");
        setBackground(new java.awt.Color(245, 241, 233));
        setBounds(new Rectangle(500, 500, 475, 49));
        setUndecorated(true);
        pack();
    }                       
}
