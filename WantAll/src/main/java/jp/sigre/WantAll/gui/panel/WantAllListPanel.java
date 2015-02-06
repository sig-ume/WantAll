/**
 *
 */
package jp.sigre.WantAll.gui.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;
import jp.sigre.WantAll.gui.ProductInfoTableModel;



/**
 * @author sigre
 *
 */
public class WantAllListPanel extends JPanel {

	private JTable table;

	String[] columnNames;
	String[][] tabledata;
	JScrollPane sp = null;
	ProductInfoTableModel model;
	JLabel paneltitle;


	public WantAllListPanel() {
		this.setLayout(null);
		this.setSize(400,200);

		model = new ProductInfoTableModel();
		model.setProductInfo(true);
		table = new JTable(model);

		sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(400, 140));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.add(sp);


	}

//
//
//	public boolean insertProductInfo() {
//		ProductInfoBean info = new ProductInfoBean(	-1,
//				titleField.getText(),
//				authorField.getText(),
//				urlField.getText(),
//				Integer.parseInt(releaseDateField.getText()),
//				0);
//
//		int lineCount = new ConnectDB().insertProductInfo(info);
//		if (lineCount != 1) {
//			return false;
//		};
//		model.updateProductInfo(info);
//
//		return true;
//	}

	public boolean insertProductInfo(ProductInfoBean info) {

		int lineCount = new ConnectDB().insertProductInfo(info);
		if (lineCount != 1) {
			return false;
		};
		model.updateProductInfo(info);

		return true;
	}



	public void resetTable() {
		//remove(sp);
		model = new ProductInfoTableModel();
		model.setProductInfo(true);
		table.setModel(model);
	}
}