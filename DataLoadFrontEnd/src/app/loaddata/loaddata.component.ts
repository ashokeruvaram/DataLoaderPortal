import { Component, OnInit } from '@angular/core';
import { LoadService } from './load.service';

@Component({
  selector: 'app-loaddata',
  templateUrl: './loaddata.component.html',
  styleUrls: ['./loaddata.component.css']
})
export class LoaddataComponent implements OnInit {

  constructor(public loadService: LoadService) { }

  ngOnInit(): void {
    this.loadService.getPatientData();
  }

}
