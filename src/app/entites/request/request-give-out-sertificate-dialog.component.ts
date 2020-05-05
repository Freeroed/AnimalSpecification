import { Component } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { FormBuilder } from '@angular/forms';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RequestStatus } from 'src/app/shared/model/enum/requestStatus.model';

@Component({
    templateUrl: './request-give-out-sertificate-dialog.component.html'
})
export class RequestGiveOutSertificateComponent {
    request: IRequest;
    RequestStatus : RequestStatus;

    constructor(
        protected requestService: RequestService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager,
        protected fb: FormBuilder){}

    editForm = this.fb.group({
        certificate: []
    })

    clear(): void {
        this.activeModal.close();
    }

    save(): void {
        const request = this.request;
        this.request.certificate1FormNumber = this.editForm.get(['certificate'])!.value;
        this.request.status = RequestStatus['3'];
        this.subscibeToSaveResponse(this.requestService.update(request))
    }

    subscibeToSaveResponse(result: Observable<HttpResponse<IRequest>>): void {
        result.subscribe(
            () => this.onSaveSuccess(),
            () => this.onSaveError()
        );
    }

    onSaveSuccess(): void {
        this.eventManager.broadcast('requestModification');
        this.activeModal.close();
    }

    onSaveError(): void {
        console.log('SAVING ERROR')
    }
}