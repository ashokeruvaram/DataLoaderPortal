import { Component, OnInit } from '@angular/core';
import { ResponseConstants } from '../constants/response-constants';
import { BaseResponse } from '../models/base-response';
import { UserDetails } from '../models/user-details';
import { LoadService } from './load.service';

@Component({
  selector: 'app-loaddata',
  templateUrl: './loaddata.component.html',
  styleUrls: ['./loaddata.component.css']
})
export class LoaddataComponent implements OnInit {

  table: boolean = true;
  patients: UserDetails[];
  constructor(public loadService: LoadService) { }

  ngOnInit() {
    this.loadService.getPatientData().subscribe(data => {
      console.info("response : " + JSON.stringify(data));
      if (data.statusCode === ResponseConstants.SUCCESS)
        this.patients = data.userDetils;
    },
      error => console.info(error));
  }

}
