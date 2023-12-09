import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baserUrl from './helper';
import { User } from '../user';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  public loginStatusSubjec = new Subject<boolean>();

  constructor(private http: HttpClient) {}

  //generamos el token
  public generateToken(loginData: any) {
    return this.http.post(`${baserUrl}/login`, loginData);
  }

  public getCurrentUser() {
    return this.http.get(`${baserUrl}/misDatos`);
  }

  //iniciamos sesión y establecemos el token en el localStorage
  public loginUser(token: any) {
    localStorage.setItem('token', token);
    return true;
  }

  public isLoggedIn() {
    let tokenStr = localStorage.getItem('token');
    if (tokenStr == undefined || tokenStr == '' || tokenStr == null) {
      return false;
    } else {
      return true;
    }
  }

  //cerranis sesion y eliminamos el token del localStorage
  public logout() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  //obtenemos el token
  public getToken() {
    return localStorage.getItem('token');
  }

  public setUser(user: any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  public getUserRoles() {
    let roleNames: string[] = [];

    let user = this.getUser();

    if (user.roles && user.roles.length > 0) {
      user.roles.forEach((role: { name: string }) => {
        roleNames.push(role.name);
      });
    }
    return roleNames;
  }
}
