import { Component, OnInit } from '@angular/core';
import { EmartService } from 'src/app/emart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seller-signup',
  templateUrl: './seller-signup.component.html',
  styleUrls: ['./seller-signup.component.css']
})
export class SellerSignupComponent implements OnInit {
  seller:any;
  username: string="";
  password: string="";
  company: string="";
  brief: string="";
  gst: number=null;
  address: string="";
  email: string="";
  website: string="";
  contact: number=null;
  constructor(protected emartService:EmartService, protected router:Router) {}
    ngOnInit(): void {
    }
    addSeller(){
    this.seller={
      sellerId:null,
      sellerUsername:this.username,
      sellerPassword:this.password,
      sellerCompany:this.company,
      sellerBrief:this.brief,
      sellerGst:this.gst,
      sellerAddress:this.address,
      sellerEmail:this.email,
      sellerWebsite:this.website,
      sellerContact:this.contact
    }
    this.emartService.addSeller(this.seller).subscribe(
      (response: any) => {
              }
    );
    this.router.navigate(['/login'])
  }
      
}