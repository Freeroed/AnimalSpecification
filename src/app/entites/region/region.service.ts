import { Injectable } from '@angular/core'
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Region, IRegion } from '../../shared/model/region.model';
import { Observable, observable, pipe } from 'rxjs';
import * as moment from 'moment';
import { map } from 'rxjs/operators';
import { SERVER_API_URL } from '../../app.constants'
import { createRequestOption } from '../../shared/util/request-util';

type EntityResponseType = HttpResponse<Region>;
type EntityArrayResponseType = HttpResponse<Region[]>;
@Injectable()
export class RegionService {
    private resourceUrl = SERVER_API_URL + 'api/regions';

    constructor(private http: HttpClient) {}

    find(id: number): Observable<EntityResponseType> {
        return this.http
        .get<Region>(`${this.resourceUrl}/${id}`, {observe: 'response'});
    }

    findAll(): Observable<EntityArrayResponseType> {
        return this.http.get<Region[]>(this.resourceUrl, { observe: 'response'});
    }
}