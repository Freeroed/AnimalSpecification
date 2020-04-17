import { Animal } from './animal.model';
import { Moment } from 'moment';

export interface IVaccine {
    id?: number,
    animal?: Animal,
    type?: string,
    title?: string,
    date?: Moment,
    vaccineBatchNumber?: string,
    vaccineNameAndManufacturer?: string,
    validUntil?: Moment
}

export class Vaccine implements IVaccine {
    constructor(
        public id?: number,
        public animal?: Animal,
        public type?: string,
        public title?: string,
        public date?: Moment,
        public vaccineBatchNumber?: string,
        public vaccineNameAndManufacturer?: string,
        public validUntil?: Moment){
    }
}