

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
 * Servlet implementation class payslipgenerator
 */
@WebServlet("/payslipgenerator")
public class payslipgenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public payslipgenerator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email=(String) session.getAttribute("email");
		int emp_id=Integer.parseInt((String) session.getAttribute("emp_id"));
		int year=Integer.parseInt((String) session.getAttribute("year"));
		String month=(String) session.getAttribute("Month");
		int days=Integer.parseInt((String) session.getAttribute("days"));
		String emp_name=(String) session.getAttribute("name");
		int deptNo=Integer.parseInt((String) session.getAttribute("Dept_no"));
		System.out.println(email);
		System.out.println(emp_id);
		System.out.println(year);
		System.out.println(month);
		System.out.println(emp_name);
		System.out.println(deptNo);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
			EmployeeSalarySlip es;
			try {
				String Department=getdeptName(deptNo);
				es = getSalarySlip(year,month);
				
				out.print("<head>\n"
						+ "\n"
						+ "  <meta charset=\"utf-8\">\n"
						+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
						+ "\n"
						+ "  <!-- Bootstrap CSS -->\n"
						+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
						+ "    integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
						+ "\n"
						+ "  <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"\n"
						+ "    integrity=\"sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p\"\n"
						+ "    crossorigin=\"anonymous\"></script>\n"
						+ "  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js\"\n"
						+ "    integrity=\"sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF\"\n"
						+ "    crossorigin=\"anonymous\"></script>\n"
						+ "\n"
						+ "\n"
						+ "</head>\n"
						+ "\n"
						+ "<body>\n"
						+ "\n"
						+ "  <div class=\"container mt-5 mb-5\">\n"
						+ "    <div class=\"row\">\n"
						+ "      <div class=\"col-md-12\">\n"
						+ "        <div class=\"text-center lh-1 mb-2\">\n"
						+ "          <h6 class=\"fw-bold\">Payslip</h6> <span class=\"fw-normal\">Payment slip for the month of "+es.getMonth() +" "+es.getYear()+"</span>\n"
						+ "        </div>\n"
						+ "        <div class=\"d-flex justify-content-end\"> <span>Working Branch:Online Product operations and tecgnology</span> </div>\n"
						+ "        <div class=\"row\">\n"
						+ "          <div class=\"col-md-10\">\n"
						+ "            <div class=\"row\">\n"
						+ "              <div class=\"col-md-6\">\n"
						+ "                <div> <span class=\"fw-bolder\">EMP Code</span> <small class=\"ms-3\">"+emp_id+"</small> </div>\n"
						+ "              </div>\n"
						+ "              <div class=\"col-md-6\">\n"
						+ "                <div> <span class=\"fw-bolder\">EMP Name : " +es.getEmp_name()+"</span></div>\n"
						+ "              </div>\n"
						+ "            </div>\n"
						+ "            <div class=\"row\">\n"
						+ "              \n"
						+ "              <div class=\"col-md-6\">\n"
						+ "                <div> <span class=\"fw-bolder\">NOD</span> <small class=\"ms-3\">"+days+"</small> </div>\n"
						+ "              </div>\n"
						+ "            </div>\n"
						+ "            <div class=\"row\">\n"
						+ "              \n"
						+ "              \n"
						+ "                <div> <span class=\"fw-bolder\">Designation</span> <small class=\"ms-3\">GET</small> </div>\n"
						+ "              </div>\n"
						+ "              \n"
						+ "            </div>\n"
						+ "          </div>\n"
						+ "          <table class=\"mt-4 table table-bordered\">\n"
						+ "            <thead class=\"bg-dark text-white\">\n"
						+ "              <tr>\n"
						+ "                <th scope=\"col\">Earnings</th>\n"
						+ "                <th scope=\"col\">Amount</th>\n"
						+ "                <th scope=\"col\">Deductions</th>\n"
						+ "                <th scope=\"col\">Amount</th>\n"
						+ "              </tr>\n"
						+ "            </thead>\n"
						+ "            <tbody>\n"
						+ "              <tr>\n"
						+ "                <th scope=\"row\">Basic</th>\n"
						+ "                <td>"+es.getBasicSalary()+"</td>\n"
						+ "                <td>PF</td>\n"
						+ "                <td>"+es.getDeductions()+"</td>\n"
						+ "              </tr>\n"
						+ "              \n"
						+ "              <tr>\n"
						+ "                <th scope=\"row\">HRA</th>\n"
						+ "                <td>"+es.getHRA()+" </td>\n"
						+ "                <td>TDS</td>\n"
						+ "                <td>0.00</td>\n"
						+ "              </tr>\n"
						+ "              \n"
						+ "              \n"
						+ "              <tr class=\"border-top\">\n"
						+ "                <th scope=\"row\">Total Earning</th>\n"
						+ "                <td>"+es.getTotaSalary()+"</td>\n"
						+ "                <td>Total Deductions</td>\n"
						+ "                <td>"+es.getDeductions()+"</td>\n"
						+ "              </tr>\n"
						+ "            </tbody>\n"
						+ "          </table>\n"
						+ "        </div>\n"
						+ "        <div class=\"row\">\n"
						+ "          <div class=\"col-md-4\"> <br> <span class=\"fw-bold\">Net Pay : "+es.getNet_salary()+"</span> </div>\n"
						+ "          <div class=\"border col-md-8\">\n"
						+ "            \n"
						+ "        </div>\n"
						+ "        <div class=\"d-flex justify-content-end\">\n"
						+ "          <div class=\"d-flex flex-column mt-2\"> <span class=\"fw-bolder\">For NPCI</span> <span\n"
						+ "              class=\"mt-4\">Authorised Signatory</span> </div>\n"
						+ "        </div>\n"
						+ "      </div>\n"
						+ "    </div>\n"
						+ "  </div>\n"
						+ "</body>");
				
				out.print("<br><a href='Logout'>Logout</a>");
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
	
	
private EmployeeSalarySlip getSalarySlip(int year,String month) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select emp_name,dept_no,slip_id,year_of_salary,month_of_salary,total_salary,basic_salary,HRA,deductions,net_salary from Employee e join EmployeesSalarySlip s on e.emp_no=s.emp_no where year_of_salary=? and month_of_salary=?;");
		p.setInt(1, year);
		p.setString(2, month);
		
		
		ResultSet r = p.executeQuery();
		if(r.next())
			return new EmployeeSalarySlip(r.getString(1),r.getInt(2),r.getInt(3),r.getInt(4),r.getString(5),r.getInt(6),r.getInt(7),r.getInt(8),r.getInt(8),r.getInt(8));
		
		return null;
	}
private String getdeptName(int dept_no) throws ClassNotFoundException, SQLException {
	
	Connection connect = getConnection();
	PreparedStatement p = connect.prepareStatement("select  from Department where dept_no=?;");
	p.setInt(1, dept_no);
	
	
	
	ResultSet r = p.executeQuery();
	if(r.next())
		return r.getString(2);
	
	return null;
}
public Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");

	return DriverManager.getConnection("jdbc:mysql://localhost:3306/npci","root","npci@12345");
	
	
	
	
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
