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
		// ��ȡurl��ַ
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// ���ݵ�ַ ִ�ж�Ӧ���ݿ����
				
		//�޸�����
		if (path.equals("/change")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String) session.getAttribute("username");
			UserDao dao = new UserDao();
			User u = dao.findByUsername(username);
			String pwd = req.getParameter("pwd");
			String pwd1 = req.getParameter("pwd1");
			if(pwd1.isEmpty() || pwd.isEmpty()){
				req.setAttribute("pwd_null", "�������ȷ�����벻��Ϊ��");
				req.getRequestDispatcher("adm_changepwd.jsp").forward(req, resp);
			}else if(!pwd1.equals(pwd)){
				req.setAttribute("pwd_error", "������������벻��ȷ");
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
		
		//1.��ȡ��ʦ�걨��Ŀ��Ϣ
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
		
		//��ҳ
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
		
		// 2.����id��ʾ��Ŀ���棬�����
		if (path.equals("/list")) {
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			// ����id���ҳ�������Ϣ������
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");			
			try {
				Program p = dao.findById(id);
				// ����ѯ������Ϣ����ҳ���޸�
				// ����stu_reviewresult.jspҳ����
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
				// ת��
				rd.forward(req, resp);
				// ת����1,���ת���� 2,����ǰservlet request response ת��jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//3.������˽��
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
		
		//4.��ѧ��������Ŀ���鿴resultadm=ͨ������Ϣ
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
		
		//��ҳ distribute
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
		
		//�����û�������
		if (path.equals("/username")) {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			// ����id���ҳ�������Ϣ������
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
		
		//������Ŀ�������Ŀ����ģ��
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
		
		//��ҳ
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
