import { Component } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { FormBuilder } from '@angular/forms';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RequestStatus } from 'src/app/shared/model/enum/requestStatus.model';
import { IDocument, Document } from 'src/app/shared/model/document.model';
import { DocumentService } from '../document/document.service';

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
        protected fb: FormBuilder,
        protected documentService: DocumentService){}

    certificateForm = this.fb.group({
        certificate: []
    })

    clear(): void {
        this.activeModal.close();
    }

    save(): void {
        let document =  new Document;
        document.documentNumber = this.certificateForm.get(['certificate'])!.value;
        this.subscribeToCreateDocument(this.documentService.create(document));
    }

    subscibeToSaveResponse(result: Observable<HttpResponse<IRequest>>): void {
        result.subscribe(
            () => this.onSaveSuccess(),
            () => this.onSaveError()
        );
    }

    subscribeToCreateDocument(result: Observable<HttpResponse<IDocument>>): void {
        result.subscribe(
            (res: HttpResponse<IDocument>) => this.onCreatingDocumentSuccess(res.body),
            () => this.onCreateDocumentError()
        );
    }

    onCreatingDocumentSuccess(document: IDocument): void {
        const request = this.request;
        request.certificate1FormNumber = document;
        request.status = RequestStatus['3'];
        this.subscibeToSaveResponse(this.requestService.update(request));
    }

    onSaveSuccess(): void {
        this.eventManager.broadcast('requestModification');
        this.activeModal.close();
    }

    onSaveError(): void {
        console.log('SAVING ERROR')
    }

    onCreateDocumentError(): void {
        console.log('SAVING DOCUMENT ERROR')
    }

    createFormFrom(): IDocument {
        return {
            ...new Document(),
            documentNumber: this.certificateForm.get(['certificate'])!.value,
            dateOfIssue: undefined,
            id: undefined,
            link: undefined
        }
        
    }
}