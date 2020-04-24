import { Injectable } from "@angular/core";
import { Resolve, Router, ActivatedRouteSnapshot, Routes } from '@angular/router';
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';
import { HttpResponse } from '@angular/common/http';
import { RequestDetailComponent } from './request-detal.component';
import { UserRouteAccessService } from 'src/app/core/auth/user-route-access-service';
import { RequestUpdateComponent } from './request-update.component';

@Injectable({providedIn: 'root'})
export class RequestResolve implements Resolve<IRequest> {
    constructor(private service: RequestService, private router: Router) {}

    resolve(route: ActivatedRouteSnapshot) : Observable<IRequest> | Observable<never> {
        const id = route.params['id'];
        if (id) {
            return this.service.find(id).pipe(
                flatMap((request: HttpResponse<IRequest>) => {
                    if(request.body) {
                        return of(request.body);
                    } else {
                        this.router.navigate(['404']);
                        return EMPTY;
                    }
                })
            )
        }
    }
}

export const requestRoute: Routes = [
    {
        path: 'requests/:id/view',
        component: RequestDetailComponent,
        data: {
            autorities: ['ROLE_USER', 'ROLE_ADMIN']
        },
        canActivate: [UserRouteAccessService],
        resolve: {
            request: RequestResolve
        }
    }, 
    {
        path: 'requests/:id/edit',
        component: RequestUpdateComponent,
        data: {
            autorities: ['ROLE_USER', 'ROLE_ADMIN']
        },
        canActivate: [UserRouteAccessService],
        resolve: {
            request: RequestResolve
        }
    }
]