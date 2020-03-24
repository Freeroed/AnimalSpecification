import { Component, OnInit } from '@angular/core';
import { AuthService } from './../../core/auth/auth.service';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html'
})
export class RegisterComponent implements OnInit {
    form: any = {}
    isSuccessful = false;
    isSignUpFailed = false;
    errorMessage = '';

    constructor(private authService: AuthService) {}

    ngOnInit() {}

    onSubmit() {
        this.authService.register(this.form).subscribe(
            data => {
                
                this.isSuccessful = true;
                this.isSignUpFailed = false;
            },
            err => {
                this.errorMessage = err.console.error.message;
                this.isSignUpFailed = true;
                
            }
        );
    }
}