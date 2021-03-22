import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/Models/User';
import { ServiceUsersService } from 'src/app/Services/service-users.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  // users: Observable<User[]>;

  users: User[] = []

  user: User = new User()

  selectedId: string;
  selectedRowIds: Set<number> = new Set<number>();


  constructor(private userService: ServiceUsersService) { }

  ngOnInit() {
    this.getUSers()
  }


  getUSers() {
    console.log('Load users')
    this.userService.getUserList().subscribe(data => {
      this.users = data
    }, error => {
      console.log('Error load service: ', error.message)
      this.user.id = 1
      this.user.name = "E"
      this.user.lastname = "R"
      this.user.status = false
      this.users.push(this.user)
      this.user = new User()
      this.user.id = 2
      this.user.name = "F"
      this.user.lastname = "O"
      this.user.status = false
      this.users.push(this.user)
    }

    )
  }

  onRowClick(id: number) {
    if(this.selectedRowIds.has(id)) {
     this.selectedRowIds.delete(id);
    }
    else {
      this.selectedRowIds.add(id);
    }
  }

  rowIsSelected(id: number) {
    return this.selectedRowIds.has(id);
  }

  getSelectedRows(){
    return this.users.filter(x => this.selectedRowIds.has(x.id));
  }

  onLogClick() {
    // console.log(this.getSelectedRows());
    console.log(this.selectedRowIds)
    this.userService.getUpdateUsers(this.selectedRowIds)
    this.users  = []
    this.getUSers()
  }
}
