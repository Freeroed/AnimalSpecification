import { Injectable } from '@angular/core';
import { Routes, Resolve, Router, ActivatedRouteSnapshot } from '@angular/router';
import { LoginComponent } from './signin/login.component';
import { RegisterComponent } from './register/register.component';
import { AccountComponent } from './account/account.component';
import { UserRouteAccessService } from '../core/auth/user-route-access-service';
import { IUser, User } from '../shared/model/user.model';
import { UserService } from '../core/user/user.service';
import { Observable, of, EMPTY } from 'rxjs';
import { AccountServive } from './account/account.service';
import { flatMap } from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class AccountResolve implements Resolve<IUser> {
  constructor(private service: AccountServive, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IUser> | Observable<never>{
    return this.service.getAccount().pipe(
      flatMap((user: HttpResponse<User>) => {
        if(user.body) {
          return of(user.body);
        } else {
          this.router.navigate(['404']);
          return EMPTY;
        }
      })
    )
  }
}


export const accountRoute: Routes = [
    {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'signup',
        component: RegisterComponent
      },
      {
        path: 'account',
        component: AccountComponent,
        data : {
          autorities: ["ROLE_USER", "ROLE_ADMIN", 'ROLE_VETERINARIAN', 'ROLE_ROSSELHOZNADZOR']
        },resolve: {
          user: AccountResolve
        },
        canActivate: [UserRouteAccessService]
      }
]