import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Models/User';

@Injectable({
  providedIn: 'root'
})
export class ServiceUsersService {

  private baseUrl = 'http://localhost:8080/api/user';  

  private header:HttpHeaders = new HttpHeaders().set('Access-Control-Allow-Origin' , '*').set('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, PUT').set('Accept','application/json').set('content-type','application/json');

  constructor(private http:HttpClient) { }

  getUserList(): Observable<any>{
    return this.http.get(this.baseUrl + '/list-users',{headers : this.header})
  }

  getUpdateUsers(items : any):Observable<any>{
     return this.http.put<any>(this.baseUrl + '/update-users',items) 
  }

  createUser(item: User):Observable<any>{
    return this.http.post<any>(this.baseUrl + '/save-user' , item)
  }



}
