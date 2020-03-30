import { Moment } from 'moment';

export interface IUser {
    id?: number,
    userName?: string,
    password?: string,
    surname?: string,
    name?: string,
    patronymic?: string,
    phone?: string,
    address?: string,
    inn?: string,
    surnameEng?: string,
    nameEng?: string,
    email?: string,
    createdAt?: Moment
}

export class User implements IUser {
    constructor(
        public id?: number,
        public userName?: string,
        public password?: string,
        public surname?: string,
        public name?: string,
        public patronymic?: string,
        public phone?: string,
        public address?: string,
        public inn?: string,
        public surnameEng?: string,
        public nameEng?: string,
        public email?: string,
        public createdAt?: Moment
    ) {}
}