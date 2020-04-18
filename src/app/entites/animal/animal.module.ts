import { NgModule } from "@angular/core";
import { AnimalComponent } from './animal.component';
import { RouterModule } from '@angular/router';
import { animalRoute } from './animal.route';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AnimalCreateComponent } from './animal-create.component';
import { NgbModule, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { AnimalDetailComponent } from './animal-detail.component';

@NgModule({
    imports: [RouterModule.forChild(animalRoute), 
        HttpClientModule, 
        CommonModule, 
        BrowserModule, 
        FormsModule, 
        ReactiveFormsModule, NgbModule],
    declarations: [AnimalComponent, AnimalCreateComponent, AnimalDetailComponent],
    
    
})
export class AnimalSpecificationAnimalModule {}