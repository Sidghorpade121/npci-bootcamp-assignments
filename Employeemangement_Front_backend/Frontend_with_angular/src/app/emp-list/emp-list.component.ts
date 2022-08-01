import { Component, OnInit } from '@angular/core';
import { Employee } from '../common/employee';
import { EmpManagementServicesService } from '../services/emp-management-services.service';

@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  employees :Employee[];
  constructor(private empService : EmpManagementServicesService) { }

 
  ngOnInit(): void {
    console.log(this.getAllEmployees())
  }

  getAllEmployees(){
    this.empService. getAllEmployees().subscribe(data  => { 
      console.log(data)
    this.employees=data})
    
  }

}
