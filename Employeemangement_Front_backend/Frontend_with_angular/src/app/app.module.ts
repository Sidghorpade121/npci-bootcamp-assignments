import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { Router,RouterModule,Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { DeptListComponent } from './dept-list/dept-list.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AddEmpComponent } from './add-emp/add-emp.component';
import { AddDeptComponent } from './add-dept/add-dept.component';
import { FormsModule } from '@angular/forms';
const route : Routes = [
  {path:'',component:WelcomeComponent} , 
  {path : 'employees',component : EmpListComponent } , 
  {path : 'departments' , component : DeptListComponent},
  {path : 'newemployee' , component : AddEmpComponent},
  {path : 'newdepartment' , component : AddDeptComponent},
  {path : 'Home' , component : WelcomeComponent},

  

]
@NgModule({
  declarations: [
    AppComponent,
    EmpListComponent,
    DeptListComponent,
    WelcomeComponent,
    AddEmpComponent,
    AddDeptComponent,
  
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(route)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
