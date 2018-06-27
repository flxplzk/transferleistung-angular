import {Component, EventEmitter, OnInit} from '@angular/core';
import {Task} from "../domain/model";
import {Output} from "@angular/compiler/src/core";

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css'],
  inputs: ['task', 'selected'],
  outputs: ['taskSelected' , 'taskDelete'],
})
export class TaskComponent implements OnInit {
  selected: boolean;
  task: Task;

  taskSelected  = new EventEmitter();
  taskDelete = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  select() {
    this.taskSelected.emit(this.task.id)
  }

  delete() {
    this.taskDelete.emit(this.task);
  }
}
