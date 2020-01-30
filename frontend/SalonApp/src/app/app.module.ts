import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AlertModule } from 'ngx-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { CustomPasswordValidator } from './components/customer/customer.component'

import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { LoginComponent } from './components/login/login.component';
import { FooterComponent } from './components/footer/footer.component';
import { CatalogComponent } from './components/catalog/catalog.component';
import { ProductComponent } from './components/product/product.component';
import { CustomerComponent } from './components/customer/customer.component';
import { SalonComponent } from './components/salon/salon.component';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './components/signup/signup.component';
import { LogoutComponent } from './components/logout/logout.component';
import { ProductdetailComponent } from './components/productdetail/productdetail.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SalonsComponent } from './components/salons/salons.component';
import { TestComponent } from './components/test/test.component';
import { BasicAuthInterceptorService } from './service/basic-auth-interceptor.service';
import { AuthGuardService } from './service/auth-guard.service';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'salons', component: SalonsComponent },
  { path: 'services', component: ProductdetailComponent },
  { path: 'catalog', component: CatalogComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'profile', component: CustomerComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'productdetail', component: ProductdetailComponent },
  { path: 'test', component: TestComponent, canActivate: [AuthGuardService] },
  { path: '**', component: HomeComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    LoginComponent,
    FooterComponent,
    CatalogComponent,
    ProductComponent,
    CustomerComponent,
    SalonComponent,
    HomeComponent,
    SignupComponent,
    LogoutComponent,
    CustomPasswordValidator,
    DashboardComponent,
    ProductdetailComponent,
    SalonsComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AlertModule.forRoot(),
    RouterModule.forRoot(routes)
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: BasicAuthInterceptorService,
      multi: true
    },
    AuthGuardService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
