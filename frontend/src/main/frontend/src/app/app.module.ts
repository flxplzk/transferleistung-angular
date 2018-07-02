import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {TaskComponent} from './task/task.component';
import {TaskService} from "./service/task.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {TaskStore} from "./service/task.store";
import {appRouting, routingComponents} from "./app.routing";
import { ShowErrorComponent } from './show-error/show-error.component';

@NgModule({
  declarations: [routingComponents, AppComponent,
    TaskComponent, ShowErrorComponent],
  imports: [appRouting, BrowserModule,
    FormsModule,BrowserModule, FormsModule,
    ReactiveFormsModule, HttpClientModule],
  providers: [TaskService, TaskStore, HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule {}
