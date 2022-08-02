import { Component, OnInit } from '@angular/core';
import { CartService } from 'src/app/cart.service';
import { Cart } from 'src/app/commons/cart';
import { Product } from 'src/app/commons/product';
import { MessengerService } from 'src/app/messenger.service';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})



export class CartComponent implements OnInit {

   cartItems: Cart[] = [];

  cartTotal = 0

  constructor(
    private msg: MessengerService,
    private cartService: CartService
  ) { }

  ngOnInit() {
    this.handleSubscription();
    this.loadCartItems();
  }

  handleSubscription() {
    this.msg.getMsg().subscribe(() => {
      this.loadCartItems();
    })
  }

  loadCartItems() {
    this.cartService.getCartItems().subscribe((items: Cart[]) => {
      this.cartItems = items;
      this.calcCartTotal();
    })
  }

  calcCartTotal() {
    this.cartTotal = 0
    this.cartItems.forEach((item: { qty: number; price: number; }) => {
      this.cartTotal += (item.qty * item.price)
    })
  }
}
