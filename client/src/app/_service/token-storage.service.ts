import { Injectable } from "@angular/core";
import { AuthResponse } from '../_model/auth-response';


const ACCESS_TOKEN_KEY = 'accessToken';
const AUTHORITIES_KEY = 'authorities';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() {}

  private roles: Array<string> = [];

  public saveAccessToken(accessToken: string) {
    window.localStorage.removeItem(ACCESS_TOKEN_KEY);
    window.localStorage.setItem(ACCESS_TOKEN_KEY, accessToken);
  }

  public getAccessToken(): string | null {
    return window.localStorage.getItem(ACCESS_TOKEN_KEY);
  }

  public saveAuthorities(authorities: string[]) {
    window.localStorage.removeItem(AUTHORITIES_KEY);
    window.localStorage.setItem(AUTHORITIES_KEY, JSON.stringify(authorities));
  }

  public getAuthorities(): any {
    this.roles = [];

    if (localStorage.getItem(ACCESS_TOKEN_KEY)) {
      JSON.parse(localStorage.getItem(AUTHORITIES_KEY) || '{}').array.forEach((authority: any) => {
        this.roles.push(authority.authority);
      });
    }
    return this.roles;
  }

  // Sauvegarde d'une donnée quelconque
  saveData(key: any, value: any) {
    localStorage.setItem(key, value)
  }
  getData(key: any) {
    localStorage.getItem(key)
  }

  // Sauvegarde de toute une réponse issue de l'établissement avec succès de la connexion
  public saveAuthResponse(authResponse: AuthResponse) {
    this.saveAccessToken(authResponse.accessToken);
    this.saveAuthorities(authResponse.authorities);
  }

  // Déconnexion d'un utilisateur et nettoyage de la session 
  signOut() {
    window.localStorage.clear();
  }

}