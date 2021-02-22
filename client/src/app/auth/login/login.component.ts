import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthResponse } from 'src/app/_model/auth-response';
import { AuthService } from 'src/app/_service/auth.service';
import { TokenStorageService } from 'src/app/_service/token-storage.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  //gestion des dates
  today: number = Date.now();

  //gestion des rôles
  roles: string[] = []

  //Gestion du formulaire
  loginForm: FormGroup;
  loginLoading = false;


  constructor(private fb: FormBuilder, 
    private authService: AuthService,
    private tokenStorageService: TokenStorageService,
    private router: Router) { }

  ngOnInit() {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  // Access rapide au formulaire
  get f() { return this.loginForm.controls; }

  // Validation de l'inscription
  onLoginSubmit() {

    // Si traitements formulaire pas valide
    if (this.loginForm.invalid) {
      Swal.fire(
        'Connexion',
        'Bie vouloir remplir le formulaire correctement',
        'warning'
      )
      return;
    }

    this.loginLoading = true;
    this.authService.login(this.f.username.value, this.f.password.value).subscribe(
      (response) => {
        let status = response.status;
        if (status == "SUCCESS") {
          this.loginLoading = false;
          let authResponse = response.data as AuthResponse;

          // recenser les rôles de l'utilisateur
          authResponse.authorities.forEach((role) => {
            this.roles.push(role['authority']);
          });

          if (this.roles.includes("ADMIN")) {
            this.tokenStorageService.saveAuthResponse(authResponse);
            this.router.navigate(['admin']);
          }
          else if (this.roles.includes("USER")) {
            this.tokenStorageService.saveAuthResponse(authResponse);
            this.router.navigate(['user']);
          }else {
            Swal.fire(
              'Connexion',
              'Vous avez été identifié, mais vous n\'avez pas droit approprié vous permettant de vous connecter !',
              'warning'
            )
          }
        }
        else { 
          this.loginLoading = false;
          Swal.fire(
            'Connexion',
            'Un problème est survenu lors de votre connexion au système, veullez reéssayer s\'il vous plaît.',
            'warning'
          )
        }
      },
      (error) => {
        this.loginLoading = false;
        Swal.fire(
          'Connexion',
          'La connexion au serveur est sûrement interrompue. Veuillez réessayer s\'il vous plaît !',
          'error'
        )
      }
    );
  }
}