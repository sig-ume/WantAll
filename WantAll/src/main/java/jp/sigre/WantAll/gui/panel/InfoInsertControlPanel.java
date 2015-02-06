/**
 *
 */
package jp.sigre.WantAll.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import jp.sigre.WantAll.gui.ProductInfoTableModel;

/**
 * @author sigre
 *
 */
public class InfoInsertControlPanel extends JPanel {


	private JButton searchButton;
	private JButton btnReset;


	ProductInfoTableModel model;

	InfoInsertListPanel listPanel;

	public InfoInsertControlPanel(InfoInsertListPanel listPanel) {
		this.listPanel = listPanel;
		model = new ProductInfoTableModel();



		searchButton = new JButton("Search");
		searchButton.setBounds(80, 136, 91, 21);
		searchButton.addActionListener(new ProductInfoListener());
		this.add(searchButton);


		btnReset = new JButton("Reset");
		btnReset.setBounds(233, 136, 91, 21);
		btnReset.addActionListener(new ProductInfoListener());
		this.add(btnReset);

	}

	public class ProductInfoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {

			if(event.getSource()  ==  searchButton)  {
				listPanel.search();
			}

		}
	}
}
