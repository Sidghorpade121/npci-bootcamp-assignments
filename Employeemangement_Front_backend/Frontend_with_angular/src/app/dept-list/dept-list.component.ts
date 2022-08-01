import { Component, OnInit } from '@angular/core';
import { Department } from 'src/app/common/department';
import { EmpManagementServicesService } from '../services/emp-management-services.service';
@Component({
  selector: 'app-dept-list',
  templateUrl: './dept-list.component.html',
  styleUrls: ['./dept-list.component.css']
})
export class DeptListComponent implements OnInit {

  departments : Department[];
  constructor(private service : EmpManagementServicesService) { }

  ngOnInit(): void {
    console.log(this.listOfDepartments())
  }

  listOfDepartments(){
    this.service.getAllDepartments().subscribe(data => {
      console.log(data)
      this.departments = data
    })
  }

}
