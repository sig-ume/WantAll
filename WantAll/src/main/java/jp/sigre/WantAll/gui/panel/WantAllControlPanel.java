/**
 *
 */
package jp.sigre.WantAll.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.downloadinfo.parse.DownloadInfo;
import jp.sigre.WantAll.gui.ProductInfoTableModel;

/**
 * @author sigre
 *
 */
public class WantAllControlPanel extends JPanel {

	private JTextField titleField;
	private JTextField authorField;
	private JTextField urlField;
	private JTextField releaseDateField;

	private JButton insertButton;
	private JButton searchButton;
	private JButton urlInsertButton;
	private JButton btnReset;

	String[] columnNames;
	String[][] tabledata;
	private JTextField textField;

	ProductInfoTableModel model;

	WantAllListPanel listPanel;

	public WantAllControlPanel(WantAllListPanel listPanel) {
		this.listPanel = listPanel;
		model = new ProductInfoTableModel();

		titleField = new JTextField();
		titleField.setBounds(12, 30, 96, 19);
		this.add(titleField);
		titleField.setColumns(10);

		authorField = new JTextField();
		authorField.setBounds(120, 30, 96, 19);
		this.add(authorField);
		authorField.setColumns(10);

		urlField = new JTextField();
		urlField.setBounds(228, 30, 96, 19);
		this.add(urlField);
		urlField.setColumns(10);

		releaseDateField = new JTextField();
		releaseDateField.setBounds(336, 30, 96, 19);
		this.add(releaseDateField);
		releaseDateField.setColumns(10);

		insertButton = new JButton("Insert");
		insertButton.setBounds(157, 59, 104, 21);
		insertButton.addActionListener(new ProductInfoListener());
		this.add(insertButton);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(51, 7, 25, 13);
		this.add(lblTitle);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(143, 7, 50, 13);
		this.add(lblAuthor);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(259, 7, 50, 13);
		this.add(lblUrl);

		JLabel lblDate = new JLabel("Release");
		lblDate.setBounds(359, 7, 50, 13);
		this.add(lblDate);

		searchButton = new JButton("Search");
		searchButton.setBounds(80, 136, 91, 21);
		searchButton.addActionListener(new ProductInfoListener());
		this.add(searchButton);

		textField = new JTextField();
		textField.setBounds(113, 99, 340, 19);
		this.add(textField);
		textField.setColumns(10);

		urlInsertButton = new JButton("URL");
		urlInsertButton.setBounds(17, 98, 91, 21);
		urlInsertButton.addActionListener(new ProductInfoListener());
		this.add(urlInsertButton);

		btnReset = new JButton("Reset");
		btnReset.setBounds(233, 136, 91, 21);
		btnReset.addActionListener(new ProductInfoListener());
		this.add(btnReset);

	}

	public class ProductInfoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()  ==  insertButton)  {
				ProductInfoBean info = new ProductInfoBean(	-1,
						titleField.getText(),
						authorField.getText(),
						urlField.getText(),
						Integer.parseInt(releaseDateField.getText()),
						0);
				listPanel.insertProductInfo(info);
			}
			if(event.getSource()  ==  searchButton)  {
				listPanel.search();
			}
			if(event.getSource()  ==  urlInsertButton)  {
				System.out.println(textField.getText());
				ProductInfoBean info = new DownloadInfo().get(textField.getText());
				//System.out.println(info.getTitle());
				listPanel.insertProductInfo(info);
			}
			if(event.getSource()  ==  btnReset)  {
				listPanel.resetTable();
			}
		}
	}
}
