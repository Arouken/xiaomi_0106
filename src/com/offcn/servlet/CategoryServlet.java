package com.offcn.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.pojo.Category;
import com.offcn.service.CategoryService;
import com.offcn.service.impl.CategoryServiceImpl;
import com.offcn.utils.DateTool;
import com.offcn.utils.PageTool;

/**
 * 类别模块
 * @author admin
 *
 */
@WebServlet("/category")
public class CategoryServlet extends BaseServlet{
	
	//引入分类的service
	private CategoryService categoryService=new CategoryServiceImpl();
	
	/**
	 * 增加分类
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void insertCategory(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, ServletException, IOException {
		//获取请求中参数
		String cname = request.getParameter("cname");
		Integer state = Integer.valueOf(request.getParameter("state"));
		Integer order_num = Integer.valueOf(request.getParameter("order_num"));
		String description = request.getParameter("description");
		//创建日期
		String createDate = request.getParameter("create_date");
		//字符串转换成日期类型
		Date create_date = DateTool.stringToDate(createDate);
		//将参数封装到分类对象
		Category category=new Category(state, order_num, cname, description, create_date);
		//调用后台增加方法
		int row=categoryService.insertCategory(category);
		//增加成功跳转查询
		if (row>0) {
			queryCategoryByPage(request, response);
		}
	}
	/**
	 * 分页查询
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	public void queryCategoryByPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.获取当前页码值
		String currentPage = request.getParameter("currentPage");
		//2.调用后台查询方法
		PageTool<Category> pageTool=categoryService.queryCategoryByPage(currentPage);
		//3.将分页对象存储到作用域
		request.setAttribute("pageTool", pageTool);
		//4.转发到展示页面
		request.getRequestDispatcher("back/category_list.jsp").forward(request, response);
		
	}
	
	/**
	 * 查询所有分类信息
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryAllCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用查询方法
		List<Category> categoryList=categoryService.queryAllCategory();
		//将分类集合存储到作用域
		request.setAttribute("categoryList", categoryList);
		//跳转到商品增加页面
		request.getRequestDispatcher("back/commodity_add.jsp").forward(request, response);
		
	}

}
