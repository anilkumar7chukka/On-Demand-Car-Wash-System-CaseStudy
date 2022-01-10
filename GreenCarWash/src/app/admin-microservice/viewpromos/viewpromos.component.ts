import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-viewpromos',
  templateUrl: './viewpromos.component.html',
  styleUrls: ['./viewpromos.component.css']
})
export class ViewpromosComponent implements OnInit {

  public _opened: boolean = false;
  promos:any = []

  constructor(private admin:AdminService,private router:Router) {
    this.admin.getPromos().subscribe(promo=>{
      this.promos=promo;
    })
  }
  ngOnInit() {
  }

  public _toggleSidebar() {
    this._opened = !this._opened;
  }

  editPromos(id:string){
    console.log(this.promos)
  }

  deletePromos(id:any){
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.admin.deletePromos(id).subscribe(car=>{
          this.promos=car;
          console.log(this.promos);
        })
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        )
      }
    }
    );
    this.router.navigateByUrl("admin/viewpromos");    
  }

  

}
