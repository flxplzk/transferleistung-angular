import {Routes} from "@angular/router";
import {TasksComponent} from "./tasks.component";
import {EditTaskComponent} from "../edit-task/edit-task.component";
import {TaskOverviewComponent} from "../task-overview/task-overview.component";
import {TaskListComponent} from "../task-list/task-list.component";

export const tasksRoutes: Routes = [{
  path: '', component: TasksComponent,
  children: [
    {
      path: '',
      component: TaskListComponent
    },
    {
      path: 'edit/:id', component: EditTaskComponent,
      data: {title: 'Aufgabe bearbeiten'}
    },
    {
      path: 'new', component: EditTaskComponent,
      data: {title: 'Neue Aufgabe anlegen'}
    }
  ]
},
  {
    path: 'overview/:id',
    component: TaskOverviewComponent,
    outlet: 'right'
  }];

export const tasksRoutingComponents = [TasksComponent, TaskListComponent, EditTaskComponent, TaskOverviewComponent];
