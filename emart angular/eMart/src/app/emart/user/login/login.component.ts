import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { EmartService } from 'src/app/emart.service';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  sign: string;
  errorMessage: string;
  username: string;
  password: string;
  currentBuyer: any;
  currentSeller:any;

  constructor(protected emartService: EmartService, protected loginService: LoginService, protected router: Router) { }

  ngOnInit(): void {
    this.errorMessage = "";
  }
  validate() {
    if (this.sign == "buyer") {
      this.emartService.validateBuyer(this.username, this.password).subscribe(
        (response) => {
          this.currentBuyer = response;
          this.emartService.setBuyerAndBills(this.currentBuyer);
          if (this.currentBuyer.buyerId != 0) {
            this.loginService.loginBuyer(this.currentBuyer);
            this.router.navigate(['/item-list']);
          }
          else {
            this.errorMessage = "invalid username or password";
          }
        }
      );
    }
    if (this.sign == 'seller') {
      this.emartService.validateSeller(this.username, this.password).subscribe(
        (response) => {
          this.currentSeller = response;
          this.emartService.setSeller(this.currentSeller);
          if (this.currentSeller.sellerId != 0) {
            this.loginService.loginSeller(this.currentSeller);
            this.router.navigate(['/item-list']);
          }
          else {
            this.errorMessage = "invalid username or password";
          }
        }
      );
    }
  }
}
