import { Product } from "./product";

export class Cart {


      id: number;
      proid: number;
      name: string;
      qty: number;
      price: number;
    
      constructor(id: number, product: Product, qty = 1) {
        this.id = id;
        this.proid = product.id;
        this.name = product.name;
        this.price = product.price;
        this.qty = qty;
      }
}
