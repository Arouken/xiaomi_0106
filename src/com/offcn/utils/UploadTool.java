package com.offcn.utils;

import java.util.UUID;

import javax.servlet.http.Part;

/**
 * �ϴ��ļ�������
 * @author admin
 *
 */
public class UploadTool {
	/**
	 * �ϴ�ͼƬ
	 */
	public static String uploadImg(Part part) {
		//����һ���ļ�����
				String photo="";
				/**
				 * �ļ��ϴ���
				 * 1����ȡ�����ϴ����ļ���part���󣨷�װ���ϴ����ļ���Ϣ��
				 * 2����ȡ�ϴ����ļ����ƣ������ļ����Ƶ����ݿ��
				 * 3�������ϴ����ļ���Ŀ���ַ��C:\\ProjectTraining\\hut\\upload\\008.jpg
				 * 
				 */
				try {
					//��ȡ�ϴ����ļ�����
					String submittedFileName = part.getSubmittedFileName();
					//����ͬ���ļ����ǣ��Զ����ַ�+����������� random  math��
					//UUID���������:����32����ַ�
					String uuid = UUID.randomUUID().toString();
					//��ȡ�ļ���׺
					String type=submittedFileName.substring(submittedFileName.lastIndexOf("."), submittedFileName.length());
					//�������ļ���uuid+�ļ���׺
					 photo=uuid+type;	
					//���ļ����浽Ŀ��Ŀ¼:Ŀ¼��ַ+�ļ�����
					String path="F:\\img\\";
					part.write(path+photo);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return photo;
		
	}

}
