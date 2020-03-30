export interface IAccount {
    username?: string,
    email?: string,
    roles?: string[]
}

export class Account implements IAccount{
    constructor(
        public username?: string,
        public email?: string,
        public roles?: string[]
    ) {}
}