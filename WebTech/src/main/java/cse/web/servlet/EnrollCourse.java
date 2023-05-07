package cse.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnrollCourse
 */
@WebServlet("/EnrollCourse")
public class EnrollCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_ENROLL_SQL = "INSERT INTO enroll" + "  (user_name, full_name, course_id, course_name, course_teacher) VALUES "
			+ " (?, ?, ?, ?, ?);";
	
	private static final String SELECT_ENROLL_BY_ID = "select * from enroll where user_name =? and course_id =?";
	
	private static final String SELECT_ENROLL_BY_USERNAME = "select * from enroll where user_name =?";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollCourse() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String user_name = (String)request.getSession(false).getAttribute("user_name");
		String full_name = (String)request.getSession(false).getAttribute("full_name");
		// Get the selected course parameters
		String course_id = request.getParameter("course_id");
		String course_name = request.getParameter("course_name");
		String course_teacher = request.getParameter("course_teacher");
		List<String[]> courseData = new ArrayList<String[]>();
		
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ENROLL_BY_ID);) {
			preparedStatement.setString(1, user_name);
			preparedStatement.setString(2, course_id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			if(!rs.next()) {
				PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_ENROLL_SQL);
				preparedStatement1.setString(1, user_name);
				preparedStatement1.setString(2, full_name);
				preparedStatement1.setString(3, course_id);
				preparedStatement1.setString(4, course_name);
				preparedStatement1.setString(5, course_teacher);
				System.out.println(preparedStatement1);
				preparedStatement1.executeUpdate();
				
				
			}
			PreparedStatement preparedStatement2 = connection.prepareStatement(SELECT_ENROLL_BY_USERNAME);
			preparedStatement2.setString(1, user_name);
			System.out.println(preparedStatement2);
			ResultSet rs1 = preparedStatement2.executeQuery();
			while (rs1.next()) {
				String ara[] = {rs1.getString(1), rs1.getString(2), rs1.getString(3),rs1.getString(4),rs1.getString(5)};
				courseData.add(ara);
				
			}
			
			request.setAttribute("user_name", user_name);
			request.setAttribute("full_name", full_name);
			request.setAttribute("courses", courseData);
			request.getRequestDispatcher("student.jsp").forward(request, response);
		} catch (SQLException e) {
			printSQLException(e);
		}
		response.sendRedirect("student.jsp");
		
	}
	
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
