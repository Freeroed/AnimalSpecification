import { NgModule } from "@angular/core";
import { AnimalComponent } from './animal.component';
import { RouterModule } from '@angular/router';
import { animalRoute } from './animal.route';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { AccountServive } from 'src/app/account/account/account.service';

@NgModule({
    imports: [RouterModule.forChild(animalRoute), HttpClientModule, CommonModule],
    declarations: [AnimalComponent],
    providers: [AccountServive]
})
export class AnimalSpecificationAnimalModule {}