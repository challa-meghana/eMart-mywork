import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { EmartService } from './emart.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(protected emartService:EmartService,protected router:Router){}
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
   
      const userExists =!!this.emartService.existBuyer();
      if(userExists)
      {
        return true;
            }
      else{
        this.router.navigate(['/login']);
        return false;
      }
  }
  
}
