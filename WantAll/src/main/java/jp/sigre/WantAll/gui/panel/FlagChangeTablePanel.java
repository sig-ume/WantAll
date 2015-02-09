package jp.sigre.WantAll.gui.panel;

import javax.swing.JOptionPane;

import jp.sigre.WantAll.database.productinfo.ConnectDB;


public class FlagChangeTablePanel extends TablePanel {


	public FlagChangeTablePanel() {
		super();
	}

	public void updateDialog(String selected) {
		int option = JOptionPane.showConfirmDialog(this, "フラグを変更しますか"+selected, "確認", 2);
		if (option == JOptionPane.YES_OPTION){
			update(selected);
		}else if (option == JOptionPane.CANCEL_OPTION){

		}
	}

	private void update(String selected) {
		int updateFlg = -1;
		if (selected.equals("未入手")) {
			updateFlg = 0;
		} else if (selected.equals("入手済み")) {
			updateFlg = 1;
		} else if (selected.equals("不要")) {
			updateFlg = 9;
		}
		for (int row = 0; row <model.getRowCount(); row++) {
			if ((boolean)model.getValueAt(row, 6)) {
				int	   id	   = new Integer(model.getValueAt(row, 0).toString());

				int count = new ConnectDB().updateProductInfoFlg(id, updateFlg);
				if (count == 1 ) {
					System.out.println("update flg");
					model.setValueAt(updateFlg, row, 5);
				} else {
				}
			}
		}
		table.repaint();
	}

	@Override
	public void setProductInfo() {
		model.setProductInfoAll(false);

	}


}
