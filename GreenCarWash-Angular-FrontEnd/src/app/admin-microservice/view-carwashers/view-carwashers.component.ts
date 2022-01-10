import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-carwashers',
  templateUrl: './view-carwashers.component.html',
  styleUrls: ['./view-carwashers.component.css']
})
export class ViewCarwashersComponent implements OnInit {

  public _opened: boolean = false;
  public message: string = '';
  washers:any = []
  router: any;

  constructor(private admin:AdminService) {
      this.admin.getCarWasher().subscribe(washer=>{
        this.washers=washer;
        console.log(this.washers);
      })
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  public _toggleSidebar() {
    this._opened = !this._opened;
  }

  delete(id:any){
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
        this.admin.deleteWasher(id).subscribe(data=>{
          console.log(data)
          this.message = "Deleted!";
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

