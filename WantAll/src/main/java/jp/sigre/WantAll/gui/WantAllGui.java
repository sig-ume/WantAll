package jp.sigre.WantAll.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;

public class WantAllGui extends JFrame {

	private JTable table;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField urlField;
	private JTextField releaseDateField;
	private JButton btnNewButton;

    String[] columnNames;
    String[][] tabledata;
    JScrollPane sp = null;
    ProductInfoTableModel model;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WantAllGui frame = new WantAllGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WantAllGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 287);

	    //columnNames = new ConnectDB().getColumns();
	    //tabledata = new ShowProductList().getProductStrAry();

		model = new ProductInfoTableModel();
	    table = new JTable(model);
//	    contentPane.add(table, BorderLayout.CENTER);
	    sp = new JScrollPane(table);
	    sp.setPreferredSize(new Dimension(400, 140));

	    JPanel p = new JPanel();
	    p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    p.add(sp);

	    getContentPane().add(p, BorderLayout.NORTH);

	    JPanel panel = new JPanel();
	    getContentPane().add(panel, BorderLayout.CENTER);
	    panel.setLayout(null);

	    titleField = new JTextField();
	    titleField.setBounds(12, 30, 96, 19);
	    panel.add(titleField);
	    titleField.setColumns(10);

	    authorField = new JTextField();
	    authorField.setBounds(120, 30, 96, 19);
	    panel.add(authorField);
	    authorField.setColumns(10);

	    urlField = new JTextField();
	    urlField.setBounds(228, 30, 96, 19);
	    panel.add(urlField);
	    urlField.setColumns(10);

	    releaseDateField = new JTextField();
	    releaseDateField.setBounds(336, 30, 96, 19);
	    panel.add(releaseDateField);
	    releaseDateField.setColumns(10);

	    btnNewButton = new JButton("Insert");
	    btnNewButton.setBounds(188, 68, 104, 21);
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		insertProductInfo();
	    	}
	    });
	    panel.add(btnNewButton);

	    JLabel lblTitle = new JLabel("Title");
	    lblTitle.setBounds(51, 7, 25, 13);
	    panel.add(lblTitle);

	    JLabel lblAuthor = new JLabel("Author");
	    lblAuthor.setBounds(143, 7, 50, 13);
	    panel.add(lblAuthor);

	    JLabel lblUrl = new JLabel("URL");
	    lblUrl.setBounds(259, 7, 50, 13);
	    panel.add(lblUrl);

	    JLabel lblDate = new JLabel("Release");
	    lblDate.setBounds(359, 7, 50, 13);
	    panel.add(lblDate);

	}

	private boolean insertProductInfo() {
		ProductInfoBean info = new ProductInfoBean(	-1,
													titleField.getText(),
													authorField.getText(),
													urlField.getText(),
													Integer.parseInt(releaseDateField.getText()),
													0);

		int lineCount = new ConnectDB().insertProductInfo(info);
		if (lineCount != 1) {
			return false;
		};
		model.updateProductInfo(info);
////	    //remove(sp);
//
//	    //tabledata = new ShowProductList().getProductStrAry();
//
//	    table = new JTable(tabledata, columnNames);
////	    contentPane.add(table, BorderLayout.CENTER);
////	    sp = new JScrollPane(table);
////	    sp.setPreferredSize(new Dimension(400, 140));
////
//	    JPanel p = new JPanel();
//	    p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//	    p.add(sp);
//
//	    getContentPane().add(p, BorderLayout.NORTH);
//
//	    JPanel panel = new JPanel();
//	    getContentPane().add(panel, BorderLayout.CENTER);

		return true;
	}
}
