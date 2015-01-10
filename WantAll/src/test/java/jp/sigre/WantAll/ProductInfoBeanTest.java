package jp.sigre.WantAll;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProductInfoBeanTest {
	ProductInfoBean info = new ProductInfoBean(
			1,
			"とある魔術の禁書目録",
			"かまちかずま",
			"http,com",
			20110101,
			0);

	@Test
	public void testGetInfoAsAry() {
		String[] strAry = info.getInfoAsAry();
		String[] expected = {"1", "とある魔術の禁書目録", "かまちかずま", "http,com", "20110101", String.valueOf(0)};
		assertThat(strAry, is(expected));
	}

}
