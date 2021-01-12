package com.offcn.utils;

import java.util.UUID;

import javax.servlet.http.Part;

/**
 * 上传文件工具类
 * @author admin
 *
 */
public class UploadTool {
	/**
	 * 上传图片
	 */
	public static String uploadImg(Part part) {
		//定义一个文件名称
				String photo="";
				/**
				 * 文件上传：
				 * 1、获取表单中上传的文件：part对象（封装了上传的文件信息）
				 * 2、获取上传的文件名称：保存文件名称到数据库表
				 * 3、保存上传的文件到目标地址：C:\\ProjectTraining\\hut\\upload\\008.jpg
				 * 
				 */
				try {
					//获取上传的文件名称
					String submittedFileName = part.getSubmittedFileName();
					//避免同名文件覆盖：自定义字符+随机数（日期 random  math）
					//UUID生成随机数:生成32随机字符
					String uuid = UUID.randomUUID().toString();
					//获取文件后缀
					String type=submittedFileName.substring(submittedFileName.lastIndexOf("."), submittedFileName.length());
					//重命名文件：uuid+文件后缀
					 photo=uuid+type;	
					//将文件保存到目标目录:目录地址+文件名称
					String path="F:\\img\\";
					part.write(path+photo);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		return photo;
		
	}

}
