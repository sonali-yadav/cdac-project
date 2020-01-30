import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer1 } from './customer-service.service';

//for the salon object
export class Salon {
  constructor(
    public user:Customer1,
    public pk:number,
    public salonName:string,
    public address:string, 
    public contact1:string,
    public contact2:string,
    public description:string,
    public salonType :number,
    public homeServiceFlag:number,
    public activeDeactive:number,
    public imagePath:string
    ){}
}

export class Service {
  constructor() {}
}

export class Category {
  constructor() {}
}

@Injectable({
  providedIn: 'root'
})
export class SalonService {

  constructor(private httpClient: HttpClient) { }

  public getSalonDetails(pk) {
    console.log("salon rest api call");
    return this.httpClient.get<Salon>('http://localhost:8080/salon/salons/profile/'+pk);
  }

  public deactivateSalon(salon) {
    return this.httpClient.get<string>('http://localhost:8080/salon/salons/deactivate/' + salon.pk);
  }

  //not sending users pk from here.Manage it on server side
  public addSalon(salon) {
    return this.httpClient.post<number>('http://localhost:8080/salon/salons/add',salon);
  }

  public updateSalonDetails(salon) {
    return this.httpClient.put<Salon>('http://localhost:8080/salon/Salons/update',salon);
  }
}
