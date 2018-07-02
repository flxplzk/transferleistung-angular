import {RouterModule, Routes} from "@angular/router";
import {TasksComponent} from "./tasks/tasks.component";
import {tasksRoutes, tasksRoutingComponents} from "./tasks/tasks.routing";

export const appRoutes: Routes = [
  {path: 'tasks', children: tasksRoutes},
  {path: 'tasks/*', redirectTo: '/tasks'},
  {path: '**', redirectTo: '/tasks', pathMatch: 'full'}
  ];
export const appRouting = RouterModule.forRoot(appRoutes);

export const routingComponents = [TasksComponent,  ...tasksRoutingComponents];
