

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

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class Payslipgeneration
 */
@WebServlet("/Payslipgen")
public class Payslipgeneration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public Payslipgeneration() {
        super();
        
        
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
		String email = (String)session.getAttribute("emailid");
		int year =Integer.parseInt((String) session.getAttribute("year"));
		String Year=String.valueOf(year);
		String month =(String) session.getAttribute("Month");
		int days =Integer.parseInt((String) session.getAttribute("Days"));
		String Days=String.valueOf(days);
		System.out.println(email);
		

			int Id = 0;
			try {
				Id = getEmployeeId(email);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String id=String.valueOf(Id);
		
		System.out.println(Id);
		try {
			
			Employee e = getEmployeeDetails(email);
			System.out.println(e);
			String dept_id=String.valueOf(e.getDeptNo());
			
			
			if( checkFirstSlip(Id,year,month)) {
				getEmployeeSlip(email,Id,year,month,days);
					//out.println("Welcome " + emailID);
					session.setAttribute("email", email);
					session.setAttribute("emp_id", id);
					session.setAttribute("year", Year); 
					session.setAttribute("Month", month); 
					session.setAttribute("days", Days); 
					session.setAttribute("name", e.geteName());
					session.setAttribute("Dept_no", dept_id);
					
					
					// email = emailID
					response.sendRedirect("payslipgenerator");
				}
				else {
				
					out.print("<html><body><div style = 'color :red;'><h4>Payslip already generated</h4></div></body></html>");
					RequestDispatcher dispatcher = request.getRequestDispatcher("Payslip");
					dispatcher.include(request, response);
				}
		}
			
					
			 catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
private int getEmployeeId(String email) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select emp_no from Employee where emp_no = (select emp_no from LogInDetails where emailid = ?)");
		p.setString(1, email);
		
		
		ResultSet r = p.executeQuery();
		if(r.next())
			return r.getInt(1);
		
		return 0;
	}
private Employee getEmployeeDetailsById(String email) throws ClassNotFoundException, SQLException {
	
	Connection connect = getConnection();
	PreparedStatement p = connect.prepareStatement("select * from Employee where emp_no = (select emp_no from LogInDetails where emailid = ?)");
	p.setString(1, email);
	
	
	ResultSet r = p.executeQuery();
	if(r.next())
		return new Employee(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6),r.getString(7),r.getInt(8));
	
	return null;
}

	private Boolean getEmployeeSlip(String email,int Id,int year,String month,int NoOfDays) throws ClassNotFoundException, SQLException {
		Employee e = getEmployeeDetails(email);
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("insert into EmployeesSalarySlip(emp_no,year_of_salary,month_of_salary,no_of_days,total_salary,basic_salary,HRA,deductions,net_salary) values(?,?,?,?,?*1400,?*500,?*300,?*50,?*(1400-50));");
		
		
		p.setInt(1, Id);
		p.setInt(2, year);
		p.setString(3, month);
		p.setInt(4,NoOfDays);
		p.setInt(5,NoOfDays);
		p.setInt(6,NoOfDays);
		p.setInt(7,NoOfDays);
		p.setInt(8,NoOfDays);
		p.setInt(9,NoOfDays);
		
		
		int i=p.executeUpdate();
		if(i != 0)
			return true;
		return false;
		
		
	}private Boolean checkFirstSlip(int Id,int year,String month) throws ClassNotFoundException, SQLException {
		
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("select * from EmployeesSalarySlip where month_of_salary=? and year_of_salary=? and emp_no=?;");
		
		
		
		
		p.setString(1, month);
		p.setInt(2, year);
		p.setInt(3, Id);
		
		
		
		ResultSet r = p.executeQuery();
		
		if(!r.next())
		{
		    return true;
		}
		else 
			return false;
		
		
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/npci","root","npci@12345");
		
		
		
		
		
	}

	
}
