import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';


@Injectable({
  providedIn: 'root'
})
@Injectable({
  providedIn: 'root'
})
export class WasherauthService {
  washerName:string='';
  constructor(private http: HttpClient, private router: Router) { }
  authenticate(username: string, password: string){
    return this.http.post("http://localhost:8081/Carwashers/auth", {username: username, password: password})
    .subscribe(
      (userData: any)=> {
        // console.log(userData);
        if(userData.response=="No"){
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Wrong Credentials!',
            footer: '<a href="">Try Again</a>'
          })
          this.router.navigate(['washer/login']);
        }
        else{
        sessionStorage.setItem('username', username);
        let token= "Bearer "+userData.response;
        sessionStorage.setItem('token', token);
        console.log(token);
        sessionStorage.setItem('userId', userData.userId);
        sessionStorage.setItem('name', sessionStorage['userName']);
        sessionStorage.getItem('username');
        this.router.navigate(['carwasher']);
      }}
    );
  }

  getWasherName(){
    return this.washerName = sessionStorage['username'];
  }

  getToken(){
    return sessionStorage['token'];
  }

  register(user:any ){
    return this.http.post("http://localhost:8081/Carwashers/subs", user);
  }

  isLoggedIn(){
    let user = sessionStorage.getItem('username');
    let token = sessionStorage.getItem("token");
    if(token==undefined || token==null || token=='')
    {
      return false;
    }else{
      return true;
    }
  }

  logout(){
    // console.log(sessionStorage);
    sessionStorage.clear();
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("username");
    // console.log(sessionStorage);
  }


}
