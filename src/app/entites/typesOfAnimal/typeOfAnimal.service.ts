import { Injectable } from "@angular/core";
import { SERVER_API_URL } from 'src/app/app.constants';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TypeOfAnimal, ITypeOfAnimal } from 'src/app/shared/model/typeOfAnimal.model';

type EntityResponsyType = HttpResponse<ITypeOfAnimal>
type EntityArrayResponsyType = HttpResponse<ITypeOfAnimal[]>

@Injectable({providedIn: 'root'})
export class TypeOfAnimalService {
    private resourseUrl = SERVER_API_URL + 'api/types'

    constructor(private http: HttpClient) {}

    findAll(): Observable<EntityArrayResponsyType> {
        return this.http.get<TypeOfAnimal[]>(this.resourseUrl, { observe: 'response'});
    }
}