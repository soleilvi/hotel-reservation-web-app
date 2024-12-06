import { Component, OnInit } from '@angular/core';
import {WelcomeService} from "../../services/welcome.service";

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  welcomeMessages:any;

  constructor(private service: WelcomeService) { }

  ngOnInit(): void {
    this.welcomeMessages = this.service.getWelcomeMessages().subscribe(data =>
      this.welcomeMessages = data
    );
  }

}
