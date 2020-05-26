import { Component, OnInit } from "@angular/core";
import { IRequest } from 'src/app/shared/model/request.model';
import { RequestService } from './request.service';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ActivatedRoute } from '@angular/router';
import { RequestAddAnimalDialogComponent } from './request-add-animal-dialid.component';
import { Animal } from 'src/app/shared/model/animal.model';
import { RequestDeleteAnimalDeleteDialogComponent } from './request-delete-animal-dialog.component';
import { Subscription, Observable, of, EMPTY } from 'rxjs';
import { RequestStatus } from 'src/app/shared/model/enum/requestStatus.model';
import { IVaccine, Vaccine } from 'src/app/shared/model/vaccine.model';
import { VaccineService } from '../vaccine/vaccine.service';
import { HttpResponse } from '@angular/common/http';
import * as moment from 'moment';
import { flatMap } from 'rxjs/operators';
import { RequestConfirmDialogComponent } from './request-confirm-dialog.component';
import { RequestGiveOutSertificateComponent } from './request-give-out-sertificate-dialog.component';
import { RequestGiveOutDocumentsComponent } from './request-give-out-documents-dialog.component';
import * as fileSaver from 'file-saver';
import { DocumentService } from '../document/document.service';
import { TokenStorageService } from 'src/app/core/auth/token-storage.service';


@Component({
    selector: 'app-request-detail',
    templateUrl: './request-detail.component.html'
})
export class RequestDetailComponent implements OnInit {
    request: IRequest;
    eventSubscriber?: Subscription;
    RequestStatus = RequestStatus;
    errors : string[][] = [];
    fillingErrors : string[];
    isViewerRecipient: boolean;
    isPageLoaded: boolean;

    constructor(
        private activatedRoute: ActivatedRoute,
        protected modalService: NgbModal,
        protected requestService: RequestService,
        protected eventManager: JhiEventManager,
        protected vaccineService: VaccineService,
        protected documentService: DocumentService,
        protected tokenStorageService: TokenStorageService){}

    ngOnInit(): void {
        this.loadPage();
        this.registerChangesInRequest();
        
        
    }
    loadPage(): void {
        console.log("called")
        if (this.isPageLoaded) {
            this.requestService.find(this.request.id).subscribe((res: HttpResponse<IRequest>) =>
            this.request = res.body)
        } else {
            this.activatedRoute.data.subscribe(({ request }) => {
            this.request = request;
            this.fillingErrors = this.chechFillngsErrors(request);
        });
        }
        

        this.checkAnimals();
        this.isViewerRecipient = this.checkUser();
        this.isPageLoaded = true;
    }

    registerChangesInRequest(): void {
        this.eventSubscriber = this.eventManager.subscribe('requestModification', () => this.loadPage())
    }

    addAnimal(): void {
        const modalRef = this.modalService.open(RequestAddAnimalDialogComponent,  { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = this.request;
    }

    deleteAnimalFromRequest(animal: Animal): void {
        const modalRef = this.modalService.open(RequestDeleteAnimalDeleteDialogComponent,  { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = this.request;
        modalRef.componentInstance.animal = animal;
    }

    checkAnimals(): void {
        this.request.animals.forEach((animal) =>{
            this.checkOneAnimal(animal).subscribe((errors: string[]) => {
                 this.errors.push(errors);
            })
        });
    }


    checkOneAnimal(animal: Animal): Observable<string[]> {
        let animalError: string[] = [];
        return this.checkVaccines(animal).pipe(
            flatMap((errors: string[]) => {
                animalError = animalError.concat(errors);
                if (animalError[0]!.length > 0){
                    return of(errors);
                } else {
                    return EMPTY;
                }
                
            })
        )
    }
    checkVaccines(animal: Animal): Observable<string[]> {
        const today = moment();
        let vaccineError: string[] = [];
        return this.vaccineService.findAlByAnimal(animal).pipe(
            flatMap((vaccines: HttpResponse<IVaccine[]>) =>{
                vaccines.body.forEach(vaccine => {
                    if (moment.duration(today.diff(vaccine.date)).asDays() < 20) {
                        vaccineError.push('Прошло менее 20-ти дней с момента вакцинации: ' + vaccine.title);
                    }
                });
                if (vaccineError[0] && vaccineError[0].length > 0) {
                   return of(vaccineError); 
                }
                else {
                    return EMPTY;
                }
            })
        )
    }

    getVaccines(animal: Animal) {
        let vaccines: IVaccine[];
        this.vaccineService.findAlByAnimal(animal).subscribe((res: HttpResponse<IVaccine[]>) => {
            vaccines = res.body;});
    }

    confirmRequest():void {
        const modalRef = this.modalService.open(RequestConfirmDialogComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = this.request;
    }

    giveFormOneSertificate(): void {
        const modalRef = this.modalService.open(RequestGiveOutSertificateComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = this.request;
    }

    giveExportDocuments(): void {
        const modalRef = this.modalService.open(RequestGiveOutDocumentsComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.request = this.request;
    }

    chechFillngsErrors(request: IRequest): string[] {
        const fillingErrors: string[] = []
        if (request.transport == null || request.transport == undefined) {
            fillingErrors.push('Не указан тип транспортного стредства');
        }

        if (request.transport && request.vehicleNumber == null || request.vehicleNumber == undefined || request.vehicleNumber == '') {
            fillingErrors.push('Не указан номер транспортного средства')
        }

        if (request.postalCode == null || request.postalCode == undefined || request.postalCode == '') {
            fillingErrors.push('Не указан почтовый индекс')
        }

        if (request.borderCrossingPoint == null || request.borderCrossingPoint == undefined) {
            fillingErrors.push('Не указан пункт пересеченя границы')
        }

        if (request.destinationCity == null || request.destinationCity == undefined || request.destinationCity == '') {
            fillingErrors.push('Не указан город назначения')
        }

        return fillingErrors;
    }

    downloadDocument(id: number): void {
        this.documentService.downloadFile(id).subscribe(
            res => {
                const fileName = res.headers.get('filename');
                console.log(res.headers)
                this.saveDocument(res.body, fileName)
            }
        )
    }

    saveDocument(data: any, filename: string): void {
        const blob = new Blob([data, {type: 'pdf'}]);
        fileSaver.saveAs(blob, filename)
    }

    checkUser(): boolean {
        const user = this.tokenStorageService.getUser();
        if (user.username == this.request.recipient.userName) {
            return true;
        } else {
            return false;
        }
    }

    
}