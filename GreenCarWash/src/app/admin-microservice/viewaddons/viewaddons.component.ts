import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-viewaddons',
  templateUrl: './viewaddons.component.html',
  styleUrls: ['./viewaddons.component.css']
})
export class ViewaddonsComponent implements OnInit {

  public _opened: boolean = false;
  addons:any = []
  router: any;

  constructor(private admin:AdminService) {
    this.admin.getAddOns().subscribe(addon=>{
      this.addons=addon;

    })
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  public _toggleSidebar() {
    this._opened = !this._opened;
    console.log(this.addons);
  }


  deleteAddons(id:any){
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
          this.admin.deleteAddOns(id).subscribe(addons=>{
            this.addons=addons;
            console.log(this.addons);
          })
          Swal.fire(
            'Deleted!',
            'Your file has been deleted.',
            'success'
          )
        }
      }
      );
      this.router.navigateByUrl("admin/viewaddons");    
    }

  }
