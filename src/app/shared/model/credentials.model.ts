export interface ICredentials {
    login?: string,
    password?:string
}

export class Credentials implements ICredentials{
    constructor(
        public login?: string,
        public password?:string
    ) {}
}