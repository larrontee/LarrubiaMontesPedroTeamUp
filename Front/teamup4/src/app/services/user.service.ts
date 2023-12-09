import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../user';
import { Observable } from 'rxjs';
import baserUrl from './helper';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(
    private httpClient: HttpClient,
    private loginService: LoginService
  ) {}

  getAllUsers(): Observable<User[]> {
    console.log('servicio getusers');
    return this.httpClient.get<User[]>(`${baserUrl}/users`);
  }
  public createUser(newUser: User) {
    console.log(this.httpClient.post('localhos:8080/createUser', newUser));
    return this.httpClient.post('http://localhost:8080/createUser', newUser);
  }

  public isAdmin() {
    let roles = this.loginService.getUserRoles();
    return roles.includes('ADMIN');
  }
}
