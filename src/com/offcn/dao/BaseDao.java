package com.offcn.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * ����һ���������̳еĶ����ݿ���л���������Dao
 *
 * @param <T>
 */
public class BaseDao<T> {
	//����QueryRunner����
	private QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource());
	// ����һ�����������շ��͵�����
	private Class<T> type;

	// ��ȡT��Class���󣬻�ȡ���͵����ͣ��������ڱ�����̳�ʱ��ȷ��
	public BaseDao() {
		// ��ȡ���������
		Class clazz = this.getClass();
		// ��ȡ���������
		// getGenericSuperclass()������ȡ��ǰ��ĸ��������
		// ParameterizedType��ʾ���Ǵ����͵�����
		ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
		// ��ȡ����ķ������� getActualTypeArguments��ȡ����ķ��͵�����
		// ��������᷵��һ��Type������
		Type[] types = parameterizedType.getActualTypeArguments();
		// ��ȡ����ķ��͵����͡�
		this.type = (Class<T>) types[0];
	}

	/**
	 * ͨ�õ���ɾ�Ĳ���
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object... params) {
		int count = 0;
		try {
			count = queryRunner.update( sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return count;
	}

	/**
	 * ��ȡһ������
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql, Object... params) {
		T t = null;
		try {
			t = queryRunner.query( sql, new BeanHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return t;
	}

	/**
	 * ��ȡ���ж���
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql, Object... params) {
		List<T> list = null;
		try {
			list = queryRunner.query(sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}

	/**
	 * ��ȡһ����һֵ�ķ�����ר������ִ����select count(*)... ������sql���
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object getSingelValue(String sql, Object... params) {
		Object count = null;
		try {
			count = queryRunner.query( sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
