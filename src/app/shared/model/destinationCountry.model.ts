import { IRegion } from './region.model';

export interface IDestinationCounry {
    id?: number,
    countryName?: string,
    countryNameEng?: string,
    region?: IRegion,
    ISOcode?: string
}

export class DestinationCounry implements IDestinationCounry {
    constructor(
        public id?: number,
        public countryName?: string,
        public countryNameEng?: string,
        public region?: IRegion,
        public ISOcode?: string
    ) {}
}