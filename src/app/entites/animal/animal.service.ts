import { Injectable } from '@angular/core'
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Animal } from '../../shared/model/animal.model';
import { Observable, observable, pipe } from 'rxjs';
import * as moment from 'moment';
import { map } from 'rxjs/operators';
import { SERVER_API_URL } from '../../app.constants'
import { createRequestOption } from '../../shared/util/request-util';


type EntityResponseType = HttpResponse<Animal>;
type EntityArrayResponseType = HttpResponse<Animal[]>;

@Injectable()
export class AnimalService {
    private resourceUrl = SERVER_API_URL + 'api/animals';

    constructor(private http: HttpClient) {}

    find(id: number): Observable<Animal> {
        return this.http
        .get<Animal>(`${this.resourceUrl}/${id}`, {observe: 'response'})
        .pipe(map((res: Animal) => this.convertDateFromServer(res)));
    }

    fiidAll(): Observable<Animal[]> {
        console.log("log bu servive");
        return this.http
        .get<Animal[]>(this.resourceUrl);
    }

    protected convertDateFromServer(res: Animal): Animal {
        if(res) {
            res.birthday = res.birthday ? moment(res.birthday) : undefined;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: Animal[]): Animal[] {
        if (res) {
            res.forEach((animal: Animal) => {
                animal.birthday = animal.birthday ? moment(animal.birthday) : undefined;
            });
        }
        return res;
    }
}