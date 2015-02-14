/**
 *
 */
package jp.sigre.WantAll.database.productinfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.sigre.WantAll.ProductInfoBean;

/**
 * @author sigre
 *
 */
public class ConvertResultSet {

	public List<ProductInfoBean> convertProjectInfo(ResultSet rs) {
		List<ProductInfoBean> result = new ArrayList<ProductInfoBean>();

		try {
			while (rs.next()) {
				ProductInfoBean info = rsToBean(rs);
				result.add(info);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ProductInfoBean rsToBean(ResultSet rs) throws SQLException {
		ProductInfoBean info = new ProductInfoBean();
		info.setId			(rs.getInt	 (1));
		info.setTitle		(rs.getString(2));
		info.setAuthor		(rs.getString(3));
		info.setReleaseDate	(rs.getInt	 (4));
		info.setUrl			(rs.getString(5));
		info.setFlag		(rs.getInt	 (6));
//		info.setId			(rs.getInt	 ("Id"));
//		info.setTitle		(rs.getString("Title"));
//		info.setAuthor		(rs.getString("Author"));
//		info.setReleaseDate	(rs.getInt	 ("ReleaseDate"));
//		info.setUrl			(rs.getString("URL"));
//		info.setFlag		(rs.getInt	 ("Flg"));

		return info;
	}
}
