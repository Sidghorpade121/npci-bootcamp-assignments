import { Component, OnInit } from '@angular/core';
import { ProductCategory } from 'src/app/commons/product-category';
import { EcomservicesService } from 'src/app/ecomservices.service';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent implements OnInit {

  category: ProductCategory = {
    categoryId: 0,
    categoryname: ''
 
  }
  submitted = false;

  constructor(private catService: EcomservicesService) { }
  ngOnInit(): void {
  }

  saveCategory(): void {
    const data = {
      categoryId: this.category.categoryId,
      categoryname: this.category.categoryname
     
    

    };
    this.catService.createCategory(data)
    .subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
    }

    newCategory(): void {
      this.submitted = false,
      this.category = {
        categoryId: 0,
        categoryname: ''
      }
    }


}
