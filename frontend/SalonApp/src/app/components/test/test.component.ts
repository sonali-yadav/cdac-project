import { Component, OnInit } from '@angular/core';
import { TestService } from 'src/app/service/test.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  data = null;

  constructor(private testServ: TestService ) { }

  ngOnInit() {
  }

  hello(){
    this.testServ.hello().subscribe(data =>{
      console.log(data);
      this.data = data;
    });
  }

}
