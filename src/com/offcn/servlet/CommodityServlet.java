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
 * ��Ʒģ��
 * @author admin
 *
 */
@WebServlet("/commodity")
@MultipartConfig
public class CommodityServlet extends BaseServlet{
	
	//����service
	CommodityService commodityService=new CommodityServiceImpl();

	/**
	 * ������Ʒ
	 */
	public void insertCommodity(HttpServletRequest request,
			HttpServletResponse response) {
		//��ȡ���Ĳ���
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
		//ʹ�ù����ཫ�ַ���ת����
		Date create_date = DateTool.stringToDate(createDate);
		//ʹ�ù�����ʵ��ͼƬ�ϴ�
		Part part=null;
		try {
			part = request.getPart("photo");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		String photo = UploadTool.uploadImg(part);
		//��װ��Ʒ����
		Commodity commodity=new Commodity(cate_id, ctype, price, cname, 
				color, size, short_desc, full_desc, photo, model, create_date);
		//���ú�̨���ӷ���
		int row=commodityService.insertCommodity(commodity);
		
	}
}
