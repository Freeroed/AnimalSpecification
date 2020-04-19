import { Injectable } from "@angular/core";
import { ILaboratoryResurch } from 'src/app/shared/model/laboratoryResurch.model';
import { HttpResponse, HttpClient } from '@angular/common/http';
import { SERVER_API_URL } from 'src/app/app.constants';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { map } from 'rxjs/operators';
import { createRequestOption } from 'src/app/shared/util/request-util';

type EntityResponseType = HttpResponse<ILaboratoryResurch>;
type EntityArrayResponseType = HttpResponse<ILaboratoryResurch[]>;

@Injectable({providedIn: 'root'})
export class LaboratoryResearchService {
    
    private resourceUrl = SERVER_API_URL + 'api/laboratoryResearches';

    constructor(private http: HttpClient) {}

    find(id: number) : Observable<EntityResponseType> {
        return this.http
            .get<ILaboratoryResurch>(`${this.resourceUrl}/${id}`, {observe: 'response'})
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    findAlByAnimal(req?: any) : Observable<EntityArrayResponseType> {
        const optional = createRequestOption(req);
        return this.http
            .get<ILaboratoryResurch[]>(this.resourceUrl, {params: optional, observe: 'response'})
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    save(laboratoryResearch: ILaboratoryResurch) {
        const copy = this.convertDateFromClient(laboratoryResearch);
        return this.http
            .post(this.resourceUrl, copy)
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }
    update(laboratoryResearch: ILaboratoryResurch): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(laboratoryResearch);
        return this.http
            .put<ILaboratoryResurch>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<{}>> {
        return this.http
                .delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }


    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((laboratoryResurch: ILaboratoryResurch) => {
                laboratoryResurch.dateOfReceiptOfResult = laboratoryResurch.dateOfReceiptOfResult ? moment(laboratoryResurch.dateOfReceiptOfResult) : undefined;

            });
        }
        return res;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.dateOfReceiptOfResult = res.body.dateOfReceiptOfResult ? moment(res.body.dateOfReceiptOfResult) : undefined;
        }
        return res;
    }

    protected convertDateFromClient(laboratoryResurch: ILaboratoryResurch): ILaboratoryResurch {
        const copy: ILaboratoryResurch = Object.assign({}, laboratoryResurch, {
            date: laboratoryResurch.dateOfReceiptOfResult && laboratoryResurch.dateOfReceiptOfResult.isValid() ? laboratoryResurch.dateOfReceiptOfResult.toJSON() : undefined
        });
        return copy;
    }
}