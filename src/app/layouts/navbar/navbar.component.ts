import { Component} from '@angular/core';
import { AuthService } from 'src/app/core/auth/auth.service';
import { LoginModalService } from 'src/app/account/signin/login-modal.service';

@Component( {
    selector: 'navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['navbar.scss']
})

export class NavbarComponent {

    constructor(
        private authService: AuthService,
        private loginModalService: LoginModalService
    ) {}

    login() : void {
        this.loginModalService.open();
    }

    logout(): void {
        this.authService.logout();
    }

}