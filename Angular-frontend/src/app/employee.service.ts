import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL= environment.BASE_URL;

  constructor( private httpClient: HttpClient) { }//DI of httpClient

  getEmployeesList():Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }
  
  createNewEmployee(employee :Employee): Observable<Object>{
    return this.httpClient.post<Object>(`${this.baseURL}/store`, employee );
  }
}
