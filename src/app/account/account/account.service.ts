import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { SERVER_API_URL } from 'src/app/app.constants';
import { Observable } from 'rxjs';
import { User, IUser } from 'src/app/shared/model/user.model';
import * as moment from 'moment';
import { map } from 'rxjs/operators';
import { Animal } from 'src/app/shared/model/animal.model';

type EntityResponseType = HttpResponse<User>;

@Injectable()
export class AccountServive {
    private resourseUrl = SERVER_API_URL + "api/users/";
    

    constructor(private http: HttpClient) {}

    getAccount(): Observable<EntityResponseType> {
        return this.http.get<IUser>(this.resourseUrl+'im', {observe: 'response'})
        .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if(res.body) {
            res.body.createdAt = res.body.createdAt ? moment(res.body.createdAt) : undefined;
        } return res;
    }
}