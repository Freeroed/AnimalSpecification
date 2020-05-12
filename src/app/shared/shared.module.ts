import { NgModule } from "@angular/core";
import { HasAnyAuthorityDirective } from './auth/has-any-authority.directive';
import { HasNoAuthorityDirective } from './auth/has-no-authority.directive';

@NgModule({
    imports:[],
    declarations: [HasAnyAuthorityDirective, HasNoAuthorityDirective],
    exports: [HasAnyAuthorityDirective, HasNoAuthorityDirective]
})
export class AnimalSpecificationSharedModule {}