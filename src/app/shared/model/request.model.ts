import { IDestinationCounry } from './destinationCountry.model';
import { IBorderCrossingPoint } from './borderCrossingPoint.model';
import { Moment } from 'moment';
import { Animal } from './animal.model';
import { RequestStatus } from './enum/requestStatus.model';
import { TransportType } from './enum/transportType.model';

export interface IRequest {
    id?: number,
    recipient?: Account,
    destinationCountry?: IDestinationCounry,
    destinationCity?: string,
    borderCrossingPoint?: IBorderCrossingPoint,
    transport?: TransportType,
    vehicleNumber?: string,
    veterinarian?: Account,
    transactionType?: string,
    wayOfStorageDuringTransportation?: string,
    quarantineLocation?: string,
    numberOfDaysToQuarantine?: number,
    inspectorOfRosselkhoznadzor?: Account,
    postalCode?: string,
    dateOfDeparture?: Moment,
    certificate1FormNumber?: string,
    status?: RequestStatus
}

export class Request implements IRequest {
    constructor(
        public id?: number,
        public recipient?: Account,
        public destinationCountry?: IDestinationCounry,
        public destinationCity?: string,
        public borderCrossingPoint?: IBorderCrossingPoint,
        public transport?: TransportType,
        public vehicleNumber?: string,
        public veterinarian?: Account,
        public transactionType?: string,
        public wayOfStorageDuringTransportation?: string,
        public quarantineLocation?: string,
        public numberOfDaysToQuarantine?: number,
        public inspectorOfRosselkhoznadzor?: Account,
        public postalCode?: string,
        public dateOfDeparture?: Moment,
        public certificate1FormNumber?: string,
        public status?: RequestStatus
    ){}
}