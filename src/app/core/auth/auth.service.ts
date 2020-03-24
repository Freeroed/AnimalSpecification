import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from './../../app.constants'
import { logging } from 'protractor';


const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({providedIn: 'root' })
export class AuthService {
    constructor(private http: HttpClient) {}


    login(credentials): Observable<any> {
        return this.http.post(SERVER_API_URL + 'api/auth/signin', {
            username: credentials.username,
            password: credentials.password
        }, httpOptions);
    
    }

    register(user): Observable<any> {
        return this.http.post(SERVER_API_URL + 'api/auth/signup',
        user, httpOptions);
    }
}



