package com.offcn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.pojo.Category;
import com.offcn.pojo.Commodity;
import com.offcn.service.CategoryService;
import com.offcn.service.CommodityService;
import com.offcn.service.impl.CategoryServiceImpl;
import com.offcn.service.impl.CommodityServiceImpl;

/**
 * ǰ����ҳ����ģ��
 * @author admin
 *
 */
@WebServlet("/index")
public class IndexServlet extends BaseServlet{
	//��������service
	private CategoryService categoryService=new CategoryServiceImpl();
	//������Ʒ��service
	private CommodityService commodityService=new CommodityServiceImpl();
	
	/**
	 * չʾ��ҳ����
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryIndexInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.��ѯ������Ϣ
		List<Category> categoryList=categoryService.queryIndexCategory();
		//������洢��������
		request.setAttribute("categoryList", categoryList);
		//2.��ѯС�����ǵ�Ʒ
		List<Commodity> starCommodityList= commodityService.queryIndexCommodity();
		request.setAttribute("stars", starCommodityList);
		//3.��ѯ�ҵ��Ʒ
		List<Commodity> homeCommodityList=commodityService.queryIndexHomeCommodity();
		request.setAttribute("homes", homeCommodityList);
		
		
		request.getRequestDispatcher("/front/index.jsp").forward(request, response);
	}
	/**
	 * ��ѯ��Ʒ����
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	public void queryCommodityDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��Ʒ��id
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		//����id��ѯ
		Commodity commodity = commodityService.queryCommodityById(cid);
		//����Ʒ�洢��������
		request.setAttribute("commodity", commodity);
		//ת��������ҳ��
		request.getRequestDispatcher("front/detail.jsp").forward(request, response);
		
	}
	

}
