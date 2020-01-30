import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TestService {

    constructor(private http: HttpClient){

    }

  hello() {
    return this.http.get("http://localhost:9090/test/hello");
  }


}
