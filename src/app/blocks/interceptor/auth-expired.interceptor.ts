import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';

import { AuthService } from '../../core/auth/auth.service'

@Injectable()
export class AuthExpiredInterceptor implements HttpInterceptor {
    constructor(
        private authService: AuthService,
        private router: Router,
    ) {}

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(
            tap(null, (err: HttpErrorResponse) => {
                if (err.status === 401 && err.url && !err.url.includes('api/account')) {
                    this.authService.logout();
                    this.router.navigate(['/login']);
                }
            })
        );
    }
}

export const authExpiredInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: AuthExpiredInterceptor, multi: true }
  ];