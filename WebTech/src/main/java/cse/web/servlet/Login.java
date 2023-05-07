package cse.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cse.web.bean.User;
import cse.web.dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userDao = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_name = request.getParameter("user_name");
		String pass_word = request.getParameter("pass_word");
		
		User user = userDao.loginUser(user_name,pass_word);
		HttpSession session = request.getSession(true);
		session.setAttribute("user_name", user_name);
		session.setAttribute("full_name", user.getFull_name());
		session.setAttribute("id", user.getId());


		switch(user.getType()) {
		case "admin": {
			response.sendRedirect("home-admin.jsp");
			break;
		}
		case "teacher": {
			response.sendRedirect("home-teacher.jsp");
			break;
		}
		case "student": {
			response.sendRedirect("student.jsp");
			break;
		}
	}
		
	//oGet(request, response);
	}

}
