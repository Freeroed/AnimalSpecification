import { Component } from "@angular/core";
import { AnimalService } from './animal.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { HttpResponse } from '@angular/common/http';
import { Animal } from 'src/app/shared/model/animal.model';
import { Observable } from 'rxjs';

@Component({
    templateUrl: './animal-delete-dialog.component.html'
})
export class AnimalDeleteDialogComponent {
    animal: Animal;

    constructor(
        protected animalService: AnimalService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ){}

    clear(): void {
        this.activeModal.dismiss();
    }

    confirmDelete(): void {
        this.subscribeToDeteleResponse(this.animalService.delete(this.animal.id))
    }

    subscribeToDeteleResponse(result: Observable<HttpResponse<Animal>>): void {
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