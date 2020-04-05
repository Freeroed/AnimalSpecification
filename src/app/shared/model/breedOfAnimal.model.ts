import { TypeOfAnimal } from './typeOfAnimal.model';

export interface IBreedOfAnimal {
    id?: number,
    breedName?: string,
    breedNameEng?: string,
    animalType?: TypeOfAnimal
}
export class BreedOfAnimal implements IBreedOfAnimal {
    constructor(
        public id?: number,
        public breedName?: string,
        public breedNameEng?: string,
        public animalType?: TypeOfAnimal
    ){}
}