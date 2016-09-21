package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.ApplyDaoInf;
import dal.StudentDaoInf;
import dal.TeacherDaoInf;
import dao.PageDaoTea;
import entity.Program;
import entity.Student;
import entity.Teacher;
import util.DAOFactory;


public class TeaApplyServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 获取url地址
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// 根据地址 执行对应数据库操作
		// 0.老师插入项目前获取到名字
		if (path.equals("/tname")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");	
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		    String applytime = sd.format(new Date());
		    
			TeacherDaoInf dao = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			StudentDaoInf dao2 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			List<Student> stu;
			try {		
			    Teacher t = dao.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				req.setAttribute("applytime", applytime);
				stu = dao2.findAll();
				req.setAttribute("stu", stu);
				RequestDispatcher rd = req.getRequestDispatcher("tea_apply.jsp");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		// 1.老师插入实践项目
		if (path.equals("/add")) {
			HttpSession  session = req.getSession(); 
			String usernametea = (String)session.getAttribute("username");
			String title = req.getParameter("title");
			String guidetea = req.getParameter("guidetea");
			String need = req.getParameter("need");
			String applytime = req.getParameter("applytime");
			List<Program> pro;
			Program p = new Program();
			
			// 通过dao访问数据库
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			try {
				p.setTitle(title);
				p.setGuidetea(guidetea);
				p.setNeed(need);
				p.setApplytime(applytime);
				dao.save(p);			
				
				Teacher t = dao1.findByUsername(usernametea);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				pro = dao.findAll2(tname);
				req.setAttribute("pro", pro);
				RequestDispatcher rd = req.getRequestDispatcher("listallpro.apply2");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 2.显示项目全部信息
		if (path.equals("/listallpro")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 通过dao访问数据库
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Program> pro;
			PageDaoTea dao = new PageDaoTea();
			Teacher t;
			try {
				t = dao1.findByUsername(username);
				String tname = t.getTname();
				req.setAttribute("tname", tname);
				pro = dao.findByPage_teaapply(1, 12,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("pro", pro);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_applyresult.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		//分页
		if (path.equals("/page_teaapply")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 通过dao访问数据库
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Program> pro;
			PageDaoTea dao = new PageDaoTea();
			int currentPage = Integer.parseInt(req.getParameter("currentPage"));
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				pro = dao.findByPage_teaapply(currentPage, pageSize,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("pro", pro);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_applyresult.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 2.根据id显示教师详细的项目
		if (path.equals("/detail")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			// 根据id查找出此条信息的内容
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");	
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				Program p = dao.findById(id);
				req.setAttribute("id", id);
				String title = p.getTitle();
				req.setAttribute("title", title);
				String guidetea = p.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String need = p.getNeed();
				req.setAttribute("need", need);
				String resultadm = p.getResultadm();
				req.setAttribute("resultadm", resultadm);
				String prostate = p.getProstate();
				req.setAttribute("prostate", prostate);
				String applytime = p.getApplytime();
				req.setAttribute("applytime", applytime);
				RequestDispatcher rd = req.getRequestDispatcher("tea_applydetail.jsp");
				// 转发
				rd.forward(req, resp);
				// 转发：1,获得转发器 2,将当前servlet request response 转给jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//审核不通过
		if (path.equals("/reviewfail")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			// 根据id查找出此条信息的内容
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");	
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				Program p = dao.findById(id);
				req.setAttribute("id", id);
				String title = p.getTitle();
				req.setAttribute("title", title);
				String guidetea = p.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String need = p.getNeed();
				req.setAttribute("need", need);
				String resultadm = p.getResultadm();
				req.setAttribute("resultadm", resultadm);
				String prostate = p.getProstate();
				req.setAttribute("prostate", prostate);
				String applytime = p.getApplytime();
				req.setAttribute("applytime", applytime);
				RequestDispatcher rd = req.getRequestDispatcher("tea_applyjudge3.jsp");
				// 转发
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		if (path.equals("/applyedit")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			String need = req.getParameter("need");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		    String applytime = sd.format(new Date());
		    int id = Integer.parseInt(req.getParameter("id"));
			try {
				ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
				TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
				Program p = dao.findById(id);
				req.setAttribute("id", id);
				p.setNeed(need);
				p.setApplytime(applytime);
				if(need != null){
				    dao.updateNeed(p);
				    dao.SetApplytime(p);
				    Teacher t = dao1.findByUsername(username);
				    String tname = t.getTname();
					req.setAttribute("tname", tname);
					RequestDispatcher rd = req.getRequestDispatcher("listallpro.apply2");
					rd.forward(req, resp);
				}	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
