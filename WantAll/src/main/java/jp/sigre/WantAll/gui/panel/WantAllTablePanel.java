/**
 *
 */
package jp.sigre.WantAll.gui.panel;

import java.util.ArrayList;
import java.util.List;

import jp.sigre.WantAll.websearch.CallBrowser;

/**
 * @author sigre
 *
 */
public class WantAllTablePanel extends TablePanel {
	boolean checkbox = true;

	public WantAllTablePanel() {
		super();


	}

	public void search() {
		for (int row = 0; row <model.getRowCount(); row++) {
			System.out.println(model.getValueAt(row, 6));
			if ((boolean)model.getValueAt(row, 6)) {
				System.out.println("google");
				List<String> searchWords = new ArrayList<>();
				searchWords.add((String)model.getValueAt(row, 1));
				new CallBrowser().callGoogle(searchWords);
			} else {
				System.out.println();
			}
		}
		System.out.println("test end");

	}

	@Override
	public void setProductInfo() {
		model.setProductInfo(true);

	}

}
