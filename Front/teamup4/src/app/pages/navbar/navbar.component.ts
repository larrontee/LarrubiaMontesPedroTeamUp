import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent implements OnInit {
  userRole: string | undefined;
  roles: string[];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    // Llamada al método del servicio AuthService para obtener el rol del usuario
    if (this.userService.isAdmin()) {
      console.log('ADMIN logg');
    } else {
      console.log('user logg');
    }
  }
}
