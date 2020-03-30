import { Injectable } from '@angular/core';
import { serialize } from 'v8';
import { IAccount } from 'src/app/shared/model/account.model';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({ providedIn: 'root'})
export class TokenStorageService {

    constructor() {}

    signOut() {
        window.sessionStorage.clear();
    }

    public saveToken(token: string) {
        window.sessionStorage.removeItem(TOKEN_KEY);
        window.sessionStorage.setItem(TOKEN_KEY, token);
    }

    public getToken(): string {
        return window.sessionStorage.getItem(TOKEN_KEY);

    }

    public saveUser(user: IAccount) {
        window.sessionStorage.removeItem(USER_KEY);
        window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
    }

    public getUser(): IAccount{
        return JSON.parse(sessionStorage.getItem(USER_KEY));
    }

    public logout() {
        window.sessionStorage.removeItem(USER_KEY);
        window.sessionStorage.removeItem(TOKEN_KEY);
    }
}