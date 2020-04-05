import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Animal } from '../../shared/model/animal.model';
import { AnimalService } from './animal.service';
import { AnimalComponent } from './animal.component';
import { UserRouteAccessService } from 'src/app/core/auth/user-route-access-service';
import { AnimalCreateComponent } from './animal-create.component';

@Injectable()
export class AnimalResolve implements Resolve<Animal> {
    constructor(private service: AnimalService, private router: Router) {}

    resolve(route: ActivatedRouteSnapshot): Observable<Animal> | Observable<never> {
        const id = route.params['id'];
        if (id) {
        return this.service.find(id).pipe(
            flatMap((animal: HttpResponse<Animal>) => {
            if (animal.body) {
                return of(animal.body);
            } else {
                this.router.navigate(['404']);
                return EMPTY;
            }
        })
        );
    }
        return of(new Animal());
    
    }
}
export const animalRoute: Routes = [
        {
        path: 'animals',
        component: AnimalComponent,
        data : {
          autorities: ['ROLE_USER', 'ROLE_ADMIN']
        },
        canActivate: [UserRouteAccessService]
      }, 
      {
        path: 'animals/new',
        component: AnimalCreateComponent,
        data : {
          autorities: ['ROLE_USER', 'ROLE_ADMIN']
        },
        canActivate: [UserRouteAccessService]
      },
];