/**
 *
 */
package jp.sigre.WantAll.gui.panel.table;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;



/**
 * @author sigre
 *
 */
public class InfoInsertTablePanel extends TablePanel {
	boolean checkbox;

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