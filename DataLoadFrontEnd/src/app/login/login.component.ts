import { Component, OnInit } from '@angular/core';
import { ResponseConstants } from '../constants/response-constants';
import { LoginServices } from './services.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LoadService } from '../loaddata/load.service';
import { Router } from '@angular/router';
import { Login } from '../models/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public service: LoginServices, private router: Router) { }

  loginDetails: Login
  ngOnInit(): void {
    this.loginDetails = new Login;
  }
  login() {
    console.info("login request " + JSON.stringify(this.loginDetails))
    this.service.Login(this.loginDetails).subscribe(data => {
      console.info("response : " + JSON.stringify(data));
      alert(data.statusMessage);
      if (data.statusCode === ResponseConstants.SUCCESS) {
        // localStorage.setItem("details", JSON.stringify(data));
        this.router.navigate(['/load']);

      }
    },
      error => console.info(error));
  }
}
