import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';

import { AuthService } from '../../core/auth/auth.service'
import { LoginModalService } from 'src/app/account/signin/login-modal.service';
import { StateStorageService } from 'src/app/core/auth/state-storage.service';
import { SessionStorageService } from 'ngx-webstorage';

@Injectable()
export class AuthExpiredInterceptor implements HttpInterceptor {
    constructor(
        private authService: AuthService,
        private router: Router,
        private loginModalService: LoginModalService,
        private stateStorageService: StateStorageService,
    ) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(
            tap(null, (err: HttpErrorResponse) => {
                if (err.status === 401 && err.url && !err.url.includes('api/account')) {
                    this.stateStorageService.storeUrl(this.router.routerState.snapshot.url);
                    this.authService.logout();
                    this.router.navigate(['']);
                    this.loginModalService.open();
                }
            })
        );
    }
}

export const authExpiredInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: AuthExpiredInterceptor, multi: true }
  ];