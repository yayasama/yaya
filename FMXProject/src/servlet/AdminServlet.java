package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DAOFactory;
import dal.ApplyDaoInf;
import dal.TeacherDaoInf;
import dao.PageDao;
import dao.UserDao;
import entity.Program;
import entity.Teacher;
import entity.User;

public class AdminServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// 获取url地址
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// 根据地址 执行对应数据库操作
				
		//修改密码
		if (path.equals("/change")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String) session.getAttribute("username");
			UserDao dao = new UserDao();
			User u = dao.findByUsername(username);
			String pwd = req.getParameter("pwd");
			String pwd1 = req.getParameter("pwd1");
			if(pwd1.isEmpty() || pwd.isEmpty()){
				req.setAttribute("pwd_null", "新密码或确认密码不能为空");
				req.getRequestDispatcher("adm_changepwd.jsp").forward(req, resp);
			}else if(!pwd1.equals(pwd)){
				req.setAttribute("pwd_error", "两次输入的密码不正确");
				req.getRequestDispatcher("adm_changepwd.jsp").forward(req, resp);
			}else if(pwd1.equals(pwd)){
				try {
					u.setPwd(pwd);
					u.setUsername(username);
					dao.updatePwd(u);
					req.getRequestDispatcher("adm_changesuccess.jsp").forward(req, resp);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 }
		
		//1.获取教师申报项目信息
		if (path.equals("/listtea")) {
			req.setCharacterEncoding("utf-8");
			List<Program> pro;
			PageDao dao = new PageDao();
			pro = dao.findByPage_review(1, 10);
			List<Integer> pageinf = dao.getPageinf();
			req.setAttribute("pro", pro);
			req.setAttribute("pageinf", pageinf);
			req.getRequestDispatcher("adm_review.jsp").forward(req, resp);
		}
		
		//分页
		if(path.equals("/page_review")){
			req.setCharacterEncoding("utf-8");
			     List<Program> pro;
				 PageDao dao = new PageDao();
				 int currentPage = Integer.parseInt(req.getParameter("currentPage"));
				 int pageSize = Integer.parseInt(req.getParameter("pageSize"));	
				 try {
					 pro = dao.findByPage_review(currentPage, pageSize);
				     List<Integer> pageinf =dao.getPageinf();
				     req.setAttribute("pro", pro);     
				     req.setAttribute("pageinf", pageinf);
				     req.getRequestDispatcher("adm_review.jsp").forward(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}	     
		}
		
		// 2.根据id显示项目报告，并审核
		if (path.equals("/list")) {
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			// 根据id查找出此条信息的内容
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");			
			try {
				Program p = dao.findById(id);
				// 将查询到的信息用于页面修改
				// 传到stu_reviewresult.jsp页面中
				req.setAttribute("id", id);
				String title = p.getTitle();
				req.setAttribute("title", title);
				String guidetea = p.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String need = p.getNeed();
				req.setAttribute("need", need);
				String resultadm = p.getResultadm();
				req.setAttribute("resultadm", resultadm);
				String applytime = p.getApplytime();
				req.setAttribute("applytime", applytime);
				RequestDispatcher rd = req.getRequestDispatcher("adm_reviewresult.jsp");
				// 转发
				rd.forward(req, resp);
				// 转发：1,获得转发器 2,将当前servlet request response 转给jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//3.返回审核结果
		if (path.equals("/resultadm")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String resultadm = req.getParameter("resultadm");
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			List<Program> pro;
			Program p = new Program();
			try {
				p.setId(id);
				p.setResultadm(resultadm);
				dao.updateResultadm(p);
				
				pro = dao.findAll();
				req.setAttribute("pro", pro);
				RequestDispatcher rd = req.getRequestDispatcher("listtea.admin");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//4.向学生发布项目，查看resultadm=通过的信息
		if (path.equals("/distribute")) {
			req.setCharacterEncoding("utf-8");
			List<Program> pro;
			PageDao dao = new PageDao();
			pro = dao.findByPage_dis(1, 10);
			List<Integer> pageinf = dao.getPageinf();
			req.setAttribute("pro", pro);
			req.setAttribute("pageinf", pageinf);
			req.getRequestDispatcher("adm_distribute.jsp").forward(req, resp);
		}
		
		//分页 distribute
		if(path.equals("/page_dis")){
			req.setCharacterEncoding("utf-8");
			     List<Program> pro;
				 PageDao dao = new PageDao();
				 int currentPage = Integer.parseInt(req.getParameter("currentPage"));
				 int pageSize = Integer.parseInt(req.getParameter("pageSize"));	 
				 try {
					 pro = dao.findByPage_dis(currentPage, pageSize);
				     List<Integer> pageinf =dao.getPageinf();
				     req.setAttribute("pro", pro);     
				     req.setAttribute("pageinf", pageinf);
				     req.getRequestDispatcher("adm_distribute.jsp").forward(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}	     
		}
		
		if (path.equals("/prostate")) {
			int id = Integer.parseInt(req.getParameter("id"));
			String prostate = req.getParameter("prostate");
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			List<Program> pro;
			Program p = new Program();
			try {
				p.setId(id);
				p.setProstate(prostate);
				dao.updateProstate(p);
				pro = dao.findPassPro();
				req.setAttribute("pro", pro);
				RequestDispatcher rd = req.getRequestDispatcher("distribute.admin");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//根据用户名搜索
		if (path.equals("/username")) {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			// 根据id查找出此条信息的内容
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			try {
				Program p = dao.findByUsername(username);
				if (p.getTitle() == null) {
					req.getRequestDispatcher("adm_filter.jsp").forward(req,resp);
				} else {
					req.setAttribute("username", username);
					String title = p.getTitle();
					req.setAttribute("title", title);
					String sname = p.getSname();
					req.setAttribute("sname", sname);
					String guidetea = p.getGuidetea();
					req.setAttribute("guidetea", guidetea);
					String finish = p.getFinish();
					req.setAttribute("finish", finish);
					String resulttea = p.getResulttea();
					req.setAttribute("resulttea", resulttea);
					String finishtime = p.getFinishtime();
					req.setAttribute("finishtime", finishtime);
					RequestDispatcher rd = req.getRequestDispatcher("adm_managefilter.jsp");
					rd.forward(req, resp);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
		
		//传入项目情况，项目管理模块
		if (path.equals("/manage")) {
			req.setCharacterEncoding("utf-8");
			List<Program> pro;
			PageDao dao = new PageDao();
			pro = dao.findByPage_manage(1, 10);
			List<Integer> pageinf = dao.getPageinf();
			req.setAttribute("pro", pro);
			req.setAttribute("pageinf", pageinf);
			req.getRequestDispatcher("adm_manage.jsp").forward(req, resp);
		}
		
		//分页
		if(path.equals("/page")){
			req.setCharacterEncoding("utf-8");
			     List<Program> pro;
				 PageDao dao = new PageDao();
				 int currentPage = Integer.parseInt(req.getParameter("currentPage"));
				 int pageSize = Integer.parseInt(req.getParameter("pageSize"));	 
				 try {
					 pro = dao.findByPage_manage(currentPage, pageSize);
				     List<Integer> pageinf =dao.getPageinf();
				     req.setAttribute("pro", pro);     
				     req.setAttribute("pageinf", pageinf);
				     req.getRequestDispatcher("adm_manage.jsp").forward(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}	     
		}
	}
}
