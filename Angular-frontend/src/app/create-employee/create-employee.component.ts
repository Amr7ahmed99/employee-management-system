import { EmployeeService } from "./../employee.service";
import { Component, OnInit } from "@angular/core";
import { Employee } from "../employee";
import { Router } from "@angular/router";

@Component({
  selector: "app-create-employee",
  templateUrl: "./create-employee.component.html",
  styleUrls: ["./create-employee.component.css"],
})
export class CreateEmployeeComponent implements OnInit {
  public employeeData: Employee;
  constructor(
    private employeeService: EmployeeService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.employeeData= new Employee();
  }

  saveEmployee(e: Event): void {
    e.preventDefault();
    this.employeeService
      .createNewEmployee(this.employeeData)
      .subscribe((data) => {
        console.log(data);
        this.goToEmployeeList();
      });
  }

  goToEmployeeList(): void {
    this.router.navigate(['/employees']);
  }
}
