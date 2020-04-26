import { Component, OnInit } from "@angular/core";
import * as moment from 'moment';
import { Moment } from 'moment';
import { VaccineService } from './vaccine.service';
import { FormBuilder } from '@angular/forms';
import { IVaccine, Vaccine } from 'src/app/shared/model/vaccine.model';
import { Animal } from 'src/app/shared/model/animal.model';
import { DATE_TIME_FORMAT, DATE_FORMAT } from 'src/app/app.constants';
import { NgbActiveModal, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { DateParserFormatter } from 'src/app/core/dateParseFormatter';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { JhiEventManager } from 'ng-jhipster';

@Component({
    templateUrl: './vaccine-update.component.html',
    providers: [{ provide: NgbDateParserFormatter, useClass: DateParserFormatter }]
})
export class VaccineUpdateComponent implements OnInit{

    date: Moment;
    animal: Animal;
    isDateValid: boolean;
    isValidUtilValid: boolean;
    vaccine: IVaccine;
    constructor(
        private vaccineService: VaccineService,
        private fb: FormBuilder,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    editForm = this.fb.group ({
        id: [],
        type: [],
        animal: [],
        title: [],
        date: [],
        vaccineBatchNumber: [],
        vaccineNameAndManufacturer: [],
        validUntil: []
    });

    ngOnInit(): void {
        if (this.vaccine) {
            this.updateForm(this.vaccine);
        }
        this.isDateValid = true;
        this.isValidUtilValid = true;
        this.date = moment(moment().format('YYYY-MM-DD'));
    }

    updateForm(vaccine: IVaccine):void {
        this.editForm.patchValue({
            id: vaccine.id,
            type: vaccine.type,
            title: vaccine.title,
            date: vaccine.date != null ? moment(vaccine.date.format(DATE_FORMAT)) : null,
            vaccineBatchNumber: vaccine.vaccineBatchNumber,
            vaccineNameAndManufacturer: vaccine.vaccineNameAndManufacturer,
            validUntil: vaccine.validUntil != null ? moment(vaccine.validUntil.format(DATE_FORMAT)) : null,
        })
    }

    createFormFrom(): IVaccine {
        return {
            ...new Vaccine(),
            id: this.editForm.get(['id'])!.value,
            type: this.editForm.get(['type'])!.value,
            title: this.editForm.get(['title'])!.value,
            animal: this.animal,
            date: this.editForm.get(['date'])!.value != null && this.editForm.get(['date'])!.value != null
            ? moment(
                this.editForm.get(['date'])!.value,
                DATE_TIME_FORMAT
              )
            : undefined,
            vaccineBatchNumber: this.editForm.get(['vaccineBatchNumber'])!.value,
            vaccineNameAndManufacturer: this.editForm.get(['vaccineNameAndManufacturer'])!.value,
            validUntil: this.editForm.get(['validUntil'])!.value != null && this.editForm.get(['validUntil'])!.value != null
            ? moment(
                this.editForm.get(['validUntil'])!.value,
                DATE_TIME_FORMAT
              )
            : undefined
        }
    }

    clear(): void {
        this.activeModal.dismiss();
    }

    save(): void {
        const vaccine = this.createFormFrom();
        if (vaccine.id === undefined || vaccine.id === null) {
            this.subscribeToSaveResponse(this.vaccineService.save(vaccine));
        } else {
            this.subscribeToSaveResponse(this.vaccineService.update(vaccine));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IVaccine>>): void {
        result.subscribe(
            () => this.onSaveSuccess(),
            () => this.onSaveError()
        );
    }

    protected onSaveSuccess(): void {
        this.eventManager.broadcast('animalModification');
        this.activeModal.close();
    }

    protected onSaveError(): void {
        console.log("CREATING ERROR");
    }

    checkDate(): void {
        const vaccineDate = this.editForm.get(['date'])!.value != null && this.editForm.get(['date'])!.value != null
        ? moment(
            this.editForm.get(['date'])!.value,
            'YYYY-MM-DD'
          )
        : undefined;
        const validUtil = this.editForm.get(['validUntil'])!.value != null && this.editForm.get(['validUntil'])!.value != null
        ? moment(
            this.editForm.get(['validUntil'])!.value,
            'YYYY-MM-DD'
          )
        : undefined;

        if(vaccineDate && vaccineDate.isAfter(this.date)) {
            this.isDateValid = false;
        }
        else {
            this.isDateValid = true;
        }
        if(vaccineDate && validUtil && validUtil.isBefore(vaccineDate)) {
            this.isValidUtilValid = false
        } else {
            this.isValidUtilValid = true;
        }
    }
}