package com.offcn.dao;

import com.offcn.pojo.Trolley;

/**
 * ���ﳵ�־û��ӿ�
 * @author admin
 *
 */
public interface TrolleyDao {

	//��ѯ��ǰ��Ʒ�Ƿ��Ѿ����ڹ��ﳵ����
	Trolley queryTrolleyByUid(Integer uid, Integer cid);
	//���ӹ��ﳵ��¼
	int insertTrolley(Integer uid, Integer cid);
	//�޸���Ʒ������
	int updateNumber(Integer tid);

}
