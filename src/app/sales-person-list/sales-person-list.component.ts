import { Component, OnInit } from '@angular/core';
import { SalesPerson } from '../sales-person';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  
  constructor() { }

  salesPersonList : SalesPerson[] = [
    new SalesPerson("Siddhant","Ghorpade","sidghorpade.121@gmail.com",40000,3000),
    new SalesPerson("Amit","Kumawat","amit.121@gmail.com",50000,2333),
    new SalesPerson("Akash","pawade","akash.121@gmail.com",60000,4000),
    new SalesPerson("Alok","Singh","alok.121@gmail.com",70000,5000)
  ]
  SalesPerson : SalesPerson =new SalesPerson ("","","",0,0);
  ngOnInit(): void {

  }
  onSubmit(){
    console.log(this.salesPersonList);
    this.salesPersonList.push(this.SalesPerson);
  }

}
