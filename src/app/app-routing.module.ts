import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AnimalComponent } from './entites/animal/animal.component';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot([
    {
      path: 'animals',
      component: AnimalComponent
    }
  ])],
  exports: [RouterModule]
})
export class AppRoutingModule { }
