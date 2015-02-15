/**
 *
 */
package jp.sigre.WantAll.gui.panel.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;
import jp.sigre.WantAll.downloadinfo.parse.DownloadInfo;
import jp.sigre.WantAll.gui.ProductInfoTableModel;
import jp.sigre.WantAll.gui.panel.table.InfoInsertTablePanel;

/**
 * @author sigre
 *
 */
public class InfoInsertControlPanel extends ControlPanel {

	private JTextField titleField;
	private JTextField authorField;
	private JTextField urlField;
	private JTextField releaseDateField;

	private JButton insertButton;
	private JButton urlInsertButton;
	private JButton btnReset;

	String[] columnNames;
	String[][] tabledata;
	private JTextField textField;

	ProductInfoTableModel model;

	InfoInsertTablePanel listPanel;

	public InfoInsertControlPanel(InfoInsertTablePanel listPanel) {
		this.listPanel = listPanel;
		model = new ProductInfoTableModel();

		titleField = new JTextField();
		titleField.setBounds(12, 30, 96, 19);
		//StitleField.setInputVerifier(new ProductTitleValidator());
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
				String releaseStr = releaseDateField.getText();
				int release = releaseStr.equals("") ? 00000000 : Integer.parseInt(releaseStr);
				ProductInfoBean info = new ProductInfoBean(	-1,
						titleField.getText(),
						authorField.getText(),
						urlField.getText(),
						release,
						0);

				if (validateInput(info)) {
					listPanel.insertProductInfo(info);
				} else {
					JOptionPane.showMessageDialog(getParent(), "考え直せ。");
				}
			}

			if(event.getSource()  ==  urlInsertButton)  {
				System.out.println(textField.getText());
				ProductInfoBean info = new DownloadInfo().get(textField.getText());
				//System.out.println(info.getTitle());
				if (validateInput(info)) {
					listPanel.insertProductInfo(info);
				} else {
					JOptionPane.showMessageDialog(getParent(), "考え直せ。");
				}			}
			if(event.getSource()  ==  btnReset)  {
				listPanel.resetTable();
			}
		}
	}

	private boolean validateInput(ProductInfoBean info) {
		return validateTitle(info) && validateReleaseDate(info);
	}

	private boolean validateInput() {
		return validateTitle() && validateReleaseDate();
	}

	private boolean validateTitle() {
		boolean result = false;

		String title = titleField.getText();
		if (title.length() == 0) {
			result = false;
		} else {
			result = true;
		}

		System.out.println("isexist " + isAlreadyExist(title));

		return result && !isAlreadyExist(title);
	}

	private boolean validateTitle(ProductInfoBean info) {
		boolean result = false;

		String title = info.getTitle();
		if (title.length() == 0) {
			result = false;
		} else {
			result = true;
		}

		System.out.println("isexist " + isAlreadyExist(title));

		return result && !isAlreadyExist(title);
	}

	private boolean validateReleaseDate() {
		boolean lengthResult = false;
		boolean dateResult   = false;

		String dateStr = releaseDateField.getText();

		if (dateStr.length() == 0) {
			lengthResult = true;
			dateResult   = true;
		} else if (dateStr.length() == 8) {
			lengthResult = true;

			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				format.setLenient(false);
	            format.parse(dateStr);
	            dateResult = true;
	        } catch (ParseException e) {
	            dateResult = false;
	        }
		}

		System.out.println("length"+ lengthResult);
		System.out.println("date"+ dateResult);


		return lengthResult && dateResult;
	}

	private boolean validateReleaseDate(ProductInfoBean info) {
		boolean lengthResult = false;
		boolean dateResult   = false;

		String dateStr = String.valueOf(info.getReleaseDate());

		if (dateStr.length() == 0) {
			lengthResult = true;
			dateResult   = true;
		} else if (dateStr.length() == 8) {
			lengthResult = true;

			try {
				SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
				format.setLenient(false);
	            format.parse(dateStr);
	            dateResult = true;
	        } catch (ParseException e) {
	            dateResult = false;
	        }
		}

		System.out.println("length"+ lengthResult);
		System.out.println("date"+ dateResult);


		return lengthResult && dateResult;
	}

	private boolean isAlreadyExist(String title) {
		boolean result =  new ConnectDB().isExist(title);

		return result;
	}
}
