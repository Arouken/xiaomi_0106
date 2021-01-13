package com.offcn.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.pojo.Category;
import com.offcn.pojo.Commodity;
import com.offcn.service.CategoryService;
import com.offcn.service.CommodityService;
import com.offcn.service.impl.CategoryServiceImpl;
import com.offcn.service.impl.CommodityServiceImpl;
import com.offcn.utils.DateTool;
import com.offcn.utils.PageTool;
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
	private CommodityService commodityService=new CommodityServiceImpl();
	//��������service
	private CategoryService categoryService=new CategoryServiceImpl();

	/**
	 * ������Ʒ
	 * @throws Exception 
	 */
	public void insertCommodity(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		//���ӳɹ���ת��ѯ
		if (row>0) {
			queryCommodityByPage(request, response);
		}
	}
	
	/**
	 * ��ҳ��ѯ��Ʒ
	 */
	
	public void queryCommodityByPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//1.��ȡ��ǰҳ��ֵ
		String currentPage = request.getParameter("currentPage");
		//2.���ú�̨��ѯ����
		PageTool<Commodity> pageTool=commodityService.queryCommodityByPage(currentPage);
		//3.��ҳ����洢��������
		request.setAttribute("pageTool", pageTool);
		//4.ת����չʾҳ��
		request.getRequestDispatcher("back/commodity_list.jsp").forward(request, response);
		
	}
	
	/**
	 * �޸�֮ǰ�Ĳ�ѯ����
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryCommodityById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ѯ��Ʒ������Ϣ
		List<Category> categoryList = categoryService.queryAllCategory();
		//��ȡ�����е�id
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		//����id��ѯ��Ʒ
		Commodity commodity=commodityService.queryCommodityById(cid);
		//�洢���ݵ�������
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("commodity", commodity);
		//ת�����޸�ҳ��
		request.getRequestDispatcher("back/commodity_update.jsp").forward(request, response);
	}
	/**
	 * �����޸ĺ����Ϣ
	 * @throws Exception 
	 */
	
	public void updateCommodity(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//��ȡ���еĲ���
		Integer cid = Integer.valueOf(request.getParameter("cid"));
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
		/**
		 * �޸���Ʒ��Ϣ��ʱ���ļ��п����ǿ�
		 * 1������ʹ��ԭ������ƷͼƬ����ԭ����ͼƬ����ʹ�����������̨
		 * 2������һ����Ʒ��ͼƬ�������ϴ�������ִ���ϴ�
		 */
		//��ȡpart����:�������ϴ����ļ���Ϣ
		Part part=null;
		try {
			part = request.getPart("photo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//����ͼƬ���Ʊ���
		String photo ="";
		if (part.getSize()==0) {
			//û���ϴ���ͼƬ��ʹ��ԭ����ͼƬ
			 photo = request.getParameter("oldPhoto");
		} else {
			//�ϴ���ͼƬ
			 photo = UploadTool.uploadImg(part);
		}
		//��װ��Ʒ����
		Commodity commodity=new Commodity(cid, cate_id, ctype, price, cname, color,
				size, short_desc, full_desc, photo, model, create_date);
		//���ú�̨�޸ı���ķ���
		int row=commodityService.updateCommodity(commodity);
		//�޸ĳɹ���ת��ѯ
		if (row>0) {
			queryCommodityByPage(request, response);
		}
		
	}
	
	
	
}
