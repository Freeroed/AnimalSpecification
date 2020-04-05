import { NgModule } from "@angular/core";
import { AnimalComponent } from './animal.component';
import { RouterModule } from '@angular/router';
import { animalRoute } from './animal.route';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { AccountServive } from 'src/app/account/account/account.service';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AnimalCreateComponent } from './animal-create.component';

@NgModule({
    imports: [RouterModule.forChild(animalRoute), 
        HttpClientModule, 
        CommonModule, 
        BrowserModule, 
        FormsModule, 
        ReactiveFormsModule],
    declarations: [AnimalComponent, AnimalCreateComponent]
    
})
export class AnimalSpecificationAnimalModule {}