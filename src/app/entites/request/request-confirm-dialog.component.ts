import { Component } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { RequestStatus } from 'src/app/shared/model/enum/requestStatus.model';

@Component({
    templateUrl: './request-confirm-dialog.component.html'
})
export class RequestConfirmDialogComponent {

    request: IRequest;

    constructor(
        private requestService: RequestService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager,
    ) {}

    clear(): void {
        this.activeModal.dismiss();
    }

    confirm(): void {
        const req = this.request;
        req.status = RequestStatus.CONFIRM;
        console.log(req);
        this.subscribeToConfirmResponse(this.requestService.update(req))
    }

    subscribeToConfirmResponse(result: Observable<HttpResponse<IRequest>>): void {
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
        console.log('SAVING ERROR');
    }
}