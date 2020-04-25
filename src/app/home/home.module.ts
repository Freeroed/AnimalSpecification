import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HOME_ROUTE } from './home.route';
import { HomeComponent} from './home.component';
import { AnimalSpecificationSharedModule } from '../shared/shared.module';

@NgModule({
    imports: [RouterModule.forChild([HOME_ROUTE]),FormsModule, CommonModule, AnimalSpecificationSharedModule ],
    declarations: [HomeComponent]
})
export class AnimalSpecificationHomeModule {}