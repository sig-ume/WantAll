/**
 *
 */
package jp.sigre.WantAll.database.productinfo;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import jp.sigre.WantAll.ProductInfoBean;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * @author sigre
 * ProductInfoTableに接続、やり取りを行う
 */
public class ConnectDB {
	Connection con;
	Statement stmt;

	private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

	Session session = null;


	public ConnectDB() {
		configureSessionFactory();
		session = sessionFactory.openSession();
	}

	private Transaction getSession() {
		session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();

		return trans;
	}

	private void closeSession() {
		session.close();
	}


    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.configure();

        Properties properties = configuration.getProperties();

        serviceRegistry = new ServiceRegistryBuilder().applySettings(properties).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

	/**
	 * ProductInfoTableのデータをBeanに格納してリスト化
	 * @return
	 */
	public List<ProductInfoBean> getProductInfoList() {
		session = sessionFactory.openSession();
        Criteria crit = session.createCriteria(ProductInfoBean.class);
        crit.add(Restrictions.not(Restrictions.eq("flag", 9)));
		List<ProductInfoBean> result = crit.list();
        closeSession();
        return result;
	}

	/**
	 * ProductInfoTableのデータをBeanに格納してリスト化
	 * @return
	 */
	public List<ProductInfoBean> getProductInfoListAll() {
		session = sessionFactory.openSession();
        List<ProductInfoBean> result = session.createCriteria(ProductInfoBean.class).list();
        closeSession();
        return result;
	}

	/**
	 * 商品を1件DBにInsertする
	 * @param info
	 * @return 更新件数
	 */
	public int insertProductInfo(ProductInfoBean info) {
		Transaction transaction = getSession();
		session.save(info);
		// Committing the change in the database.
        session.flush();
        transaction.commit();
		closeSession();

		return 1;
	}

	/**
	 * ProductInfoTableの列名一覧を取得
	 * @return
	 */
	public String[] getColumns() {

//		try {
//			con = getConnection();
//			String sql = "SELECT * FROM ProductInfo;";
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery();
//			ResultSetMetaData metaData = rs.getMetaData();
//			int columnCount = metaData.getColumnCount();
//			String result[] = new String[columnCount];
//			for (int iLoop = 0 ;iLoop < columnCount ; iLoop ++){
//				//カラム名取得
//				result[iLoop] = metaData.getColumnName(iLoop + 1);
//			}
//			return result;
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		} finally {
//			closeStatement();
//		}
//		return null;
		String[] str = {"", "", "", "", "", ""};
		return str;
	}


	/**
	 * 商品を1件DBからDeleteする
	 * @param info
	 * @return 更新件数
	 */
	public int deleteProductInfo(ProductInfoBean info) {
//		try {
//			con = getConnection();
//			String sql =  "DELETE FROM ProductInfo "
//					+ "WHERE	id = ?"
//					+ "AND		title = ?"
//					+ "AND		author = ?"
//					+ "AND		url = ?"
//					+ "AND		releasedate = ?"
//					+ "AND		flg = ?;"
//					;
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt   (1, info.getId());
//			pstmt.setString(2, info.getTitle());
//			pstmt.setString(3, info.getAuthor());
//			pstmt.setString(4, info.getUrl());
//			pstmt.setInt   (5, info.getReleaseDate());
//			pstmt.setInt   (6, info.getFlag());
//
//			return pstmt.executeUpdate();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}  finally {
//			closeStatement();
//		}
		return 0;
	}

	public int updateProductInfoFlg(int id, int updateFlg) {
//		try {
//			con = getConnection();
//			String sql =  "UPDATE  ProductInfo "
//					+ "SET 		flg = ?"
//					+ "WHERE	id = ?";
//			;
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setInt   (1, updateFlg);
//			pstmt.setInt   (2, id);
//
//			return pstmt.executeUpdate();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}  finally {
//			closeStatement();
//		}
		return 0;
	}

	public boolean isExist(String title) {
		boolean result = false;
//
//		try {
//			con = getConnection();
//			String sql =  "SELECT * FROM ProductInfo "
//					+ "WHERE title = ?;";
//
//			PreparedStatement pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, title);
//
//			result = pstmt.executeQuery().next();
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}  finally {
//			closeStatement();
//		}
		return result;
	}

//
///**
// * DB切断。
// * @return
// */
//public boolean closeStatement() {
//	try {
//		if (stmt != null) stmt.close();
//		if (con  != null) con.close();
//	} catch (SQLException e1) {
//		e1.printStackTrace();
//		return false;
//	}
//	return true;
//}
//
//public Connection getConnection() throws SQLException{
//	try {
//		Class.forName("org.sqlite.JDBC");
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	}
//	con = DriverManager
//			.getConnection("jdbc:sqlite:db/ProductInfo.db");
//	return con;
//}


}
