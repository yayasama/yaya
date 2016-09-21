package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dal.StudentDaoInf;
import dal.TeacherDaoInf;
import dao.PageDao;
import dao.UserDao;

import entity.Student;
import entity.Teacher;
import entity.User;
import util.DAOFactory;


public class EditTeaServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 获取url地址
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// 根据地址 执行对应数据库操作
		
		// 1.增加功能
		if (path.equals("/add")) {
			String username = req.getParameter("username");
			String tname = req.getParameter("tname");
			int tage = Integer.parseInt(req.getParameter("tage"));
			String pwd = req.getParameter("pwd");
			String tgender = req.getParameter("tgender");
			String tschool = req.getParameter("tschool");
			int usergroup = Integer.parseInt(req.getParameter("usergroup"));
			// 通过dao访问数据库
			TeacherDaoInf dao = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			UserDao dao2 = new UserDao();
			List<Teacher> tea;
			try {
				Teacher t = dao.findByUsername(username);
				User u = dao2.findByUsername(username);
				if(t.toString() == null && u == null){
				t.setUsername(username);
				t.setTname(tname);
				t.setTage(tage);
				t.setPwd(pwd);
				t.setTgender(tgender);
				t.setTschool(tschool);
				t.setUsergroup(usergroup);
				dao.save(t);
				
				tea = dao.findAll();
				req.setAttribute("tea", tea);
				RequestDispatcher rd = req.getRequestDispatcher("list.do2");
				rd.forward(req, resp);
				}else{
					req.setAttribute("tea_username_duplicate", "该编号已存在！");
					req.getRequestDispatcher("adm_addTea.jsp").forward(req, resp);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// 2.list显示信息
		if (path.equals("/list")) {
			req.setCharacterEncoding("utf-8");
			List<Teacher> tea;
			PageDao dao = new PageDao();
			tea = dao.findByPage_tea(1, 12);
			List<Integer> pageinf = dao.getPageinf();
			System.out.println("print servlet:" + pageinf);
			req.setAttribute("tea", tea);
			req.setAttribute("pageinf", pageinf);
			req.getRequestDispatcher("adm_editTea.jsp").forward(req, resp);
		}
		
		//分页
		if (path.equals("/page_tealist")) {
			req.setCharacterEncoding("utf-8");
			TeacherDaoInf dao2 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Teacher> tea;
			PageDao dao = new PageDao();
			int currentPage = Integer.parseInt(req.getParameter("currentPage"));
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			try {
				tea = dao2.findAll();
				tea = dao.findByPage_tea(currentPage, pageSize);
				List<Integer> pageinf = dao.getPageinf();
				System.out.println("pageinf:" + pageinf);
				req.setAttribute("tea", tea);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("adm_editTea.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 3.edit更改雇员信息
		if (path.equals("/edit")) {
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			// 根据id查找出此条信息的内容
			TeacherDaoInf dao = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			try {
				Teacher t = dao.findById(id);
				req.setAttribute("id", id);
				String tname = t.getTname();
				req.setAttribute("tname", tname);
				int tage = t.getTage();
				req.setAttribute("tage", tage);
				String tgender = t.getTgender();
				req.setAttribute("tgender", tgender);
				String tschool = t.getTschool();
				req.setAttribute("tschool", tschool);
				RequestDispatcher rd = req.getRequestDispatcher("adm_editTeaInfo.jsp");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 4.update更新数据
		if (path.equals("/update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String tname = req.getParameter("tname");
			int tage = Integer.parseInt(req.getParameter("tage"));
			String tgender = req.getParameter("tgender");
			String tschool = req.getParameter("tschool");

			TeacherDaoInf dao = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Teacher> tea;
			Teacher t = new Teacher();
			try {
				t.setId(id);
				t.setTname(tname);
				t.setTage(tage);
				t.setTgender(tgender);
				t.setTschool(tschool);
				dao.update(t);
				
				tea = dao.findAll();
				req.setAttribute("tea", tea);
				RequestDispatcher rd = req.getRequestDispatcher("list.do2");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		// 5.delete删除
		if (path.equals("/delete")) {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			TeacherDaoInf dao = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Teacher> tea;
			try {
				dao.delete(username);
				tea = dao.findAll();
				req.setAttribute("tea", tea);
				RequestDispatcher rd = req.getRequestDispatcher("list.do2");
				rd.forward(req, resp);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
