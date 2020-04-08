import { Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, ReplaySubject } from 'rxjs';
import { SERVER_API_URL } from './../../app.constants'
import { TokenStorageService } from './token-storage.service';
import { ICredentials } from 'src/app/shared/model/credentials.model';
import { User } from 'src/app/shared/model/user.model';
import { Router } from '@angular/router';


const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({providedIn: 'root' })
export class AuthService {
    private authenticationState = new ReplaySubject<User | null>(1);
    constructor(
        private http: HttpClient, 
        private tokenStorage: TokenStorageService,
        private router: Router) {}


    login(credentials: ICredentials): Observable<any> {
        return this.http.post(SERVER_API_URL + 'api/auth/signin', {
            username: credentials.login,
            password: credentials.password
        }, httpOptions);
    
    }
    authenticate(user: User | null): void{
        this.authenticationState.next(user);
    }

    register(user): Observable<any> {
        return this.http.post(SERVER_API_URL + 'api/auth/signup',
        user, httpOptions);
    }

    logout(): void {
        this.tokenStorage.logout();
        this.authenticate(null);
        this.router.navigate(['']);
    }
    hasRoles(): boolean {
        const user = this.tokenStorage.getUser();
        if(user && user.roles && user.roles.length > 0 ) {
            return true
        } else {
            return false;
        }
    }

    hasAnyRole(roles : string[] | string): boolean {
        const user = this.tokenStorage.getUser();
        if(user && user.roles) {
            return user.roles.some((role: string) => roles.includes(role));
        } else { 
            return false;
        }
    }
    getAuthenticationState(): Observable<User | null> {
        return this.authenticationState.asObservable();
      }




}



