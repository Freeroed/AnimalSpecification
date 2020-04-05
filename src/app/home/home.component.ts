import { Component, OnInit } from '@angular/core';
import { Region } from './../shared/model/region.model'
import { RegionService } from '../entites/region/region.service';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { DestinationCounryService } from '../entites/destinationCountry/destinationCountry.service';
import { IDestinationCounry } from '../shared/model/destinationCountry.model';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html'
})

export class HomeComponent implements OnInit {
    regions: Region[];
    countries!: IDestinationCounry[];
    checkRegion =false;
    selected;
    selectedCountry;

    editForm = this.fb.group({
        region: [],
        country: []
    })

    constructor(
        protected regionService: RegionService,
        protected countryService: DestinationCounryService,
        protected fb: FormBuilder
        ) { }

    ngOnInit(){
        this.regionService.findAll().subscribe((res: HttpResponse<Region[]>) =>
        this.regions = res.body);
        this.countryService.findAll().subscribe((res: HttpResponse<IDestinationCounry[]>) => 
        this.countries = res.body);
    }

    check(): void {
        if(this.selected){
            this.countryService.findAllByRegion(this.selected).subscribe((res: IDestinationCounry[]) =>
            this.countries = res)
        this.selectedCountry = null;
        }
        
    }
    cheking(): void {
        console.log(this.countries);
        
    }
}