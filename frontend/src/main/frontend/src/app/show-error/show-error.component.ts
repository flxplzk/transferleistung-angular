import {Component, Input, Optional} from '@angular/core';
import {NgForm, FormGroup} from '@angular/forms';

@Component({
  selector: 'show-error',
  template: `
    <div *ngIf="errorMessages" class="alert alert-danger">
        <div *ngFor="let errorMessage of errorMessages">
            {{errorMessage}}
        </div>
    </div>` })
export class ShowErrorComponent {

  @Input('path') controlPath;
  @Input('text') displayName = '';

  private form: FormGroup;

  constructor(ngForm: NgForm) {
    this.form = ngForm.form;
  }

  get errorMessages(): string[] {
    const control = this.form.get(this.controlPath);
    const messages = [];
    if (!control || !(control.touched) || !control.errors) {
      return null;
    }
    for (const code in control.errors) {
      // Berechnung der lesbaren Fehlermeldungen
      if (control.errors.hasOwnProperty(code)) {
        const error = control.errors[code];
        let message = '';
        switch (code) {
          case 'required':
            message = `${this.displayName} ist ein Pflichtfeld`;
            break;
          case 'minlength':
            message = `${this.displayName} muss mindestens ${error.requiredLength} Zeichen enthalten`;
            break;
          case 'maxlength':
            message = `${this.displayName} darf maximal ${error.requiredLength} Zeichen enthalten`;
            break;
          case 'invalidEMail':
            message = `Bitte geben Sie eine gültige E-Mail Adresse an`;
            break;
          case 'userNotFound':
            message = `Der eingetragene Benutzer existiert nicht.`;
            break;
          default:
            message = `${name} ist nicht valide`;
        }
        messages.push(message);
      }
    }
    return messages;
  }
}
