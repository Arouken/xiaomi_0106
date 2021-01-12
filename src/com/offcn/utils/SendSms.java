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
 * 手机验证码发送工具类
 * @author admin
 *
 */
public class SendSms {
	
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	/**
	 * 发送验证码方法
	 */
	
	public static int sendCode(String phone) {
		int num=0;
		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
		//生成的验证码：6位随机整数
		int mobile_code = (int)((Math.random()*9+1)*100000);
		//短信的模板：免费的不能修改
	    String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

		NameValuePair[] data = {//提交短信
			    new NameValuePair("account", "C60437585"), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
			    new NameValuePair("password", "664f63f821dca6d2e2f9110eba535e86"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
			    new NameValuePair("mobile", phone), //目标手机号：登录表单中输入的手机号
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

			 if("2".equals(code)){//短信发送成功
				System.out.println("短信提交成功");
				System.out.println("短信验证码是："+mobile_code);
				num=mobile_code;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return num;
	}

}
