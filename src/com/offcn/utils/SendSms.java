package com.offcn.utils;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * �ֻ���֤�뷢�͹�����
 * @author admin
 *
 */
public class SendSms {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	/**
	 * ������֤�뷽��
	 */
	
	public static int sendCode(String phone) {
		int num=0;
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
		//���ɵ���֤�룺6λ�������
		int mobile_code = (int)((Math.random()*9+1)*100000);
		//���ŵ�ģ�壺��ѵĲ����޸�
	    String content = new String("������֤���ǣ�" + mobile_code + "���벻Ҫ����֤��й¶�������ˡ�");

		NameValuePair[] data = {//�ύ����
			    new NameValuePair("account", "C60437585"), //�鿴�û����ǵ�¼�û�����->��֤�����->��Ʒ����->APIID
			    new NameValuePair("password", "664f63f821dca6d2e2f9110eba535e86"),  //�鿴�������¼�û�����->��֤�����->��Ʒ����->APIKEY
			    new NameValuePair("mobile", phone), //Ŀ���ֻ��ţ���¼����������ֻ���
			    new NameValuePair("content", content),
		};
		method.setRequestBody(data);

		try {
			client.executeMethod(method);
			
			String SubmitResult =method.getResponseBodyAsString();

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			 if("2".equals(code)){//���ŷ��ͳɹ�
				System.out.println("�����ύ�ɹ�");
				System.out.println("������֤���ǣ�"+mobile_code);
				num=mobile_code;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return num;
	}

}
