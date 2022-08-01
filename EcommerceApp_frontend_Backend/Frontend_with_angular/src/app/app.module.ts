import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { CreateProductComponent } from './components/create-product/create-product.component';
import { CreateCategoryComponent } from './components/create-category/create-category.component';
import { Router,RouterModule,Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { WelcomeComponent } from './components/welcome/welcome.component';
const route : Routes = [
  {path : 'products',component : ProductListComponent } , 
  {path : 'categories' , component : CategoryListComponent},
  {path : 'newProduct' , component : CreateProductComponent},
  {path : 'newCategory' , component : CreateCategoryComponent},
  {path : 'Home' , component : WelcomeComponent},

]

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CategoryListComponent,
    CreateProductComponent,
    CreateCategoryComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(route)
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
