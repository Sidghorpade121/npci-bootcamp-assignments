import { Component, OnInit } from '@angular/core';
import { Employee } from '../common/employee';
import { EmpManagementServicesService } from '../services/emp-management-services.service';
@Component({
  selector: 'app-add-emp',
  templateUrl: './add-emp.component.html',
  styleUrls: ['./add-emp.component.css']
})
export class AddEmpComponent implements OnInit {

  employee: Employee = {
    empno: 0,
   ename: '',
   job:'',
   hireDate: new Date(2012, 0, 1),
   managerId:0,
   salary:0,
   commission:0,
   deptNo:0
  }
  submitted = false;

  constructor(private emplService: EmpManagementServicesService) { }

  ngOnInit(): void {
  }
  saveEmployee(): void {
    const data = {
      empno: this.employee.empno,
      ename: this.employee.ename,
      job: this.employee.job,
      hiredate: this.employee.hireDate,
      managerId: this.employee.managerId,
      salary: this.employee.salary,
      commission: this.employee.commission,
      deptNo:this.employee.deptNo

    };
    this.emplService.create(data)
    .subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
    }

      newEmployee(): void {
        this.submitted = false,
        this.employee = {
          empno: 0,
          ename:"",
          job:"",
          hireDate:new Date(0,0,0),
          managerId:0,
          salary:0,
          commission:0,
          deptNo:0
        }
      }
    
    }
  




