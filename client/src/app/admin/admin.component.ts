import { Component, isDevMode, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { User } from '../_model/user.model';
import { TokenStorageService } from '../_service/token-storage.service';
import { UserService } from '../_service/user.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  currentUser: User;

  constructor(private router: Router,
    private modalService: NgbModal,
    private userService: UserService,
    private storageService: TokenStorageService) { }

  ngOnInit(): void {
    this.userService.getCurrentUser()
    .subscribe(
      response =>{
        let status = response.status
        if(status === 'SUCCESS'){
          this.currentUser = response.data as User
          if(isDevMode)
            console.log(this.currentUser)
        }
      }, error =>{
        if(isDevMode)
          console.log("Impossible de récupérer l'utilisateur connecté !")
      }
    )
  }

  logout() {
    this.storageService.signOut;
    this.router.navigate(['/auth/login']);
  }

}
