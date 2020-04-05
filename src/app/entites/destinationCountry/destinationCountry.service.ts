import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient, HttpHeaders } from '@angular/common/http';
import { DestinationCounry, IDestinationCounry } from 'src/app/shared/model/destinationCountry.model';
import { SERVER_API_URL } from 'src/app/app.constants';
import { Observable } from 'rxjs';
import { Region, IRegion } from 'src/app/shared/model/region.model';
import { createRequestOption } from 'src/app/shared/util/request-util';


type EntityResponseType = HttpResponse<IDestinationCounry>;
type EntityArrayResponseType = HttpResponse<DestinationCounry[]>;

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'}),
};
@Injectable({ providedIn: 'root'})
export class DestinationCounryService {
    private resourseUrl = SERVER_API_URL + 'api/countries';

    constructor(private http: HttpClient) {}

    findAll(req?: any): Observable<EntityArrayResponseType> {
        const optional = createRequestOption(req);
        
        return this.http
            .get<DestinationCounry[]>(this.resourseUrl, {params: optional, observe: 'response'});
    }


}
