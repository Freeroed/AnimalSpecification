import { Component, OnInit, OnDestroy } from "@angular/core";
import { ActivatedRoute } from '@angular/router';
import { IUser, User } from 'src/app/shared/model/user.model';
import { AccountServive } from './account.service';
import * as moment from 'moment';
import { Animal } from 'src/app/shared/model/animal.model';
import { AnimalService } from 'src/app/entites/animal/animal.service';
import { HttpResponse } from '@angular/common/http';
import { RequestService } from 'src/app/entites/request/request.service';
import { IRequest } from 'src/app/shared/model/request.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AnimalDeleteDialogComponent } from 'src/app/entites/animal/animal-delete-dialog.component';
import { RequestDeleteDialogComponent } from 'src/app/entites/request/request-delete-dialog.component';
import { JhiEventManager } from 'ng-jhipster';
import { Subscription } from 'rxjs';

@Component({
    selector: 'app-account',
    templateUrl: './account.component.html'
})
export class AccountComponent implements OnInit, OnDestroy {
    user : IUser | null = null;
    date : number;
    animals: Animal[];
    requests?: IRequest[];
    eventInRequestSubscriber?: Subscription;
    eventInAnimalsSubscriber?: Subscription;
    
    constructor(
        protected accountService: AccountServive,
        protected activatedRoute: ActivatedRoute,
        protected animalService: AnimalService,
        protected requestService: RequestService,
        protected modalService: NgbModal,
        protected eventManager: JhiEventManager
    ) {}

    ngOnInit() {
        this.date = moment().get("hours");
        this.loadPage();
        this.registerChangesInAnimals();
        this.registerChangesInRequest();   
    }

    ngOnDestroy(): void {
        if (this.eventInRequestSubscriber) {
            this.eventManager.destroy(this.eventInRequestSubscriber);
        }
        if (this.eventInAnimalsSubscriber) {
            this.eventManager.destroy(this.eventInAnimalsSubscriber);
        }
    }

    loadPage(): void {
        this.activatedRoute.data.subscribe(({ user }) => {
            this.user = user;
        });
        this.animalService.findMy().subscribe( (res: HttpResponse<Animal[]>) => {
            this.animals = res.body
        }
        );
        this.requestService.findMy().subscribe((res: HttpResponse<IRequest[]>) =>
        {this.requests = res.body;  }
        )
    }
    registerChangesInRequest(): void {
        this.eventInRequestSubscriber = this.eventManager.subscribe('requestModification', () => this.loadPage())
    }

    registerChangesInAnimals(): void {
        this.eventInAnimalsSubscriber = this.eventManager.subscribe('animalModification', () => this.loadPage())
    }

    previousState(): void {
        window.history.back();
    }

    deleteAnimal(animal: Animal): void {
        const modalRef = this.modalService.open(AnimalDeleteDialogComponent, { size: 'lg', backdrop: 'static' });  
        modalRef.componentInstance.animal = animal;
    }

    deleteRequest(request: IRequest): void {
        const modalRef = this.modalService.open(RequestDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = request;

    }
}