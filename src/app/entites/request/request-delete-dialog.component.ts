import { Component } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Component({
    templateUrl: './request-delete-dialog.component.html'
})
export class RequestDeleteDialogComponent {
    request: IRequest;

    constructor(
        protected requestService: RequestService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager,
    ){}

    clear(): void {
        this.activeModal.dismiss();
    }

    confirmDelete(): void {
        this.subscribeToDeteleResponse(this.requestService.delete(this.request.id));
    }

    subscribeToDeteleResponse(result: Observable<HttpResponse<IRequest>>): void {
        result.subscribe( 
            () => this.onSuccess(),
            () => this.onError()
        )
    }

    onSuccess(): void {
        this.eventManager.broadcast('requestModification');
        this.activeModal.close();
    }

    onError(): void {
        console.log('EROR IN DELETING')
    }
}