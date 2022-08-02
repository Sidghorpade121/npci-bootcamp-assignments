import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Cart } from './commons/cart';
import { Product } from './commons/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  constructor(private http: HttpClient) { }

  private cartUrl='http://localhost:8080/api/cart'
  getCartItems(): Observable<Cart[]> {
    //TODO: Mapping the obtained result to our CartItem props. (pipe() and map())
    return this.http.get<Cart[]>(this.cartUrl).pipe(
      map((result: any[]) => {
        let cartItems: Cart[] = [];

        for (let item of result) {
          let productExists = false

          for (let i in cartItems) {
            if (cartItems[i].proid === item.product.id) {
              cartItems[i].qty++
              productExists = true 
              break;
            }
          }

          if (!productExists) {
            cartItems.push(new Cart(item.id, item.product));
          }
        }

        return cartItems;
      })
    );
  }



  addProductToCart(data: any): Observable<any> {
    console.log(data)
    return this.http.post(this.cartUrl, data);
  }
}
