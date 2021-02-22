import { Directive, TemplateRef, ViewContainerRef, Input } from '@angular/core';
import { TokenStorageService } from '../_service/token-storage.service';

@Directive({
  selector: '[hasRole]'
})
export class HasRoleDirective {

  private role: string

  constructor(private storageService: TokenStorageService,
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef) { }

  // Autoriser l'affichage d'un élément suivant le rôle approprié
  @Input() set hasRole(value: string) {
    this.role = value;
    let roles = this.storageService.getAuthorities();
    if (roles.includes(value)) {
      this.viewContainer.createEmbeddedView(this.templateRef);
    } else {
      this.viewContainer.clear();
    }
  }

}
