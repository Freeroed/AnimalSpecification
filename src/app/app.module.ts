import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalSpecificationAnimalModule } from './entites/animal/animal.module'
import { AnimalService } from './entites/animal/animal.service';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { AnimalSpecificationHomeModule } from './home/home.module';
import { RegionService } from './entites/region/region.service';
import { RouterModule } from '@angular/router';
import { FormBuilder } from '@angular/forms';

@NgModule({
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    AnimalSpecificationAnimalModule,
    HttpClientModule,
    AnimalSpecificationHomeModule,
    RouterModule
  ],
  declarations: [
    AppComponent,
    NavbarComponent
  ],
  providers: [AnimalService, RegionService, FormBuilder],
  bootstrap: [AppComponent]
})
export class AppModule { }
