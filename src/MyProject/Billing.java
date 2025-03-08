	package MyProject;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.io.File;

import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class Billing extends JFrame{
	Date currentDate = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
	String formattedTime = timeFormat.format(currentDate);
	String formattedDate = dateFormat.format(currentDate);
	private static final long serialVersionUID = 1L;
	private double subTotal;
	private double total;
	private static long cash;
	private float change;
	private JTable table;
	private static DefaultTableModel _table;
	private String modeOfpayment;
	public Billing(double subTotal,double total,double cash,String modeOfpayment,DefaultTableModel dtm) {
		setUndecorated(true);
		this.subTotal = subTotal;
		this.total = total;
		this.modeOfpayment = modeOfpayment;
		this.change = (float) (cash-total);
		this._table = dtm;
		setSize(new Dimension(900, 900));
		getContentPane().setMinimumSize(new Dimension(200, 200));
		getContentPane().setPreferredSize(new Dimension(380, 600));
		UIManager. put("TableHeader.background", new Color(191,160,123));
		UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(240, 230, 213));
		panel.setBounds(5, 5, 370, 584);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Billing.class.getResource("/Images/Logo.png")));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 26, 35, 48);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Café");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(102, 66, 41));
		lblNewLabel_1.setFont(new Font("Ananda Black Personal Use", Font.BOLD, 25));
		lblNewLabel_1.setBounds(90, 26, 73, 48);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mate");
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(102, 66, 41));
		lblNewLabel_1_1.setFont(new Font("Ananda Black Personal Use", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(191, 26, 73, 48);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("8000, DAVAO CITY");
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(50, 50, 50));
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 9));
		lblNewLabel_3.setBounds(128, 74, 114, 20);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("CAFÉ MATE");
		lblNewLabel_3_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(50, 50, 50));
		lblNewLabel_3_1.setFont(new Font("Segoe UI Black", Font.BOLD, 9));
		lblNewLabel_3_1.setBounds(128, 91, 114, 13);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("(000) - 0000000");
		lblNewLabel_3_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(new Color(50, 50, 50));
		lblNewLabel_3_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 9));
		lblNewLabel_3_1_1.setBounds(128, 105, 114, 13);
		panel.add(lblNewLabel_3_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setOpaque(false);
		panel_1.setBounds(24, 168, 322, 313);
		panel.add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 322, 14);
		panel_1.add(panel_3);
		panel_3.setBackground(new Color(191,160,123));
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("ITEM");
		lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_5.setPreferredSize(new Dimension(120, 14));
		panel_3.add(lblNewLabel_5, BorderLayout.WEST);
		
		JLabel lblNewLabel_6 = new JLabel("QTY");
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_6, BorderLayout.CENTER);
		
		JLabel lblNewLabel_7 = new JLabel("AMOUNT");
		lblNewLabel_7.setFocusable(false);
		lblNewLabel_7.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel_7.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_7.setPreferredSize(new Dimension(80, 14));
		panel_3.add(lblNewLabel_7, BorderLayout.EAST);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 322, 192);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setShowHorizontalLines(false);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
		table.setModel(dtm);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(172);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(48);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.setFont(new Font("Verdana", Font.PLAIN, 15));
		table.getTableHeader().setVisible(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(248, 248, 248));
		panel_2.setBounds(0, 191, 322, 122);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("SubTotal:");
		lblNewLabel_4.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_4.setBounds(10, 5, 67, 14);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("Total amount:");
		lblNewLabel_4_2.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_4_2.setBounds(10, 43, 91, 14);
		panel_2.add(lblNewLabel_4_2);
		
		JLabel cashAmountLabel = new JLabel("Cash amount:");
		
		cashAmountLabel.setFont(new Font("Verdana", Font.BOLD, 10));
		cashAmountLabel.setBounds(10, 62, 158, 14);
		panel_2.add(cashAmountLabel);
		
		JLabel changeLabel = new JLabel("Change:");
		changeLabel.setFont(new Font("Verdana", Font.BOLD, 10));
		changeLabel.setBounds(10, 81, 158, 14);
		panel_2.add(changeLabel);
		
		JLabel lblNewLabel_4_6 = new JLabel("Mode of Payment:");
		lblNewLabel_4_6.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_4_6.setBounds(10, 100, 158, 14);
		panel_2.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Tax:");
		lblNewLabel_4_2_1.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_4_2_1.setBounds(10, 24, 67, 14);
		panel_2.add(lblNewLabel_4_2_1);
		
		JLabel subT = new JLabel("₱"+subTotal);

		subT.setHorizontalAlignment(SwingConstants.TRAILING);
		subT.setFont(new Font("Verdana", Font.PLAIN, 10));
		subT.setBounds(245, 5, 67, 14);
		panel_2.add(subT);
		
		JLabel lblNewLabel_4_2_1_1_1 = new JLabel("10%");
		lblNewLabel_4_2_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4_2_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_4_2_1_1_1.setBounds(245, 24, 67, 14);
		panel_2.add(lblNewLabel_4_2_1_1_1);
		
		JLabel tAmount = new JLabel("₱"+total);
		tAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		tAmount.setFont(new Font("Verdana", Font.PLAIN, 10));
		tAmount.setBounds(245, 43, 67, 14);
		panel_2.add(tAmount);
		
		JLabel cashAmount = new JLabel("₱"+cash);
		cashAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		cashAmount.setFont(new Font("Verdana", Font.PLAIN, 10));
		cashAmount.setBounds(176, 62, 136, 14);
		panel_2.add(cashAmount);
		
		JLabel _change = new JLabel("₱"+change);
		_change.setHorizontalAlignment(SwingConstants.TRAILING);
		_change.setFont(new Font("Verdana", Font.PLAIN, 10));
		_change.setBounds(176, 81, 136, 14);
		panel_2.add(_change);	
		
		JLabel mod = new JLabel(this.modeOfpayment);
		mod.setHorizontalAlignment(SwingConstants.TRAILING);
		mod.setFont(new Font("Verdana", Font.PLAIN, 10));
		mod.setBounds(245, 100, 67, 14);
		panel_2.add(mod);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(10, 60, 302, 2);
		panel_2.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("DATE :");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_2.setBounds(24, 139, 44, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("mm/dd/yy");
		lblNewLabel_2_1.setText(formattedDate);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(63, 139, 100, 20);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("H/M/S");
		lblNewLabel_2_1_1.setText(formattedTime);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lblNewLabel_2_1_1.setBounds(246, 142, 100, 20);
		panel.add(lblNewLabel_2_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(62, 39, 35));
		separator.setBorder(new LineBorder(new Color(191, 160, 123), 2, true));
		separator.setBounds(24, 160, 322, 2);
		panel.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(62, 39, 35));
		separator_2.setBackground(new Color(62, 39, 35));
		separator_2.setBorder(new LineBorder(new Color(191, 160, 123), 2, true));
		separator_2.setBounds(24, 488, 322, 2);
		panel.add(separator_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("THANK YOU FOR YOUR PURCHASE!");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 10));
		lblNewLabel_2_2.setBounds(24, 501, 322, 37);
		panel.add(lblNewLabel_2_2);
		switch(modeOfpayment) {
		case "Card":
				Billing.setCash(Frame.getCashString());
				cashAmountLabel.setText("Card#:");
				cashAmount.setText(String.valueOf(Billing.cash));
				changeLabel.setText("Deducted credit: ");
				_change.setText("-₱"+total);
				_change.setForeground(Color.red);
				break;
		case "G-Cash" :
			Billing.setCash(Frame.getCashString());
			cashAmountLabel.setText("G-Cash#:");
			cashAmount.setText(""+gcashNumber(Billing.cash));
			changeLabel.setText("Deducted credit: ");
			_change.setText("-₱"+total);
			_change.setForeground(Color.red);
			break;
			
		}
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.setForeground(new Color(240, 230, 227));
		btnNewButton.setBackground(new Color(62, 39, 35));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {	
					 	btnNewButton.setVisible(false);
			            printComponentToFile(getContentPane(), true);
			            printComponentToFile(getContentPane(), false);
			        } catch (PrinterException exp) {
			            exp.printStackTrace();
			        }finally {
			        	JOptionPane.showMessageDialog(null, "Successfully printed your receipt!");
			        	
			        	try {
							Desktop.getDesktop().open(new File(System.getProperty("user.home") + "/Desktop/Receipt.png"));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			        	
			        	dispose();
			        }
				
				 
				
			}
		});
		btnNewButton.setFocusable(false);
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 10));
		btnNewButton.setBounds(140, 549, 89, 23);
		panel.add(btnNewButton);
		pack();
	}
	public static void setCash(String cash) {
		Billing.cash = Long.parseLong(cash);
	}
	public String gcashNumber(Long num) {
		String hold="";
		String sNum = String.valueOf(num);
		for(int i =0; i<sNum.length() ; i++) {
			if(i<1) {
				
				hold += "0"+sNum.charAt(i);
			}else if(i<=6)  hold += "X";
			else hold+= sNum.charAt(i);
			
		}
		return hold;
	}
	public static void printComponent(JComponent comp, boolean fill) throws PrinterException {
        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat pf = pjob.defaultPage();
        pf.setOrientation(PageFormat.LANDSCAPE);

        PageFormat postformat = pjob.pageDialog(pf);
        if (pf != postformat) {
            //Set print component
            pjob.setPrintable(new ComponentPrinter(comp, fill), postformat);
            if (pjob.printDialog()) {
                pjob.print();
            }
        }    
    }

	public static void printComponentToFile(Component comp, boolean fill) throws PrinterException {
	    // Get the size of the component
	    Dimension compSize = comp.getPreferredSize();

	    Paper paper = new Paper();
	    paper.setSize(compSize.getWidth(), compSize.getHeight());
	    paper.setImageableArea(0, 0, compSize.width, compSize.height);

	    PageFormat pf = new PageFormat();
	    pf.setPaper(paper);
	    pf.setOrientation(PageFormat.PORTRAIT);

	    BufferedImage img = new BufferedImage(
	            (int) Math.round(pf.getWidth()),
	            (int) Math.round(pf.getHeight()),
	            BufferedImage.TYPE_INT_RGB);

	    Graphics2D g2d = img.createGraphics();
	    g2d.setColor(Color.WHITE);
	    g2d.fill(new Rectangle(0, 0, img.getWidth(), img.getHeight()));
	    ComponentPrinter cp = new ComponentPrinter(comp, fill);

	    try {
	        cp.print(g2d, pf, 0);
	    } finally {
	        g2d.dispose();
	    }

	    try {
	        ImageIO.write(img, "png", new File(System.getProperty("user.home") + "/Desktop/Receipt.png"));
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}

    public static class ComponentPrinter implements Printable {

        private Component comp;
        private boolean fill;

        public ComponentPrinter(Component comp, boolean fill) {
            this.comp = comp;
            this.fill = fill;
        }

        @Override
        public int print(Graphics g, PageFormat format, int page_index) throws PrinterException {

            if (page_index > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) g;
            g2.translate(format.getImageableX(), format.getImageableY());

            double width = (int) Math.floor(format.getImageableWidth());
            double height = (int) Math.floor(format.getImageableHeight());

            if (!fill) {

                width = Math.min(width, comp.getPreferredSize().width);
                height = Math.min(height, comp.getPreferredSize().height);

            }

            comp.setBounds(0, 0, (int) Math.floor(width), (int) Math.floor(height));
            if (comp.getParent() == null) {
                comp.addNotify();
            }
            comp.validate();
            comp.doLayout();
            comp.printAll(g2);
            if (comp.getParent() != null) {
                comp.removeNotify();
            }

            return Printable.PAGE_EXISTS;
        }

    }

}
