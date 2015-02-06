/**
 *
 */
package jp.sigre.WantAll.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import jp.sigre.WantAll.gui.ProductInfoTableModel;

/**
 * @author sigre
 *
 */
public class FlagChangeControlPanel extends JPanel {
	ProductInfoTableModel model;
	String selected;

	JButton searchButton;
	JComboBox<String> combo;

	FlagChangeListPanel panel;

	public FlagChangeControlPanel(FlagChangeListPanel panel) {
		this.panel = panel;
		this.setLayout(null);

		Vector<String> combodata = new Vector<>();
		combodata.add("未入手");
		combodata.add("入手済み");
		combodata.add("不要");
		combo = new JComboBox<>(combodata);
		combo.setBounds(204, 57, 108, 19);
		this.add(combo);

		searchButton = new JButton("update");
		searchButton.setBounds(170, 138, 91, 21);
		searchButton.addActionListener(new ProductInfoListener());
		this.add(searchButton);
	}

	private class ProductInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()  ==  searchButton)  {
				selected = (String)combo.getSelectedItem();
				panel.updateDialog(selected);
			}

		}
	}
}
