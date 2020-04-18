import { Animal } from './animal.model';
import { Moment } from 'moment';
import { VacctineType } from './enum/vaccineType.model';

export interface IVaccine {
    id?: number,
    animal?: Animal,
    type?: VacctineType,
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
        public type?: VacctineType,
        public title?: string,
        public date?: Moment,
        public vaccineBatchNumber?: string,
        public vaccineNameAndManufacturer?: string,
        public validUntil?: Moment){
    }
}