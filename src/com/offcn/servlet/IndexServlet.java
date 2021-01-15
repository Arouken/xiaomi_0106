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
 * 前端首页数据模块
 * @author admin
 *
 */
@WebServlet("/index")
public class IndexServlet extends BaseServlet{
	//引入分类的service
	private CategoryService categoryService=new CategoryServiceImpl();
	//引入商品的service
	private CommodityService commodityService=new CommodityServiceImpl();
	
	/**
	 * 展示首页数据
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryIndexInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.查询分类信息
		List<Category> categoryList=categoryService.queryIndexCategory();
		//将结果存储作用域中
		request.setAttribute("categoryList", categoryList);
		//2.查询小米明星单品
		List<Commodity> starCommodityList= commodityService.queryIndexCommodity();
		request.setAttribute("stars", starCommodityList);
		//3.查询家电产品
		List<Commodity> homeCommodityList=commodityService.queryIndexHomeCommodity();
		request.setAttribute("homes", homeCommodityList);
		
		
		request.getRequestDispatcher("/front/index.jsp").forward(request, response);
	}
	/**
	 * 查询商品详情
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	public void queryCommodityDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取商品的id
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		//根据id查询
		Commodity commodity = commodityService.queryCommodityById(cid);
		//将商品存储到作用域
		request.setAttribute("commodity", commodity);
		//转发到详情页面
		request.getRequestDispatcher("front/detail.jsp").forward(request, response);
		
	}
	

}
