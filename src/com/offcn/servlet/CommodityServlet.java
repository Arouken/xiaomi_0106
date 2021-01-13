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
 * 商品模块
 * @author admin
 *
 */
@WebServlet("/commodity")
@MultipartConfig
public class CommodityServlet extends BaseServlet{
	
	//引入service
	private CommodityService commodityService=new CommodityServiceImpl();
	//引入分类的service
	private CategoryService categoryService=new CategoryServiceImpl();

	/**
	 * 增加商品
	 * @throws Exception 
	 */
	public void insertCommodity(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		//增加成功跳转查询
		if (row>0) {
			queryCommodityByPage(request, response);
		}
	}
	
	/**
	 * 分页查询商品
	 */
	
	public void queryCommodityByPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//1.获取当前页码值
		String currentPage = request.getParameter("currentPage");
		//2.调用后台查询方法
		PageTool<Commodity> pageTool=commodityService.queryCommodityByPage(currentPage);
		//3.分页对象存储作用域中
		request.setAttribute("pageTool", pageTool);
		//4.转发到展示页面
		request.getRequestDispatcher("back/commodity_list.jsp").forward(request, response);
		
	}
	
	/**
	 * 修改之前的查询回显
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryCommodityById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//查询商品分类信息
		List<Category> categoryList = categoryService.queryAllCategory();
		//获取请求中的id
		Integer cid = Integer.valueOf(request.getParameter("cid"));
		//根据id查询商品
		Commodity commodity=commodityService.queryCommodityById(cid);
		//存储数据到作用域
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("commodity", commodity);
		//转发到修改页面
		request.getRequestDispatcher("back/commodity_update.jsp").forward(request, response);
	}
	/**
	 * 保存修改后的信息
	 * @throws Exception 
	 */
	
	public void updateCommodity(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//获取表单中的参数
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
		//使用工具类将字符串转日期
		Date create_date = DateTool.stringToDate(createDate);
		/**
		 * 修改商品信息的时候文件有可能是空
		 * 1、继续使用原来的商品图片：将原来的图片名称使用隐藏域传入后台
		 * 2、更换一个商品的图片：调用上传工具类执行上传
		 */
		//获取part对象:包含了上传的文件信息
		Part part=null;
		try {
			part = request.getPart("photo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		//定义图片名称变量
		String photo ="";
		if (part.getSize()==0) {
			//没有上传新图片，使用原来的图片
			 photo = request.getParameter("oldPhoto");
		} else {
			//上传新图片
			 photo = UploadTool.uploadImg(part);
		}
		//封装商品对象
		Commodity commodity=new Commodity(cid, cate_id, ctype, price, cname, color,
				size, short_desc, full_desc, photo, model, create_date);
		//调用后台修改保存的方法
		int row=commodityService.updateCommodity(commodity);
		//修改成功跳转查询
		if (row>0) {
			queryCommodityByPage(request, response);
		}
		
	}
	
	
	
}
