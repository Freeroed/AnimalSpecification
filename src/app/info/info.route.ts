import { InfoComponent } from './info.component';
import { Route } from '@angular/router';

export const INFO_ROUTE: Route = {
    path: 'info',
    component: InfoComponent,
    data: {
        pageTitle: 'Animal Specification'
    }
};