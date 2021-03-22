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
  ids:Number[] = []
  hidden: boolean = true
  error: boolean = false
  message: String = ""

  constructor(private userService: ServiceUsersService) { }

  ngOnInit() {
    this.getUSers()
  }


  getUSers() {
    console.log('Load users')
    this.userService.getUserList().subscribe(r => {
      this.users = r.data
    }, error => {
      console.log('Error load service: ', error.message)
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
    return   this.selectedRowIds.has(id);
  }

  getSelectedRows(){
    return this.users.filter(x => this.selectedRowIds.has(x.id)).map((x)=>{return x.id});
  }


  onLogClick() {
    console.log(this.getSelectedRows())
    this.userService.getUpdateUsers(this.getSelectedRows()).subscribe(r=>{
      this.message = r.message
      this.error = false
      this.hidden = false
      this.delay()
      this.selectedRowIds.clear()
    },e=>{
      this.hidden = false
      this.error = true
      this.message = e.message
      this.selectedRowIds.clear()
    })
    this.users  = []
    this.getUSers()
  }

  delay() {
    setTimeout(() => {
      this.hidden = true
    }, 2000);
  }
}
