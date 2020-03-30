import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnimalComponent } from './entites/animal/animal.component';
import { LoginComponent } from './account/signin/login.component';
import { RegisterComponent } from './account/register/register.component';
import { DocsComponent } from './admin/docs/docs.component';
import { UserRouteAccessService } from './core/auth/user-route-access-service';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {
      path: 'animals',
      component: AnimalComponent,
      data : {
        autorities: ['ROLE_USER', 'ROLE_ADMIN']
      },
      canActivate: [UserRouteAccessService]
    }, 
    
    {
      path: 'admin/docs',
      component: DocsComponent,
      data : {
        autorities: ['ROLE_ADMIN']
      },
      canActivate: [UserRouteAccessService]
    }
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
