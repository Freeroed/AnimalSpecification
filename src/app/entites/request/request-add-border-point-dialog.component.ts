import { Component, OnInit } from "@angular/core";
import { BorderCrossingPointService } from '../borderCrosingPoint/borderCrossingPoint.service';
import { FormBuilder } from '@angular/forms';
import { IRequest } from 'src/app/shared/model/request.model';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';
import { IBorderCrossingPoint } from 'src/app/shared/model/borderCrossingPoint.model';
import { HttpResponse } from '@angular/common/http';

@Component({
    templateUrl: './request-add-border-point-dialog.component.html'
})
export class RequestAddBorderPointComponent implements OnInit{
    request: IRequest;
    borderCrossingPoints: IBorderCrossingPoint[];

    constructor(
        private borderService: BorderCrossingPointService,
        private fb: FormBuilder,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager,
    ) {}

    editForm = this.fb.group({
        borderCrossingPoint: []
    })

    ngOnInit(): void {
        this.loadPage();
    }

    loadPage(): void{
        this.borderService.findAll().subscribe((res: HttpResponse<IBorderCrossingPoint[]>) => {
            this.borderCrossingPoints = res.body;
        });
    }

    clear(): void {
        this.activeModal.dismiss();
    }

    confirmAdd(): void {
        this.request.borderCrossingPoint = this.editForm.get(['borderCrossingPoint'])!.value;
        this.eventManager.broadcast('requestModification');
        this.activeModal.close();
    }
}