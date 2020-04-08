import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../core/auth/auth.service';
import { TokenStorageService } from '../../core/auth/token-storage.service';
import { StateStorageService } from 'src/app/core/auth/state-storage.service';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder } from '@angular/forms';
import { ICredentials, Credentials } from 'src/app/shared/model/credentials.model';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
    form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(
    private authService: AuthService, 
    private tokenStorage: TokenStorageService,
    private stateStorageService: StateStorageService,
    private router: Router,
    private fb: FormBuilder,
    public activeModal: NgbActiveModal
    ) { }

  loginForm = this.fb.group ({
    login:[],
    password:[]
  })
  ngOnInit() {
    this.authService.logout();
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  login() {
    const cred = this.createFormFrom();
    this.authService.login(cred).subscribe(
      data => {
        this.tokenStorage.saveToken(data.token);
        this.tokenStorage.saveUser(data.account);
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.navigateToStoredUrl();
        this.activeModal.close();
        this.authService.authenticate(this.tokenStorage.getUser())
      },
      error => {
        this.isLoginFailed = true;
      }
    );
  }

  createFormFrom(): ICredentials {
    return {
      ...new Credentials(),
      login: this.loginForm.get(['login'])!.value,
      password: this.loginForm.get(['password'])!.value
    }
  }

  reloadPage() {
    window.location.reload();
  }

  private navigateToStoredUrl(): void {
    const previousUrl = this.stateStorageService.getUrl();
    if (previousUrl) {
        this.stateStorageService.clearUrl();
        this.router.navigateByUrl(previousUrl);
    }
}
}