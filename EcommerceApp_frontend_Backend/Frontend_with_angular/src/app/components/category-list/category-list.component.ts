import { Component, OnInit } from '@angular/core';
import { ProductCategory } from 'src/app/commons/product-category';
import { EcomservicesService } from 'src/app/ecomservices.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categories : ProductCategory[];
  constructor(private service : EcomservicesService) { }

  ngOnInit(): void {
    console.log(this.listOfDepartments())
  }

  listOfDepartments(){
    this.service.getAllCategories().subscribe(data => {
      console.log(data)
      this.categories = data
    })
  }


}
