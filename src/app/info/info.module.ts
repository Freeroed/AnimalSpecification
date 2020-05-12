import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { INFO_ROUTE } from './info.route';
import { CommonModule } from '@angular/common';
import { AnimalSpecificationSharedModule } from '../shared/shared.module';
import { InfoComponent } from './info.component';

@NgModule({
    imports: [RouterModule.forChild([INFO_ROUTE]), CommonModule, AnimalSpecificationSharedModule ],
    declarations: [InfoComponent]
})
export class AnimalSpecificationInfoModule {}