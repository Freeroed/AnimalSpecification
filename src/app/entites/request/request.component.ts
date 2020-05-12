import { Component, OnInit } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { FormBuilder } from '@angular/forms';
import { HttpResponse } from '@angular/common/http';

@Component({
    selector: 'app-requsests',
    templateUrl: './request.component.html'
})
export class RequestComponent implements OnInit {
    requests: IRequest[];

    constructor(
        private requestService: RequestService,
        private fb: FormBuilder
    ) {}

    ngOnInit(): void {
        this.loadPage();
    }

    loadPage(): void {
        this.requestService.findAll().subscribe((res: HttpResponse<IRequest[]>) => {
            this.requests = res.body;
        })
    }

    

}