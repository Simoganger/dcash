import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RestResponse } from '../_model/rest-response';

const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = environment.SERVER_URL;
  
  constructor(private http: HttpClient) { }

    /**
     * Récupérer les informations sur l'utilisateur courant
     */
    getCurrentUser(): Observable<RestResponse> {
      return this.http.get<RestResponse>(this.url + "/user/me", httpOptions)
    }

}
