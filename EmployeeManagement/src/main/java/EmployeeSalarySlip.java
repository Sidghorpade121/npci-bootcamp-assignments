
public class EmployeeSalarySlip {

	private String emp_name;
	private int dept_no;
	private int slipId;
	private int year;
	private String month;
	private int totaSalary;
	private int basicSalary;
	private int HRA;
	private int deductions;
	private int net_salary;
	
	public EmployeeSalarySlip(String emp_name, int dept_no, int slipId, int year, String month, int totaSalary,
			int basicSalary, int hRA, int deductions, int net_salary) {
		super();
		this.emp_name = emp_name;
		this.dept_no = dept_no;
		this.slipId = slipId;
		this.year = year;
		this.month = month;
		this.totaSalary = totaSalary;
		this.basicSalary = basicSalary;
		HRA = hRA;
		this.deductions = deductions;
		this.net_salary = net_salary;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public int getSlipId() {
		return slipId;
	}

	public void setSlipId(int slipId) {
		this.slipId = slipId;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getTotaSalary() {
		return totaSalary;
	}

	public void setTotaSalary(int totaSalary) {
		this.totaSalary = totaSalary;
	}

	public int getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}

	public int getHRA() {
		return HRA;
	}

	public void setHRA(int hRA) {
		HRA = hRA;
	}

	public int getDeductions() {
		return deductions;
	}

	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}

	public int getNet_salary() {
		return net_salary;
	}

	public void setNet_salary(int net_salary) {
		this.net_salary = net_salary;
	}

	@Override
	public String toString() {
		return "EmployeeSalarySlip [getEmp_name()=" + getEmp_name() + ", getDept_no()=" + getDept_no()
				+ ", getSlipId()=" + getSlipId() + ", getYear()=" + getYear() + ", getMonth()=" + getMonth()
				+ ", getTotaSalary()=" + getTotaSalary() + ", getBasicSalary()=" + getBasicSalary() + ", getHRA()="
				+ getHRA() + ", getDeductions()=" + getDeductions() + ", getNet_salary()=" + getNet_salary() + "]";
	}
	
	
	
	
	
}
