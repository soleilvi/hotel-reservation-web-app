import { Component, OnInit } from '@angular/core';
import {TimeService} from "../../services/time.service";

@Component({
  selector: 'app-time',
  templateUrl: './time.component.html',
  styleUrls: ['./time.component.css']
})
export class TimeComponent implements OnInit {

  timeZones:any;

  constructor(private service: TimeService) { }

  ngOnInit(): void {
    this.timeZones = this.service.getTimes().subscribe(data => this.timeZones = data);
  }

}
