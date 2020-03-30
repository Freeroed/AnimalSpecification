import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from './../../app.constants'
import { logging } from 'protractor';
import { TokenStorageService } from './token-storage.service';
import { StateStorageService } from './state-storage.service';
import { Router } from '@angular/router';
import { User } from 'src/app/shared/model/user.model';
import { ICredentials } from 'src/app/shared/model/credentials.model';


const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({providedIn: 'root' })
export class AuthService {
    constructor(
        private http: HttpClient, 
        private tokenStorage: TokenStorageService) {}


    login(credentials: ICredentials): Observable<any> {
        return this.http.post(SERVER_API_URL + 'api/auth/signin', {
            username: credentials.login,
            password: credentials.password
        }, httpOptions);
    
    }

    register(user): Observable<any> {
        return this.http.post(SERVER_API_URL + 'api/auth/signup',
        user, httpOptions);
    }

    logout(): void {
        this.tokenStorage.logout();
    }




}



