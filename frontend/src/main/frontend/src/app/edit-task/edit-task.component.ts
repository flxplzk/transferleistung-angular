import {Component, OnInit, ViewChild} from '@angular/core';
import {createInitialTask, Task} from "../domain/model";
import {NgForm} from "@angular/forms";
import {Subscription} from "rxjs/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {TaskService} from "../service/task.service";
import {filter, map, flatMap} from "rxjs/operators";
import * as model from '../domain/model';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.css']
})
export class EditTaskComponent implements OnInit {
  model = model;
  task: Task = createInitialTask();
  saved = false;

  @ViewChild(NgForm) form: NgForm;

  subscription: Subscription;

  constructor(private route: ActivatedRoute,
              private taskService: TaskService,
              private router: Router) {

  }

  ngOnInit() {
    this.subscription = this.route.params
      .pipe(
        map(params => params['id']),
        filter(id => id != undefined),
        flatMap(id => this.taskService.getTask(id))
      ).subscribe(task => {
        this.task = task;
      })
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  addTag() {
    this.task.tags.push({label: ''});
    return false;
  }

  removeTag(i:number) {
    this.task.tags.splice(i, 1);
    return false;
  }

  saveTask() {
    this.taskService.saveTask(this.task).subscribe(task => {
      this.saved = true;
      const relativeUrl = this.router.url.includes('edit') ? '../..' : '..';
      this.router.navigate([relativeUrl], {relativeTo: this.route});
    });
  }

  cancel() {
    const relativeUrl = this.router.url.includes('edit') ? '../..' : '..';
    this.router.navigate([relativeUrl], {relativeTo: this.route});
    return false;
  }

  canDeactivate() : boolean {
    if (this.saved || !this.form.dirty) {
      return true;
    }
    return window.confirm(`Ihr Formular besitzt ungespeicherte Änderungen, möchten Sie die Seite wirklich verlassen?`);
  }
}
