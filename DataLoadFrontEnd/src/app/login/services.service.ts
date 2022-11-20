import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlConstants } from '../constants/url-constants';
import { BaseResponse } from '../entitys/base-response.model';
import { LoginDetails } from '../entitys/login-details';

@Injectable({
  providedIn: 'root'
})
export class LoginServices {

  constructor(private http: HttpClient) { }
  Login(loginDetails: LoginDetails) {
    console.info("inside author service register: " + JSON.stringify(loginDetails));
    return this.http.post<BaseResponse>(UrlConstants.LOGIN, loginDetails);
  }
}
