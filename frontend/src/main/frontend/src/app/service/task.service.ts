import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Task} from "../domain/model";
import {HttpClient} from "@angular/common/http";
import {LOAD, ADD, EDIT, REMOVE, TaskStore} from "./task.store";
import {tap, map} from "rxjs/operators"
import {BehaviorSubject} from "rxjs/BehaviorSubject";

const BASE_URL = `http://localhost:3000/api/tasks/`;

@Injectable()
export class TaskService {

  tasks$: Observable<Task[]>;

  constructor(private httpClient: HttpClient, private taskStore: TaskStore) {
    this.tasks$ = this.taskStore.items$;
  }

  findTasks(query: string): Observable<Task[]> {
    this.httpClient.get<Task[]>(BASE_URL, {})
      .subscribe(tasks => this.taskStore.dispatch({type: LOAD, data: tasks}));
    return this.tasks$;
  }

  getTask(id: number | string): Observable<Task> {
    return this.httpClient.get<Task>(BASE_URL + id)
  }

  tasksChanged = new BehaviorSubject({});

  saveTask(task: Task) {
    const options = {
      body: task
    };
    const method: string = task.id ? 'PUT' : 'POST';

    return this.httpClient.request(method, BASE_URL + (task.id || ''), options)
      .pipe(
        tap(savedTask => {
          this.tasksChanged.next(savedTask);
          const actionType = task.id ? EDIT : ADD;
          const action = {type: actionType, data: savedTask};
          this.taskStore.dispatch(action);
        })
      )
  }

  deleteTask(task: Task) {
    return this.httpClient.delete(BASE_URL + task.id)
      .pipe(
        tap(response => this.taskStore.dispatch({type: REMOVE, data: task}))
      )
  }
}
