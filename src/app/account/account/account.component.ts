import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from '@angular/router';
import { IUser, User } from 'src/app/shared/model/user.model';
import { AccountServive } from './account.service';
import * as moment from 'moment';
import { Animal } from 'src/app/shared/model/animal.model';
import { AnimalService } from 'src/app/entites/animal/animal.service';
import { HttpResponse } from '@angular/common/http';
import { RequestService } from 'src/app/entites/request/request.service';
import { IRequest } from 'src/app/shared/model/request.model';

@Component({
    selector: 'app-account',
    templateUrl: './account.component.html'
})
export class AccountComponent implements OnInit {
    user : IUser | null = null;
    date : number;
    animals: Animal[];
    requests?: IRequest[];
    

    constructor(
        protected accountService: AccountServive,
        protected activatedRoute: ActivatedRoute,
        protected animalService: AnimalService,
        protected requestService: RequestService 
    ) {}

    ngOnInit() {
        this.date = moment().get("hours");
        this.activatedRoute.data.subscribe(({ user }) => {
            this.user = user;
        });
        this.animalService.findMy().subscribe( (res: HttpResponse<Animal[]>) => 
        this.animals = res.body
        );
        this.requestService.findMy().subscribe((res: HttpResponse<IRequest[]>) =>
        {this.requests = res.body; 
        console.log(res.body);}
        )
        
    }

    previousState(): void {
        window.history.back();
    }

    clicker(): void {
        console.log(this.user);
    }
}