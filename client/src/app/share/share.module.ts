import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShareRoutingModule } from './share-routing.module';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxSpinnerModule } from 'ngx-spinner';


@NgModule({
  declarations: [FooterComponent],
  imports: [
    CommonModule,
    ShareRoutingModule,
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    NgbModule,
    FormsModule,
    NgxSpinnerModule,
  ],
  exports: [
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    NgbModule,
    FormsModule,
    NgxSpinnerModule,

    FooterComponent,
  ]
})
export class ShareModule { }
