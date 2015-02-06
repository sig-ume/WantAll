/**
 *
 */
package jp.sigre.WantAll.gui.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jp.sigre.WantAll.gui.ProductInfoTableModel;
import jp.sigre.WantAll.websearch.CallBrowser;

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

	public void search() {
		System.out.println("test start");
		for (int row = 0; row <model.getRowCount(); row++) {
			System.out.println(model.getValueAt(row, 6));
			if ((boolean)model.getValueAt(row, 6)) {
				System.out.println("google");
				List<String> searchWords = new ArrayList<>();
				searchWords.add((String)model.getValueAt(row, 1));
				new CallBrowser().callGoogle(searchWords);
			} else {
				System.out.println();
			}
		}
		System.out.println("test end");

	}
}
