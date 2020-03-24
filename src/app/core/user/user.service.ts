import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from './../../app.constants';

const URL = SERVER_API_URL + 'api/'

@Injectable({ providedIn: 'root'})
export class UserService {
    constructor(private http: HttpClient) {}

    getPublicContext(): Observable<any> {
        return this.http.get(URL, {responseType: 'text'})
    }
}