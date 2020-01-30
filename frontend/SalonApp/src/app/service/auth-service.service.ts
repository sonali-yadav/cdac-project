import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  user: any;

  constructor(private httpClient: HttpClient) {

     this.user = sessionStorage.getItem('username');

  }

  authenticate(username, password) {
    console.log("******************");

    console.log(username);
    console.log(password);
    const headers = new HttpHeaders({ Authorization: 'Basic' + btoa(username + ':' + password) });
    return this.httpClient.post('http://localhost:8080/salon/authenticate',{ username, password }, { headers }).pipe(
      map(
        userData => {
          console.log(userData);
          localStorage.setItem('token', userData['jwttoken']);
          localStorage.setItem('username', username);
          this.user = username;
          let authString = 'Basic' + btoa(username + ':' + password);
          sessionStorage.setItem('basicauth',authString);
          return userData;
        }
      )
    );
  }

  isUserLoggedIn() {
    // console.log(!(this.user === null));
    return !(this.user===null);
  }

  logOut() {
    localStorage.removeItem('username');
    localStorage.removeItem('token');
    this.user = null;
  }
}

