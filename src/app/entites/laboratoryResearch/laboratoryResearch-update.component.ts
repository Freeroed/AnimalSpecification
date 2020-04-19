import { Component, OnInit } from "@angular/core";
import { LaboratoryResearchService } from './laboratoryResearch.service';
import { FormBuilder } from '@angular/forms';
import { NgbActiveModal, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { Moment } from 'moment';
import { Animal } from 'src/app/shared/model/animal.model';
import { LaboratoryResurch, ILaboratoryResurch } from 'src/app/shared/model/laboratoryResurch.model';
import { DATE_TIME_FORMAT, DATE_FORMAT } from 'src/app/app.constants';
import * as moment from 'moment';
import { DateParserFormatter } from 'src/app/core/dateParseFormatter';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

@Component({
    templateUrl: './laboratoryResearch-update.component.html',
    providers: [{ provide: NgbDateParserFormatter, useClass: DateParserFormatter }]
})

export class LaboratoryResearchUpdateComponent implements OnInit {

    date: Moment;
    animal: Animal;
    isDateValid: boolean;
    constructor(
        private laboratoryResearchService: LaboratoryResearchService,
        private fb: FormBuilder,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}
    laboratoryResearch: ILaboratoryResurch;

    editForm = this.fb.group ({
        id: [],
        laboratory: [],
        indicator: [],
        dateOfReceiptOfResult: [],
        researchMethod: [],
        examinationNumber: [],
        result: [],
        animal: []
    });

    createFormFrom(): ILaboratoryResurch {
        return {
            ...new LaboratoryResurch(),
            id: this.editForm.get(['id'])!.value,
            laboratory: this.editForm.get(['laboratory'])!.value,
            indicator: this.editForm.get(['indicator'])!.value,
            dateOfReceiptOfResult: this.editForm.get(['dateOfReceiptOfResult'])!.value != null && this.editForm.get(['dateOfReceiptOfResult'])!.value != null
            ? moment(
                this.editForm.get(['dateOfReceiptOfResult'])!.value,
                DATE_TIME_FORMAT
              )
            : undefined,
            researchMethod: this.editForm.get(['researchMethod'])!.value,
            examinationNumber: this.editForm.get(['examinationNumber'])!.value,
            result: this.editForm.get(['result'])!.value,
            animal: this.animal
            
        }
    }

    updateForm(laboratoryResearch: ILaboratoryResurch): void {
        this.editForm.patchValue({
            id: laboratoryResearch.id,
            laboratory: laboratoryResearch.laboratory,
            indicator: laboratoryResearch.indicator,
            dateOfReceiptOfResult: laboratoryResearch.dateOfReceiptOfResult != null ? moment(laboratoryResearch.dateOfReceiptOfResult.format(DATE_FORMAT)) : null,
            examinationNumber: laboratoryResearch.examinationNumber,
            result: laboratoryResearch.result,
            researchMethod: laboratoryResearch.researchMethod
        })
    }

    clear(): void {
        this.activeModal.dismiss();
    }

    save(): void {
        const laboratoryResearch = this.createFormFrom();
        if (laboratoryResearch.id === undefined || laboratoryResearch.id === null) {
            this.subscribeToSaveResponse(this.laboratoryResearchService.save(laboratoryResearch));
        } else {
            this.subscribeToSaveResponse(this.laboratoryResearchService.update(laboratoryResearch));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ILaboratoryResurch>>): void {
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
    ngOnInit(): void{
        this.date = moment(moment().format('YYYY-MM-DD'));
        this.isDateValid = true;
        if (this.laboratoryResearch) {
            this.updateForm(this.laboratoryResearch);
        }
    }

    checkDate(): boolean {
        const dateOfReceiptOfResult = this.editForm.get(['dateOfReceiptOfResult'])!.value != null && this.editForm.get(['dateOfReceiptOfResult'])!.value != null
        ? moment(
            this.editForm.get(['dateOfReceiptOfResult'])!.value,
            'YYYY-MM-DD'
          )
        : undefined;
        if (dateOfReceiptOfResult && this.date.isBefore(dateOfReceiptOfResult)) {
            return this.isDateValid = true;
        } else {
            return this.isDateValid = false;
        }
    }
}