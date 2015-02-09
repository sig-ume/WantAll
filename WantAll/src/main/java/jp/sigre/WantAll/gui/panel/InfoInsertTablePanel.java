/**
 *
 */
package jp.sigre.WantAll.gui.panel;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;
import jp.sigre.WantAll.gui.ProductInfoTableModel;



/**
 * @author sigre
 *
 */
public class InfoInsertTablePanel extends TablePanel {

	public InfoInsertTablePanel() {
		super();
	}



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



	@Override
	public void setProductInfo() {
		model.setProductInfo(true);
	}

//残骸
//
//			public boolean insertProductInfo() {
//				ProductInfoBean info = new ProductInfoBean(	-1,
//						titleField.getText(),
//						authorField.getText(),
//						urlField.getText(),
//						Integer.parseInt(releaseDateField.getText()),
//						0);
//
//				int lineCount = new ConnectDB().insertProductInfo(info);
//				if (lineCount != 1) {
//					return false;
//				};
//				model.updateProductInfo(info);
//
//				return true;
//			}
}