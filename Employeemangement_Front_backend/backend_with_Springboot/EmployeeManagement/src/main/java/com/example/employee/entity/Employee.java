package com.example.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="empno")
	private int empno;
    
    @Column(name="ENAME")
	private String ename;
    
    @Column(name="JOB")
	private String job;
    
    @Column(name="HIERDATE")
	private Date hiredate;
    
    @Column(name="SALARY")
	private int salary;
    
    @Column(name="MANAGERID")
	private int managerid;
    
    @Column(name="COMMISSION")
	private int commission;
    
    @Column(name="DEPTNO")
	private int deptno;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Employee(int empno, String ename, String job, Date hiredate, int salary, int managerid, int commission,
			int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
		this.salary = salary;
		this.managerid = managerid;
		this.commission = commission;
		this.deptno = deptno;
	}


	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	

}
