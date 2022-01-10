import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,Validators } from '@angular/forms';
import { CarwasherService } from 'src/app/services/carwasher.service';
import Swal from 'sweetalert2';
import { carWasherDetails } from './carwasherRegisterInfo';
@Component({
  selector: 'app-carwasher-registration',
  templateUrl: './carwasher-registration.component.html',
  styleUrls: ['./carwasher-registration.component.css']
})
export class CarwasherRegistrationComponent implements OnInit {

  constructor(private washer:CarwasherService) { }
  carwasherDetails:carWasherDetails = {
    username:"",
    password:"",
    washerRating:"",
    washerEmail:""
  }

  message:any;
  RegistrationForm = new FormGroup({
    username : new FormControl('',Validators.required),
    washerEmail: new FormControl('',[Validators.required,Validators.email]),
    password : new FormControl('',[Validators.required,Validators.minLength(5)])

  })

  public registerNow(){
    let res = this.washer.postRegistration(this.carwasherDetails);
    res.subscribe(data=>this.message=data)
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: 'Your work has been saved',
      showConfirmButton: false,
      timer: 1500
    })
    console.log(this.carwasherDetails);
  }

  ngOnInit(): void {
  }

}
