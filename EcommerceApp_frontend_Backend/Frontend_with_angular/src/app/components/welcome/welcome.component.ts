import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private route : Router) { }

  ngOnInit(): void {
  }

  ProductDetails(){
    this.route.navigateByUrl("/products")
}
Categorydetails(){
  this.route.navigateByUrl("/categories")
}
NewProduct(){
this.route.navigateByUrl("/newProduct")
}
NewCategory(){
this.route.navigateByUrl("/newCategory")
}

}
