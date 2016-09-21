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
import dal.ReportDaoInf;
import dal.StudentDaoInf;
import dal.TeacherDaoInf;
import dao.PageDao;
import dao.PageDaoStu;
import entity.Program;
import entity.Report1;
import entity.Student;
import entity.Teacher;
import entity.User;
import util.DAOFactory;


public class StuApplyServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// ��ȡurl��ַ
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// ���ݵ�ַ ִ�ж�Ӧ���ݿ����
		
		//�ж�ѧ��ʵ����Ŀ������
		/*
		 * 1.���ѧ��Ϊ�գ���ѧ����û���걨��Ŀ����ת���걨��Ŀ����
		 * 2.���ѧ�Ų�Ϊ�գ�����Ŀ״̬Ϊ�����
		 * 3.�����Ŀ״̬Ϊ��ͨ�������޸���Ŀ
		 * 4.�����Ŀͨ������ʾ����Ŀ����Ϣ 
		 */
		if (path.equals("/judgeapply")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			StudentDaoInf dao1 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			resp.setContentType("text/html;charset=utf-8");
			try {
				Student s = dao1.findByUsername(username);
			    String sname = s.getSname();
				req.setAttribute("sname", sname);
				Program p = dao.findByUsername(username);
				req.setCharacterEncoding("utf-8");
				if (p.getUsername() == null) {
					RequestDispatcher rd = req.getRequestDispatcher("listteapro.apply");
					rd.forward(req, resp);
				} else if (p.getUsername() != null && p.getResulttea().equals("�����")) {			
					RequestDispatcher rd = req.getRequestDispatcher("stu_judge2_list.jsp");
					rd.forward(req, resp);
				}else if(p.getResulttea().equals("��ͨ��")){
					RequestDispatcher rd = req.getRequestDispatcher("stu_judge3_list.jsp");
					rd.forward(req, resp);
				} else if(p.getResulttea().equals("ͨ��")){
					RequestDispatcher rd = req.getRequestDispatcher("stu_judgeapply.jsp");
					rd.forward(req, resp);
				} 
			}catch (Exception e1) {
					e1.printStackTrace();
			}
	   }
		
		//��ȡ��ʦ�걨��Ŀ
		if (path.equals("/listteapro")) {
			req.setCharacterEncoding("utf-8");
			List<Program> pro;
			PageDaoStu dao = new PageDaoStu();
			pro = dao.findByPage_stuapply(1, 10);
			List<Integer> pageinf = dao.getPageinf();
			req.setAttribute("pro", pro);
			req.setAttribute("pageinf", pageinf);
			req.getRequestDispatcher("stu_applytea.jsp").forward(req, resp);
		}
		
		//��ҳ
		if(path.equals("/page_applyteapro")){
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
				     req.getRequestDispatcher("stu_applytea.jsp").forward(req, resp);
				} catch (Exception e) {
					e.printStackTrace();
				}	     
		}
		
		// 2.����id��ʾ��Ŀ���棬���걨
		if (path.equals("/listprobyid")) {
			req.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(req.getParameter("id"));
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");	
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		    String finishtime = sd.format(new Date());
			// ����id���ҳ�������Ϣ������
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");	
			StudentDaoInf dao2 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			try {
				Student s = dao2.findByUsername(username);
				String sname = s.getSname();
				req.setAttribute("sname", sname);
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
				req.setAttribute("finishtime", finishtime);
				RequestDispatcher rd = req.getRequestDispatcher("stu_applyresult.jsp");
				// ת��
				rd.forward(req, resp);
				// ת����1,���ת���� 2,����ǰservlet request response ת��jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	
		//3.�޸���󷵻�
		if (path.equals("/applyedit")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = req.getParameter("username");
			String sname = req.getParameter("sname");
			String title = req.getParameter("title");
			String finishtime = req.getParameter("finishtime");
			String guidetea = req.getParameter("guidetea");
			String need = req.getParameter("need");
			String content = req.getParameter("content");
			
			List<Program> pro;
			Program p = new Program();
			
			// ͨ��dao�������ݿ�
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			try {
				p.setUsername(username);
				p.setSname(sname);
				p.setTitle(title);
				p.setFinishtime(finishtime);
				p.setGuidetea(guidetea);
				p.setNeed(need);
				p.setContent(content);
				dao.saveApply(p);			
				req.setAttribute("sname", sname);
				RequestDispatcher rd = req.getRequestDispatcher("stu_subsuccess.jsp");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//4.�鿴����
		if (path.equals("/all")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// ����id���ҳ�������Ϣ������
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");			
			try {
				Program p = dao.findByUsername(username);
				// ����ѯ������Ϣ����ҳ����
				req.setAttribute("username", username);
				String sname = p.getSname();
				req.setAttribute("sname", sname);
				String title = p.getTitle();
				req.setAttribute("title", title);
				String guidetea = p.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String need = p.getNeed();
				req.setAttribute("need", need);
				String content = p.getContent();
				req.setAttribute("content", content);
				String finishtime = p.getFinishtime();
				req.setAttribute("finishtime", finishtime);
				RequestDispatcher rd = req.getRequestDispatcher("stu_judgeapplyall.jsp");
				// ת��
				rd.forward(req, resp);
				// ת����1,���ת���� 2,����ǰservlet request response ת��jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//��˲�ͨ���޸�
		if (path.equals("/reviewfail")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// ����id���ҳ�������Ϣ������
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");			
			try {
				Program p = dao.findByUsername(username);
				// ����ѯ������Ϣ����ҳ����
				req.setAttribute("username", username);
				String sname = p.getSname();
				req.setAttribute("sname", sname);
				String title = p.getTitle();
				req.setAttribute("title", title);
				String guidetea = p.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String need = p.getNeed();
				req.setAttribute("need", need);
				String content = p.getContent();
				req.setAttribute("content", content);
				String finishtime = p.getFinishtime();
				req.setAttribute("finishtime", finishtime);
				RequestDispatcher rd = req.getRequestDispatcher("stu_apply.jsp");
				// ת��
				rd.forward(req, resp);
				// ת����1,���ת���� 2,����ǰservlet request response ת��jsp
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (path.equals("/applyedit")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			String content = req.getParameter("content");
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		    String finishtime = sd.format(new Date());
			try {
				ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
				StudentDaoInf dao1 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
				Program p = new Program();
				p.setUsername(username);
				p.setContent(content);
				p.setFinishtime(finishtime);
				if(content != null){
				    dao.SetFinish(p);
				    dao.updateContent(p);
				    dao.SetFinishtime(p);
				    Student s = dao1.findByUsername(username);
				    String sname = s.getSname();
					req.setAttribute("sname", sname);
					RequestDispatcher rd = req.getRequestDispatcher("stu_subsuccess.jsp");
					rd.forward(req, resp);
				}	
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//��.�鿴���
		if (path.equals("/result")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// ͨ��dao�������ݿ�
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			StudentDaoInf dao1 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			// ͨ��dao����
			try {		
				Student s = dao1.findByUsername(username);
			    String sname = s.getSname();
				req.setAttribute("sname", sname);
				Program p = dao.findByUsername(username );
				// ����stu_result.jspҳ����
				if (p.getProstate() == null) {
					RequestDispatcher rd = req.getRequestDispatcher("stu_judge1.jsp");
					rd.forward(req, resp);
					} else{
						req.setAttribute("sname", sname);
						String title = p.getTitle();
						req.setAttribute("title", title);
						String resulttea = p.getResulttea();
						req.setAttribute("resulttea", resulttea);
				        // ת����1,���ת���� 2,����ǰservlet request response ת��jsp
				       RequestDispatcher rd = req.getRequestDispatcher("stu_result.jsp");
				       // ת��
				      rd.forward(req, resp);
				      }
				} catch (Exception e1) {
					e1.printStackTrace();
			}
		}
	}
}
