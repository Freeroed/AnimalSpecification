import { Component, OnInit } from '@angular/core';
import { Region } from './../shared/model/region.model'
import { RegionService } from '../entites/region/region.service';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html'
})

export class HomeComponent implements OnInit {
    regions: Region[];
    checkRegion =false;
    selected;

    editForm = this.fb.group({
        region: []
    })

    constructor(
        protected regionService: RegionService,
        protected fb: FormBuilder
        ) { }

    ngOnInit(){
        this.regionService.findAll().subscribe((res: HttpResponse<Region[]>) =>
        this.regions = res.body);
    }

    check(): void {
        if(this.selected === '1'){
            this.checkRegion = true;
        } else {
            this.checkRegion = false;
        }
        
    }
}