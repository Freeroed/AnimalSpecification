import { IDestinationCounry } from './destinationCountry.model';
import { IBorderCrossingPoint } from './borderCrossingPoint.model';
import { Moment } from 'moment';
import { Animal } from './animal.model';
import { RequestStatus } from './enum/requestStatus.model';
import { TransportType } from './enum/transportType.model';
import { User } from './user.model';
import { TransactionType } from './enum/transactionType.model';

export interface IRequest {
    id?: number,
    recipient?: User,
    destinationCountry?: IDestinationCounry,
    destinationCity?: string,
    borderCrossingPoint?: IBorderCrossingPoint,
    transport?: TransportType,
    vehicleNumber?: string,
    veterinarian?: User,
    transactionType?: TransactionType,
    wayOfStorageDuringTransportation?: string,
    quarantineLocation?: string,
    numberOfDaysToQuarantine?: number,
    inspectorOfRosselkhoznadzor?: User,
    postalCode?: string,
    dateOfDeparture?: Moment,
    certificate1FormNumber?: string,
    status?: RequestStatus,
    animals?: Animal[]
}

export class Request implements IRequest {
    constructor(
        public id?: number,
        public recipient?: User,
        public destinationCountry?: IDestinationCounry,
        public destinationCity?: string,
        public borderCrossingPoint?: IBorderCrossingPoint,
        public transport?: TransportType,
        public vehicleNumber?: string,
        public veterinarian?: User,
        public transactionType?: TransactionType,
        public wayOfStorageDuringTransportation?: string,
        public quarantineLocation?: string,
        public numberOfDaysToQuarantine?: number,
        public inspectorOfRosselkhoznadzor?: User,
        public postalCode?: string,
        public dateOfDeparture?: Moment,
        public certificate1FormNumber?: string,
        public status?: RequestStatus,
        public animals?: Animal[]
    ){}
}