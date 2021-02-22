import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { RestResponse } from '../_model/rest-response';


const httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) };

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private url = environment.SERVER_URL;

  constructor(private http: HttpClient) { }

  // Récupérer tous les rôles disponibles
  getRoles(): Observable<RestResponse> {
    return this.http.get<RestResponse>(this.url + "/roles", httpOptions);
  }

}
