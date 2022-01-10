import { Component, OnInit } from '@angular/core';
import { FormControl,FormGroup,Validators } from '@angular/forms';
import { CustomerService } from 'src/app/services/customer.service';
import Swal from 'sweetalert2';
import { OrderInfo } from './orderinfo';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  message:any;
  addons:any = [];
  promos:any = [];
  details:any = [];
  price:number = 0;
  addOnPrice:number;
  promoPrice:number;
  carDetailsPrice:number;

  order: OrderInfo={customerName:"",customerEmail:"",washerName:"",
  washerEmail:"",promoCode:"",customerPlace:"",
  customerAddress:"",washcost:0,promoprice:0,addOnCost:0,date:"",time:""}


  constructor(private customer:CustomerService) {
    this.addOnPrice=0;
    this.promoPrice=0;
    this.carDetailsPrice=0;
  }
  orderForm = new FormGroup({
    name : new FormControl('',Validators.required),
    email:new FormControl('',[Validators.required,Validators.email]),
    place: new FormControl('',Validators.required),
    address: new FormControl('',Validators.required),
    time: new FormControl('',Validators.required),
    date:new FormControl('',Validators.required),
    addons: new FormControl('')
  });
  placeOrder(){
    this.order.addOnCost=Number(this.addOnPrice);
    this.order.promoprice=Number(this.promoPrice);
    this.order.washcost=Number(this.carDetailsPrice);
    this.customer.postOrder(this.order).subscribe(data=>{
      this.message=data;
      window.location.href = "https://paytm.me/m4DK-OR";
    });
    console.log(this.message);
    console.log(this.order);
  }
  sum(){
    this.price = +this.addOnPrice - +this.promoPrice + +this.carDetailsPrice ;
  }
  ngOnInit(): void {
    this.customer.getAddOns().subscribe(addon=>{
      this.addons=addon;
    })

    this.customer.getpromos().subscribe(promo=>{
      this.promos=promo;

    })

    this.customer.getCarDetails().subscribe(carDetails=>{
      this.details=carDetails;

    })

  }

  confirm(){
    Swal.fire({
      title: 'Place Order?',
      text: "Your order will be confirmed",
      icon: 'success',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Done!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.placeOrder();
      }
    })
  }

}
