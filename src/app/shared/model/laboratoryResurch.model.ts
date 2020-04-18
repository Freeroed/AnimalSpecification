import { Moment } from 'moment';
import { Animal } from './animal.model';
import { LaboratoryTestResult } from './enum/laboratoryTestResult.model';

export interface ILaboratoryResurch {
    id?: number,
    laboratory?: string,
    indicator?: string,
    dateOfReceiptOfResult?: Moment,
    researchMethod?: string,
    examinationNumber?: string,
    result?: LaboratoryTestResult,
    animal?: Animal
}

export class LaboratoryResurch implements ILaboratoryResurch {
    constructor(
        public id?: number,
        public laboratory?: string,
        public indicator?: string,
        public dateOfReceiptOfResult?: Moment,
        public researchMethod?: string,
        public examinationNumber?: string,
        public result?: LaboratoryTestResult,
        public animal?: Animal
    ){}
}