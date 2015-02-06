package jp.sigre.WantAll.gui.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jp.sigre.WantAll.database.productinfo.ConnectDB;
import jp.sigre.WantAll.gui.ProductInfoTableModel;


public class FlagChangeListPanel extends JPanel {
	private JTable table;

	String[] columnNames;
	String[][] tabledata;
	JScrollPane sp = null;
	ProductInfoTableModel model;
	String selected;

	JButton searchButton;
	JComboBox<String> combo;

	public FlagChangeListPanel() {
		this.setLayout(null);
		this.setSize(400,200);

		model = new ProductInfoTableModel();
		model.setProductInfoAll(false);
		table = new JTable(model);

		sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(400, 140));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.add(sp);


	}

	public void updateDialog(String selected) {
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


}
