import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { RestResponse } from '../_model/rest-response';
import { User } from '../_model/user.model';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

@Injectable({ providedIn: 'root' })
export class AuthService {

  private url = environment.SERVER_URL + "/auth";

  constructor(private http: HttpClient) { }

  /**
   * Connecter un utilisateur
   * @param login 
   * @param password 
   */
  login(username: string, password: string): Observable<RestResponse> {
    return this.http.post<RestResponse>(this.url + "/login", { username, password }, httpOptions)
  }

  /**
   * Vérifier le code de connexion à double facteur
   * @param code
   */
  verifyLoginCode(code: string): Observable<RestResponse> {
    return this.http.post<RestResponse>(this.url + "/auth/verify/login/code?code=" + code, httpOptions);
  }

  /**
   * Récupération de l'utilisateur courant
   */
  getCurrentUser(): Observable<RestResponse> {
    return this.http.get<RestResponse>(this.url + "/user/me", httpOptions);
  }


}