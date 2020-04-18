import { Component, OnInit } from "@angular/core";
import { Animal } from 'src/app/shared/model/animal.model';
import { AnimalService } from './animal.service';
import { ActivatedRoute } from '@angular/router';
import { IVaccine } from 'src/app/shared/model/vaccine.model';
import { ILaboratoryResurch } from 'src/app/shared/model/laboratoryResurch.model';
import { Moment } from 'moment';
import * as moment  from 'moment';

@Component ({
    selector: 'app-animal-detail',
    templateUrl: './animal-detail.component.html'
})
export class AnimalDetailComponent implements OnInit {
    today: Moment;
    animal: Animal;
    vaccines: IVaccine[];
    laboretoryResurches: ILaboratoryResurch[];

    constructor(
        private animalService: AnimalService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ animal }) => {
            this.animal = animal;
            console.log(this.animal);
        });
        this.vaccines = [];
        this.laboretoryResurches = [];
        this.today = moment();
    }
}