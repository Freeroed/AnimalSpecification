import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Region } from './../../shared/model/region.model';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { Animal} from 'src/app/shared/model/animal.model';
import { AnimalService } from './animal.service';

@Component({
    selector: 'app-animal-list',
    templateUrl: './animal.component.html'
})
export class AnimalComponent implements OnInit {
    animals: Animal[];


    constructor(
        protected animalService: AnimalService,
    ) {}

    ngOnInit() {
        this.animalService.fiidAll().subscribe(data => {
            this.animals = data;
        });
    }

    previousState(): void {
        window.history.back();
    }
}