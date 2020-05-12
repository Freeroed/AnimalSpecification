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
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AnimalDeleteDialogComponent } from 'src/app/entites/animal/animal-delete-dialog.component';

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
        protected requestService: RequestService,
        protected modalService: NgbModal,
    ) {}

    ngOnInit() {
        this.date = moment().get("hours");
        this.activatedRoute.data.subscribe(({ user }) => {
            this.user = user;
        });
        this.animalService.findMy().subscribe( (res: HttpResponse<Animal[]>) => {
            console.log(res);
            this.animals = res.body
        }
        );
        this.requestService.findMy().subscribe((res: HttpResponse<IRequest[]>) =>
        {this.requests = res.body;  }
        )
        
    }

    previousState(): void {
        window.history.back();
    }

    clicker(): void {
        console.log(this.user);
    }

    delete(id: number): void {
        const modalRef = this.modalService.open(AnimalDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
        
    }
}