package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		// ��ȡurl��ַ
		String url = req.getRequestURI();
		String path = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		// ���ݵ�ַ ִ�ж�Ӧ���ݿ����
		
		// ��½
		if (path.equals("/login")) {
			String username = req.getParameter("username");
			UserDao dao = new UserDao();
			System.out.println(username);
			User u = dao.findByUsername(username);
			String pwd = req.getParameter("pwd");
			System.out.println(pwd);
			
			if (username.isEmpty()) {
				req.setAttribute("username_null", "�û�������Ϊ��");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else if (u == null) {
				req.setAttribute("username_error", "�û���������");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}else if (!u.getPwd().equals(pwd)) {
				req.setAttribute("pwd_error", "���벻��ȷ");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			} else if(u.getUsergroup()==1){
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				resp.sendRedirect("listtea.admin");
			}else if(u.getUsergroup()==2){
				HttpSession session = req.getSession();
				session.setAttribute("username",username);
				resp.sendRedirect("listallpro.apply2");
			}else if(u.getUsergroup()==3){
				HttpSession session = req.getSession();
				session.setAttribute("username",username);
			    resp.sendRedirect("judgeapply.apply");
			  }
		 }
	 }
}
