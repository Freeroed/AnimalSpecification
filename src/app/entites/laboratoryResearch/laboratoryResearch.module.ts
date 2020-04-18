import { NgModule } from "@angular/core";
import { LaboratoryResearchUpdateComponent } from './laboratoryResearch-update.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
    imports: [
        HttpClientModule, 
        CommonModule, 
        BrowserModule, 
        FormsModule, 
        ReactiveFormsModule, 
        NgbModule],
    declarations: [LaboratoryResearchUpdateComponent],
    entryComponents: [LaboratoryResearchUpdateComponent]
})
export class AnimalSpecificationLaboratoryResearchModule {

}