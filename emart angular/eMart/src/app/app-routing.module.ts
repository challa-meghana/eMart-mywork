import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemListComponent } from './emart/items/item-list/item-list.component';
import { ItemDisplayComponent } from './emart/items/item-display/item-display.component';
import { CartListComponent } from './emart/cart/cart-list/cart-list.component';
import { BillViewComponent } from './emart/bill/bill-view/bill-view.component';
import { BillListComponent } from './emart/bill/bill-list/bill-list.component';
import { LoginComponent } from './emart/user/login/login.component';
import { LogoutComponent } from './emart/logout/logout.component';
import { BuyerSignupComponent } from './emart/user/buyer-signup/buyer-signup.component';
import { SellerSignupComponent } from './emart/user/seller-signup/seller-signup.component';
import { AuthGuard } from './auth.guard';


const routes: Routes = [{
  path: 'login',
  component: LoginComponent
},
{
  path: 'item-list',
  component: ItemListComponent,
  canActivate :[AuthGuard]
},
{
  path: 'item-display/:iId',
  component: ItemDisplayComponent,
  canActivate :[AuthGuard]
},
{
  path: 'cart-list',
  component: CartListComponent,
  canActivate :[AuthGuard]
},
{
  path: 'bill-view',
  component: BillViewComponent,
  canActivate :[AuthGuard]
},
{
  path: 'bill-list',
  component: BillListComponent,
  canActivate :[AuthGuard]
},
{
  path: 'logout',
  component: LogoutComponent,
  canActivate :[AuthGuard]
},
{
  path: 'buyer-signup',
  component: BuyerSignupComponent,
  
},
{
  path: 'seller-signup',
  component: SellerSignupComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
