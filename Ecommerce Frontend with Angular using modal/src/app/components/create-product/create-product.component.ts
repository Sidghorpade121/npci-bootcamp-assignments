import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/commons/product';
import { ProductCategory } from 'src/app/commons/product-category';
import { EcomservicesService } from 'src/app/ecomservices.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  categories : ProductCategory[]
  product: Product = {
    id: 0,
    sku: "",
    name: "",
    desciption: "",
    unit_price: 0,
    imageurl: "",
    units_in_stock: 0,
    price: 0,
    datecreated: new Date(0, 0, 0),
    lastUpdated: new Date(0, 0, 0),
    categoryId: 0
  }
  submitted = false;
  constructor(private proService: EcomservicesService,private route:Router) { }

  ngOnInit(): void {
    this.listOfCategoriess()
  }

  listOfCategoriess(){
    this.proService.getAllCategories().subscribe(data=>{
      console.log(data)
    this.categories=data
    })
  }

  saveProduct(): void {
    const data = {
      id: this.product.id,
      sku: this.product.sku,
      name: this.product.name,
      desciption: this.product.desciption,
      unit_price: this.product.unit_price,
      imageurl: this.product.imageurl,
      units_in_stock: this.product.units_in_stock,
      price: this.product.price,
      datecreated: this.product.datecreated,
      lastUpdated: this.product.lastUpdated,
      categoryId: this.product.categoryId

    };
    this.proService.createProduct(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newProduct(): void {
    this.submitted = false,
      this.product = {
        id: 0,
        sku: "",
        name: "",
        desciption: "",
        unit_price: 0,
        imageurl: "",
        units_in_stock: 0,
        price: 0,
        datecreated: new Date(0, 0, 0),
        lastUpdated: new Date(0, 0, 0),
        categoryId: 0
      }
  }

}
