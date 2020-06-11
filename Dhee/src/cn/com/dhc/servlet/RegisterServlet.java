package cn.com.dhc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.imageio.spi.RegisterableService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.dhc.bean.User;
import cn.com.dhc.service.UserService;
import cn.com.dhc.utils.DButils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("u_name");
		String pwd = request.getParameter("u_pwd");
		String pwd2 = request.getParameter("u_pwd_2");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String email = request.getParameter("email");
		User u = new User(name, pwd, sex, email);
		if(UserService.registerService(u)) {
			request.setAttribute("name_dl", name);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
	}

}
