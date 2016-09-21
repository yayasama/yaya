package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.ApplyDaoInf;
import dal.ReportDaoInf;
import dal.TeacherDaoInf;
import dao.PageDaoTea;
import entity.Program;
import entity.Report1;
import entity.Report2;
import entity.Report3;
import entity.Teacher;
import util.DAOFactory;

public class TeaReviewServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 获取url地址
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// 根据地址 执行对应数据库操作
		
		//一. 审核学生申报项目
		// 1.显示学生申报项目的信息	
		if (path.equals("/listpro")) {
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
				pro = dao.findByPage_teareview(1, 10,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("pro", pro);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_review.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		//分页
		if (path.equals("/page_teareview")) {
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
				pro = dao.findByPage_teareview(currentPage, pageSize,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("pro", pro);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_review.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 2.根据id显示学生的项目报告，并审核
		if (path.equals("/pro")) {
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
				// 将查询到的信息用于页面修改
				// 传到stu_reviewresult.jsp页面中
				req.setAttribute("id", id);
				String sname = p.getSname();
				req.setAttribute("sname", sname);
				String title = p.getTitle();
				req.setAttribute("title", title);
				String guidetea = p.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String content = p.getContent();
				req.setAttribute("content", content);
				String resulttea = p.getResulttea();
				req.setAttribute("resulttea", resulttea);
				String finishtime = p.getFinishtime();
				req.setAttribute("finishtime", finishtime);
				RequestDispatcher rd = req.getRequestDispatcher("tea_reviewresult.jsp");
				// 转发
				rd.forward(req, resp);
				// 转发：1,获得转发器 2,将当前servlet request response 转给jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//3.返回审核结果
		if (path.equals("/proresulttea")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			String resulttea = req.getParameter("resulttea");
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Program> pro;
			Program p = new Program();
			try {			
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				p.setResulttea(resulttea);
				p.setId(id);
				dao.updateResult(p);
				
				pro = dao.findAll2(tname);
				req.setAttribute("pro", pro);
				RequestDispatcher rd = req.getRequestDispatcher("listpro.review");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//根据用户名搜索
		if (path.equals("/username")) {
			req.setCharacterEncoding("utf-8");
		   String username = req.getParameter("username");
		   HttpSession  session = req.getSession(); 
		   String tea_username = (String)session.getAttribute("username");
			// 根据id查找出此条信息的内容
		   ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
		   TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			try {
				Program p  = dao.findByUsername(username);
				if (p.getTitle() == null) {
					Teacher t = dao1.findByUsername(tea_username);
				    String tname = t.getTname();
					req.setAttribute("tname", tname);
					req.getRequestDispatcher("tea_filter.jsp").forward(req,resp);
				} else {
				Teacher t = dao1.findByUsername(tea_username);
				String tname = t.getTname();
				req.setAttribute("tname", tname);
				req.setAttribute("username", username);
				String sname = p.getSname();
				req.setAttribute("sname", sname);
				String title = p.getTitle();
				req.setAttribute("title", title);
				String guidetea = p.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String finishtime = p.getFinishtime();
				req.setAttribute("finishtime", finishtime);
				String resulttea = p.getResulttea();		
				req.setAttribute("resulttea", resulttea);
				RequestDispatcher rd = req.getRequestDispatcher("tea_reviewfilter.jsp");
				rd.forward(req, resp);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//二. 审核季度报告
		//1.显示信息		
		if (path.equals("/listjidu")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 通过dao访问数据库
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Report1> rep1;
			PageDaoTea dao = new PageDaoTea();
			Teacher t;
			try {
				t = dao1.findByUsername(username);
				String tname = t.getTname();
				req.setAttribute("tname", tname);
				rep1 = dao.findByPage_report1(1, 12,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("rep1", rep1);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_report1.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		//分页
		if (path.equals("/page_report1")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 通过dao访问数据库
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Report1> rep1;
			PageDaoTea dao = new PageDaoTea();
			int currentPage = Integer.parseInt(req.getParameter("currentPage"));
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				rep1 = dao.findByPage_report1(currentPage, pageSize,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("rep1", rep1);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_report1.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 2. 查看季度报告详细内容，并审核
		if (path.equals("/report1")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			// 根据id查找出此条信息的内容
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");		
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				Report1 r1 = dao.findById(id);
				// 将查询到的信息用于页面修改
				req.setAttribute("id", id);
				String sname = r1.getSname();
				req.setAttribute("sname", sname);
				String title = r1.getTitle();
				req.setAttribute("title", title);
				String progress = r1.getProgress();
				req.setAttribute("progress", progress);
				String gain = r1.getGain();
				req.setAttribute("gain", gain);
				String result = r1.getResult();
				req.setAttribute("result", result);
				RequestDispatcher rd = req.getRequestDispatcher("tea_report1result.jsp");
				// 转发
				rd.forward(req, resp);
				// 转发：1,获得转发器 2,将当前servlet request response 转给jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//3.返回审核结果
		if (path.equals("/report1result")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			String result = req.getParameter("result");
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");	
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Report1> rep1;
			Report1 r1 = new Report1();
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);	
				r1.setId(id);
				r1.setResult(result);
				dao.updateResult1(r1);
				rep1 = dao.findByGuidetea(tname);
				req.setAttribute("rep1", rep1);
				RequestDispatcher rd = req.getRequestDispatcher("listjidu.review");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
		//三. 审核中期报告
		//1.显示信息
		if (path.equals("/listzhongqi")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 通过dao访问数据库
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Report2> rep2;
			PageDaoTea dao = new PageDaoTea();
			Teacher t;
			try {
				t = dao1.findByUsername(username);
				String tname = t.getTname();
				req.setAttribute("tname", tname);
				rep2 = dao.findByPage_report2(1, 12,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("rep2", rep2);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_report2.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		//分页
		if (path.equals("/page_report2")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 通过dao访问数据库
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Report2> rep2;
			PageDaoTea dao = new PageDaoTea();
			int currentPage = Integer.parseInt(req.getParameter("currentPage"));
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				rep2 = dao.findByPage_report2(currentPage, pageSize,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("rep2", rep2);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_report2.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 2. 查看中期报告详细内容，并审核
		if (path.equals("/report2")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			// 根据id查找出此条信息的内容
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");		
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				Report2 r2 = dao.findById2(id);
				// 将查询到的信息用于页面修改
				req.setAttribute("id", id);
				String sname = r2.getSname();
				req.setAttribute("sname", sname);
				String title = r2.getTitle();
				req.setAttribute("title", title);
				String progress = r2.getProgress();
				req.setAttribute("progress", progress);
				String gain = r2.getGain();
				req.setAttribute("gain", gain);
				String result = r2.getResult();
				req.setAttribute("result", result);
				RequestDispatcher rd = req.getRequestDispatcher("tea_report2result.jsp");
				// 转发
				rd.forward(req, resp);
				// 转发：1,获得转发器 2,将当前servlet request response 转给jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//3.返回审核结果
		if (path.equals("/report2result")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			String result = req.getParameter("result");
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");	
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Report2> rep2;
			Report2 r2 = new Report2();
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);	
				r2.setId(id);
				r2.setResult(result);
				dao.updateResult2(r2);
				rep2 = dao.findByGuidetea2(tname);
				req.setAttribute("rep2", rep2);
				RequestDispatcher rd = req.getRequestDispatcher("listzhongqi.review");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		
		//四. 审核结题报告
		//1.显示信息
		if (path.equals("/listjieti")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 通过dao访问数据库
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Report3> rep3;
			PageDaoTea dao = new PageDaoTea();
			Teacher t;
			try {
				t = dao1.findByUsername(username);
				String tname = t.getTname();
				req.setAttribute("tname", tname);
				rep3 = dao.findByPage_report3(1, 12,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("rep3", rep3);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_report3.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		//分页
		if (path.equals("/page_report3")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 通过dao访问数据库
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			List<Report3> rep3;
			PageDaoTea dao = new PageDaoTea();
			int currentPage = Integer.parseInt(req.getParameter("currentPage"));
			int pageSize = Integer.parseInt(req.getParameter("pageSize"));
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				rep3 = dao.findByPage_report3(currentPage, pageSize,tname);
				List<Integer> pageinf = dao.getPageinf();
				req.setAttribute("rep3", rep3);
				req.setAttribute("pageinf", pageinf);
				req.getRequestDispatcher("tea_report3.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 2. 查看季度报告详细内容，并审核
		if (path.equals("/report3")) {
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// 根据id查找出此条信息的内容
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);
				Report3 r3 = dao.findById3(id);
				// 将查询到的信息用于页面修改
				req.setAttribute("id", id);
				String sname = r3.getSname();
				req.setAttribute("sname", sname);
				String title = r3.getTitle();
				req.setAttribute("title", title);
				String progress = r3.getProgress();
				req.setAttribute("progress", progress);
				String gain = r3.getGain();
				req.setAttribute("gain", gain);
				String result = r3.getResult();
				req.setAttribute("result", result);
				RequestDispatcher rd = req.getRequestDispatcher("tea_report3result.jsp");
				// 转发
				rd.forward(req, resp);
				// 转发：1,获得转发器 2,将当前servlet request response 转给jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//3.返回审核结果
		if (path.equals("/report3result")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			String result = req.getParameter("result");
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");	
			TeacherDaoInf dao1 = (TeacherDaoInf) DAOFactory.getInstance("TeacherDaoInf");		
			List<Report3> rep3;
			Report3 r3 = new Report3();
			try {
				Teacher t = dao1.findByUsername(username);
			    String tname = t.getTname();
				req.setAttribute("tname", tname);			
				r3.setId(id);
				r3.setResult(result);
				dao.updateResult3(r3);
				rep3 = dao.findByGuidetea3(tname);
				req.setAttribute("rep3", rep3);
				RequestDispatcher rd = req.getRequestDispatcher("listjieti.review");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
