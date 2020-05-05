import { Component, OnInit } from '@angular/core';
import { Region } from './../shared/model/region.model'
import { RegionService } from '../entites/region/region.service';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { DestinationCounryService } from '../entites/destinationCountry/destinationCountry.service';
import { IDestinationCounry } from '../shared/model/destinationCountry.model';
import { RequestService } from '../entites/request/request.service';
import { IRequest, Request } from '../shared/model/request.model';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html'
})

export class HomeComponent implements OnInit {
    regions: Region[];
    countries!: IDestinationCounry[];
    checkRegion =false;
    selected = null;
    selectedCountry = null;

    editForm = this.fb.group({
        region: [],
        country: []
    })

    constructor(
        protected regionService: RegionService,
        protected countryService: DestinationCounryService,
        protected fb: FormBuilder,
        protected requestService: RequestService,
        protected router: Router
        ) { }

    ngOnInit(){
        this.regionService.findAll().subscribe((res: HttpResponse<Region[]>) =>
        this.regions = res.body);
    }

    check(): void {
        if(this.selected && this.selected !== ''){
            this.countryService.findAll({'id' : this.selected.id ? this.selected.id : null})
            .subscribe((res: HttpResponse<IDestinationCounry[]>) =>
            this.countries = res.body)
        
        }
    }

    createFormFrom(): IRequest {
        return {
            ...new Request(),
            destinationCountry: this.selectedCountry,
            dateOfDeparture: moment()
        }
    }

    createRequest(): void {
        const request = this.createFormFrom();
        this.subscribeToSaveResponse(this.requestService.save(request));
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IRequest>>): void {
        result.subscribe(
            (request) => this.onSaveSuccess(request),
            () => this.onSaveError()
        );
    }

    protected onSaveSuccess(request: IRequest): void {
        this.router.navigate(['requesrs', request.id, 'view'])
    }

    protected onSaveError(): void {
        console.log("CREATING ERROR")
    }

}