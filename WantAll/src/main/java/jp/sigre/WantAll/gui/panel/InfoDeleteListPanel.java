package jp.sigre.WantAll.gui.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import jp.sigre.WantAll.gui.ProductInfoTableModel;

public class InfoDeleteListPanel extends JPanel {

	private JTable table;

	String[] columnNames;
	String[][] tabledata;
	JScrollPane sp = null;
	ProductInfoTableModel model;

	JButton deleteButton;
	JButton delete9Button;


	public InfoDeleteListPanel() {
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

}
