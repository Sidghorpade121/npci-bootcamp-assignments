import { Injectable } from '@angular/core';
import { Observable,map } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Product } from './commons/product';
import { ProductCategory } from './commons/product-category';
@Injectable({
  providedIn: 'root'
})
export class EcomservicesService {

  prodUrl="http://localhost:8080/api/prod";
  catURL  ="http://localhost:8080/api/cat";
  constructor(private httpclient : HttpClient) { }

  getAllProducts() : Observable<Product[]>{
    
    return this.httpclient.get<GetResponseProduct>(this.prodUrl)
    .pipe(map(response => response._embedded.products));
  }

  getAllCategories()  : Observable<ProductCategory[]>{

    console.log( this.httpclient.get<getCategoryResponse>(this.catURL)
    .pipe(map(response => response._embedded.productcategories)))
    return this.httpclient.get<getCategoryResponse>(this.catURL)
    .pipe(map(response => response._embedded.productcategories))
  }

  createProduct(data: any): Observable<any> {
    return this.httpclient.post(this.prodUrl, data);
  }
  createCategory(data: any): Observable<any> {
    return this.httpclient.post(this.catURL, data);
  }
}
interface GetResponseProduct{
  _embedded :{
    products : Product[]
  }
}
interface getCategoryResponse{
  _embedded : {
    productcategories : ProductCategory[]
  }
}


