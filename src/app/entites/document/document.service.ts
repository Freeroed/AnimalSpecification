import { Injectable } from "@angular/core";
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SERVER_API_URL } from 'src/app/app.constants';

@Injectable({
    providedIn: 'root'
})
export class DocumentService {
    resourceUrl = SERVER_API_URL + 'api/document';

    constructor(
        private http: HttpClient
    ) {}

    downloadFile():Observable<HttpResponse<Blob>> {
        const headers = new HttpHeaders().set('Accept', 'application/pdf');
        return this.http.get(this.resourceUrl + '/download', {headers: headers, observe: 'response', responseType: 'blob'});
    }
}