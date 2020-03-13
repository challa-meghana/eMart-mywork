import { Component, OnInit } from '@angular/core';
import { EmartService } from '../emart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seller-item-list',
  templateUrl: './seller-item-list.component.html',
  styleUrls: ['./seller-item-list.component.css']
})
export class SellerItemListComponent implements OnInit {
  allItems: any;

  constructor(protected emartService:EmartService,protected router:Router) { }

  ngOnInit(): void {
    this.emartService.getAllItems().subscribe(
      (response: any) => {
        this.allItems = response;
      }
    );
  }
  displayAddMovie() {
    this.router.navigate(['/item-add']);

  }
}
