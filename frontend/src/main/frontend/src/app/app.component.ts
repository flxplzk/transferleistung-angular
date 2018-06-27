import {Component, OnInit} from '@angular/core';
import {TaskService} from "./service/task.service";
import {Task} from "./domain/model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  numberInProgress: number;

  constructor(private taskService: TaskService) {
  }
  ngOnInit(): void {
    this.taskService.tasks$.subscribe((tasks) => {
      this.numberInProgress = tasks.filter(
        (task:Task)=> task.state === 'IN_PROGRESS').length;
    });
  }
}
