import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../../service/auth-service.service';
import { Router } from '@angular/router';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = "";
  password: string = "";
  invalidLogin: boolean = false;

  constructor(private Router: Router,private loginService: AuthServiceService) { }

  ngOnInit() {
  }

  checkLogin() {
    this.loginService.authenticate(this.username,this.password).subscribe((data)=>{
      if(data){
        this.Router.navigateByUrl("/test");
        this.invalidLogin=false;
      }else {
        this.invalidLogin=true;
      }
    })
  }
}
