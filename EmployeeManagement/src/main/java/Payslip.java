

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SalarySlipGenerationValidation
 */
@WebServlet("/Payslip")
public class Payslip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payslip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String email = (String)session.getAttribute("email");
		//session.setAttribute("emailid", email);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String year = request.getParameter("Year");
		String month = request.getParameter("Month");
		//String email1=session.getAttribute(email);
		//String id = request.getParameter("emp_no");
		String days = request.getParameter("days");
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(email);
		System.out.println(days);
		
		try {
			if(!validate(year,month)) {
				
				
				
				session.setAttribute("year", year);
				session.setAttribute("emailid", email);
				session.setAttribute("Month", month);
				session.setAttribute("Days", days);
				// email = emailID
				response.sendRedirect("Payslipgen");
				
			}
			else {
			
				out.print("<html><body><div style = 'color :red;'><h4>Payslip already generated !</h4></div></body></html>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage");
				dispatcher.include(request, response);
			}
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private boolean validate(String Year, String Month) throws SQLException, ClassNotFoundException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select * from EmployeesSalarySlip where year_of_salary= ? and month_of_salary=?;");
		p.setString(1, Year);
		p.setString(2, Month);
		
		ResultSet r = p.executeQuery();
		
		if(r.next())
			return true;
		
		return false;
	}

	private Employee getEmployeeDetails(int emp_no) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select * from Employee where emp_no = ?");
		p.setInt(1, emp_no);
		
		
		ResultSet r = p.executeQuery();
		if(r.next())
			return new Employee(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6),r.getString(7),r.getInt(8));
		
		return null;
	}


	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/npci","root","npci@12345");
		
		
		
		
		
	}

	

}


	
