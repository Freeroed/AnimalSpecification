import { Component } from "@angular/core";
import * as moment from 'moment';
import { Moment } from 'moment';
import { VaccineService } from './vaccine.service';
import { FormBuilder } from '@angular/forms';
import { IVaccine, Vaccine } from 'src/app/shared/model/vaccine.model';
import { Animal } from 'src/app/shared/model/animal.model';
import { DATE_TIME_FORMAT } from 'src/app/app.constants';

@Component({
    templateUrl: './vaccine-update.component.html'
})
export class VaccineUpdateComponent {

    date: Moment;
    animal: Animal;
    constructor(
        private vaccineService: VaccineService,
        private fb: FormBuilder
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
}