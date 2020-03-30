import { Injectable } from '@angular/core';
import { Routes } from '@angular/router';
import { LoginComponent } from './signin/login.component';
import { RegisterComponent } from './register/register.component';

export const accountRoute: Routes = [
    {
        path: 'login',
        component: LoginComponent
      },
      {
        path: 'signup',
        component: RegisterComponent
      },
]