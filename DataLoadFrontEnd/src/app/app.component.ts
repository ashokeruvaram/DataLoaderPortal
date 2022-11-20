import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'DataLoad';
  showHomePage: boolean = true;


  constructor(private router: Router) {
  }


  transfer() {
    console.info("chinna")
    this.router.navigate(['/login']);
  }
}
