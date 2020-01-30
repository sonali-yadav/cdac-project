import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


//for the customer object
export class Customer {
  constructor(
    public pk: number,
    public firstName: string,
    public lastName: string,
    public email: string,
    public contact1: string,
    public contact2: string = "",
    public gender:string,
    public activeDeactive:number,
    public password:string,
    public cpassword:string,
    public role:number
  ) { }
} 
export class Customer1 {
  constructor(
    public pk: number,
    public firstName: string,
    public lastName: string,
    public email: string,
    public contact1: string,
    public contact2: string = "",
    public gender:string,
    public activeDeactive:number,
    public password:string,
    public role:number
  ) { }
}
@Injectable({
  providedIn: 'root'
})

export class CustomerServiceService {

  constructor(private httpClient: HttpClient) { }

  public getCustomerDetails(pk) {
    console.log("test rest api call");
    return this.httpClient.get<Customer>('http://localhost:8080/salon/user/profile/'+pk);
  }

  public deactivateCustomer(customer) {
    return this.httpClient.get<string>('http://localhost:8080/salon/user/deactivate/' + customer.pk);
  }

  public addCustomer(cust) {
    return this.httpClient.post<number>('http://localhost:8080/salon/user/add',cust);
  }

  public updateCustomerDetails(cust) {
    return this.httpClient.put<Customer>('http://localhost:8080/salon/user/update',cust);
  }
}
