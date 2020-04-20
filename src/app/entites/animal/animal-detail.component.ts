import { Component, OnInit } from "@angular/core";
import { Animal } from 'src/app/shared/model/animal.model';
import { AnimalService } from './animal.service';
import { ActivatedRoute } from '@angular/router';
import { IVaccine } from 'src/app/shared/model/vaccine.model';
import { ILaboratoryResurch } from 'src/app/shared/model/laboratoryResurch.model';
import { Moment } from 'moment';
import * as moment  from 'moment';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { VaccineUpdateComponent } from '../vaccine/vaccine-update.component';
import { VaccineService } from '../vaccine/vaccine.service';
import { HttpResponse } from '@angular/common/http';
import { LaboratoryResearchUpdateComponent } from '../laboratoryResearch/laboratoryResearch-update.component';
import { LaboratoryResearchService } from '../laboratoryResearch/laboratoryResearch.service';
import { JhiEventManager } from 'ng-jhipster';
import { Subscription } from 'rxjs';

@Component ({
    selector: 'app-animal-detail',
    templateUrl: './animal-detail.component.html'
})
export class AnimalDetailComponent implements OnInit {
    today: Moment;
    animal: Animal= new Animal();
    vaccines: IVaccine[];
    laboratoryResurches: ILaboratoryResurch[];
    eventSubscriber?: Subscription;

    constructor(
        private activatedRoute: ActivatedRoute,
        protected modalService: NgbModal,
        protected vaccineService: VaccineService,
        protected laboratoryResearchService: LaboratoryResearchService,
        protected eventManager: JhiEventManager,
    ) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ animal }) => {
            this.animal = animal;
            this.loadPage();
        });
        this.today = moment();
        this.registerChangesInAnimal();
    }

    loadPage(): void {
        this.vaccineService.findAlByAnimal({'id' : this.animal.id ? this.animal.id : null}).subscribe((res : HttpResponse<IVaccine[]>) =>
                this.vaccines = res.body);
        this.laboratoryResearchService.findAlByAnimal({'id' : this.animal.id ? this.animal.id : null}).subscribe((res: HttpResponse<ILaboratoryResurch[]>) =>
            this.laboratoryResurches = res.body);
    }

    createVaccine(): void {
        const modalRef = this.modalService.open(VaccineUpdateComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.animal = this.animal ;
    }

    createLaboratoryResearch(): void {
        const modalRef = this.modalService.open(LaboratoryResearchUpdateComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.animal = this.animal;
    }

    registerChangesInAnimal(): void {
        this.eventSubscriber = this.eventManager.subscribe('animalModification', ()=> this.ngOnInit())
    }

    updateLaboratoryResearch(laboratoryResearch: ILaboratoryResurch) {
        const modalRef = this.modalService.open(LaboratoryResearchUpdateComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.animal = this.animal;
        modalRef.componentInstance.laboratoryResearch = laboratoryResearch;
    }

    updateVaccine(vaccine: IVaccine): void {
        const modalRef = this.modalService.open(VaccineUpdateComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.animal = this.animal ;
        modalRef.componentInstance.vaccine = vaccine;
    }
}