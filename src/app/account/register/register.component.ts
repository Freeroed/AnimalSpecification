import { Component, OnInit } from '@angular/core';
import { AuthService } from './../../core/auth/auth.service';
import { FormBuilder, Validators } from '@angular/forms';
import { User, IUser } from 'src/app/shared/model/user.model';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {
    isSuccessful = false;
    isSignUpFailed = false;
    errorMessage = '';

    constructor(private authService: AuthService, private fb: FormBuilder) {}

    editForm = this.fb.group ({
        id:[],
        userName: ['',[Validators.maxLength(50), Validators.minLength(6)]],
        password: ['',[Validators.maxLength(50),Validators.minLength(6)]],
        surname: ['',Validators.maxLength(50)],
        name: ['',Validators.maxLength(50)],
        patronymic: ['',Validators.maxLength(50)],
        phone: ['',[Validators.maxLength(13), Validators.minLength(11)]],
        address: ['',Validators.maxLength(255)],
        inn: ['',Validators.maxLength(20)],
        surnameEng: ['',Validators.maxLength(50)],
        nameEng: ['',Validators.maxLength(50)],
        email: ['',[Validators.maxLength(255), Validators.email]],
        createdAt: []
    })
    ngOnInit() {
        this.authService.logout();
    }

    private createFormFrom(): IUser {
        return {
            ...new User(),
            id: this.editForm.get(['id'])!.value,
            userName: this.editForm.get(['userName'])!.value,
            password: this.editForm.get(['password'])!.value,
            surname: this.editForm.get(['surname'])!.value,
            name: this.editForm.get(['name'])!.value,
            patronymic: this.editForm.get(['patronymic'])!.value,
            phone: this.editForm.get(['phone'])!.value,
            address: this.editForm.get(['address'])!.value,
            inn: this.editForm.get(['inn'])!.value,
            surnameEng: this.editForm.get(['surnameEng'])!.value,
            nameEng: this.editForm.get(['nameEng'])!.value,
            email: this.editForm.get(['email'])!.value
        }
    }

    register() {
        const user = this.createFormFrom();
        this.subscrabeToSaveResponse(this.authService.register(user))
    }

    protected subscrabeToSaveResponse(result: Observable<HttpResponse<IUser>>): void {
        result.subscribe(
            //TODO check errors
            () => window.history.back(),
            message => {this.errorMessage = message.error.message,
                window.scrollTo(0,0);
            this.isSignUpFailed=true;}
        )
    }

    previousState(): void {
        window.history.back();
    }
}