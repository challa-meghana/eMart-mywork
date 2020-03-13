import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmartService } from 'src/app/emart.service';

@Component({
  selector: 'app-buyer-signup',
  templateUrl: './buyer-signup.component.html',
  styleUrls: ['./buyer-signup.component.css']
})
export class BuyerSignupComponent implements OnInit {
  buyer: any;

  constructor(protected router: Router, protected emartService: EmartService) {
    this.buyer = {
      buyerUsername: "",
      buyerPassword: "",
      buyerEmail: "",
      buyerMobile: null,
      buyerDate: new Date()
    }
  }

  ngOnInit(): void {
  }

  addBuyer() {
    this.emartService.addBuyer(this.buyer).subscribe(
      (response: any) => {
      }
    );
    this.router.navigate(['/login'])
  }
}



