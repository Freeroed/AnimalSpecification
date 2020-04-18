import { Component } from "@angular/core";
import * as moment from 'moment';
import { Moment } from 'moment';
import { VaccineService } from './vaccine.service';
import { FormBuilder } from '@angular/forms';
import { IVaccine, Vaccine } from 'src/app/shared/model/vaccine.model';
import { Animal } from 'src/app/shared/model/animal.model';
import { DATE_TIME_FORMAT } from 'src/app/app.constants';
import { NgbActiveModal, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { DateParserFormatter } from 'src/app/core/dateParseFormatter';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Component({
    templateUrl: './vaccine-update.component.html',
    providers: [{ provide: NgbDateParserFormatter, useClass: DateParserFormatter }]
})
export class VaccineUpdateComponent {

    date: Moment;
    animal: Animal;
    constructor(
        private vaccineService: VaccineService,
        private fb: FormBuilder,
        public activeModal: NgbActiveModal
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
        console.log(this.createFormFrom());
        const vaccine = this.createFormFrom();
        if (vaccine.id === undefined || vaccine.id === null) {
            this.subscribeToSaveResponse(this.vaccineService.save(vaccine));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IVaccine>>): void {
        result.subscribe(
            () => this.onSaveSuccess(),
            () => this.onSaveError()
        );
    }

    protected onSaveSuccess(): void {
        this.activeModal.dismiss();
    }

    protected onSaveError(): void {
        console.log("CREATING ERROR");
    }
}