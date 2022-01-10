import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';
import { CarDetailsModel } from './carDetails';

@Component({
  selector: 'app-edit-car-details',
  templateUrl: './edit-car-details.component.html',
  styleUrls: ['./edit-car-details.component.css']
})
export class EditCarDetailsComponent implements OnInit {

  type:string = "";
  carDetailsObj:any;
  id:string='';

  carDetails:CarDetailsModel = {  type:'',price:0,active :true}
  constructor(private activateRoute:ActivatedRoute,private adminService:AdminService) {
    this.id = this.activateRoute.snapshot.params['id'];
    this.adminService.GetSingleCarDetails(this.id).subscribe(result=>{
        this.carDetailsObj = result;
        console.log(result);
    })
   }


   editCarDetails = new FormGroup({
    type : new FormControl(''),
    price : new FormControl(''),  
  })

  update(){

    console.log(this.carDetailsObj);
    
    this.adminService.putCarDetails(this.carDetailsObj.id,this.carDetailsObj).subscribe(d=>{
      Swal.fire(
        d.toString(),
        'Successfully Updated',
        'success'
      )
    });
    console.log(this.carDetailsObj);
    
  }

  ngOnInit(): void {
  }


}
