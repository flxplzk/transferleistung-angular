import {Component, OnInit} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Task} from "../domain/model";
import {FormControl} from "@angular/forms";
import {TaskService} from "../service/task.service";
import {Location} from '@angular/common';
import {ActivatedRoute, Router} from "@angular/router";
import {debounceTime, distinctUntilChanged, map, switchMap, tap} from "rxjs/operators";
import {merge} from "rxjs/observable/merge";

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  selectedTaskId: number | string = null;
  tasks$: Observable<Task[]>;
  searchTerm = new FormControl();

  constructor(private taskService: TaskService,
              private router: Router,
              private route: ActivatedRoute,
              private location: Location) {
  }

  ngOnInit() {
    this.tasks$ = this.taskService.findTasks('');

    const paramsStream = this.route.queryParams
      .pipe(
        map(params => decodeURI(params['query'] || '')),
        tap(query => this.searchTerm.setValue(query))
      );

    const searchTermStream = this.searchTerm.valueChanges
      .pipe(
        debounceTime(400),
        tap(query => this.adjustBrowserUrl(query))
      );

    merge(paramsStream, searchTermStream)
      .pipe(
        distinctUntilChanged(),
        switchMap(query => this.taskService.findTasks(query))
      ).subscribe();
  }

  deleteTask(task) {
    this.taskService.deleteTask(task).subscribe();
  }

  selectTask(taskId: string | number) {
    this.selectedTaskId = taskId;
  }

  findTasks(query: string) {
    this.taskService.findTasks(query);
  }

  adjustBrowserUrl(queryString = '') {
    const absoluteUrl = this.location.path().split('?')[0];
    const queryPart = queryString !== '' ? `query=${queryString}` : '';
    this.location.replaceState(absoluteUrl, queryPart);
  }
}
