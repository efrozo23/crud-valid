import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { User } from 'src/app/Models/User';
import { ServiceUsersService } from 'src/app/Services/service-users.service';

@Component({
  selector: 'app-create-users',
  templateUrl: './create-users.component.html',
  styleUrls: ['./create-users.component.css']
})
export class CreateUsersComponent implements OnInit {

  user: User = new User()

  myForm: FormGroup

  hidden: boolean = true
  error: boolean = false
  message: String = ""

  constructor(private userService: ServiceUsersService, public formBuilder: FormBuilder) {
    this.myForm = this.formBuilder.group({
      name: [''],
      lastname: ['']
    })

  }

  ngOnInit() {
  }

  createUser() {
    this.user = this.myForm.value
    console.log(this.user)
    this.myForm.reset()
    this.userService.createUser(this.user).subscribe(r => {
      this.hidden = false
      this.message = r
      this.delay()
    }, error => {
      console.error(error.message)
      this.hidden = false
      this.error = true
      this.message = error.message
      this.delay()
    })
  }

  delay() {
    setTimeout(() => {
      this.hidden = true
    }, 2000);
  }



}
