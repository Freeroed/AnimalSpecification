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

@NgModule({
    imports: [RouterModule.forChild(accountRoute), 
        HttpClientModule,
        CommonModule, 
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        CheckboxModule, WavesModule, NgbModule, IconsModule],
    declarations: [RegisterComponent, LoginComponent]
})
export class AnimalSpecificatonAccountModule {}