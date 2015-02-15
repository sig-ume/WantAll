/**
 *
 */
package jp.sigre.WantAll.gui.panel.table;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jp.sigre.WantAll.gui.ProductInfoTableModel;

/**
 * @author sigre
 *
 */
public abstract class TablePanel extends JPanel {

	JTable table;

	ProductInfoTableModel model;

	boolean flgCheckAll = true;
	boolean checkbox = true;

	public TablePanel() {
		this.setLayout(null);
		this.setSize(400,200);

		model = new ProductInfoTableModel();
		//model.setProductInfo(true);
		table = new JTable(model);

		JScrollPane sp = new JScrollPane(table);
		sp.setPreferredSize(new Dimension(400, 140));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		this.add(sp);

		setProductInfo();
	}

	public abstract void setProductInfo();

	public boolean setAllCheckBox() {
		for (int row = 0; row <model.getRowCount(); row++) {
			model.setValueAt(flgCheckAll, row, 6);
		}

		flgCheckAll = !flgCheckAll;
		return flgCheckAll;
	}

	public void resetTable() {
		model = new ProductInfoTableModel();
		setProductInfo();
		table.setModel(model);
	}}
