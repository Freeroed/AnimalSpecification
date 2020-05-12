import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'src/app/app.constants';
import { IDocument } from 'src/app/shared/model/document.model';
import * as moment from 'moment';
import { map } from 'rxjs/operators';
type EntityResponseType = HttpResponse<IDocument>;

@Injectable({
    providedIn: 'root'
})
export class DocumentService {
    resourceUrl = SERVER_API_URL + 'api/documents';

    constructor(
        private http: HttpClient
    ) {}

    downloadFile(id: number):Observable<HttpResponse<Blob>> {
        const headers = new HttpHeaders().set('Accept', 'application/pdf');
        return this.http.get(`${this.resourceUrl}/${id}/download`, {headers: headers, observe: 'response', responseType: 'blob'});
    }

    create(document: IDocument): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(document);
        return this.http
                    .post(this.resourceUrl, copy)
                    .pipe(map((res: EntityResponseType) => this.createDateFromServer(res)));
    }

    createDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.dateOfIssue = res.body.dateOfIssue ? moment(res.body.dateOfIssue) : undefined;
        };
        return res;
    }

    protected convertDateFromClient(document: IDocument): IDocument {
        const copy: IDocument = Object.assign({}, document, {
            dateOfIssue: document.dateOfIssue && document.dateOfIssue.isValid() ? document.dateOfIssue.toJSON(): undefined
        });
        return copy;
    }
}