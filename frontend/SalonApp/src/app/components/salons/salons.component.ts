import { Component, OnInit } from '@angular/core';
import { SalonService, Salon } from 'src/app/service/salon.service';
import { Router } from '@angular/router';
import { Customer1 } from 'src/app/service/customer-service.service';

@Component({
  selector: 'app-salons',
  templateUrl: './salons.component.html',
  styleUrls: ['./salons.component.css']
})
export class SalonsComponent implements OnInit {

  //userspk=sessionStorage.getItem('theuser').pk;
  user:Customer1;
  salon: Salon = new Salon(this.user,0, '', '', '', '', '', 0, 0, 0, '');
  pk: number = 0;
  deactivated: boolean = false;
  loggedin: boolean = false;
  h: string = "";

  constructor(private salonService: SalonService, public myrouter: Router) { }

  ngOnInit() {
  }

  setSalonType(hh) {
    this.h = hh;
    console.log(this.h);
  }
  handleAdded(response) {
    console.log("salon add success");
    this.myrouter.navigate(['salons']);
  }

  //main handler

  handleSalonData(c) {
    console.log(c);
    console.log("rest api: salon called");
    c.salonType = this.h;
    c.
    this.salonService.addSalon(c).subscribe(
      response => this.handleAdded(response)
    );
  }
}
