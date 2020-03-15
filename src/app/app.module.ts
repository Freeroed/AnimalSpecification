import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalSpecificationAnimalModule } from './entites/animal/animal.module'
import { AnimalService } from './entites/animal/animal.service';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { AnimalSpecificationHomeModule } from './home/home.module';

@NgModule({
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    AnimalSpecificationAnimalModule,
    HttpClientModule,
    AnimalSpecificationHomeModule
  ],
  declarations: [
    AppComponent,
    NavbarComponent
  ],
  providers: [AnimalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
