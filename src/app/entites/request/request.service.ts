import { HttpResponse, HttpClient } from "@angular/common/http";
import { IRequest } from 'src/app/shared/model/request.model';
import { Injectable } from '@angular/core';
import { SERVER_API_URL, DATE_FORMAT } from 'src/app/app.constants';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { map } from 'rxjs/operators';
import { createRequestOption } from 'src/app/shared/util/request-util';

type EntityResponseType = HttpResponse<IRequest>;
type EntityArrayResponseType = HttpResponse<IRequest[]>;

@Injectable({ providedIn: 'root'})
export class RequestService {
    private resourceUrl = SERVER_API_URL + 'api/requests';

    constructor(private http: HttpClient) {}

    find(id: number) : Observable<EntityResponseType> {
        console.log("123")
        return this.http
            .get<IRequest>(`${this.resourceUrl}/${id}`, {observe: 'response'})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)))
    }

    findMy(): Observable<EntityArrayResponseType> {
        return this.http
            .get<IRequest[]>(this.resourceUrl + '/my', { observe: 'response'})
            .pipe(map((res:EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }
    
    findAll(req?: any): Observable<EntityArrayResponseType> {
        const optional = createRequestOption(req);
        return this.http
            .get<IRequest[]>(this.resourceUrl, {params: optional, observe: 'response'})
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    save(request: IRequest): Observable<EntityResponseType> {
        const copy = this.convetDateFromClient(request);
        return this.http
            .post(this.resourceUrl, copy)
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(request: IRequest):Observable<EntityResponseType> {
        const copy = this.convetDateFromClient(request);
        return this.http
            .put<IRequest>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<{}>> {
        return this.http
                .delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.dateOfDeparture = res.body.dateOfDeparture ? moment(res.body.dateOfDeparture, DATE_FORMAT) : undefined;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((request: IRequest) => {
                request.dateOfDeparture = request.dateOfDeparture ? moment(request.dateOfDeparture) : undefined;
            });
        }
        return res;
    }

    protected convetDateFromClient(request: IRequest): IRequest {
        const copy: IRequest = Object.assign({}, request, {
            dateOfDeparture: request.dateOfDeparture && request.dateOfDeparture.isValid() ? request.dateOfDeparture.toJSON() : undefined
        });
        return copy;
    }

}