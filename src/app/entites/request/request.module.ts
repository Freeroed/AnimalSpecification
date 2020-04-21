import { NgModule } from "@angular/core";
import { RequestDetailComponent } from './request-detal.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';
import { requestRoute } from './request.route';
import { RequestAddAnimalDialogComponent } from './request-add-animal-dialid.component';
import { RequestDeleteAnimalDeleteDialogComponent } from './request-delete-animal-dialog.component';

@NgModule({
    imports: [RouterModule.forChild(requestRoute),
        HttpClientModule, 
        CommonModule, 
        BrowserModule, 
        FormsModule, 
        ReactiveFormsModule, NgbModule],
    declarations: [RequestDetailComponent, RequestAddAnimalDialogComponent, RequestDeleteAnimalDeleteDialogComponent],
    entryComponents: [RequestAddAnimalDialogComponent, RequestDeleteAnimalDeleteDialogComponent]
})
export class AnimalSpecificationRequestModule {

}