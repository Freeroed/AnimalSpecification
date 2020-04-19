import { Moment } from 'moment';
import { BreedOfAnimal } from './breedOfAnimal.model';
import { User } from './user.model';
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
    public master?: User,
    public tnvedCode?: string,
    public colorENG?: string,
    ) {}
}