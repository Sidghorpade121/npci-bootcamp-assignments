import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,map } from 'rxjs';
import { Department } from '../common/department';
import { Employee } from '../common/employee';

@Injectable({
  providedIn: 'root'
})
export class EmpManagementServicesService {

  baseUrl="http://localhost:8080/api/emp";
  deptURL  = "http://localhost:8080/api/dept";

 
  constructor(private httpclient : HttpClient) { }

  getAllEmployees() : Observable<Employee[]>{
    
    return this.httpclient.get<GetResponseEmployee>(this.baseUrl)
    .pipe(map(response => response._embedded.employees));
  }

  getAllDepartments()  : Observable<Department[]>{
    return this.httpclient.get<getDepartmentResponse>(this.deptURL).pipe(map(response => response._embedded.departments))
  }

  create(data: any): Observable<any> {
    return this.httpclient.post(this.baseUrl, data);
  }
  createDepartment(data: any): Observable<any> {
    return this.httpclient.post(this.deptURL, data);
  }
}
interface GetResponseEmployee{
  _embedded :{
    employees : Employee[]
  }
}
interface getDepartmentResponse{
  _embedded : {
    departments : Department[]
  }
}
