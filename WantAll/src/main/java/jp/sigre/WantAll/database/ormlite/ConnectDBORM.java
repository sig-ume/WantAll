package jp.sigre.WantAll.database.ormlite;

import java.util.List;

import jp.sigre.WantAll.ProductInfoBean;
import android.app.Activity;

import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

public class ConnectDBORM extends Activity{

	private DatabaseHelper helper;
	private RuntimeExceptionDao<ProductInfoBean, Integer> dao;

	public ConnectDBORM(){
			helper = new DatabaseHelper(this);
			dao = helper.getRuntimeExceptionDao(ProductInfoBean.class);
	}

	/**
	 * ProductInfoTableのデータをBeanに格納してリスト化
	 * @return
	 */
	public List<ProductInfoBean> getProductInfoList() {
		try {
			QueryBuilder<ProductInfoBean, Integer> queryBuilder = dao.queryBuilder();

            PreparedQuery<ProductInfoBean> preparedQuery = queryBuilder.where().eq("value", "hoge").prepare();

            List<ProductInfoBean> list = dao.query(preparedQuery);
            return list;
		} catch (Exception e) {
			e.printStackTrace();
			//Log.e(TAG, "例外が発生しました", e);
			return null;
		} finally {
			helper.close();
		}
	}

	/**
	 * ProductInfoTableのデータをBeanに格納してリスト化
	 * @return
	 */
	public List<ProductInfoBean> getProductInfoListAll() {

		try {
			return dao.queryForAll();
		} catch (Exception e) {
			e.printStackTrace();
			//Log.e(TAG, "例外が発生しました", e);
			return null;
		} finally {
			helper.close();
		}
	}
}
