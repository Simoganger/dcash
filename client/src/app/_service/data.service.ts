import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../_model/user.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private userSource = new BehaviorSubject<any>(null)

  currentUser = this.userSource.asObservable()

  constructor() {}
 
  // L'utilisateur courant a changé
  changeUser(user: User){
    this.userSource.next(user)
  }
}
