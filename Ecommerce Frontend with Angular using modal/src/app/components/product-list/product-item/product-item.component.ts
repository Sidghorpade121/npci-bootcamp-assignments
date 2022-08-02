import { Component, Input, OnInit } from '@angular/core';
import { CartService } from 'src/app/cart.service';
import { Product } from 'src/app/commons/product';
import { MessengerService } from 'src/app/messenger.service';
import { ProductListComponent } from '../product-list.component';

@Component({
  selector: 'app-product-item',
  templateUrl: './product-item.component.html',
  styleUrls: ['./product-item.component.css']
})
export class ProductItemComponent implements OnInit {

  display = "none";
  @Input() productsItem: Product;
  constructor( private cartService: CartService,
    private msg:MessengerService) { }

  ngOnInit(): void {
    
  }
  handleAddToCart() {
    console.log(this.productsItem);
    this.cartService.addProductToCart(this.productsItem).subscribe(() => {
      this.msg.sendMsg(this.productsItem)
    })
  }

  openModal() {
    this.display = "block";
  }
  onCloseHandled() {
    this.display = "none";
  }

}
