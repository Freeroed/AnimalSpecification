import { NgModule } from "@angular/core";
import { AnimalComponent } from './animal.component';
import { RouterModule } from '@angular/router';
import { animalRoute } from './animal.route';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@NgModule({
    imports: [RouterModule.forChild(animalRoute), HttpClientModule, CommonModule],
    declarations: [AnimalComponent]
})
export class AnimalSpecificationAnimalModule {}