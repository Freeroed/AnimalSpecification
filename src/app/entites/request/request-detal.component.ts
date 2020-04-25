import { Component, OnInit } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { RequestAddAnimalDialogComponent } from './request-add-animal-dialid.component';
import { Animal } from 'src/app/shared/model/animal.model';
import { RequestDeleteAnimalDeleteDialogComponent } from './request-delete-animal-dialog.component';
import { Subscription } from 'rxjs';
import { RequestStatus } from 'src/app/shared/model/enum/requestStatus.model';

@Component({
    selector: 'app-request-detail',
    templateUrl: './request-detail.component.html'
})
export class RequestDetailComponent implements OnInit {
    request: IRequest;
    eventSubscriber?: Subscription;
    RequestStatus = RequestStatus;

    constructor(
        private activatedRoute: ActivatedRoute,
        protected modalService: NgbModal,
        protected requestService: RequestService,
        protected eventManager: JhiEventManager){}

    ngOnInit(): void {
        this.loadPage();
        this.registerChangesInRequest();
        console.log(RequestStatus);
    }
    loadPage(): void {
        this.activatedRoute.data.subscribe(({ request }) => {
            this.request = request;
        });
    }

    registerChangesInRequest(): void {
        this.eventSubscriber = this.eventManager.subscribe('requestModification', () => this.loadPage())
    }

    addAnimal(): void {
        const modalRef = this.modalService.open(RequestAddAnimalDialogComponent,  { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = this.request;
    }

    deleteAnimalFromRequest(animal: Animal): void {
        const modalRef = this.modalService.open(RequestDeleteAnimalDeleteDialogComponent,  { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = this.request;
        modalRef.componentInstance.animal = animal;
    }

    
}