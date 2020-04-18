import { NgModule } from "@angular/core";
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { VaccineUpdateComponent } from './vaccine-update.component';

@NgModule({
    imports: [HttpClientModule, 
        CommonModule, 
        BrowserModule, 
        FormsModule, 
        ReactiveFormsModule, NgbModule],
    declarations: [VaccineUpdateComponent],
    entryComponents: [VaccineUpdateComponent]
})

export class AnimasSpecificationVaccineModule {}