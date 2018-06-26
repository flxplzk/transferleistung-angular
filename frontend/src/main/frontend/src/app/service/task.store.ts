import { Injectable } from '@angular/core';
import {Task} from "../domain/model";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

export const LOAD = 'LOAD';
export const ADD = 'ADD';
export const EDIT = 'EDIT';
export const REMOVE = 'REMOVE';

@Injectable()
export class TaskStore {
  private tasks: Task[] = [];
  items$ = new BehaviorSubject<Task[]>([]);

  dispatch(action) {
    console.log("dispatched");
    this.tasks = this._reduce(this.tasks, action);
    this.items$.next(this.tasks);
  }

  _reduce(tasks: Task[], action) {
    switch (action.type) {
      case LOAD:
        return [...action.data];
      case ADD:
        return [...tasks, action.data];
      case EDIT:
        return tasks.map(task => {
          const editedTask = action.data;
          if (task.id !== editedTask.id){
            return task;
          }
          return editedTask;
        });
      case REMOVE:
        return tasks.filter(task => task.id !== action.data.id);
      default:
        return tasks;
    }
  }
}
