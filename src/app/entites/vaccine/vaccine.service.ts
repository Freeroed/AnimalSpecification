import { Injectable } from "@angular/core";
import { SERVER_API_URL } from 'src/app/app.constants';
import { IVaccine } from 'src/app/shared/model/vaccine.model';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { map } from 'rxjs/operators';
import { createRequestOption } from 'src/app/shared/util/request-util';

type EntityResponseType = HttpResponse<IVaccine>;
type EntityArrayResponseType = HttpResponse<IVaccine[]>;

@Injectable({providedIn:'root'})
export class VaccineService {
    
    private resourceUrl = SERVER_API_URL + 'api/vaccines';

    constructor(private http: HttpClient) {}

    find(id: number) : Observable<EntityResponseType> {
        return this.http
            .get<IVaccine>(`${this.resourceUrl}/${id}`, {observe: 'response'})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    findAlByAnimal(req?: any) : Observable<EntityArrayResponseType> {
        const optional = createRequestOption(req);
        return this.http
            .get<IVaccine[]>(this.resourceUrl, {params: optional, observe: 'response'})
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    save(vaccine: IVaccine) {
        const copy = this.convertDateFromClient(vaccine);
        return this.http
            .post(this.resourceUrl, copy)
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(vaccine: IVaccine): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(vaccine);
        return this.http
            .put<IVaccine>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
        
    }

    delete(id: number): Observable<HttpResponse<{}>> {
        return this.http
                .delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((vaccine: IVaccine) => {
                vaccine.validUntil = vaccine.validUntil ? moment(vaccine.validUntil) : undefined;
                vaccine.date = vaccine.date ? moment(vaccine.date) : undefined;
            });
        }
        return res;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.date = res.body.date ? moment(res.body.date) : undefined;
            res.body.validUntil = res.body.validUntil ? moment(res.body.date) : undefined;
        }
        return res;
    }

    protected convertDateFromClient(vaccine: IVaccine): IVaccine {
        const copy: IVaccine = Object.assign({}, vaccine, {
            date: vaccine.date && vaccine.date.isValid() ? vaccine.date.toJSON() : undefined,
            validUntil: vaccine.validUntil && vaccine.validUntil.isValid() ? vaccine.validUntil.toJSON() : undefined
        });
        return copy;
    }
}