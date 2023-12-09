export class User {
  username: string;
  password: string;
  name: string;
  surnames: string;
  email: string;
  profilePhoto?: string;
  birthdate: string; // Formato 'YYYY-MM-DD'
  description?: string;
  roles?: any[]; // Asegúrate de enviar un array de roles según lo esperado por el backend
}
