/**
 *
 */
package jp.sigre.WantAll.file;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author sigre
 *
 */
public class SqliteImportTest {

	@Test
	public void test() throws SQLException {
		File exported = new File("C:\\Users\\sigre\\git\\WantAll\\WantAll\\db\\exported.db");
		Connection con = getConnection();
		Statement st = con.createStatement();

		st.execute("attach '" + exported.getPath() + "' as exported");
		//ResultSet rs = st.executeQuery("SELECT * FROM main.ProductInfo;");
		ResultSet r2 = st.executeQuery("SELECT * FROM exported.ProductInfo;");
		while (r2.next()) {
			System.out.println(r2.getString(2));
		}
		System.out.println("-------");

		//※諸事情でmainとexportedが逆。本来はmain側がexported
		String sql =  "select * from exported.ProductInfo "
					+ "left outer join main.ProductInfo on (main.ProductInfo.Title = exported.ProductInfo.Title) "
					+ "where main.ProductInfo.id is null;";
		ResultSet r3 = st.executeQuery(sql);
		while (r3.next()) {
			for (int i = 1; i < 13; i++) {
				String str = (r3.getString(i)== null) ?  "null" :r3.getString(i) ;
				if (str.equals("")) str = "blank";
				System.out.print(str+ " ");
			}
			System.out.println();
		}
	}


	public Connection getConnection() throws SQLException{
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = DriverManager
				.getConnection("jdbc:sqlite:db/ProductInfo.db");
		return con;
	}
}
