import { Component } from "@angular/core";
import { AnimalService } from './animal.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

@Component({
    templateUrl: './animal-delete-dialog.component.html'
})
export class AnimalDeleteDialogComponent {
    id!: number;

    constructor(
        protected animalService: AnimalService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ){}

    clear(): void {
        this.activeModal.dismiss();
    }
}