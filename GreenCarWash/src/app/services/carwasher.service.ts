import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { WasherauthService } from './washerauth.service';
@Injectable({
  providedIn: 'root'
})
export class CarwasherService {
  constructor(private http:HttpClient,private washerAuth:WasherauthService) {
  }

   header = new HttpHeaders().set("Authorization",this.washerAuth.getToken());
  
  getOrdersData() {
    let url = 'http://localhost:8081/carwasher/view_orders';
    console.log(this.washerAuth.getToken());
    return this.http.get(url,{headers:this.header});
  }

  getProfileData(username:string){
    let url = `http://localhost:8081/carwasher/profile/${username}`;
    return this.http.get(url);
  }

  putWasherName(data:any,id:string){
    let url = `http://localhost:8081/carwasher/order_update/${id}`;
    return this.http.put(url,data,{responseType:'text' as 'json'})
  }

  postRegistration(customer:any){
    return this.http.post('http://localhost:8081/carwasher/new_washer',customer,{responseType:'text' as 'json'})
  }


}
