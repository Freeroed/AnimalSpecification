import { Component, OnInit } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { Animal } from 'src/app/shared/model/animal.model';
import { RequestService } from './request.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
    templateUrl: './request-delete-animal-dialog.component.html'
})
export class RequestDeleteAnimalDeleteDialogComponent{

    request: IRequest;
    animal: Animal;

    constructor(
        protected requestService: RequestService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager,
    ){}




    clear(): void {
        this.activeModal.dismiss();
    }

    confirmDelete(): void {
        const request = this.deleteAnimalFromRequest();
        this.subscribeToDeteleResponse(this.requestService.update(request));
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
    deleteAnimalFromRequest(): IRequest {

        const request = this.request;
        request.animals.splice(request.animals.indexOf(this.animal), 1);
        return request;
    }
}