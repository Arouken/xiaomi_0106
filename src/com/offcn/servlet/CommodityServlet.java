package com.offcn.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.pojo.Commodity;
import com.offcn.service.CommodityService;
import com.offcn.service.impl.CommodityServiceImpl;
import com.offcn.utils.DateTool;
import com.offcn.utils.UploadTool;

/**
 * 商品模块
 * @author admin
 *
 */
@WebServlet("/commodity")
@MultipartConfig
public class CommodityServlet extends BaseServlet{
	
	//引入service
	CommodityService commodityService=new CommodityServiceImpl();

	/**
	 * 增加商品
	 */
	public void insertCommodity(HttpServletRequest request,
			HttpServletResponse response) {
		//获取表单的参数
		Integer cate_id = Integer.valueOf(request.getParameter("cate_id"));
		Integer ctype = Integer.valueOf(request.getParameter("ctype"));
		String cname = request.getParameter("cname");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		Double price = Double.valueOf(request.getParameter("price"));
		String short_desc = request.getParameter("short_desc");
		String full_desc = request.getParameter("full_desc");
		String model = request.getParameter("model");
		String createDate = request.getParameter("create_date");
		//使用工具类将字符串转日期
		Date create_date = DateTool.stringToDate(createDate);
		//使用工具类实现图片上传
		Part part=null;
		try {
			part = request.getPart("photo");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		String photo = UploadTool.uploadImg(part);
		//封装商品对象
		Commodity commodity=new Commodity(cate_id, ctype, price, cname, 
				color, size, short_desc, full_desc, photo, model, create_date);
		//调用后台增加方法
		int row=commodityService.insertCommodity(commodity);
		
	}
}
