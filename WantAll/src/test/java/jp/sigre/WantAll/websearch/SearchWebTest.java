package jp.sigre.WantAll.websearch;

import jp.sigre.WantAll.ProductInfoBean;

import org.junit.Test;

public class SearchWebTest {

	@Test
	public void testSearchGoogleWithTitle() {
		ProductInfoBean info = new ProductInfoBean( 1,
													"とある魔術の禁書目録",
													"かまちかずま",
													"http,com",
													20110101,
													0);
		new SearchWeb().searchGoogleWithTitle(info);
	}

}
