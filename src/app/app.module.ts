import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalSpecificationAnimalModule } from './entites/animal/animal.module'
import { AnimalService } from './entites/animal/animal.service';

@NgModule({
  
  imports: [
    BrowserModule,
    AppRoutingModule,
    AnimalSpecificationAnimalModule,
    HttpClientModule
  ],
  declarations: [
    AppComponent,
    
  ],
  providers: [AnimalService],
  bootstrap: [AppComponent]
})
export class AppModule { }
