import { Injectable } from '@angular/core';
import { HttpResponse, HttpClient, HttpHeaders } from '@angular/common/http';
import { DestinationCounry, IDestinationCounry } from 'src/app/shared/model/destinationCountry.model';
import { SERVER_API_URL } from 'src/app/app.constants';
import { Observable } from 'rxjs';
import { Region, IRegion } from 'src/app/shared/model/region.model';


type EntityResponseType = HttpResponse<IDestinationCounry>;
type EntityArrayResponseType = HttpResponse<DestinationCounry[]>;

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'}),
};
@Injectable({ providedIn: 'root'})
export class DestinationCounryService {
    private resourseUrl = SERVER_API_URL + 'api/countries';

    constructor(private http: HttpClient) {}

    findAll(): Observable<EntityArrayResponseType> {
        return this.http
            .get<DestinationCounry[]>(this.resourseUrl, { observe: 'response'});
    }

    findAllByRegion(region: IRegion): Observable<IDestinationCounry[]> {
        return this.http
            .post<IDestinationCounry[]>(this.resourseUrl+'/get', region, httpOptions);
    }

}
