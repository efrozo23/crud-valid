import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Routes, RouterModule } from '@angular/router';  
import { UsersListComponent } from './Components/users-list/users-list.component';
import { CreateUsersComponent } from './Components/create-users/create-users.component';

const routes: Routes = [  
  { path: '', redirectTo: 'user-list', pathMatch: 'full' },  
  { path: 'user-list', component: UsersListComponent },  
  { path: 'add-user', component: CreateUsersComponent },  
];  

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[RouterModule],
  declarations: []
})
export class AppRoutingModule { }
