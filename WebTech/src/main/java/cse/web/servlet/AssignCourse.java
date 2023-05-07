package cse.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cse.web.bean.User;
import cse.web.dao.CourseDao;
import cse.web.dao.UserDao;
import cse.web.bean.Courses;

/**
 * Servlet implementation class AssignCourse
 */
@WebServlet("/AssignCourse")
public class AssignCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseDao courseDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		courseDao = new CourseDao();
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
		//doGet(request, response);
		
		String course_id = request.getParameter("course_id");
		String course_name = request.getParameter("course_name");
		String course_teacher = request.getParameter("course_teacher");
		Courses newCourse = new Courses(course_id, course_name, course_teacher);
		try {
			courseDao.insertCourse(newCourse);
			response.sendRedirect("home-admin.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
