import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from '@angular/router';
import { IUser, User } from 'src/app/shared/model/user.model';
import { AccountServive } from './account.service';
import * as moment from 'moment';

@Component({
    selector: 'app-account',
    templateUrl: './account.component.html'
})
export class AccountComponent implements OnInit {
    user : IUser | null = null;
    date : number;
    temp =  " sssss";

    constructor(
        protected accountService: AccountServive,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.date = moment().get("hours");
        this.activatedRoute.data.subscribe(({ user }) => {
            this.user = user;
        })
        
    }

    previousState(): void {
        window.history.back();
    }

    clicker(): void {
        console.log(this.user);
    }
}