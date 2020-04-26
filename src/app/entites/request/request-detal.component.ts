import { Component, OnInit } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { RequestAddAnimalDialogComponent } from './request-add-animal-dialid.component';
import { Animal } from 'src/app/shared/model/animal.model';
import { RequestDeleteAnimalDeleteDialogComponent } from './request-delete-animal-dialog.component';
import { Subscription, Observable, of } from 'rxjs';
import { RequestStatus } from 'src/app/shared/model/enum/requestStatus.model';
import { IVaccine, Vaccine } from 'src/app/shared/model/vaccine.model';
import { VaccineService } from '../vaccine/vaccine.service';
import { HttpResponse } from '@angular/common/http';
import * as moment from 'moment';
import { flatMap } from 'rxjs/operators';


@Component({
    selector: 'app-request-detail',
    templateUrl: './request-detail.component.html'
})
export class RequestDetailComponent implements OnInit {
    request: IRequest;
    eventSubscriber?: Subscription;
    RequestStatus = RequestStatus;
    errors : string[][] = [];

    constructor(
        private activatedRoute: ActivatedRoute,
        protected modalService: NgbModal,
        protected requestService: RequestService,
        protected eventManager: JhiEventManager,
        protected vaccineService: VaccineService){}

    ngOnInit(): void {
        this.loadPage();
        this.registerChangesInRequest();
        this.checkAnimals();
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

    checkAnimals(): void {
        this.request.animals.forEach((animal) =>{
            //let animalError: string[];
            this.checkOneAnimal(animal).subscribe((errors: string[]) => {
                 this.errors.push(errors);
            })
        });
    }


    checkOneAnimal(animal: Animal): Observable<string[]> {
        let animalError: string[] = [];
        return this.checkVaccines(animal).pipe(
            flatMap((errors: string[]) => {
                animalError = animalError.concat(errors);
                return of(errors);
            })
        )
    }
    checkVaccines(animal: Animal): Observable<string[]> {
        const today = moment();
        let vaccineError: string[] = [];
        return this.vaccineService.findAlByAnimal(animal).pipe(
            flatMap((vaccines: HttpResponse<IVaccine[]>) =>{
                vaccines.body.forEach(vaccine => {
                    if (moment.duration(today.diff(vaccine.date)).asDays() < 20) {
                        vaccineError.push('Прошло менее 20-ти дней с момента вакцинации: ' + vaccine.title);
                    }
                });
                return of(vaccineError);
            })
        )
    }

    getVaccines(animal: Animal) {
        let vaccines: IVaccine[];
        this.vaccineService.findAlByAnimal(animal).subscribe((res: HttpResponse<IVaccine[]>) => {
            vaccines = res.body;});
    }

    
}