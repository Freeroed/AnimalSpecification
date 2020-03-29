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
    ) {}
}