import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; 
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalSpecificationAnimalModule } from './entites/animal/animal.module'
import { AnimalService } from './entites/animal/animal.service';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { AnimalSpecificationHomeModule } from './home/home.module';
import { RegionService } from './entites/region/region.service';
import { RouterModule } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { authInterceptorProviders } from './blocks/interceptor/auth.intercoptor';
import { FormsModule, ReactiveFormsModule  }   from '@angular/forms';
import { authExpiredInterceptorProviders } from './blocks/interceptor/auth-expired.interceptor';
import { DocsComponent } from './admin/docs/docs.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { SessionStorageService } from 'ngx-webstorage';
import { FooterComponent } from './layouts/footer/footer.component';
import { NgbModule, NgbDateParserFormatter, NgbDateAdapter } from '@ng-bootstrap/ng-bootstrap';
import { AnimalSpecificatonAccountModule } from './account/account.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { DateParserFormatter } from './core/dateParseFormatter';
import { NgbDateMomentAdapter } from './shared/util/datepicker-adapter';
import { HasAnyAuthorityDirective } from './shared/auth/has-any-authority.directive';
import { AnimasSpecificationVaccineModule } from './entites/vaccine/vaccine.module';


@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    AnimalSpecificationAnimalModule,
    HttpClientModule,
    AnimalSpecificationHomeModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    NgxWebstorageModule.forRoot(),
    NgbModule,
    AnimalSpecificatonAccountModule,
    BrowserAnimationsModule,
    BsDatepickerModule.forRoot(),
    AnimasSpecificationVaccineModule
  ],
  declarations: [
    AppComponent,
    NavbarComponent,
    DocsComponent,
    FooterComponent,
    HasAnyAuthorityDirective
  ],
  providers: [FormBuilder,SessionStorageService, authInterceptorProviders, authExpiredInterceptorProviders, { provide: NgbDateParserFormatter, useClass: DateParserFormatter }, { provide: NgbDateAdapter, useClass: NgbDateMomentAdapter }],
  bootstrap: [AppComponent]
})
export class AppModule { }
