package jp.sigre.WantAll.gui.standalone;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;
import jp.sigre.WantAll.gui.ProductInfoTableModel;

public class InfoDeleteGui extends JFrame {

	private JTable table;

	String[] columnNames;
	String[][] tabledata;
	JScrollPane sp = null;
	ProductInfoTableModel model;

	JButton deleteButton;
	JButton delete9Button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoDeleteGui frame = new InfoDeleteGui();
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
	public InfoDeleteGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 400);

		model = new ProductInfoTableModel();
		model.setProductInfoAll(false);
		table = new JTable(model);

		sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(400, 140));

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		p.add(sp);

		getContentPane().add(p, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		deleteButton = new JButton("Delete");
		deleteButton.setBounds(170, 138, 91, 21);
		deleteButton.addActionListener(new ProductInfoListener());
		panel.add(deleteButton);

		delete9Button = new JButton("Delete 9");
		delete9Button.setBounds(170, 77, 91, 21);
		delete9Button.addActionListener(new ProductInfoListener());
		panel.add(delete9Button);

	}

	private void deleteDialog() {
		int option = JOptionPane.showConfirmDialog(this, "削除しますか", "確認", 2);//showConfirmDialog(this, "男性ですか？");

	    if (option == JOptionPane.YES_OPTION){
	    	delete();
	    }else if (option == JOptionPane.CANCEL_OPTION){

	    }
	}

	private void delete9Dialog() {
		int option = JOptionPane.showConfirmDialog(this, "削除しますか", "確認", 2);//showConfirmDialog(this, "男性ですか？");

	    if (option == JOptionPane.YES_OPTION){
	    	delete9();
	    }else if (option == JOptionPane.CANCEL_OPTION){

	    }
	}

	private void delete9() {
		for (int row = 0; row <model.getRowCount(); row++) {
			if (model.getValueAt(row, 5).equals("9")) {
				int	   id	   = new Integer(model.getValueAt(row, 0).toString());
				String title   =	 (String)model.getValueAt(row, 1);
				String author  =	 (String)model.getValueAt(row, 2);
				String url     =	 (String)model.getValueAt(row, 3);
				int	   release = new Integer(model.getValueAt(row, 4).toString());
				int    flg	   = new Integer(model.getValueAt(row, 5).toString());
				ProductInfoBean info = new ProductInfoBean(id, title, author, url, release, flg);
				int count = new ConnectDB().deleteProductInfo(info);
				if (count == 1 ) {
					System.out.println("remove9");
					model.removeRow(row);
					row--;
				} else {
					System.out.println(info.getInfoAsAry().toString());
				}
			}
		}
		table.repaint();
	}

	private void delete() {
		for (int row = 0; row <model.getRowCount(); row++) {
			if ((boolean)model.getValueAt(row, 6)) {
				int	   id	   = new Integer(model.getValueAt(row, 0).toString());
				String title   =	 (String)model.getValueAt(row, 1);
				String author  =	 (String)model.getValueAt(row, 2);
				String url     =	 (String)model.getValueAt(row, 3);
				int	   release = new Integer(model.getValueAt(row, 4).toString());
				int    flg	   = new Integer(model.getValueAt(row, 5).toString());
				ProductInfoBean info = new ProductInfoBean(id, title, author, url, release, flg);
				int count = new ConnectDB().deleteProductInfo(info);
				if (count == 1 ) {
					System.out.println("remove");
					model.removeRow(row);
					row--;
				} else {
					System.out.println(info.getInfoAsAry().toString());
				}
			}
		}
		table.repaint();
	}

	private class ProductInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()  ==  deleteButton)  {
				deleteDialog();
			}
			if(event.getSource()  ==  delete9Button)  {
				delete9Dialog();
			}

		}
	}
}
