import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/commons/product';
import { EcomservicesService } from 'src/app/ecomservices.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})

export class ProductListComponent implements OnInit {

  products: Product[] = [];

  constructor(private service : EcomservicesService) { }

  ngOnInit(): void {
    console.log(this.listOfProducts())
  }

  listOfProducts(){
    this.service.getAllProducts().subscribe(data => {
      console.log(data)
      this.products = data
    })
  }

}
