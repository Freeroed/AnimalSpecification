import { Component } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { RequestStatus } from 'src/app/shared/model/enum/requestStatus.model';

@Component({
    templateUrl: './request-give-out-documents-dialog.component.html'
})
export class RequestGiveOutDocumentsComponent {
    request : IRequest;

    constructor(
        protected requestService: RequestService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager,
        protected fb: FormBuilder
    ){}

    clear() {
        this.activeModal.close();
    }

    save(): void {
        const request = this.request;
        request.status = RequestStatus['4'];
        this.subscribeToSaveResponse(this.requestService.update(request));
    }

    subscribeToSaveResponse(result: Observable<HttpResponse<IRequest>>): void{
        result.subscribe(
            () => this.onSaveSuccess(),
            () => this.onSaveError()
        )
    }

    onSaveSuccess(): void {
        this.eventManager.broadcast('requestModification');
        this.activeModal.close();
    }

    onSaveError(): void{
        console.log('SAVING ERROR');
    }
}