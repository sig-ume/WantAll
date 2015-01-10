/**
 *
 */
package jp.sigre.WantAll.gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;

/**
 * @author sigre
 * JTable出力Model
 */
public class ProductInfoTableModel extends DefaultTableModel {
	ConnectDB db = new ConnectDB();

	public ProductInfoTableModel() {
		super();
		String[] columns = db.getColumns();
		super.setColumnCount(columns.length);
		super.setRowCount(0);
		super.setColumnIdentifiers(columns);
		setProductInfo();
	}

	private void setProductInfo() {
		List<ProductInfoBean> list = new ConnectDB().getProductInfoList();

		for (ProductInfoBean info : list) {
			super.addRow(info.getInfoAsAry());

		}
	}

	/**
	 * DB更新後にTableにデータを追加。
	 * TODO:やるべきかわからんが、DBに接続して更新された行を取得→表示にすべきか
	 * 現状は、入力データを直で表示。上記を行うとDB接続増える、別にいいけど。
	 * @param info
	 */
	public void updateProductInfo(ProductInfoBean info) {

		super.addRow(info.getInfoAsAry());
	}
}
