import { TypeOfAnimal } from './typeOfAnimal.model';

export interface IBreedOfAnimal {
    id?: number,
    breedName?: string,
    breedNameEng?: string,
    typeOfAnimal?: TypeOfAnimal
}
export class BreedOfAnimal implements IBreedOfAnimal {
    constructor(
        public id?: number,
        public breedName?: string,
        public breedNameEng?: string,
        public typeOfAnimal?: TypeOfAnimal
    ){}
}