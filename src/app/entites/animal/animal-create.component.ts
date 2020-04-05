import { Component, OnInit } from "@angular/core";
import { AnimalService } from './animal.service';
import { FormBuilder } from '@angular/forms';
import { BreedOfAnimal } from 'src/app/shared/model/breedOfAnimal.model';
import { TypeOfAnimal } from 'src/app/shared/model/typeOfAnimal.model';
import { BreedsOfAnimalService } from '../breedsOfAnimal/breedsOfAnimal.service';
import { TypeOfAnimalService } from '../typesOfAnimal/typeOfAnimal.service';
import { HttpResponse } from '@angular/common/http';
import { Animal } from 'src/app/shared/model/animal.model';

@Component({
    selector: 'app-create-animal',
    templateUrl: './animal-create.component.html'
})
export class AnimalCreateComponent implements OnInit {
    breeds : BreedOfAnimal[];
    types : TypeOfAnimal[];
    isSuccessful = false;
    isSignUpFailed = false;
    errorMessage = '';

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
        }
    }
}