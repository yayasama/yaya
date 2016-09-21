package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.DAOFactory;
import dal.ApplyDaoInf;
import dal.StudentDaoInf;
import dao.PageDao;
import dao.UserDao;
import entity.Student;
import entity.User;



public class EditStuServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 获取url地址
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// 根据地址 执行对应数据库操作
		
		// 1.管理员加学生
		if (path.equals("/add")) {
			String username = req.getParameter("username");
			String sname = req.getParameter("sname");
			int sage = Integer.parseInt(req.getParameter("sage"));
			String sclass = req.getParameter("sclass");
			String pwd = req.getParameter("pwd");
			String sgender = req.getParameter("sgender");
			int usergroup = Integer.parseInt(req.getParameter("usergroup"));
			// 通过dao访问数据库
			StudentDaoInf dao = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			UserDao dao2 = new UserDao();
			List<Student> stu;
			try {
				Student s = dao.findByUsername(username);
				User u = dao2.findByUsername(username);
				if (s.toString() == null && u == null) {
					s.setUsername(username);
					s.setSname(sname);
					s.setSage(sage);
					s.setSclass(sclass);
					s.setPwd(pwd);
					s.setSgender(sgender);
					s.setUsergroup(usergroup);
					dao.save(s);

					stu = dao.findAll();
					req.setAttribute("stu", stu);
					RequestDispatcher rd = req.getRequestDispatcher("list.do");
					rd.forward(req, resp);
				} else {
					req.setAttribute("username_duplicate", "该学号已存在！");
					req.getRequestDispatcher("adm_addStu.jsp").forward(req, resp);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 2.显示学生全部信息
		if (path.equals("/list")) {
			req.setCharacterEncoding("utf-8");
			List<Student> stu;
			PageDao dao = new PageDao();
			stu = dao.findByPage_stu(1, 12);
			List<Integer> pageinf = dao.getPageinf();
			System.out.println("print servlet:" + pageinf);
			req.setAttribute("stu", stu);
			req.setAttribute("pageinf", pageinf);
			req.getRequestDispatcher("adm_editStu.jsp").forward(req, resp);
		}
		
		//分页
		if (path.equals("/page_stulist")) {
			req.setCharacterEncoding("utf-8");
			StudentDaoInf dao2 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			List<Student> stu;
			PageDao dao = new PageDao();
			int currentPage = Integer.parseInt(req.getParameter("currentPage"));
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			try {
				stu = dao2.findAll();
				stu = dao.findByPage_stu(currentPage, pageSize);
				List<Integer> pageinf = dao.getPageinf();
				System.out.println("pageinf:" + pageinf);
				req.setAttribute("stu", stu);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("adm_editStu.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 3.修改学生信息
		if (path.equals("/edit")) {
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			// 根据id查找出此条信息的内容
			StudentDaoInf dao = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			try {
				Student s = dao.findById(id);
				req.setAttribute("id", id);
				String sname = s.getSname();
				req.setAttribute("sname", sname);
				int sage = s.getSage();
				req.setAttribute("sage", sage);
				String sclass = s.getSclass();
				req.setAttribute("sclass", sclass);
				String sgender = s.getSgender();
				req.setAttribute("sgender", sgender);
				RequestDispatcher rd = req.getRequestDispatcher("adm_editStuInfo.jsp");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 4.更新学生信息
		if (path.equals("/update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String sname = req.getParameter("sname");
			int sage = Integer.parseInt(req.getParameter("sage"));
			String sclass = req.getParameter("sclass");
			String sgender = req.getParameter("sgender");

			StudentDaoInf dao = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			List<Student> stu;
			Student s = new Student();
			try {
				s.setId(id);
				s.setSname(sname);
				s.setSage(sage);
				s.setSclass(sclass);
				s.setSgender(sgender);
				dao.update(s);
				
				stu = dao.findAll();
				req.setAttribute("stu", stu);
				RequestDispatcher rd = req.getRequestDispatcher("list.do");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 5.删除学生
		if (path.equals("/delete")) {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			StudentDaoInf dao = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			List<Student> stu;
			try {
				dao.delete(username);
				stu = dao.findAll();
				req.setAttribute("stu", stu);
				RequestDispatcher rd = req.getRequestDispatcher("list.do");
				rd.forward(req, resp);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
