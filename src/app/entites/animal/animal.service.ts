import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Animal } from '../../shared/model/animal.model';
import { Observable, observable, pipe } from 'rxjs';
import * as moment from 'moment';
import { map } from 'rxjs/operators';
import { SERVER_API_URL } from '../../app.constants'
import { createRequestOption } from '../../shared/util/request-util';


type EntityResponseType = HttpResponse<Animal>;
type EntityArrayResponseType = HttpResponse<Animal[]>;

@Injectable({ providedIn: 'root'})
export class AnimalService {
    private resourceUrl = SERVER_API_URL + 'api/animals';

    constructor(private http: HttpClient) {}

    find(id: number): Observable<EntityResponseType> {
        return this.http
        .get<Animal>(`${this.resourceUrl}/${id}`, {observe: 'response'})
        .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    findAll(): Observable<EntityArrayResponseType> {
        return this.http.get<Animal[]>(this.resourceUrl, { observe: 'response'})
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)))
    }
    findMy(): Observable<EntityArrayResponseType> {
        return this.http.get<Animal[]>(this.resourceUrl + '/my', { observe: 'response'})
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)))
    } 
    save(animal: Animal): Observable<any> {
        const copy = this.convetDateFromClient(animal);
        return this.http.post(this.resourceUrl , copy)
        .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    /*
    Корневрт даты
    */
    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.birthday = res.body.birthday ? moment(res.body.birthday) : undefined;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((animal: Animal) => {
                animal.birthday = animal.birthday ? moment(animal.birthday) : undefined;
            });
        }
        return res;
    }

    protected convetDateFromClient(animal: Animal): Animal {
        const copy: Animal = Object.assign({}, animal, {
            birthday: animal.birthday && animal.birthday.isValid() ? animal.birthday.toJSON() : undefined
        });
        return copy;
    }
}