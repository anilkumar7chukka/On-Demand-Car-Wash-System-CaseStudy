import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';
import { PromoDetails } from './promo';

@Component({
  selector: 'app-editpromos',
  templateUrl: './editpromos.component.html',
  styleUrls: ['./editpromos.component.css']
})
export class EditpromosComponent implements OnInit {

  type:string = "";
  promoDetailsObj:any;
  id:string='';

  promos:PromoDetails = {  code:'', price:0, description:'',active :true}
  constructor(private activateRoute:ActivatedRoute,private adminService:AdminService) {
    this.id = this.activateRoute.snapshot.params['id'];
    this.adminService.GetSinglePromo(this.id).subscribe(result=>{
        this.promoDetailsObj = result;
        console.log(result);
    })
   }


   editPromoDetails = new FormGroup({
    code : new FormControl(''),
    price : new FormControl(''),  
    description: new FormControl('')
  })

  update(){

    console.log(this.promoDetailsObj);
    
    this.adminService.putPromoDetails(this.promoDetailsObj.id,this.promoDetailsObj).subscribe(d=>{
      Swal.fire(
        d.toString(),
        'Successfully Updated',
        'success'
      )
    });
    console.log(this.promoDetailsObj);
    
  }

  ngOnInit(): void {
  }

}
