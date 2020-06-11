package cn.com.dhc.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.com.dhc.bean.User;
import cn.com.dhc.dao.UserDaoImp;
import cn.com.dhc.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		User u = UserService.loginService(name);
		ArrayList<User> list = UserService.selectService();
		if(name.equals(u.getName()) && pwd.equals(u.getPwd())) {
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			request.setAttribute("name", name);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
	}

}
