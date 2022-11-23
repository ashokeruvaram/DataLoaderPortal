import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlConstants } from '../constants/url-constants';
import { BaseResponse } from '../models/base-response';

@Injectable({
  providedIn: 'root'
})
export class LoadService {

  constructor(private http: HttpClient) {

  }
  getPatientData() {
    console.info("inside author service register: ");
    return this.http.get<BaseResponse>(UrlConstants.GETPATIENTS);
  }

}
