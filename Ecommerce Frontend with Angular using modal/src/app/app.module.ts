import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { CreateProductComponent } from './components/create-product/create-product.component';
import { CreateCategoryComponent } from './components/create-category/create-category.component';
import { Router,RouterModule,Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { HeaderComponent } from './components/shared/header/header.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { PageNotFoundComponent } from './components/shared/page-not-found/page-not-found.component';
import { ProductItemComponent } from './components/product-list/product-item/product-item.component';
import { MerchantComponent } from './components/merchant/merchant.component';
import { CartComponent } from './components/cart/cart.component';


const route : Routes = [
  {path : '',component : WelcomeComponent } ,
  {path : 'products',component : ProductListComponent } , 
  {path : 'categories' , component : CategoryListComponent},
  {path : 'newProduct' , component : CreateProductComponent},
  {path : 'newCategory' , component : CreateCategoryComponent},
  {path : 'Home' , component : WelcomeComponent},
  {path : 'merchant' , component : MerchantComponent},
  {path : 'cart' , component : CartComponent}


]

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CategoryListComponent,
    CreateProductComponent,
    CreateCategoryComponent,
    WelcomeComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    PageNotFoundComponent,
    ProductItemComponent,
    MerchantComponent
    
   
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(route),
    ReactiveFormsModule
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
