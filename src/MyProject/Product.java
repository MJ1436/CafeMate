package MyProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Insets;


public class Product extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public DefaultTableModel dtm = new DefaultTableModel();
	private String productName = "[Product]";
	private int productPrice;
	private int QTY;
	private ImageIcon image;
	private JTextField price;
	private JTextField textField;
	
	
	Product(String productName, int productPrice, ImageIcon image){
		setUndecorated(true);
		setTitle("Product");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Product.class.getResource("/Images/Logo.png")));
		getContentPane().setBackground(new Color(240, 230, 213));
		this.productName = productName;
		this.productPrice = productPrice;
		this.image = image;	
		setPreferredSize(new Dimension(245, 350));
		setResizable(false);
		getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(62, 36, 35));
		panel.setBounds(36, 64, 172, 141);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel productImage = new JLabel();
		productImage.setBackground(new Color(255, 255, 255));
		productImage.setIcon(image);
		productImage.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(productImage, BorderLayout.CENTER);
		
		JLabel name = new JLabel(productName);
		name.setBackground(new Color(248, 248, 248));
		name.setForeground(new Color(62, 39, 35));
		name.setBounds(36, 39, 172, 26);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Verdana", Font.BOLD, 18));
		getContentPane().add(name);
		JSpinner quantity = new JSpinner();
		quantity.setRequestFocusEnabled(false);
		quantity.setFocusable(false);
		quantity.setBounds(154, 230, 54, 18);
		quantity.setFont(new Font("Verdana", Font.PLAIN, 12));
		quantity.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		getContentPane().add(quantity);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity :");
		lblNewLabel_2.setBackground(new Color(248, 248, 248));
		lblNewLabel_2.setForeground(new Color(62, 39, 35));
		lblNewLabel_2.setBounds(36, 230, 81, 14);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price :");
		lblNewLabel_3.setBackground(new Color(248, 248, 248));
		lblNewLabel_3.setForeground(new Color(62, 39, 35));
		lblNewLabel_3.setBounds(36, 207, 80, 15);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 12));
		getContentPane().add(lblNewLabel_3);
		
		price = new JTextField();
		price.setFocusable(false);
		price.setBounds(174, 207, 34, 18);
		price.setHorizontalAlignment(SwingConstants.RIGHT);
		price.setFont(new Font("Verdana", Font.PLAIN, 12));
		price.setText(String.valueOf(productPrice));
		getContentPane().add(price);
		price.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(36, 255, 172, 35);
		btnNewButton.setForeground(new Color(247, 240, 240));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(62, 36, 35));
		btnNewButton.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		QTY = Integer.parseInt(quantity.getValue().toString());
      		double amount = Double.parseDouble(price.getText()) * QTY;
      		dtm = (DefaultTableModel) Frame.getTable().getModel();
      		dtm.addRow(new Object[] {productName,QTY,"₱"+amount});
      		Frame.getTable().setModel(dtm);
      		double subTotal = Frame.getSubTotal();
      		subTotal = subTotal+amount;
      		double total = subTotal+(subTotal*0.10);
      		Frame.setSubTotal("₱"+subTotal);
      		Frame.setTotal("₱"+total);
      		   		
      		dispose();
      	}
      });
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(0, 0, 0)));
		textField.setText("₱");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Verdana", Font.PLAIN, 12));
		textField.setFocusable(false);
		textField.setColumns(10);
		textField.setBounds(154, 207, 20, 18);
		getContentPane().add(textField);
		
		JButton exitBtn = new JButton("x");
		exitBtn.setBackground(new Color(177, 126, 75));
		exitBtn.setFont(new Font("Verdana", Font.BOLD, 11));
		exitBtn.setBorder(null);
		exitBtn.setOpaque(false);
		exitBtn.setForeground(new Color(0, 0, 0));
		exitBtn.setFocusable(false);
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitBtn.setMargin(new Insets(2, 2, 2, 2));
		exitBtn.setBounds(219, 0, 26, 23);
		getContentPane().add(exitBtn);
		pack();
	}

	public String getProductName() {
		return productName;	
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public void setProductImage(ImageIcon image) {
		this.image = image;
	}
	public ImageIcon getProductImage() {
		return image;
	}
}
   