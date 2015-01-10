/**
 *
 */
package jp.sigre.WantAll.database;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;

import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author sigre
 *
 */
@RunWith(JUnit4.class)
public class ConnectDBTest {
	ConnectDB cdb = new ConnectDB();

	@Test
	public void connectStatementTest1() {
		Statement stmt = cdb.connectStatement();
		assertThat(stmt, is(notNullValue()));
	}

	@Test
	public void closeStatementTest() throws SQLException {
		cdb.getConnection().createStatement();

		boolean actual = cdb.closeStatement();
		assertThat(actual, is(true));
	}

	@Test
	public void getProductResultSetTest() throws SQLException {
		List<ProductInfoBean> actual = cdb.getProductInfoList();
		ProductInfoBean expected = new ProductInfoBean(	2,
														"とある魔術の禁書目録",
														"かまちかずま",
														"http://index.com",
														20120101,
														0);
		assertThat(actual, hasItem(SamePropertyValuesAs.samePropertyValuesAs(expected)));
	}

	@Test
	public void getColumnsTest() {
		String[] actual   = cdb.getColumns();
		String[] expected = {"Id", "Title", "Author", "URL", "ReleaseDate", "Flg"};
		assertThat(actual, is(expected));
	}
}
