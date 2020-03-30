import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { LoginModalService } from 'src/app/account/signin/login-modal.service';
import { StateStorageService } from './state-storage.service';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';


@Injectable({providedIn: 'root'})
export class UserRouteAccessService implements CanActivate {
    constructor(
        private router: Router,
        private loginModalService: LoginModalService,
        private stateTrorageService: StateStorageService,
        private tokenStorageService: TokenStorageService
    ) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        const authorites = route.data['autorities'];
        if (authorites){
            const currentUser = this.tokenStorageService.getUser();
            if(currentUser) {
                for(let role of currentUser.roles){
                    if (authorites.indexOf(role) !== -1) {
                        return true;
                    }
                }
        }
        }
        this.stateTrorageService.storeUrl(state.url);
        this.router.navigate(['']);
        this.loginModalService.open();
        return false;
    }
}