import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../../service/auth-service.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  role:number=0;
  constructor(public authService:AuthServiceService) { }

  ngOnInit() {
    this.role=2;
  }

}
