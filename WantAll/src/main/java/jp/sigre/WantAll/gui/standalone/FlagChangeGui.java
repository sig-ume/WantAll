package jp.sigre.WantAll.gui.standalone;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jp.sigre.WantAll.database.productinfo.ConnectDB;
import jp.sigre.WantAll.gui.ProductInfoTableModel;

public class FlagChangeGui extends JFrame {

	private JTable table;

	String[] columnNames;
	String[][] tabledata;
	JScrollPane sp = null;
	ProductInfoTableModel model;
	String selected;

	JButton searchButton;
	JComboBox<String> combo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlagChangeGui frame = new FlagChangeGui();
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
	public FlagChangeGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 400);

		model = new ProductInfoTableModel();
		model.setProductInfoAll(false);
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

		Vector<String> combodata = new Vector<>();
		combodata.add("未入手");
		combodata.add("入手済み");
		combodata.add("不要");
		combo = new JComboBox<>(combodata);
		combo.setBounds(204, 57, 108, 19);
		panel.add(combo);

		searchButton = new JButton("update");
		searchButton.setBounds(170, 138, 91, 21);
		searchButton.addActionListener(new ProductInfoListener());
		panel.add(searchButton);
	}

	private void updateDialog(String selected) {
		int option = JOptionPane.showConfirmDialog(this, "フラグを変更しますか"+selected, "確認", 2);
		if (option == JOptionPane.YES_OPTION){
			update(selected);
		}else if (option == JOptionPane.CANCEL_OPTION){

		}
	}

	private void update(String selected) {
		int updateFlg = -1;
		if (selected.equals("未入手")) {
			updateFlg = 0;
		} else if (selected.equals("入手済み")) {
			updateFlg = 1;
		} else if (selected.equals("不要")) {
			updateFlg = 9;
		}
		for (int row = 0; row <model.getRowCount(); row++) {
			if ((boolean)model.getValueAt(row, 6)) {
				int	   id	   = new Integer(model.getValueAt(row, 0).toString());

				int count = new ConnectDB().updateProductInfoFlg(id, updateFlg);
				if (count == 1 ) {
					System.out.println("update flg");
					model.setValueAt(updateFlg, row, 5);
				} else {
				}
			}
		}
		table.repaint();
	}

	private class ProductInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()  ==  searchButton)  {
				selected = (String)combo.getSelectedItem();
				updateDialog(selected);
			}

		}
	}
}
