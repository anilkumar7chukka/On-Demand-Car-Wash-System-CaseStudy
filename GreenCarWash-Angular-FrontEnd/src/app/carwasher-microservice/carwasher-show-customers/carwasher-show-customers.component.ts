import { Component, OnInit } from '@angular/core';
import { CarwasherService } from 'src/app/services/carwasher.service';
import { WasherauthService } from 'src/app/services/washerauth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-carwasher-show-customers',
  templateUrl: './carwasher-show-customers.component.html',
  styleUrls: ['./carwasher-show-customers.component.css']
})
export class CarwasherShowCustomersComponent implements OnInit {
  public _opened: boolean = false;
  public removed:boolean = true;
  public edit:boolean = false;
  orders:any = []
  array:any = []
  odr:any;

  constructor(private carwasher:CarwasherService,private washerAuth:WasherauthService) {
      this.carwasher.getOrdersData().subscribe(order=>{
        this.orders=order;
        this.array = order;
      })
  }
  ngOnInit(): void {
  }
  isRemove(){
    return !this.removed;
  }
  hide(i:number){
    console.log(this.array);
    this.orders.splice(i,1);
  }
  select(order:any){
    this.odr = order;
    console.log(order,order.id);
    order.washerName = this.washerAuth.getWasherName();
    // order = JSON.parse(JSON.stringify(order.trim()));
    // order = JSON.parse(order);
    this.carwasher.putWasherName(order,order.id).subscribe(res=>console.log(res));
    // this.odr.washerName = this.washerAuth.getWasherName();

    this.edit = true;
  }


}
