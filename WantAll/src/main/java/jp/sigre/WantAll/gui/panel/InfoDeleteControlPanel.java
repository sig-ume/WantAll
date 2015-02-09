/**
 *
 */
package jp.sigre.WantAll.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author sigre
 *
 */
public class InfoDeleteControlPanel extends JPanel {
	JButton deleteButton;
	JButton delete9Button;
	InfoDeleteTablePanel panel;

	public InfoDeleteControlPanel(InfoDeleteTablePanel panel) {
		this.panel = panel;

		this.setLayout(null);

		deleteButton = new JButton("Delete");
		deleteButton.setBounds(170, 138, 91, 21);
		deleteButton.addActionListener(new ProductInfoListener());
		this.add(deleteButton);

		delete9Button = new JButton("Delete 9");
		delete9Button.setBounds(170, 77, 91, 21);
		delete9Button.addActionListener(new ProductInfoListener());
		this.add(delete9Button);
	}

	private class ProductInfoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()  ==  deleteButton)  {
				panel.deleteDialog();
			}
			if(event.getSource()  ==  delete9Button)  {
				panel.delete9Dialog();
			}

		}
	}
}
