import { Moment } from 'moment';
import { BreedOfAnimal } from './breedOfAnimal.model';
export class Animal {
    constructor(
    public id?: number,
    public nickname?: string,
    public sex?: string,
    public chip?: string,
    public birthday?: Moment,
    public breed?: BreedOfAnimal,
    public color?: string,
    public placeOfBirth?: string,
    public human?: number,
    public tnvedCode?: string,
    public colorENG?: string,
    ) {}
}