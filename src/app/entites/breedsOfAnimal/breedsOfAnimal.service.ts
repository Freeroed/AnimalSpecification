import { Injectable, Optional } from "@angular/core";
import { HttpClient, HttpResponse } from '@angular/common/http';
import { IBreedOfAnimal, BreedOfAnimal } from 'src/app/shared/model/breedOfAnimal.model';
import { Observable } from 'rxjs';
import { createRequestOption } from 'src/app/shared/util/request-util';
import { SERVER_API_URL } from 'src/app/app.constants';

type EntityResponseType = HttpResponse<IBreedOfAnimal>;
type EntityArrayResponseType = HttpResponse<IBreedOfAnimal[]>;
@Injectable({providedIn: 'root'})
export class BreedsOfAnimalService {
    private resourseUrl = SERVER_API_URL + 'api/breeds';
    constructor(
        private http: HttpClient
    ) {}

    findAll(req?: any): Observable<EntityArrayResponseType> {
        const optional = createRequestOption(req);
        return this.http
            .get<BreedOfAnimal[]>(this.resourseUrl, {params: optional, observe: 'response'});
    }
}