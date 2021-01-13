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
 * ���ģ��
 * @author admin
 *
 */
@WebServlet("/category")
public class CategoryServlet extends BaseServlet{
	
	//��������service
	private CategoryService categoryService=new CategoryServiceImpl();
	
	/**
	 * ���ӷ���
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void insertCategory(HttpServletRequest request,
			HttpServletResponse response) throws ParseException, ServletException, IOException {
		//��ȡ�����в���
		String cname = request.getParameter("cname");
		Integer state = Integer.valueOf(request.getParameter("state"));
		Integer order_num = Integer.valueOf(request.getParameter("order_num"));
		String description = request.getParameter("description");
		//��������
		String createDate = request.getParameter("create_date");
		//�ַ���ת������������
		Date create_date = DateTool.stringToDate(createDate);
		//��������װ���������
		Category category=new Category(state, order_num, cname, description, create_date);
		//���ú�̨���ӷ���
		int row=categoryService.insertCategory(category);
		//���ӳɹ���ת��ѯ
		if (row>0) {
			queryCategoryByPage(request, response);
		}
	}
	/**
	 * ��ҳ��ѯ
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	public void queryCategoryByPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡ��ǰҳ��ֵ
		String currentPage = request.getParameter("currentPage");
		//2.���ú�̨��ѯ����
		PageTool<Category> pageTool=categoryService.queryCategoryByPage(currentPage);
		//3.����ҳ����洢��������
		request.setAttribute("pageTool", pageTool);
		//4.ת����չʾҳ��
		request.getRequestDispatcher("back/category_list.jsp").forward(request, response);
		
	}
	
	/**
	 * ��ѯ���з�����Ϣ
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryAllCategory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//���ò�ѯ����
		List<Category> categoryList=categoryService.queryAllCategory();
		//�����༯�ϴ洢��������
		request.setAttribute("categoryList", categoryList);
		//��ת����Ʒ����ҳ��
		request.getRequestDispatcher("back/commodity_add.jsp").forward(request, response);
		
	}

}