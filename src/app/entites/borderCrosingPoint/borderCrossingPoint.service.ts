import { Injectable } from "@angular/core";
import { HttpResponse, HttpClient } from '@angular/common/http';
import { IBorderCrossingPoint } from 'src/app/shared/model/borderCrossingPoint.model';
import { SERVER_API_URL } from 'src/app/app.constants';
import { Observable } from 'rxjs';

type EntityArrayResponseType = HttpResponse<IBorderCrossingPoint[]>

@Injectable({ providedIn: 'root'})
export class BorderCrossingPointService {
    private resourseUrl = SERVER_API_URL + 'api/border-crossing-points';

    constructor(private http: HttpClient) {}

    findAll(): Observable<EntityArrayResponseType> {
        return this.http.get<IBorderCrossingPoint[]>(this.resourseUrl, { observe: 'response'})
    }
}