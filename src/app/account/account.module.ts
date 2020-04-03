import { NgModule } from "@angular/core";
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RegisterComponent } from './register/register.component';
import { accountRoute } from './account.route';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { LoginComponent } from './signin/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CheckboxModule, WavesModule, IconsModule,} from 'angular-bootstrap-md';
import { BrowserModule } from '@angular/platform-browser';
import { AccountComponent } from './account/account.component';

@NgModule({
    imports: [RouterModule.forChild(accountRoute), 
        HttpClientModule,
        CommonModule, 
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        CheckboxModule, WavesModule, NgbModule, IconsModule, BrowserModule ],
    declarations: [RegisterComponent, LoginComponent,AccountComponent]
})
export class AnimalSpecificatonAccountModule {}