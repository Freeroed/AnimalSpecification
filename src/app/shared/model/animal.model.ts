import { Moment } from 'moment';
export class Animal {
    constructor(
    public id?: number,
    public nickname?: string,
    public sex?: string,
    public type?: number,
    public chip?: string,
    public weight?: number,
    public birthday?: Moment,
    public breed?: number,
    public color?: string,
    public placeOfBirth?: string,
    public human?: number,
    public tnvedCode?: string,
    public colorENG?: string,
    ) {}
}