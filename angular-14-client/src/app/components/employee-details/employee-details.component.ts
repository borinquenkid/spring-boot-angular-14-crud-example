import { Component, Input, OnInit } from '@angular/core';
import { EmployeeService } from 'src/app/services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/models/employee.model';
// import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentEmployee: Employee = {
    name: '',
    workDays: 0,
    vacationDays: 0
  };

  message = '';

  constructor(
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getEmployee(this.route.snapshot.params["id"]);
    }
  }

  getEmployee(id: string): void {
    this.employeeService.get(id)
      .subscribe({
        next: (data) => {
          this.currentEmployee = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  // updatePublished(status: boolean): void {
  //   const data = {
  //     name: this.currentEmployee.name,
  //     vacationDays: this.currentEmployee.vacationDays
  //   };
  //
  //   this.message = '';
  //
  //   this.employeeService.update(this.currentEmployee.id, data)
  //     .subscribe({
  //       next: (res) => {
  //         console.log(res);
  //         this.currentEmployee.published = status;
  //         this.message = res.message ? res.message : 'The status was updated successfully!';
  //       },
  //       error: (e) => console.error(e)
  //     });
  // }

  updateWorkdays(): void {
    this.message = '';

    this.employeeService.updateWorkDays(this.currentEmployee.id, this.currentEmployee.workDays, this.currentEmployee)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This employee was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  updateVacationdays(): void {
    this.message = '';

    this.employeeService.updateVacationDays(this.currentEmployee.id, this.currentEmployee.vacationDays, this.currentEmployee)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This employee was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  // deleteEmployee(): void {
  //   this.employeeService.delete(this.currentEmployee.id)
  //     .subscribe({
  //       next: (res) => {
  //         console.log(res);
  //         this.router.navigate(['/employees']);
  //       },
  //       error: (e) => console.error(e)
  //     });
  // }

}
