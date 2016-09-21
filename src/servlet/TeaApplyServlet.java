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
		// ��ȡurl��ַ
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// ���ݵ�ַ ִ�ж�Ӧ���ݿ����
		// 0.��ʦ������Ŀǰ��ȡ������
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
		// 1.��ʦ����ʵ����Ŀ
		if (path.equals("/add")) {
			HttpSession  session = req.getSession(); 
			String usernametea = (String)session.getAttribute("username");
			String title = req.getParameter("title");
			String guidetea = req.getParameter("guidetea");
			String need = req.getParameter("need");
			String applytime = req.getParameter("applytime");
			List<Program> pro;
			Program p = new Program();
			
			// ͨ��dao�������ݿ�
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
		
		// 2.��ʾ��Ŀȫ����Ϣ
		if (path.equals("/listallpro")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// ͨ��dao�������ݿ�
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
		
		//��ҳ
		if (path.equals("/page_teaapply")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// ͨ��dao�������ݿ�
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
		
		// 2.����id��ʾ��ʦ��ϸ����Ŀ
		if (path.equals("/detail")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			// ����id���ҳ�������Ϣ������
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
				// ת��
				rd.forward(req, resp);
				// ת����1,���ת���� 2,����ǰservlet request response ת��jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//��˲�ͨ��
		if (path.equals("/reviewfail")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			int id = Integer.parseInt(req.getParameter("id"));
			// ����id���ҳ�������Ϣ������
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
				// ת��
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
