import { IDocumentType } from './documentType.model';
import { Moment } from 'moment';

export interface IDocument {
    id?: number,
    type?: IDocumentType,
    dateOfIssue?: Moment,
    link?: string,
    documentNumber?: string
}

export class Document implements IDocument {
    constructor(
        public id?: number,
        public type?: IDocumentType,
        public dateOfIssue?: Moment,
        public link?: string,
        public documentNumber?: string
    ) {}
}