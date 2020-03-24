import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnimalComponent } from './entites/animal/animal.component';
import { LoginComponent } from './account/signin/login.component';
import { RegisterComponent } from './account/register/register.component';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {
      path: 'animals',
      component: AnimalComponent
    }, 
    {
      path: 'login',
      component: LoginComponent
    },
    {
      path: 'singup',
      component: RegisterComponent
    }
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
