import { Component, OnInit } from "@angular/core";
import { AnimalService } from './animal.service';
import { FormBuilder } from '@angular/forms';
import { BreedOfAnimal } from 'src/app/shared/model/breedOfAnimal.model';
import { TypeOfAnimal } from 'src/app/shared/model/typeOfAnimal.model';
import { BreedsOfAnimalService } from '../breedsOfAnimal/breedsOfAnimal.service';
import { TypeOfAnimalService } from '../typesOfAnimal/typeOfAnimal.service';
import { HttpResponse } from '@angular/common/http';
import { Animal } from 'src/app/shared/model/animal.model';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'src/app/app.constants';
import { NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { DateParserFormatter } from 'src/app/core/dateParseFormatter';

@Component({
    selector: 'app-create-animal',
    templateUrl: './animal-create.component.html',
    providers: [{ provide: NgbDateParserFormatter, useClass: DateParserFormatter }]
    
})
export class AnimalCreateComponent implements OnInit {
    breeds : BreedOfAnimal[];
    types : TypeOfAnimal[];
    isSuccessful = false;
    isCreateFailed = false;
    errorMessage = '';
    selectedType = null;
    selectedBreed = null;
    selectedSex = null;

    constructor(
        private animalService: AnimalService,
        private fb: FormBuilder,
        private breedsService: BreedsOfAnimalService,
        private typesService: TypeOfAnimalService
    ) {}

    editForm = this.fb.group ({
        id: [],
        nickname: [],
        sex: [],
        chip: [],
        weitht: [],
        birthday: [],
        breed: [],
        type: [],
        color: [],
        placeOfBirth: [],
        tnvedCode: [],
        colorENG: []
    })

    ngOnInit() {
        this.typesService.findAll().subscribe((res: HttpResponse<TypeOfAnimal[]>) =>
        this.types = res.body);
    }

    createFormFrom(): Animal {
        return {
            ...new Animal(),
            id: this.editForm.get(['id'])!.value,
            nickname: this.editForm.get(['nickname'])!.value,
            sex: this.editForm.get(['sex'])!.value,
            weight: this.editForm.get(['weitht'])!.value,
            birthday: this.editForm.get(['birthday'])!.value != null && this.editForm.get(['birthday'])!.value != null
            ? moment(
                this.editForm.get(['birthday'])!.value,
                DATE_TIME_FORMAT
              )
            : undefined,
            breed: this.editForm.get(['breed'])!.value,
            color: this.editForm.get(['color'])!.value,
            placeOfBirth: this.editForm.get(['placeOfBirth'])!.value,
            tnvedCode: this.editForm.get(['tnvedCode'])!.value,
            colorENG: this.editForm.get(['colorENG'])!.value,
            chip: this.editForm.get(['chip'])!.value,
        }
    }
    getBreeds() : void {
        if (this.selectedType) {
        this.selectedBreed = null;
        this.breedsService.findAll({'id' : this.selectedType.id ? this.selectedType.id : null}).subscribe((res: HttpResponse<BreedOfAnimal[]>) => 
        this.breeds = res.body)
        }
    }
    save() {
        const animal = this.createFormFrom();
        this.subscribeToSaveResponse(this.animalService.save(animal));
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<Animal>>): void {
        result.subscribe(
            () => window.history.back(),
            message => {this.errorMessage = message.error.message;
            this.isCreateFailed = true;   //TODO check errors
            }
        )
    }

    previousState(): void {
        window.history.back();
    }
    
}