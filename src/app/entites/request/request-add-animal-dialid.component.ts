import { Component, OnInit } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RegionService } from '../region/region.service';
import { AnimalService } from '../animal/animal.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { Animal } from 'src/app/shared/model/animal.model';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { add } from 'ngx-bootstrap/chronos/public_api';
import { Observable } from 'rxjs';
import { RequestService } from './request.service';

@Component({
    templateUrl: './request-add-animal-dialid.component.html'
})
export class RequestAddAnimalDialogComponent implements OnInit{
    request: IRequest;
    animals: Animal[];

    constructor(
        protected requestService: RequestService,
        protected animalService: AnimalService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager,
        protected fb: FormBuilder
    ){}

    editForm = this.fb.group({
        animal:[]
    })
    ngOnInit(): void {
        this.animalService.findMy().subscribe((res: HttpResponse<Animal[]>) => {
        this.animals = res.body;
        console.log(this.deleteAnimals(res.body));
        });
    }
    clear(): void {
        this.activeModal.close();
    }

    addAnimalToRequest(request: IRequest): IRequest {
        const req = request;
        const animal=this.editForm.get(['animal'])!.value;
        req.animals.push(animal);
        return req;

    }

    save(): void {
        const request = this.addAnimalToRequest(this.request);
        this.subscribeToSaveResponse(this.requestService.update(request));
    }

    subscribeToSaveResponse(result: Observable<HttpResponse<IRequest>>): void {
        result.subscribe(
            () => this.onSaveSuccess(),
            () => this.onSaveError()
        );
    }

    onSaveSuccess(): void {
        this.eventManager.broadcast('requestModification');
        this.activeModal.close();
    }

    onSaveError(): void {
        console.log('ERROR IN SAVING');
    }

    deleteAnimals(animals: Animal[]): Animal[] {
        this.request.animals.forEach(animal => {
            animals.forEach(anim => {
                if (animal.id === anim.id) {
                    animals.splice(animals.indexOf(anim),1)
                }
            })
        })
        return animals;
    }

    
}