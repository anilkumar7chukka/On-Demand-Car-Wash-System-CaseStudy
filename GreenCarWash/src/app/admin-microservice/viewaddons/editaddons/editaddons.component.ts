import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';
import { AddOnModel } from './addOns';

@Component({
  selector: 'app-editaddons',
  templateUrl: './editaddons.component.html',
  styleUrls: ['./editaddons.component.css']
})
export class EditaddonsComponent implements OnInit {
  addonName:string = "";
  addOnObj:any;
  addOnsID:string='';

  addOn:AddOnModel = {addon:'',cost:0,active :true}
  constructor(private activateRoute:ActivatedRoute,private adminService:AdminService) {
    this.addOnsID = this.activateRoute.snapshot.params['id'];
    this.adminService.GetSingleAddOn(this.addOnsID).subscribe(result=>{
        this.addOnObj = result 
    })
   }


  editAddons = new FormGroup({
    addon : new FormControl(''),
    cost : new FormControl(''),  
  })

  update(){
    
    this.adminService.putAddOn(this.addOnObj.id,this.addOnObj).subscribe(d=>{
      Swal.fire(
        d.toString(),
        'Successfully Updated'
      )
    });
    console.log(this.addOnObj);
    
    // console.log(this.addOnObj.cost);
    // console.log(this.activate);
  }

  ngOnInit(): void {
  }

}
