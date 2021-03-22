import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Models/User';

@Injectable({
  providedIn: 'root'
})
export class ServiceUsersService {

  private baseUrl = 'http://localhost:8080/api/';  

  constructor(private http:HttpClient) { }

  getUserList(): Observable<any>{
    return this.http.get(this.baseUrl + 'list-users')
  }

  getUpdateUsers(items: Set<number>){
     return this.http.put(this.baseUrl + '',items) 
  }

  createUser(item: User):Observable<String>{
    return this.http.post<String>(this.baseUrl + 'save-user' , item)
  }



}
