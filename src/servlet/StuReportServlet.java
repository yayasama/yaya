package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dal.ApplyDaoInf;
import dal.ReportDaoInf;
import dal.StudentDaoInf;
import entity.Program;
import entity.Report1;
import entity.Report2;
import entity.Report3;
import entity.Student;
import util.DAOFactory;

public class StuReportServlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// ��ȡurl��ַ
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));

		 /*�ж�
		 * 1. resultadmΪ��ͨ������prostateΪ�� -> �㻹û��ʵ����Ŀ��
		 * 2. content����д��rsultteaΪ�� -> ���ʵ����Ŀ��������У�
		 * 3. resulttea="��ͨ��" -> ���ʵ����Ŀ���ʧ�ܣ�����ϵ���ָ����ʦ�����޸ġ�
		 * 4. resulttea ="ͨ��" && "progress" ="" -> stu_report.jsp
		 * 5. progress ="XXXX" && gain="" -> �ύ�ɹ���
		 */
		// һ. 1.���ȱ����ж�
		if (path.equals("/judge1")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			StudentDaoInf dao1 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			ReportDaoInf dao2 = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			resp.setContentType("text/html;charset=utf-8");
			try {
				req.setCharacterEncoding("utf-8");
				Program p = dao.findByUsername(username);
				Report1 r1 = dao2.findByUsername(username);
				Student s = dao1.findByUsername(username);
			    String sname = s.getSname();
				req.setAttribute("sname", sname);
				if (p.getUsername() == null) {
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge1.jsp");
				     rd.forward(req, resp);
				} else if(p.getContent() != null && p.getResulttea().equals("�����")){
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge2.jsp");
				     rd.forward(req, resp);
				}else if(p.getResulttea().equals("��ͨ��")){
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge3.jsp");
				     rd.forward(req, resp);
				}else if(p.getResulttea().equals("ͨ��") && r1.getProgress() == null){
					try {
						req.setAttribute("username", username);
						String guidetea = p.getGuidetea();
						req.setAttribute("guidetea", guidetea);
						RequestDispatcher rd = req.getRequestDispatcher("stu_report1.jsp");
						rd.forward(req, resp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(r1.getProgress() != null && r1.getGain() != null){
					RequestDispatcher rd = req.getRequestDispatcher("listpro1.report");
					rd.forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		
		//2.���ڱ���
		if (path.equals("/judge2")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			StudentDaoInf dao1 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			ReportDaoInf dao2 = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			resp.setContentType("text/html;charset=utf-8");
			try {
				req.setCharacterEncoding("utf-8");
				Program p = dao.findByUsername(username);
				Report2 r2 = dao2.findByUsername2(username);
				Student s = dao1.findByUsername(username);
			    String sname = s.getSname();
				req.setAttribute("sname", sname);
				if (p.getUsername() == null) {
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge1.jsp");
				     rd.forward(req, resp);
				} else if(p.getContent() != null && p.getResulttea() == null){
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge2.jsp");
				     rd.forward(req, resp);
				}else if(p.getResulttea().equals("��ͨ��")){
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge3.jsp");
				     rd.forward(req, resp);
				}else if(p.getResulttea().equals("ͨ��") && r2.getProgress() == null){
					try {
						req.setAttribute("username", username);
						String guidetea = p.getGuidetea();
						req.setAttribute("guidetea", guidetea);
						RequestDispatcher rd = req.getRequestDispatcher("stu_report2.jsp");
						rd.forward(req, resp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(r2.getProgress() != null && r2.getGain() != null){
					RequestDispatcher rd = req.getRequestDispatcher("listpro2.report");
					rd.forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		
		//3. ���ⱨ��
		if (path.equals("/judge3")) {
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			ApplyDaoInf dao = (ApplyDaoInf) DAOFactory.getInstance("ApplyDaoInf");
			StudentDaoInf dao1 = (StudentDaoInf) DAOFactory.getInstance("StudentDaoInf");
			ReportDaoInf dao2 = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			resp.setContentType("text/html;charset=utf-8");
			try {
				req.setCharacterEncoding("utf-8");
				Program p = dao.findByUsername(username);
				Report3 r3 = dao2.findByUsername3(username);
				Student s = dao1.findByUsername(username);
			    String sname = s.getSname();
				req.setAttribute("sname", sname);
				if (p.getUsername() == null) {
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge1.jsp");
				     rd.forward(req, resp);
				}else if(p.getContent() != null && p.getResulttea() == null){
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge2.jsp");
				     rd.forward(req, resp);
				}else if(p.getResulttea().equals("��ͨ��")){
					 RequestDispatcher rd = req.getRequestDispatcher("stu_judge3.jsp");
				     rd.forward(req, resp);
				}else if(p.getResulttea().equals("ͨ��") && r3.getProgress() == null){
					try {
						req.setAttribute("username", username);
						String guidetea = p.getGuidetea();
						req.setAttribute("guidetea", guidetea);
						RequestDispatcher rd = req.getRequestDispatcher("stu_report3.jsp");
						rd.forward(req, resp);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if(r3.getProgress() != null && r3.getGain() != null){
					RequestDispatcher rd = req.getRequestDispatcher("listpro3.report");
					rd.forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		
		
		// ��.��ӱ���
		//1.���뼾�ȱ���
		if (path.equals("/add1")) {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			String sname = req.getParameter("sname");
			String title = req.getParameter("title");
			String guidetea = req.getParameter("guidetea");
			String progress = req.getParameter("progress");
			String gain = req.getParameter("gain");

			// ͨ��dao�������ݿ�
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			Report1 r1 = new Report1();
			try {
				resp.setContentType("text/html;charset=utf-8");
				r1.setUsername(username);
				r1.setSname(sname);
				r1.setTitle(title);
				r1.setGuidetea(guidetea);
				r1.setProgress(progress);
				r1.setGain(gain);
				dao.save(r1);
				req.setAttribute("sname", sname);
				RequestDispatcher rd = req.getRequestDispatcher("stu_subsuccess.jsp");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 2.�������ڱ���
		if (path.equals("/add2")) {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			String sname = req.getParameter("sname");
			String title = req.getParameter("title");
			String guidetea = req.getParameter("guidetea");
			String progress = req.getParameter("progress");
			String gain = req.getParameter("gain");

			// ͨ��dao�������ݿ�
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			Report2 r2 = new Report2();
			try {
				r2.setUsername(username);
				r2.setSname(sname);
				r2.setGuidetea(guidetea);
				r2.setTitle(title);
				r2.setProgress(progress);
				r2.setGain(gain);
				dao.save(r2);
				req.setAttribute("sname", sname);
				RequestDispatcher rd = req.getRequestDispatcher("stu_subsuccess.jsp");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 3.������ⱨ��
		if (path.equals("/add3")) {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			String sname = req.getParameter("sname");
			String guidetea = req.getParameter("guidetea");
			String title = req.getParameter("title");
			String progress = req.getParameter("progress");
			String gain = req.getParameter("gain");

			// ͨ��dao�������ݿ�
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			Report3 r3 = new Report3();
			try {
				r3.setUsername(username);
				r3.setSname(sname);
				r3.setGuidetea(guidetea);
				r3.setTitle(title);
				r3.setProgress(progress);
				r3.setGain(gain);
				dao.save(r3);
				req.setAttribute("sname", sname);
				RequestDispatcher rd = req.getRequestDispatcher("stu_subsuccess.jsp");
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//�������ύ����ʾ�����������Ϣ
		//1.���ȱ���
		if (path.equals("/listpro1")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// ͨ��dao�������ݿ�
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			try {		
				Report1 r1 = dao.findByUsername(username);
				// ����stu_result.jspҳ����
				req.setAttribute("username", username);
				String sname = r1.getSname();
				req.setAttribute("sname", sname);
				String title = r1.getTitle();
				req.setAttribute("title", title);
				String guidetea =r1.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String progress =r1.getProgress();
				req.setAttribute("progress", progress);
				String gain =r1.getGain();
				req.setAttribute("gain", gain);
				String result =r1.getResult();
				req.setAttribute("result", result);
				// ת����1,���ת���� 2,����ǰservlet request response ת��jsp
				RequestDispatcher rd = req.getRequestDispatcher("stu_judgerep.jsp");
				// ת��
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		//2.���ڱ���
		if (path.equals("/listpro2")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// ͨ��dao�������ݿ�
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			try {		
				Report2 r2 = dao.findByUsername2(username);
				// ����stu_result.jspҳ����
				req.setAttribute("username", username);
				String sname = r2.getSname();
				req.setAttribute("sname", sname);
				String title = r2.getTitle();
				req.setAttribute("title", title);
				String guidetea =r2.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String progress =r2.getProgress();
				req.setAttribute("progress", progress);
				String gain =r2.getGain();
				req.setAttribute("gain", gain);
				String result =r2.getResult();
				req.setAttribute("result", result);
				// ת����1,���ת���� 2,����ǰservlet request response ת��jsp
				RequestDispatcher rd = req.getRequestDispatcher("stu_judgerep.jsp");
				// ת��
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		//3.���ⱨ��
		if (path.equals("/listpro3")) {
			req.setCharacterEncoding("utf-8");
			HttpSession  session = req.getSession(); 
			String username = (String)session.getAttribute("username");
			// ͨ��dao�������ݿ�
			ReportDaoInf dao = (ReportDaoInf) DAOFactory.getInstance("ReportDaoInf");
			try {		
				Report3 r3 = dao.findByUsername3(username);
				// ����stu_result.jspҳ����
				req.setAttribute("username", username);
				String sname = r3.getSname();
				req.setAttribute("sname", sname);
				String title = r3.getTitle();
				req.setAttribute("title", title);
				String guidetea =r3.getGuidetea();
				req.setAttribute("guidetea", guidetea);
				String progress =r3.getProgress();
				req.setAttribute("progress", progress);
				String gain =r3.getGain();
				req.setAttribute("gain", gain);
				String result =r3.getResult();
				req.setAttribute("result", result);
				// ת����1,���ת���� 2,����ǰservlet request response ת��jsp
				RequestDispatcher rd = req.getRequestDispatcher("stu_judgerep.jsp");
				// ת��
				rd.forward(req, resp);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
