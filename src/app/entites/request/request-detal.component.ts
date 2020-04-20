import { Component, OnInit } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { RequestAddAnimalDialogComponent } from './request-add-animal-dialid.component';

@Component({
    selector: 'app-request-detail',
    templateUrl: './request-detail.component.html'
})
export class RequestDetailComponent implements OnInit {
    request: IRequest;

    constructor(
        private activatedRoute: ActivatedRoute,
        protected modalService: NgbModal,
        protected requestService: RequestService,
        protected eventManager: JhiEventManager){}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ request }) => {
            this.request = request;
        })
    }

    addAnimal(): void {
        const modalRef = this.modalService.open(RequestAddAnimalDialogComponent,  { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = this.request;
    }
}