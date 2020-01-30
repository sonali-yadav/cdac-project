import {HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthInterceptorService implements HttpInterceptor {

  constructor() { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    // if (sessionStorage.getItem('username') &&
    //     sessionStorage.getItem('basicauth')) {
    //   req = req.clone(
    //       {setHeaders: {Authorization: sessionStorage.getItem('basicauth')}})
    // }


    if (localStorage.getItem('token')) {
      console.log("************************");
      console.log(localStorage.getItem('token'));
      req = req.clone(
          {setHeaders: {Authorization: ("Bearer " + localStorage.getItem('token'))}});
    }

    return next.handle(req);
  }
}
