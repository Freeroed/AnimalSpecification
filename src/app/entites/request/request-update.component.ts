import { Component, OnInit } from "@angular/core";
import { FormBuilder } from '@angular/forms';
import { RequestService } from './request.service';
import { Animal } from 'src/app/shared/model/animal.model';
import { IRequest, Request } from 'src/app/shared/model/request.model';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

import { DATE_FORMAT } from 'src/app/app.constants';
import * as moment from 'moment';
import { NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { DateParserFormatter } from 'src/app/core/dateParseFormatter';
import { IDestinationCounry } from 'src/app/shared/model/destinationCountry.model';
import { DestinationCounryService } from '../destinationCountry/destinationCountry.service';
import { BorderCrossingPointService } from '../borderCrosingPoint/borderCrossingPoint.service';
import { IBorderCrossingPoint } from 'src/app/shared/model/borderCrossingPoint.model';

@Component({
    selector: 'app-request-update',
    templateUrl: './request-update.component.html',
    providers: [{ provide: NgbDateParserFormatter, useClass: DateParserFormatter }]
})
export class RequestUpdateComponent implements OnInit {
    animals!: Animal[];
    isError = false;
    countries : IDestinationCounry[];
    selectedCountry: IDestinationCounry;
    selectedBorderCrossingPoint: IBorderCrossingPoint;
    borderCrossingsPoints: IBorderCrossingPoint[];

    constructor(
        private activatedRoute: ActivatedRoute,
        private fb: FormBuilder,
        private requestService: RequestService,
        private countryServive: DestinationCounryService,
        private borderServive: BorderCrossingPointService) {}

    editForm = this.fb.group({
        id: [],
        recipient: [],
        destinationCountry: [],
        destinationCity: [],
        borderCrossingPoint: [],
        transport: [],
        vehicleNumber: [],
        veterinarian: [],
        wayOfStorageDuringTransportation: [],
        quarantineLocation: [],
        numberOfDaysToQuarantine: [],
        inspectorOfRosselkhoznadzor: [],
        postalCode: [],
        dateOfDeparture: [],
        certificate1FormNumber: [],
        status: [],
        transactionType: []

    })
    ngOnInit(): void {
        this.loadPage();
        console.log(this.selectedCountry);
        
    }

    loadPage(): void {
        this.activatedRoute.data.subscribe(( { request }) => {
            this.updateForm(request);
            this.animals = request.animals;
            this.selectedCountry = request.destinationCountry;
            this.selectedBorderCrossingPoint = request.borderCrossingPoint
        });
        this.countryServive.findAll().subscribe((res: HttpResponse<IDestinationCounry[]>) => {
            this.countries = res.body;
        });
        this.borderServive.findAll().subscribe((res: HttpResponse<IBorderCrossingPoint[]>) => {
            this.borderCrossingsPoints = res.body
        })
    }

    updateForm(request: IRequest): void {
        this.editForm.patchValue({
            id: request.id,
            recipient: request.recipient,
            destinationCity: request.destinationCity,
            destinationCountry: request.destinationCountry,
            borderCrossingPoint: request.borderCrossingPoint,
            transport: request.transport,
            vehicleNumber: request.vehicleNumber,
            veterinarian: request.veterinarian,
            transactionType: request.transactionType,
            status: request.status,
            dateOfDeparture: request.dateOfDeparture != null ? moment(request.dateOfDeparture.format(DATE_FORMAT)) : undefined,
            inspectorOfRosselkhoznadzor: request.inspectorOfRosselkhoznadzor,
            certificate1FormNumber: request.certificate1FormNumber
        })
    }

    createFormFrom(): IRequest {
        return {
            ...new Request(),
            id: this.editForm.get(['id'])!.value,
            recipient: this.editForm.get(['recipient'])!.value,
            destinationCountry: this.selectedCountry,
            destinationCity: this.editForm.get(['destinationCity'])!.value,
            borderCrossingPoint: this.editForm.get(['borderCrossingPoint'])!.value,
            transport: this.editForm.get(['transport'])!.value,
            vehicleNumber: this.editForm.get(['vehicleNumber'])!.value,
            veterinarian: this.editForm.get(['veterinarian'])!.value,
            inspectorOfRosselkhoznadzor: this.editForm.get(['inspectorOfRosselkhoznadzor'])!.value,
            status: this.editForm.get(['status'])!.value,
            certificate1FormNumber: this.editForm.get(['certificate1FormNumber'])!.value,
            dateOfDeparture: this.editForm.get(['dateOfDeparture'])!.value != null ? 
                moment(
                    this.editForm.get(['dateOfDeparture'])!.value,
                    DATE_FORMAT
                ) : undefined,
            transactionType: this.editForm.get(['transactionType'])!.value,
            animals: this.animals
        }
    }

    save(): void {
        const request = this.createFormFrom();
        this.subscribeToSaveResponse(this.requestService.update(request));
    }

    previousState(): void {
        window.history.back();
    }

    subscribeToSaveResponse(result: Observable<HttpResponse<IRequest>>): void {
        result.subscribe(
            () => this.onSaveSuccess(),
            () => this.onSaveError()
        );
    }

    onSaveSuccess(): void {
        window.history.back();
    }

    onSaveError(): void {
        console.log("SAVING ERROR");
    }

    check():void {
        console.log(this.selectedCountry)
    }
}