package jp.sigre.WantAll.websearch;

import jp.sigre.WantAll.ProductInfoBean;

public class SearchWeb {

	public void searchGoogleWithTitle(ProductInfoBean info) {
		new CallBrowser().call(new MakeURL().generateGoogleUri(info.getTitle()));
	}
}
