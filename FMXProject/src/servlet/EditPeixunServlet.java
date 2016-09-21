package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.PeixunDaoInf;
import dal.TeacherDaoInf;
import dao.PageDao;
import dao.UserDao;
import entity.Peixun;
import entity.Student;
import entity.Teacher;
import entity.User;

import util.DAOFactory;

public class EditPeixunServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 获取url地址
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// 根据地址 执行对应数据库操作
		
		// 1.增加功能
		if (path.equals("/add")) {
			String username = req.getParameter("username");
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			String gender = req.getParameter("gender");
			String institution = req.getParameter("institution");
			String category = req.getParameter("category");
			String time = req.getParameter("time");
			int usergroup = Integer.parseInt(req.getParameter("usergroup"));
			// 通过dao访问数据库
			PeixunDaoInf dao = (PeixunDaoInf) DAOFactory.getInstance("PeixunDaoInf");
			UserDao dao2 = new UserDao();
			List<Peixun> px;
			try {
				Peixun p = dao.findByUsername(username);
				User u = dao2.findByUsername(username);
				if (p.toString() == null && u == null) {
				p.setUsername(username);
				p.setName(name);
				p.setAge(age);
				p.setGender(gender);
				p.setInstitution(institution);
				p.setCategory(category);
				p.setTime(time);
				p.setUsergroup(usergroup);

				dao.save(p);
				px = dao.findAll();
				req.setAttribute("px", px);
				RequestDispatcher rd = req.getRequestDispatcher("list.do3");
				rd.forward(req, resp);
				}else{
					req.setAttribute("px_username_duplicate", "该编号已存在！");
					req.getRequestDispatcher("adm_addPx.jsp").forward(req, resp);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// 2.list显示信息
		if (path.equals("/list")) {
			req.setCharacterEncoding("utf-8");
			List<Peixun> px;
			PageDao dao = new PageDao();
			px = dao.findByPage_px(1, 12);
			List<Integer> pageinf = dao.getPageinf();
			System.out.println("print servlet:" + pageinf);
			req.setAttribute("px", px);
			req.setAttribute("pageinf", pageinf);
			req.getRequestDispatcher("adm_editPx.jsp").forward(req, resp);
		}
		
		//分页
		if (path.equals("/page_pxlist")) {
			req.setCharacterEncoding("utf-8");
			PeixunDaoInf dao2 = (PeixunDaoInf) DAOFactory.getInstance("PeixunDaoInf");
			List<Peixun> px;
			PageDao dao = new PageDao();
			int currentPage = Integer.parseInt(req.getParameter("currentPage"));
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			try {
				px = dao2.findAll();
				px = dao.findByPage_px(currentPage, pageSize);
				List<Integer> pageinf = dao.getPageinf();
				System.out.println("pageinf:" + pageinf);
				req.setAttribute("px", px);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("adm_editPx.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 3.edit更改信息
		if (path.equals("/edit")) {
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			// 根据id查找出此条信息的内容
			PeixunDaoInf dao = (PeixunDaoInf) DAOFactory.getInstance("PeixunDaoInf");
			try {
				Peixun p = dao.findById(id);
				req.setAttribute("id", id);
				String name = p.getName();
				req.setAttribute("name", name);
				int age = p.getAge();
				req.setAttribute("age", age);
				String gender = p.getGender();
				req.setAttribute("gender", gender);
				String institution = p.getInstitution();
				req.setAttribute("institution", institution);
				String category = p.getCategory();
				req.setAttribute("category", category);
				String time = p.getTime();
				req.setAttribute("time", time);
				RequestDispatcher rd = req.getRequestDispatcher("adm_editPxInfo.jsp");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 4.update更新数据
		if (path.equals("/update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			String gender = req.getParameter("gender");
			String institution = req.getParameter("institution");
			String category = req.getParameter("category");
			String time = req.getParameter("time");

			PeixunDaoInf dao = (PeixunDaoInf) DAOFactory.getInstance("PeixunDaoInf");
			List<Peixun> px;
			Peixun p = new Peixun();
			try {
				p.setId(id);
				p.setName(name);
				p.setAge(age);
				p.setGender(gender);
				p.setInstitution(institution);
				p.setCategory(category);
				p.setTime(time);
				dao.update(p);
				
				px = dao.findAll();
				req.setAttribute("px", px);
				RequestDispatcher rd = req.getRequestDispatcher("list.do3");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// 5.delete删除
		if (path.equals("/delete")) {
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			PeixunDaoInf dao = (PeixunDaoInf) DAOFactory.getInstance("PeixunDaoInf");
			List<Peixun> px;
			try {
				dao.delete(id);
				px = dao.findAll();
				req.setAttribute("px", px);
				RequestDispatcher rd = req.getRequestDispatcher("list.do3");
				rd.forward(req, resp);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
