import { Directive, Input, TemplateRef, ViewContainerRef, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/core/auth/auth.service';

/**
 * @whatItDoes Conditionally includes an HTML element if current user has any
 * of the authorities passed as the `expression`.
 *
 * @howToUse
 * ```
 *     <some-element *jhiHasAnyAuthority="'ROLE_ADMIN'">...</some-element>
 *
 *     <some-element *jhiHasAnyAuthority="['ROLE_ADMIN', 'ROLE_USER']">...</some-element>
 * ```
 */
@Directive({
  selector: '[appHasNoAuthority]'
})
export class HasNoAuthorityDirective implements OnDestroy {
  private authenticationSubscription?: Subscription;

  constructor(private accountService: AuthService, private templateRef: TemplateRef<any>, private viewContainerRef: ViewContainerRef) 
  {
    this.appHasNoAuthority();
  }
  
  
  appHasNoAuthority() {
    this.updateView();
    // Get notified each time authentication state changes.
    this.authenticationSubscription = this.accountService.getAuthenticationState().subscribe(() => this.updateView());
  }

  ngOnDestroy(): void {
    if (this.authenticationSubscription) {
      this.authenticationSubscription.unsubscribe();
    }
  }

  private updateView(): void {
    const hasNoAuthority = this.accountService.hasNoRole();
    this.viewContainerRef.clear();
    if (hasNoAuthority) {
      this.viewContainerRef.createEmbeddedView(this.templateRef);
    }
  }
}
