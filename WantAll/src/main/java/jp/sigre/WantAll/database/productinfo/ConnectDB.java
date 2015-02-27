/**
 *
 */
package jp.sigre.WantAll.database.productinfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jp.sigre.WantAll.ProductInfoBean;

/**
 * @author sigre
 * ProductInfoTableに接続、やり取りを行う
 */
public class ConnectDB {
	Connection con;
	Statement stmt;

	/**
	 * 実質、接続テスト用
	 * @return
	 */
	public Statement connectStatement() {
		try {
			con = getConnection();
			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (stmt != null) stmt.close();
				if (con  != null) con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			closeStatement();
		}
		return stmt;
	}

	/**
	 * ProductInfoTableのデータをBeanに格納してリスト化
	 * @return
	 */
	public List<ProductInfoBean> getProductInfoList() {
		try {
			con = getConnection();
			String sql = "SELECT * FROM ProductInfo WHERE flag != 9 ORDER BY id DESC;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return new ConvertResultSet().convertProjectInfo(rs);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  finally {
			closeStatement();
		}
		return null;
	}

	/**
	 * ProductInfoTableのデータをBeanに格納してリスト化
	 * @return
	 */
	public List<ProductInfoBean> getProductInfoListAll() {
		try {
			con = getConnection();
			String sql = "SELECT * FROM ProductInfo ORDER BY id DESC;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			return new ConvertResultSet().convertProjectInfo(rs);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  finally {
			closeStatement();
		}
		return null;
	}

	/**
	 * 商品を1件DBにInsertする
	 * @param info
	 * @return 更新件数
	 */
	public int insertProductInfo(ProductInfoBean info) {
		try {
			con = getConnection();
			String sql =  "INSERT INTO ProductInfo (Title, Author, URL, ReleaseDate, Flag) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, info.getTitle());
			pstmt.setString(2, info.getAuthor());
			pstmt.setString(3, info.getUrl());
			pstmt.setInt   (4, info.getReleaseDate());
			pstmt.setInt   (5, info.getFlag());

			return pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  finally {
			closeStatement();
		}
		return 0;
	}

	/**
	 * ProductInfoTableの列名一覧を取得
	 * @return
	 */
	public String[] getColumns() {

		try {
			con = getConnection();
			String sql = "SELECT * FROM ProductInfo;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			String result[] = new String[columnCount];
			for (int iLoop = 0 ;iLoop < columnCount ; iLoop ++){
				//カラム名取得
				result[iLoop] = metaData.getColumnName(iLoop + 1);
			}
			return result;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			closeStatement();
		}
		return null;
	}


	/**
	 * 商品を1件DBからDeleteする
	 * @param info
	 * @return 更新件数
	 */
	public int deleteProductInfo(ProductInfoBean info) {
		try {
			con = getConnection();
			String sql =  "DELETE FROM ProductInfo "
					+ "WHERE	id = ?"
					+ "AND		title = ?"
					+ "AND		author = ?"
					+ "AND		url = ?"
					+ "AND		releasedate = ?"
					+ "AND		flg = ?;"
					;
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt   (1, info.getId());
			pstmt.setString(2, info.getTitle());
			pstmt.setString(3, info.getAuthor());
			pstmt.setString(4, info.getUrl());
			pstmt.setInt   (5, info.getReleaseDate());
			pstmt.setInt   (6, info.getFlag());

			return pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  finally {
			closeStatement();
		}
		return 0;
	}

	public int updateProductInfoFlg(int id, int updateFlg) {
		try {
			con = getConnection();
			String sql =  "UPDATE  ProductInfo "
					+ "SET 		flg = ?"
					+ "WHERE	id = ?";
			;
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt   (1, updateFlg);
			pstmt.setInt   (2, id);

			return pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  finally {
			closeStatement();
		}
		return 0;
	}

	public boolean isExist(String title) {
		boolean result = false;

		try {
			con = getConnection();
			String sql =  "SELECT * FROM ProductInfo "
					+ "WHERE title = ?;";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);

			result = pstmt.executeQuery().next();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}  finally {
			closeStatement();
		}
		return result;
	}


/**
 * DB切断。
 * @return
 */
public boolean closeStatement() {
	try {
		if (stmt != null) stmt.close();
		if (con  != null) con.close();
	} catch (SQLException e1) {
		e1.printStackTrace();
		return false;
	}
	return true;
}

public Connection getConnection() throws SQLException{
	try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	con = DriverManager
			.getConnection("jdbc:sqlite:db/ProductInfo.db");
	return con;
}


}
