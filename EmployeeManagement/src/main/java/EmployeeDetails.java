
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmployeeDetails
 */
@WebServlet("/HomePage")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String emaili = (String)session.getAttribute("email");
		
		session.setAttribute("email", emaili);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		try {
			Employee e = getEmployeeDetails(emaili);
			
		
	
			
			out.print(
					 "<h1>Welcome to NPCI Employee Portal "+e.geteName()+"</h1>"
					 + "<h1>Employee Code :"+e.getEmpNo()+"</h1>"
					 +"<hr>"
					 + "<br><h5> Number of days to generate salary slip<h5>\"<head>\n"
					 + "<title>Forms</title>\n"
					 + "<meta charset=\"utf-8\">\n"
					 + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
					 + "\n"
					 + "    <!-- Bootstrap CSS -->\n"
					 + "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
					 + "\n"
					 + "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\" integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\" crossorigin=\"anonymous\"></script>\n"
					 + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js\" integrity=\"sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF\" crossorigin=\"anonymous\"></script>\n"
					 + "\n"
					 + "<link rel=\"stylesheet\" href=\"style.css\" />\n"
					 + "\n"
					 + "</head>\n"
					 + "<body style=\"margin-top : 50px\" class=\"container\">\n"
					 + "<form action=\"Payslip\" method = \"get\">\n"
					 + "<div class=\"row\">\n"
					 + "<div class=\"col-md-2\">\n"
					 + "\n"
					 + "<label class=\"form-label\">year</label> </div>\n"
					 + "</div>\n"
					 + "\n"
					 + "<div class=\"col-md-4\">\n"
					 + "<input type =\"number\" name=\"Year\" class=\"form-control\"/>\n"
					 + "</div>\n"
					 + "\n"
					 + "<div class=\"row\">\n"
					 + "<div class=\"col-md-4\">\n"
					 + "\n"
					 + "<label class=\"form-label\">month</label>\n"
					 + "<input type =\"text\" name=\"Month\" class=\"form-control\"/>\n"
					 + "</div>\n"
					 + "</div>\n"
					 + "&nbsp;\n"
					 + "<div class=\"row\">\n"
					 + "    <div class=\"col-md-4\">\n"
					 + "    \n"
					 + "    <label class=\"form-label\">No Of days</label>\n"
					 + "    <input type =\"number\" name=\"days\" class=\"form-control\"/>\n"
					 + "    </div>\n"
					 + "    </div>\n"
					 + "    &nbsp;\n"
					 + "<div class=\"row\">\n"
					 + "<div class=\"col-md-4\">\n"
					 + "\n"
					 + "<button type =\"submit\" class=\"btn btn-primary\">Submit </button>\n"
					 + "</div>\n"
					 + "</div>\n"
					 + "\n"
					 + "</form>\n"
					 + "\n"
					 + "\n"
					 + "</body>\n"
					 + "\n"
					 + "");
			
			out.print("<br><a href='Logout'>Logout</a>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	

	private Employee getEmployeeDetails(String email) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select * from Employee where emp_no = (select emp_no from LogInDetails where emailid = ?)");
		p.setString(1, email);
		
		
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
