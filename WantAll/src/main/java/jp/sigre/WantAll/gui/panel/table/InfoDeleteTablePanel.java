package jp.sigre.WantAll.gui.panel.table;

import javax.swing.JOptionPane;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;

public class InfoDeleteTablePanel extends TablePanel {

	public InfoDeleteTablePanel() {
		super();

	}

	public void deleteDialog() {
		int option = JOptionPane.showConfirmDialog(this, "削除しますか", "確認", 2);//showConfirmDialog(this, "男性ですか？");

	    if (option == JOptionPane.YES_OPTION){
	    	delete();
	    }else if (option == JOptionPane.CANCEL_OPTION){

	    }
	}

	public void delete9Dialog() {
		int option = JOptionPane.showConfirmDialog(this, "削除しますか", "確認", 2);//showConfirmDialog(this, "男性ですか？");

	    if (option == JOptionPane.YES_OPTION){
	    	delete9();
	    }else if (option == JOptionPane.CANCEL_OPTION){

	    }
	}

	private void delete9() {
		for (int row = 0; row <model.getRowCount(); row++) {
			if (model.getValueAt(row, 5).equals("9")) {
				ProductInfoBean info = getInfoFromTable(row);
				int count = new ConnectDB().deleteProductInfo(info);
				if (count == 1 ) {
					System.out.println("remove9");
					model.removeRow(row);
					row--;
				} else {
					System.out.println(info.toString() + " " + count);
				}
			}
		}
		table.repaint();
	}

	private void delete() {
		for (int row = 0; row <model.getRowCount(); row++) {
			if ((boolean)model.getValueAt(row, 6)) {
				ProductInfoBean info = getInfoFromTable(row);
				int count = new ConnectDB().deleteProductInfo(info);
				if (count == 1 ) {
					System.out.println("remove");
					model.removeRow(row);
					row--;
				} else {
					System.out.println(info.toString() + " " + count);
				}
			}
		}
		table.repaint();
	}

	private ProductInfoBean getInfoFromTable(int row) {
		int	   id	   = new Integer(model.getValueAt(row, 0).toString());
		String title   =	 (String)model.getValueAt(row, 1);
		String author  =	 (String)model.getValueAt(row, 2);
		String url     =	 (String)model.getValueAt(row, 3);
		int	   release = new Integer(model.getValueAt(row, 4).toString());
		int    flg	   = new Integer(model.getValueAt(row, 5).toString());
		ProductInfoBean info = new ProductInfoBean(id, title, author, url, release, flg);

		return info;
	}

	@Override
	public void setProductInfo() {
		model.setProductInfoAll(false);
	}

}
