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
				ProductInfoBean info = new ProductInfoBean();
				info.setId			(rs.getInt	 ("Id"));
				info.setTitle		(rs.getString("Title"));
				info.setAuthor		(rs.getString("Author"));
				info.setReleaseDate	(rs.getInt	 ("ReleaseDate"));
				info.setUrl			(rs.getString("URL"));
				info.setFlag		(rs.getInt	 ("Flg"));
				result.add(info);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
