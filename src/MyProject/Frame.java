	package MyProject;
	import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
	
	public class Frame extends javax.swing.JFrame {
	    public Frame() {
	    	setUndecorated(true);
	    	setTitle("Café Mate");
	    	setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/Images/Logo.png")));
	        initComponents();
	    }
        			
		private static int x;
	    private static int y;
	    public static boolean status= false;
	    Product products[] = new Product[12];
	
	             
	    private void initComponents() {
	    	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	    	JLabel category;
	    	JButton coffeeMenu;
	        contentPane = new javax.swing.JPanel();
	        contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 4));
	        sidePanel = new javax.swing.JPanel();
	        sidePanel.addMouseListener(new MouseAdapter() {
	        	public void mousePressed(MouseEvent ev){
	                x = ev.getX ();
	                y = ev.getY();
	               }
	        });
	        sidePanel.addMouseMotionListener(new MouseMotionAdapter() {
	    		@Override
	    		public void mouseDragged(MouseEvent evt) {
	                int x = evt.getXOnScreen()-Frame.x;
	                int y = evt.getYOnScreen()-Frame.y;
	                setLocation(x,y); 
	
	            }
	    	});
	        
	        
	        sidePanel.setBounds(0, 0, 60, 661);
	        Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
	        insets.top = -1;
	        insets.bottom = -1;
	        insets.left = -1;
	        insets.right = -1;
	        UIManager.put("TabbedPane.contentBorderInsets", insets);
	        JLabel mode = new JLabel("₱");
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setPreferredSize(new Dimension(880, 662));
	        setResizable(false);
	        setSize(new Dimension(890, 662));
	        contentPane.setLayout(null);
	
	        sidePanel.setBackground(new Color(255, 255, 255));
	        sidePanel.setPreferredSize(new Dimension(75, 700));
	
	        contentPane.add(sidePanel);
	        sidePanel.setLayout(new BorderLayout(0, 0));
	        
	        btns = new JPanel();
	        btns.setBackground(new Color(62, 36, 35));
	        sidePanel.add(btns, BorderLayout.CENTER);
	        btns.setLayout(null);
	        
	        homeBtn = new JButton();
	        homeBtn.setFocusable(false);
	        homeBtn.setOpaque(false);
	        
	        homeBtn.setRequestFocusEnabled(false);
	        homeBtn.setFont(new Font("Verdana", Font.PLAIN, 9));
	        homeBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
	        homeBtn.setIcon(new ImageIcon(Frame.class.getResource("/Images/Home.png")));
	        homeBtn.setBounds(17, 131, 25, 25);
	        homeBtn.setBorder(null);
	        homeBtn.setBackground(new Color(199, 166, 141));
	        homeBtn.setHorizontalTextPosition(SwingConstants.CENTER);
	        btns.add(homeBtn);
	        
	        JButton logoutBtn = new JButton();
	        logoutBtn.setBackground(new Color(245, 245, 245));
	        logoutBtn.setOpaque(false);
	        logoutBtn.setBorder(null);
	        logoutBtn.setRequestFocusEnabled(false);
	        logoutBtn.setIcon(new ImageIcon(Frame.class.getResource("/Images/Logout.png")));
	        logoutBtn.setHorizontalTextPosition(SwingConstants.CENTER);
	        logoutBtn.setBounds(17, 594, 25, 25);
	        btns.add(logoutBtn);
	        
	        JLabel logo = new JLabel("");
	        logo.setHorizontalAlignment(SwingConstants.CENTER);
	        logo.setHorizontalTextPosition(SwingConstants.CENTER);
	        logo.setBackground(new Color(255, 255, 255));
	        logo.setIcon(new ImageIcon(Frame.class.getResource("/Images/Logo.png")));
	        logo.setBounds(7, 11, 45, 45);
	        btns.add(logo);
	        
	        JButton salesBtn = new JButton();
	        salesBtn.setFocusable(false);
	        salesBtn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		tabbedPane.setSelectedIndex(1);
	        	}
	        });
	        salesBtn.setOpaque(false);
	        salesBtn.setIcon(new ImageIcon(Frame.class.getResource("/Images/Sales.png")));
	        salesBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
	        salesBtn.setRequestFocusEnabled(false);
	        salesBtn.setHorizontalTextPosition(SwingConstants.CENTER);
	        salesBtn.setFont(new Font("Verdana", Font.PLAIN, 9));
	        salesBtn.setBorder(null);
	        salesBtn.setBackground(new Color(199, 166, 141));
	        salesBtn.setBounds(17, 214, 25, 25);
	        btns.add(salesBtn);
	        
	        JLabel lblNewLabel = new JLabel("HOME");
	        lblNewLabel.setForeground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 9));
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setBounds(5, 161, 50, 18);
	        btns.add(lblNewLabel);
	        
	        JLabel lblSales = new JLabel("SALES");
	        lblSales.setForeground(new Color(255, 255, 255));
	        lblSales.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSales.setFont(new Font("Verdana", Font.BOLD, 9));
	        lblSales.setBounds(5, 239, 50, 18);
	        btns.add(lblSales);
	        
	        JLabel lblLogout = new JLabel("LOGOUT");
	        lblLogout.setForeground(new Color(255, 255, 255));
	        lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
	        lblLogout.setFont(new Font("Verdana", Font.BOLD, 8));
	        lblLogout.setBounds(5, 617, 50, 18);
	        btns.add(lblLogout);
	        
	        JLabel logoName = new JLabel("Café Mate");
	        logoName.setHorizontalTextPosition(SwingConstants.CENTER);
	        logoName.setHorizontalAlignment(SwingConstants.CENTER);
	        logoName.setForeground(Color.WHITE);
	        logoName.setFont(new Font("Ananda Black Personal Use", Font.PLAIN, 11));
	        logoName.setBounds(0, 50, 60, 18);
	        btns.add(logoName);
	        
	        
	
	        getContentPane().add(contentPane, java.awt.BorderLayout.CENTER);
	        
	        
	        tabbedPane.setRequestFocusEnabled(false);
	        tabbedPane.setBounds(57, -27, 827, 698);
	        contentPane.add(tabbedPane);
	        homeBtn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	tabbedPane.setSelectedIndex(0);
	        		
	        	}
	        });
	        logoutBtn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		resetTable();
	        	CoffeeLogin login = new CoffeeLogin();
	        	login.setVisible(true);
	        	login.setLocationRelativeTo(null);
	        	dispose();
	        		
	        	}
	        });
	        JPanel HomePanel = new JPanel();
	        HomePanel.setFont(new Font("Ananda Black Personal Use", Font.PLAIN, 11));
	        HomePanel.setPreferredSize(new Dimension(200, 1650));
	        HomePanel.setBackground(new Color(247, 247, 247));
	        tabbedPane.addTab("Home", null, HomePanel, null);
	        
	        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.BOTTOM);
	        tabbedPane_1.setBorder(null);
	        tabbedPane_1.setRequestFocusEnabled(false);
	        
	        JLabel jLabel1 = new JLabel();
	        jLabel1.setForeground(new Color(134, 96, 57));
	        jLabel1.setText("Categories");
	        jLabel1.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
	        
	        coffeeMenu = new JButton();
	        coffeeMenu.setForeground(new Color(255, 255, 255));
	        coffeeMenu.setFont(new Font("Agency FB", Font.BOLD, 20));
	        coffeeMenu.setText("COFFEE MENU");
	        coffeeMenu.setHorizontalTextPosition(SwingConstants.CENTER);
	        coffeeMenu.setIcon(new ImageIcon(Frame.class.getResource("/Images/Default_a_vibrant_coffee_background_rendered_in_stunning_highd_3.jpg")));
	        coffeeMenu.setBorder(new LineBorder(new Color(62, 36, 35), 1, true));
	        coffeeMenu.setRequestFocusEnabled(false);
	        
	        
	        JButton foodMenu = new JButton();
	        foodMenu.setForeground(new Color(255, 255, 255));
	        foodMenu.setFont(new Font("Agency FB", Font.BOLD, 20));
	        foodMenu.setIcon(new ImageIcon(Frame.class.getResource("/Images/Default_a_vibrant_breakfast_background_featuring_an_assortment_3.png")));
	        foodMenu.setHorizontalTextPosition(SwingConstants.CENTER);
	        foodMenu.setBorder(new LineBorder(new Color(62, 36, 35), 1, true));
	        foodMenu.setRequestFocusEnabled(false);
	        
	        foodMenu.setText("FOOD MENU");
	        
	        category = new JLabel();
	        category.setForeground(new Color(134, 96, 57));
	        category.setText("Coffee Menu");
	        category.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));
	        foodMenu.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		tabbedPane_1.setSelectedIndex(1);
	        		category.setText("Food Menu");
	        	}
	        });
	        coffeeMenu.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		tabbedPane_1.setSelectedIndex(0);
	        		category.setText("Coffee Menu");
	        	}
	        });
	        JPanel jPanel1 = new JPanel();
	        jPanel1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        jPanel1.setLayout(null);
	        jPanel1.setPreferredSize(new Dimension(300, 1650));
	        jPanel1.setFont(new Font("Verdana", Font.PLAIN, 11));
	        jPanel1.setBackground(new Color(235, 235, 235));
	        
	        JLabel jLabel3 = new JLabel();
	        jLabel3.setText("Order List");
	        jLabel3.setFont(new Font("Calibri Light", Font.BOLD, 18));
	        jLabel3.setBounds(24, 33, 123, 25);
	        jPanel1.add(jLabel3);
	        
	        JLabel jLabel7 = new JLabel();
	        jLabel7.setText("Total");
	        jLabel7.setFont(new Font("Verdana", Font.BOLD, 12));
	        jLabel7.setBounds(30, 450, 160, 10);
	        jPanel1.add(jLabel7);
	        
	        JLabel jLabel10 = new JLabel();
	        jLabel10.setText("Subtotal");
	        jLabel10.setFont(new Font("Verdana", Font.PLAIN, 12));
	        jLabel10.setBounds(30, 400, 160, 10);
	        jPanel1.add(jLabel10);
	        
	        JLabel jLabel11 = new JLabel();
	        jLabel11.setText("Tax");
	        jLabel11.setFont(new Font("Verdana", Font.PLAIN, 12));
	        jLabel11.setBounds(30, 420, 160, 10);
	        jPanel1.add(jLabel11);
	        
	        JPanel jPanel5 = new JPanel();
	        jPanel5.setBorder(new LineBorder(new Color(141, 110, 99)));
	        jPanel5.setBackground(new Color(235, 235, 235));
	        jPanel5.setFont(new Font("Verdana", Font.PLAIN, 11));
	        jPanel5.setBounds(0, 480, 337, 190);
	        jPanel1.add(jPanel5);
	        
	        JLabel jLabel4 = new JLabel();
	        jLabel4.setBounds(30, 11, 210, 27);
	        jLabel4.setText("Payment Method");
	        jLabel4.setFont(new Font("Calibri Light", Font.BOLD, 15));
	        
	        JButton jButton11 = new JButton();
	        jButton11.setFocusable(false);
	        jButton11.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {

	        		switch(getMode()) {
	        		case "Cash":
	        			try {
	        				if(total.getText().equals("₱0.0")) {
		            			JOptionPane.showMessageDialog(null,"Please select at least 1 product!","ERROR",-1);
		            		}else if(getCash() < getTotal()) {
		            			JOptionPane.showMessageDialog(null,"Not enough cash amount!","ERROR",1);
		            		}else {
		            			
		            			Billing billing = new Billing(getSubTotal(),getTotal(),getCash(),getMode(),(DefaultTableModel)table.getModel());
		            			billing.setVisible(true);
		            			billing.setLocationRelativeTo(null);
		            			updateTable();
		            		}
	        			}catch(NumberFormatException w) {
	        				JOptionPane.showMessageDialog(null,"Invalid Input!","ERROR",1);
	        			}
	        			break;
	        			
	        		case "Card":
	        			try {
	        				if(total.getText().equals("₱0.0")) {
		            			JOptionPane.showMessageDialog(null,"Please select at least 1 product!","ERROR",-1);
		            		}else {
		            			if(cash.getText()=="" || getCashLength() != 10) {
		                			JOptionPane.showMessageDialog(null,"Invalid Card number!","ERROR",1);
		                		}else {
		                			Billing billing = new Billing(getSubTotal(),getTotal(),getCash(),getMode(),(DefaultTableModel)table.getModel());
		                			billing.setVisible(true);
		                			billing.setLocationRelativeTo(null);
		                			updateTable();
		                		}
		            			
		            		}
	        			}catch(NumberFormatException r) {
	        				JOptionPane.showMessageDialog(null,"Invalid Input!","ERROR",1);
	        			}
	        			break;
	        		case "G-Cash":
	        			try {
	        				if(total.getText().equals("₱0.0")) {
		            			JOptionPane.showMessageDialog(null,"Please select at least 1 product!","ERROR",-1);
		            		}else {
		            			if(cash.getText()=="" || getCashLength() != 10) {
		                			JOptionPane.showMessageDialog(null,"Invalid G-Cash Number!","ERROR",1);
		                		}else {
		             		
		                			Billing billing = new Billing(getSubTotal(),getTotal(),getCash(),getMode(),(DefaultTableModel)table.getModel());
		                			billing.setVisible(true);
		                			Billing.setCash(cash.getText());
		                			billing.setLocationRelativeTo(null);
		                			updateTable();
		                		}
		            		}
	        			}catch(NumberFormatException w) {
	        				JOptionPane.showMessageDialog(null,"Invalid Input!","ERROR",1);
	        			}
	        			break;
	        		default:
	        			break;
	        		}
	        	}
	        	}
	        );
	        jButton11.setForeground(new Color(244, 238, 234));
	        jButton11.setBorder(new EmptyBorder(1, 1, 1, 1));
	        jButton11.setBounds(30, 120, 288, 40);
	        jButton11.setRequestFocusEnabled(false);
	        jButton11.setText("PAY");
	        jButton11.setFont(new Font("Verdana", Font.BOLD, 18));
	        jButton11.setBackground(new Color(62, 36, 35));
	        jPanel5.setLayout(null);
	        jPanel5.add(jLabel4);
	        jPanel5.add(jButton11);
	        
	        JPanel panel_3 = new JPanel();
	        panel_3.setBackground(new Color(245, 245, 245));
	        panel_3.setBounds(30, 41, 288, 65);
	        jPanel5.add(panel_3);
	        panel_3.setLayout(null);
	        
	        JPanel panel_4 = new JPanel();
	        panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	        panel_4.setBackground(new Color(255, 255, 255));
	        panel_4.setBounds(10, 12, 47, 43);
	        panel_3.add(panel_4);
	        panel_4.setLayout(null);
	        
	        JLabel pmLogo = new JLabel("");
	        pmLogo.setIcon(new ImageIcon(Frame.class.getResource("/Images/cash.png")));
	        pmLogo.setHorizontalAlignment(SwingConstants.CENTER);
	        pmLogo.setBackground(Color.BLACK);
	        pmLogo.setBounds(11, 9, 25, 25);
	        panel_4.add(pmLogo);
	        
	       
	        
	        paymentMode.setRequestFocusEnabled(false);
	        paymentMode.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		String choice = paymentMode.getSelectedItem().toString();
	        		switch(choice) {
	        		case "Cash":
	        			pmLogo.setIcon(new ImageIcon(Frame.class.getResource("/Images/cash.png")));
	        			mode.setText("₱");
	        			break;
	        		case "Card":
	        			pmLogo.setIcon(new ImageIcon(Frame.class.getResource("/Images/card.png")));
	        			mode.setText("#");
	        			break;
	        		case "G-Cash":
	        			pmLogo.setIcon(new ImageIcon(Frame.class.getResource("/Images/gcash.png")));
	        			mode.setText("+63");
	        			break;
	        		default:
	        			pmLogo.setIcon(new ImageIcon(Frame.class.getResource("/Images/Home.png")));
	        			break;
	        		}
	        	}
	        });
	        paymentMode.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Card", "G-Cash"}));
	        paymentMode.setFont(new Font("Bahnschrift", Font.BOLD, 13));
	        paymentMode.setFocusable(false);
	        paymentMode.setBounds(61, 12, 74, 43);
	        panel_3.add(paymentMode);
	        
	        cash = new JTextField();
	        cash.setText("");
	        cash.setMargin(new Insets(2, 4, 2, 4));
	        cash.setHorizontalAlignment(SwingConstants.LEFT);
	        cash.setBorder(new LineBorder(new Color(171, 173, 179)));
	        cash.setFont(new Font("Verdana", Font.PLAIN, 12));
	        cash.setBounds(169, 12, 111, 43);
	        panel_3.add(cash);
	        cash.setColumns(4);
	        
	        JPanel panel_5 = new JPanel();
	        panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
	        panel_5.setBackground(new Color(255, 255, 255));
	        panel_5.setBounds(138, 12, 31, 43);
	        panel_3.add(panel_5);
	        panel_5.setLayout(null);
	        
	        
	        mode.setHorizontalTextPosition(SwingConstants.CENTER);
	        mode.setHorizontalAlignment(SwingConstants.CENTER);
	        mode.setFont(new Font("Verdana", Font.BOLD, 12));
	        mode.setBounds(0, 0, 31, 43);
	        panel_5.add(mode);
	        
	        JSeparator separator_1 = new JSeparator();
	        
	        JLabel lblCafMate = new JLabel("Café Mate");
	        lblCafMate.setHorizontalTextPosition(SwingConstants.CENTER);
	        lblCafMate.setHorizontalAlignment(SwingConstants.CENTER);
	        lblCafMate.setForeground(new Color(62, 36, 35));
	        lblCafMate.setFont(new Font("Ananda Black Personal Use", Font.PLAIN, 30));
	        GroupLayout gl_HomePanel = new GroupLayout(HomePanel);
	        gl_HomePanel.setHorizontalGroup(
	        	gl_HomePanel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_HomePanel.createSequentialGroup()
	        			.addGroup(gl_HomePanel.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_HomePanel.createSequentialGroup()
	        					.addContainerGap(27, Short.MAX_VALUE)
	        					.addGroup(gl_HomePanel.createParallelGroup(Alignment.LEADING)
	        						.addGroup(gl_HomePanel.createParallelGroup(Alignment.LEADING, false)
	        							.addGroup(gl_HomePanel.createSequentialGroup()
	        								.addComponent(coffeeMenu, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
	        								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        								.addComponent(foodMenu))
	        							.addComponent(category)
	        							.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
	        							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        						.addComponent(jLabel1))
	        					.addGap(18))
	        				.addGroup(gl_HomePanel.createSequentialGroup()
	        					.addContainerGap()
	        					.addComponent(lblCafMate, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
	        );
	        gl_HomePanel.setVerticalGroup(
	        	gl_HomePanel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_HomePanel.createSequentialGroup()
	        			.addGroup(gl_HomePanel.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_HomePanel.createSequentialGroup()
	        					.addGap(16)
	        					.addComponent(lblCafMate, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(jLabel1)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addGroup(gl_HomePanel.createParallelGroup(Alignment.BASELINE)
	        						.addComponent(coffeeMenu, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
	        						.addComponent(foodMenu, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
	        					.addGap(12)
	        					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        					.addGap(4)
	        					.addComponent(category)
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE))
	        				.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 668, GroupLayout.PREFERRED_SIZE))
	        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        
	        JSeparator separator = new JSeparator();
	        separator.setForeground(new Color(141, 110, 99));
	        separator.setBounds(0, 436, 350, 2);
	        jPanel1.add(separator);
	        
	        
	        subTotal.setHorizontalAlignment(SwingConstants.RIGHT);
	        subTotal.setFont(new Font("Verdana", Font.PLAIN, 11));
	        subTotal.setBounds(219, 398, 98, 14);
	        jPanel1.add(subTotal);
	        
	        JLabel tax = new JLabel("10%");
	        tax.setHorizontalAlignment(SwingConstants.RIGHT);
	        tax.setFont(new Font("Verdana", Font.PLAIN, 11));
	        tax.setBounds(219, 419, 98, 14);
	        jPanel1.add(tax);
	        
	        
	        total.setHorizontalAlignment(SwingConstants.RIGHT);
	        total.setFont(new Font("Verdana", Font.PLAIN, 11));
	        total.setBounds(219, 449, 98, 14);
	        jPanel1.add(total);
	        
	        JPanel panel = new JPanel();
	        panel.setOpaque(false);
	        panel.setBackground(new Color(141, 110, 99));
	        panel.setBorder(null);
	        panel.setBounds(24, 59, 288, 330);
	        jPanel1.add(panel);
	        panel.setLayout(null);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setViewportBorder(null);
	        scrollPane.setOpaque(false);
	        scrollPane.setBackground(new Color(247, 247, 247));
	        scrollPane.setBounds(0, 0, 288, 305);
	        panel.add(scrollPane);
	        table.setBorder(new LineBorder(new Color(141, 110, 99)));
	        table.setGridColor(new Color(141, 110, 99));
	        table.setBackground(new Color(255, 255, 255));
	        
	        
	        table.setPreferredScrollableViewportSize(new Dimension(400, 400));
	        table.setFocusTraversalKeysEnabled(false);
	        table.setFont(new Font("Verdana", Font.PLAIN, 15));
	        table.setFocusable(false);
	        table.setSelectionBackground(new Color(255, 255, 255));
	        table.setRowHeight(25);
	        table.setRequestFocusEnabled(false);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
	        scrollPane.setViewportView(table);
	        table.getTableHeader().setReorderingAllowed(false);
	        table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        		"Item", "Qty", "Amount"
	        	}
	        ) {
	        	boolean[] columnEditables = new boolean[] {
	        		false, false, false
	        	};
	        	public boolean isCellEditable(int row, int column) {
	        		return columnEditables[column];
	        	}
	        });
	        table.getColumnModel().getColumn(0).setResizable(false);
	        table.getColumnModel().getColumn(0).setPreferredWidth(183);
	        table.getColumnModel().getColumn(1).setResizable(false);
	        table.getColumnModel().getColumn(1).setPreferredWidth(48);
	        table.getColumnModel().getColumn(2).setResizable(false);
	        table.getColumnModel().getColumn(2).setPreferredWidth(73);
	        
	        JButton clearBtn = new JButton("CLEAR");
	        clearBtn.setBorder(null);
	        clearBtn.setBounds(222, 305, 65, 25);
	        panel.add(clearBtn);
	        clearBtn.setMargin(new Insets(2, 2, 2, 2));
	        clearBtn.setForeground(new Color(255, 255, 255));
	        clearBtn.setBackground(new Color(62, 36, 35));
	        clearBtn.setFocusable(false);
	        clearBtn.setRequestFocusEnabled(false);
	        clearBtn.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        			resetTable();
	        			//dispose();
	        		
	        		
	        	}
	        });
	        clearBtn.setFont(new Font("Verdana", Font.BOLD, 11));
	        
	        JPanel panel_1 = new JPanel();
	        
	        panel_1.setBorder(UIManager.getBorder("ToolBar.border"));
	        panel_1.setBackground(new Color(240, 240, 240));
	        panel_1.setBounds(123, 0, 214, 33);
	        jPanel1.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JLabel dateTime = new JLabel("MM/DD/YYYY hh/mm/ss");
	        dateTime.setBounds(44, 11, 130, 13);
	        dateTime.setFont(new Font("Roboto", Font.BOLD, 10));
	        panel_1.add(dateTime);
	        
	        JButton btnNewButton_1_1 = new JButton("");
	        btnNewButton_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		setState(JFrame.ICONIFIED);
	        	}
	        });
	        
	        btnNewButton_1_1.setIcon(new ImageIcon(Frame.class.getResource("/Images/minimizeb.png")));
	        
	        btnNewButton_1_1.setOpaque(false);
	        btnNewButton_1_1.setMargin(new Insets(2, 2, 2, 2));
	        btnNewButton_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnNewButton_1_1.setFont(new Font("Verdana", Font.BOLD, 17));
	        btnNewButton_1_1.setFocusable(false);
	        btnNewButton_1_1.setBorder(null);
	        btnNewButton_1_1.setBackground(new Color(102, 66, 41));
	        btnNewButton_1_1.setBounds(184, 5, 25, 25);
	        panel_1.add(btnNewButton_1_1);
	        
	        JPanel Coffee = new JPanel();
	        Coffee.setLayout(null);
	        Coffee.setBackground(new Color(235, 235, 235));
	        Coffee.setAutoscrolls(true);
	        tabbedPane_1.addTab("New tab", null, Coffee, null);
	        
	        JButton Coffee1 = new JButton();
	        Coffee1.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Black coffee.png")));
	        Coffee1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Black Coffee",39,new ImageIcon(Frame.class.getResource("/CoffeeImg/Black coffee.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        
	        Coffee1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        Coffee1.setRequestFocusEnabled(false);
	        Coffee1.setMargin(new Insets(2, 2, 2, 2));
	        Coffee1.setHorizontalTextPosition(SwingConstants.CENTER);
	        Coffee1.setForeground(new Color(62, 36, 35));
	        Coffee1.setFont(new Font("Verdana", Font.BOLD, 15));
	        Coffee1.setFocusable(false);
	        Coffee1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        Coffee1.setBackground(Color.WHITE);
	        Coffee1.setBounds(10, 11, 126, 126);
	        Coffee.add(Coffee1);
	        
	        JButton Coffee2 = new JButton();
	        Coffee2.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Espresso.png")));
	        Coffee2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Espresso",65,new ImageIcon(Frame.class.getResource("/CoffeeImg/Espresso.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        Coffee2.setVerticalTextPosition(SwingConstants.BOTTOM);
	        Coffee2.setRequestFocusEnabled(false);
	        Coffee2.setMargin(new Insets(2, 2, 2, 2));
	        Coffee2.setHorizontalTextPosition(SwingConstants.CENTER);
	        Coffee2.setForeground(new Color(62, 36, 35));
	        Coffee2.setFont(new Font("Verdana", Font.BOLD, 15));
	        Coffee2.setFocusable(false);
	        Coffee2.setBorder(new LineBorder(new Color(141, 110, 99)));
	        Coffee2.setBackground(new Color(255, 255, 255));
	        Coffee2.setBounds(152, 11, 126, 126);
	        Coffee.add(Coffee2);
	        
	        JButton btnProduct_1_3 = new JButton();
	        btnProduct_1_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Macchiato",60,new ImageIcon(Frame.class.getResource("/CoffeeImg/Macchiato.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_3.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Macchiato.png")));
	        btnProduct_1_3.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_3.setRequestFocusEnabled(false);
	        btnProduct_1_3.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_3.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_3.setForeground(new Color(62, 36, 35));
	        btnProduct_1_3.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_3.setFocusable(false);
	        btnProduct_1_3.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_3.setBackground(Color.WHITE);
	        btnProduct_1_3.setBounds(294, 11, 126, 126);
	        Coffee.add(btnProduct_1_3);
	        
	        JButton btnProduct_1_4 = new JButton();
	        btnProduct_1_4.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Cappuccino",45,new ImageIcon(Frame.class.getResource("/CoffeeImg/Cappuccino.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_4.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Cappuccino.png")));
	        btnProduct_1_4.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_4.setRequestFocusEnabled(false);
	        btnProduct_1_4.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_4.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_4.setForeground(new Color(62, 36, 35));
	        btnProduct_1_4.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_4.setFocusable(false);
	        btnProduct_1_4.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_4.setBackground(Color.WHITE);
	        btnProduct_1_4.setBounds(10, 160, 126, 126);
	        Coffee.add(btnProduct_1_4);
	        
	        JButton btnProduct_1_2_2 = new JButton();
	        btnProduct_1_2_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Frappe",70,new ImageIcon(Frame.class.getResource("/CoffeeImg/Frappe coffee.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_2_2.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Frappe coffee.png")));
	        btnProduct_1_2_2.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_2_2.setRequestFocusEnabled(false);
	        btnProduct_1_2_2.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_2_2.setForeground(new Color(62, 36, 35));
	        btnProduct_1_2_2.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_2_2.setFocusable(false);
	        btnProduct_1_2_2.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_2_2.setBackground(Color.WHITE);
	        btnProduct_1_2_2.setBounds(152, 160, 126, 126);
	        Coffee.add(btnProduct_1_2_2);
	        
	        JButton btnProduct_1_3_2 = new JButton();
	        btnProduct_1_3_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Iced Coffee",75,new ImageIcon(Frame.class.getResource("/CoffeeImg/Iced coffee.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_3_2.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Iced coffee.png")));
	        btnProduct_1_3_2.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_3_2.setRequestFocusEnabled(false);
	        btnProduct_1_3_2.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_3_2.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_3_2.setForeground(new Color(62, 36, 35));
	        btnProduct_1_3_2.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_3_2.setFocusable(false);
	        btnProduct_1_3_2.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_3_2.setBackground(Color.WHITE);
	        btnProduct_1_3_2.setBounds(294, 160, 126, 126);
	        Coffee.add(btnProduct_1_3_2);
	        
	        JButton btnProduct_1_4_2 = new JButton();
	        btnProduct_1_4_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Cold Brew",80,new ImageIcon(Frame.class.getResource("/CoffeeImg/Iced coffee.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_4_2.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Cold Brew.png")));
	        btnProduct_1_4_2.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_4_2.setRequestFocusEnabled(false);
	        btnProduct_1_4_2.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_4_2.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_4_2.setForeground(new Color(62, 36, 35));
	        btnProduct_1_4_2.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_4_2.setFocusable(false);
	        btnProduct_1_4_2.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_4_2.setBackground(Color.WHITE);
	        btnProduct_1_4_2.setBounds(10, 306, 126, 126);
	        Coffee.add(btnProduct_1_4_2);
	        
	        JButton btnProduct_1_2_2_2 = new JButton();
	        btnProduct_1_2_2_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Irish Coffee",50,new ImageIcon(Frame.class.getResource("/CoffeeImg/Irish coffee.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        	
	        });
	        btnProduct_1_2_2_2.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Irish coffee.png")));
	        btnProduct_1_2_2_2.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_2_2_2.setRequestFocusEnabled(false);
	        btnProduct_1_2_2_2.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_2_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_2_2_2.setForeground(new Color(62, 36, 35));
	        btnProduct_1_2_2_2.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_2_2_2.setFocusable(false);
	        btnProduct_1_2_2_2.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_2_2_2.setBackground(Color.WHITE);
	        btnProduct_1_2_2_2.setBounds(152, 306, 126, 126);
	        Coffee.add(btnProduct_1_2_2_2);
	        
	        JButton btnProduct_1_3_2_2 = new JButton();
	        btnProduct_1_3_2_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Affogato",65,new ImageIcon(Frame.class.getResource("/CoffeeImg/Affogato.png")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_3_2_2.setIcon(new ImageIcon(Frame.class.getResource("/CoffeeImg/Affogato.png")));
	        btnProduct_1_3_2_2.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_3_2_2.setRequestFocusEnabled(false);
	        btnProduct_1_3_2_2.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_3_2_2.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_3_2_2.setForeground(new Color(62, 36, 35));
	        btnProduct_1_3_2_2.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_3_2_2.setFocusable(false);
	        btnProduct_1_3_2_2.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_3_2_2.setBackground(Color.WHITE);
	        btnProduct_1_3_2_2.setBounds(294, 306, 126, 126);
	        Coffee.add(btnProduct_1_3_2_2);
	        tabbedPane_1.setBackgroundAt(0, new Color(172, 123, 88));
	        
	        JPanel Food = new JPanel();
	        Food.setLayout(null);
	        Food.setBackground(new Color(235, 235, 235));
	        Food.setAutoscrolls(true);
	        tabbedPane_1.addTab("New tab", null, Food, null);
	        
	        JButton product1_1 = new JButton();
	        product1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("B-Cheese Sandwich",120,new ImageIcon(Frame.class.getResource("/FoodImg/Bacon 4 Cheese Sandwich.jpg")));
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        product1_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/Bacon 4 Cheese Sandwich.jpg")));
	        product1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        product1_1.setRequestFocusEnabled(false);
	        product1_1.setMargin(new Insets(2, 2, 2, 2));
	        product1_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        product1_1.setForeground(new Color(62, 36, 35));
	        product1_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        product1_1.setFocusable(false);
	        product1_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        product1_1.setBackground(Color.WHITE);
	        product1_1.setBounds(10, 11, 126, 126);
	        Food.add(product1_1);
	        
	        JButton btnProduct_1_2_1 = new JButton();
	        
	        btnProduct_1_2_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/Tuna Melt Sandwich.jpg")));
	        btnProduct_1_2_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Tuna Sandwich",110,(ImageIcon) btnProduct_1_2_1.getIcon());
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_2_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_2_1.setRequestFocusEnabled(false);
	        btnProduct_1_2_1.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_2_1.setForeground(new Color(62, 36, 35));
	        btnProduct_1_2_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_2_1.setFocusable(false);
	        btnProduct_1_2_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_2_1.setBackground(Color.WHITE);
	        btnProduct_1_2_1.setBounds(152, 11, 126, 126);
	        Food.add(btnProduct_1_2_1);
	        
	        JButton btnProduct_1_3_1 = new JButton();
	        btnProduct_1_3_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/AllDay Breakfast Corned Beef.jpg")));
	        btnProduct_1_3_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Corned Beef",135,(ImageIcon) btnProduct_1_3_1.getIcon());
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_3_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_3_1.setRequestFocusEnabled(false);
	        btnProduct_1_3_1.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_3_1.setForeground(new Color(62, 36, 35));
	        btnProduct_1_3_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_3_1.setFocusable(false);
	        btnProduct_1_3_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_3_1.setBackground(Color.WHITE);
	        btnProduct_1_3_1.setBounds(294, 11, 126, 126);
	        Food.add(btnProduct_1_3_1);
	        
	        JButton btnProduct_1_4_1 = new JButton();
	        btnProduct_1_4_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/Boneless Bangus with Rice.jpg")));
	        btnProduct_1_4_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Boneless Bangus",150,(ImageIcon) btnProduct_1_4_1.getIcon());
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_4_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_4_1.setRequestFocusEnabled(false);
	        btnProduct_1_4_1.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_4_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_4_1.setForeground(new Color(62, 36, 35));
	        btnProduct_1_4_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_4_1.setFocusable(false);
	        btnProduct_1_4_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_4_1.setBackground(Color.WHITE);
	        btnProduct_1_4_1.setBounds(10, 157, 126, 126);
	        Food.add(btnProduct_1_4_1);
	        
	        JButton btnProduct_1_2_2_1 = new JButton();
	        btnProduct_1_2_2_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/Beef Tapa.jpg")));
	        btnProduct_1_2_2_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Beef Tapa",125,(ImageIcon) btnProduct_1_2_2_1.getIcon());
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_2_2_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_2_2_1.setRequestFocusEnabled(false);
	        btnProduct_1_2_2_1.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_2_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_2_2_1.setForeground(new Color(62, 36, 35));
	        btnProduct_1_2_2_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_2_2_1.setFocusable(false);
	        btnProduct_1_2_2_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_2_2_1.setBackground(Color.WHITE);
	        btnProduct_1_2_2_1.setBounds(152, 157, 126, 126);
	        Food.add(btnProduct_1_2_2_1);
	        
	        JButton btnProduct_1_3_2_1 = new JButton();
	        btnProduct_1_3_2_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/Garlic Longganisa.jpg")));
	        btnProduct_1_3_2_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Garlic Longganisa",130,(ImageIcon) btnProduct_1_3_2_1.getIcon());
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_3_2_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_3_2_1.setRequestFocusEnabled(false);
	        btnProduct_1_3_2_1.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_3_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_3_2_1.setForeground(new Color(62, 36, 35));
	        btnProduct_1_3_2_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_3_2_1.setFocusable(false);
	        btnProduct_1_3_2_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_3_2_1.setBackground(Color.WHITE);
	        btnProduct_1_3_2_1.setBounds(294, 157, 126, 126);
	        Food.add(btnProduct_1_3_2_1);
	        
	        JButton btnProduct_1_4_1_1 = new JButton();
	        btnProduct_1_4_1_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/Chicken Alfredo Penne.jpg")));
	        btnProduct_1_4_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Chicken Alfredo",150,(ImageIcon) btnProduct_1_4_1_1.getIcon());
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_4_1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_4_1_1.setRequestFocusEnabled(false);
	        btnProduct_1_4_1_1.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_4_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_4_1_1.setForeground(new Color(62, 36, 35));
	        btnProduct_1_4_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_4_1_1.setFocusable(false);
	        btnProduct_1_4_1_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_4_1_1.setBackground(Color.WHITE);
	        btnProduct_1_4_1_1.setBounds(10, 303, 126, 126);
	        Food.add(btnProduct_1_4_1_1);
	        
	        JButton btnProduct_1_2_2_1_1 = new JButton();
	        btnProduct_1_2_2_1_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/Chicken Parmigiana with Hot Pepper Rice.jpg")));
	        btnProduct_1_2_2_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("Chicken Parmigiana",190,(ImageIcon) btnProduct_1_2_2_1_1.getIcon());
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_2_2_1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_2_2_1_1.setRequestFocusEnabled(false);
	        btnProduct_1_2_2_1_1.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_2_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_2_2_1_1.setForeground(new Color(62, 36, 35));
	        btnProduct_1_2_2_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_2_2_1_1.setFocusable(false);
	        btnProduct_1_2_2_1_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_2_2_1_1.setBackground(Color.WHITE);
	        btnProduct_1_2_2_1_1.setBounds(152, 303, 126, 126);
	        Food.add(btnProduct_1_2_2_1_1);
	        
	        JButton btnProduct_1_3_2_1_1 = new JButton();
	        btnProduct_1_3_2_1_1.setIcon(new ImageIcon(Frame.class.getResource("/FoodImg/French Toast.jpg")));
	        btnProduct_1_3_2_1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Product product = new Product("French Toast",100,(ImageIcon) btnProduct_1_3_2_1_1.getIcon());
	        		product.setVisible(true);
	        		product.setLocationRelativeTo(null);
	        	}
	        });
	        btnProduct_1_3_2_1_1.setVerticalTextPosition(SwingConstants.BOTTOM);
	        btnProduct_1_3_2_1_1.setRequestFocusEnabled(false);
	        btnProduct_1_3_2_1_1.setMargin(new Insets(2, 2, 2, 2));
	        btnProduct_1_3_2_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        btnProduct_1_3_2_1_1.setForeground(new Color(62, 36, 35));
	        btnProduct_1_3_2_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
	        btnProduct_1_3_2_1_1.setFocusable(false);
	        btnProduct_1_3_2_1_1.setBorder(new LineBorder(new Color(141, 110, 99)));
	        btnProduct_1_3_2_1_1.setBackground(Color.WHITE);
	        btnProduct_1_3_2_1_1.setBounds(294, 303, 126, 126);
	        Food.add(btnProduct_1_3_2_1_1);
	        HomePanel.setLayout(gl_HomePanel);
	        
	        JPanel SalesPanel = new JPanel();
	        SalesPanel.setBackground(new Color(247, 247, 247));
	        tabbedPane.addTab("Sales", null, SalesPanel, null);
	        SalesPanel.setLayout(null);
	        
	        JPanel panel_2 = new JPanel();
	        panel_2.setBackground(new Color(62, 36, 35));
	        panel_2.setBounds(0, -1, 825, 59);
	        SalesPanel.add(panel_2);
	        panel_2.setLayout(null);
	        
	        JLabel lblNewLabel_1 = new JLabel("SALES");
	        lblNewLabel_1.setBounds(10, 11, 95, 59);
	        lblNewLabel_1.setForeground(new Color(255, 255, 255));
	        lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
	        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
	        lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 30));
	        panel_2.add(lblNewLabel_1);
	        
	        JScrollPane scrollTable = new JScrollPane();
	        scrollTable.setBounds(3, 57, 820, 616);
	        SalesPanel.add(scrollTable);
	        
	        table_1 = new JTable();
	        table_1.setRowMargin(5);
	        table_1.setRowHeight(25);
	        table_1.setPreferredScrollableViewportSize(new Dimension(455, 400));
	        table_1.setFocusable(false);
	        table_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
	        table_1.setBorder(null);
	        scrollTable.setViewportView(table_1);
	        table_1.setModel(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        		"Product Name", "Quantity", "Amount", "Date"
	        	}
	        ) {
	        	boolean[] columnEditables = new boolean[] {
	        		false, false, false, false
	        	};
	        	public boolean isCellEditable(int row, int column) {
	        		return columnEditables[column];
	        	}
	        });
	       
	        	
	        table_1.getColumnModel().getColumn(0).setResizable(false);
	        table_1.getColumnModel().getColumn(0).setPreferredWidth(362);
	        table_1.getColumnModel().getColumn(1).setResizable(false);
	        table_1.getColumnModel().getColumn(1).setPreferredWidth(88);
	        table_1.getColumnModel().getColumn(2).setResizable(false);
	        table_1.getColumnModel().getColumn(2).setPreferredWidth(73);
	        table_1.getColumnModel().getColumn(3).setResizable(false);
	        Timer timer = new Timer();
	
	        timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	  
	                Date currentDate = new Date();
	
	                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a MM/dd/yyyy ");
	
	                String formattedDateTime = dateFormat.format(currentDate);
	
	                dateTime.setText(formattedDateTime);
	            }
	        }, 0, 1000);
	        pack();
	        
	    }  
	    private static JLabel subTotal = new JLabel("₱0.0");
	    private static JLabel total = new JLabel("₱0.0");
	    private javax.swing.JPanel contentPane;
	    private javax.swing.JPanel sidePanel;
	    private JPanel btns;
	    private JButton homeBtn;
		private static final long serialVersionUID = 1L;
	    public static JTable table = new JTable();
	    private static JTextField cash;
	    private static JComboBox paymentMode = new JComboBox();
	    private JTable table_1;
	    public static double removeSign(String word) {
	    	String hold = "";
	for(int i =1;i<= word.length()-1;i++) {
				hold += word.charAt(i);
			}
			return Double.parseDouble(hold);
	    }
		public static double getSubTotal() {
			
			
			return removeSign(subTotal.getText());
		}
		public static void setSubTotal(String subTotal) {
			Frame.subTotal.setText(subTotal);
		}
		public static double getTotal() {
			return removeSign(total.getText());
		}
		public static void setTotal(String total) {
			Frame.total.setText(total);
		}
		public static JTable getTable() {
			return table;
		}
		public static void setTable(JTable table) {
			Frame.table = table;
		}
		public static double getCash() {
			if (cash.getText().isEmpty()) {
		        return 0;
		    } else {
		            return Double.parseDouble(cash.getText());
		    }
		}	
	
		public static String getCashString() {
			return cash.getText();
		}
		public static int getCashLength() {
			return cash.getText().length();
		}
		public static String getMop() {
			return paymentMode.getSelectedItem().toString();
		}
		public static String getMode() {
			return paymentMode.getSelectedItem().toString();
		}
		void updateTable() {
			DefaultTableModel src = (DefaultTableModel) table.getModel();
    		DefaultTableModel cTable = (DefaultTableModel) table_1.getModel();
    		int rowCount = src.getRowCount();
    		int columnCount = src.getColumnCount();
    		for (int i = 0; i < rowCount; i++) {
    		    Object[] rowData = new Object[cTable.getColumnCount()]; // Ensure rowData matches model2 columns

    		    // Copy data from model1
    		    for (int j = 0; j < columnCount; j++) {
    		        rowData[j] = src.getValueAt(i, j);
    		    }
    		    Date currentDate = new Date();
    		    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    			
                String formattedDateTime = dateFormat.format(currentDate);

                
    		    
    		    rowData[columnCount] = formattedDateTime;

    		    cTable.addRow(rowData);
    		}
		}
		void resetTable() {
			DefaultTableModel dm = (DefaultTableModel)table.getModel();
    		int rowCount = dm.getRowCount();
    		for (int i = rowCount - 1; i >= 0; i--) {
    		    dm.removeRow(i);
    		}
    		total.setText("₱0.0");
    		subTotal.setText("₱0.0");
    		cash.setText("");
		}
	}
