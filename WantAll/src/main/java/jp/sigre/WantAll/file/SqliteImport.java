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

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import jp.sigre.WantAll.ProductInfoBean;
import jp.sigre.WantAll.database.productinfo.ConnectDB;
import jp.sigre.WantAll.database.productinfo.ConvertResultSet;

/**
 * @author sigre
 *
 */
public class SqliteImport {

	JFrame jFrame;
	File exported;
	public SqliteImport(JFrame frame) {
		jFrame = frame;
	}

	public void dialogImportFile() {
		JFileChooser filechooser = new JFileChooser("C:\\Users\\sigre\\git\\WantAll\\WantAll\\db");
		int selected = filechooser.showOpenDialog(jFrame);
		if (selected == JFileChooser.APPROVE_OPTION){
			exported = filechooser.getSelectedFile();

			importFile();
		}else if (selected == JFileChooser.CANCEL_OPTION){
			//label.setText("キャンセルされました");
		}else if (selected == JFileChooser.ERROR_OPTION){
			//label.setText("エラー又は取消しがありました");
		}
	}

//
//	private File getSqliteFile() {
//		File file = new File("db/ProductInfo.db");
//
//		return file;
//	}

	public void importFile() {
		try {
			Connection con = getConnection();
			Statement st = con.createStatement();

			st.execute("attach '" + exported.getPath() + "' as exported");
			//ResultSet rs = st.executeQuery("SELECT * FROM main.ProductInfo;");
			ResultSet r2 = st.executeQuery("SELECT * FROM exported.ProductInfo;");
			while (r2.next()) {
				System.out.println(r2.getString(2));
			}
			System.out.println("-------");

			String sql =  "select * from exported.ProductInfo "
					+ "left outer join main.ProductInfo on (main.ProductInfo.Title = exported.ProductInfo.Title) "
					+ "where main.ProductInfo.id is null;";
			ResultSet r3 = st.executeQuery(sql);

//			while (r3.next()) {
//				for (int i = 1; i < 13; i++) {
//					String str = (r3.getString(i)== null) ?  "null" :r3.getString(i) ;
//					if (str.equals("")) str = "blank";
//					System.out.print(str+ " ");
//				}
//				System.out.println();
//			}
//			if (r3.first()) {
//				System.out.println("●");
//			} else {
//				System.out.println("閥");
//			}

			//r3をインポート
			System.out.println("r3インポート");
			for (ProductInfoBean info : new ConvertResultSet().convertProjectInfo(r3)) {
				System.out.println(info.getTitle());
				new ConnectDB().insertProductInfo(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
