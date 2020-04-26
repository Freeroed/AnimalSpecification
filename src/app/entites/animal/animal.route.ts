import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Animal } from '../../shared/model/animal.model';
import { AnimalService } from './animal.service';
import { AnimalComponent } from './animal.component';
import { UserRouteAccessService } from 'src/app/core/auth/user-route-access-service';
import { AnimalUpdateComponent } from './animal-update.component';
import { AnimalDetailComponent } from './animal-detail.component';

@Injectable({providedIn: 'root'})
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
          autorities: ['ROLE_USER', 'ROLE_ADMIN', 'ROLE_VETERINARIAN', 'ROLE_ROSSELHOZNADZOR']
        },
        canActivate: [UserRouteAccessService]
      }, 
      {
        path: 'animals/new',
        component: AnimalUpdateComponent,
        data : {
          autorities: ['ROLE_USER', 'ROLE_ADMIN', 'ROLE_VETERINARIAN', 'ROLE_ROSSELHOZNADZOR']
        },
        canActivate: [UserRouteAccessService]
      },
      {
        path: 'animals/:id/view',
        component: AnimalDetailComponent,
        data: {
          autorities: ['ROLE_USER', 'ROLE_ADMIN', 'ROLE_VETERINARIAN', 'ROLE_ROSSELHOZNADZOR']
        },
        canActivate: [UserRouteAccessService],
        resolve: {
          animal : AnimalResolve }
      },
      {
        path: 'animals/:id/edit',
        component: AnimalUpdateComponent,
        data: {
          autorities: ['ROLE_USER', 'ROLE_ADMIN', 'ROLE_VETERINARIAN', 'ROLE_ROSSELHOZNADZOR']
        },
        canActivate: [UserRouteAccessService],
        resolve: {
          animal : AnimalResolve
        }
      }
];