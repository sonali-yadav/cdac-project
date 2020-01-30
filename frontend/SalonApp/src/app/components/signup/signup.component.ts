import { Component, OnInit } from '@angular/core';
import { CustomerServiceService, Customer, Customer1 } from '../../service/customer-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  customer: Customer = new Customer(0, '', '', '', '', '', '', 0, '', '', 0);
  customer1: Customer1 = new Customer1(0, '', '', '', '', '', '', 0, '', 0);
  pk: number = 0;
  g: string = "";

  constructor(private customerService: CustomerServiceService, public myrouter: Router) { }

  ngOnInit() { }

  setGender(gg) {
    this.g = gg;
    console.log(this.g);
  }

  handleAdded(response) {
    console.log("signup success");
    this.myrouter.navigate(['login']);
  }

  //main handler

  handleCustomerData(c) {
    console.log(c);
    console.log("rest api: signup called");
    c.gender = this.g;
    this.customerService.addCustomer(c).subscribe(
      response => this.handleAdded(response)
    );
  }
}
