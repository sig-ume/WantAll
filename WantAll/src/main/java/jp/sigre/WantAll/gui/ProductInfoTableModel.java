/**
 *
 */
package jp.sigre.WantAll.gui;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

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

		String[] dbColumns = db.getColumns();
		String[] columns = new String[7];
		System.arraycopy(dbColumns, 0, columns, 0, dbColumns.length);
		columns[columns.length-1] = "CheckBox";
		super.setColumnCount(columns.length);
		super.setRowCount(0);
		super.setColumnIdentifiers(columns);
	}

	public void setProductInfo(boolean bool) {
		List<ProductInfoBean> list = new ConnectDB().getProductInfoList();

		setRows(list, bool);
	}


	public void setProductInfoAll(boolean bool) {
		List<ProductInfoBean> list = new ConnectDB().getProductInfoListAll();

		setRows(list, bool);
	}

	private void setRows(List<ProductInfoBean> list, boolean bool) {
		for (ProductInfoBean info : list) {
			Object[] row = info.getInfoAsAry();
			Vector<Object> rowAddedBool = new Vector<>(Arrays.asList(row));
			rowAddedBool.add(new Boolean(bool));
			super.addRow(rowAddedBool);
		}
	}


	public void resetProductInfo(boolean bool) {
		int rowCount = super.getRowCount();
		for (int i = 0; i < rowCount; i++) {
			super.removeRow(0);
		}

		setProductInfo(bool);
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

	public Class<? extends Object> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
}
